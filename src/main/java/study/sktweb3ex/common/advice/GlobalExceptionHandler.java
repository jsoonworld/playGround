package study.sktweb3ex.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.sopt.sktweb3.common.exception.BadRequestException;
import org.sopt.sktweb3.common.exception.InternalServerErrorException;
import org.sopt.sktweb3.common.exception.NotFoundException;
import org.sopt.sktweb3.common.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 공통 응답 생성 메서드
    private ResponseEntity<BaseResponse<Void>> buildResponseEntity(HttpStatus status, String message) {
        log.error("Error: {}, Status: {}", message, status);
        return ResponseEntity.status(status).body(BaseResponse.fail(message));
    }

    // BadRequestException 핸들러
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<Void>> handleBadRequestException(BadRequestException e) {
        return buildResponseEntity(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    // NotFoundException 핸들러
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<Void>> handleNotFoundException(NotFoundException e) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, e.getMessage());
    }

    // InternalServerErrorException 핸들러
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<BaseResponse<Void>> handleInternalServerErrorException(InternalServerErrorException e) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    // 일반적인 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Void>> handleException(Exception e) {
        return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }







}
