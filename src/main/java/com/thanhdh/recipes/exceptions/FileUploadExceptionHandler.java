package com.thanhdh.recipes.exceptions;

import com.thanhdh.recipes.web.model.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FileUploadExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
            .body(new ResponseMessage("File too large!"));
    }

    @ExceptionHandler(FileStorageException.class)
    public ResponseEntity<ResponseMessage> handleFileStorateException(FileStorageException e) {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
            .body(new ResponseMessage("Error when handling the file. "));
    }
}
