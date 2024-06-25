package study.sktweb3ex2.common.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.sktweb3ex2.common.exception.BadRequestException;
import study.sktweb3ex2.common.exception.InternalServerErrorException;
import study.sktweb3ex2.common.exception.NotFoundException;
import study.sktweb3ex2.common.response.BaseResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BaseResponse<Void>> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(400).body(BaseResponse.fail(e.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<Void>> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(404).body(BaseResponse.fail(e.getMessage()));
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<BaseResponse<Void>> handleInternalServerErrorException(InternalServerErrorException e) {
        return ResponseEntity.status(500).body(BaseResponse.fail(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Void>> handleException(Exception e) {
        return ResponseEntity.status(500).body(BaseResponse.fail(e.getMessage()));
    }

}
