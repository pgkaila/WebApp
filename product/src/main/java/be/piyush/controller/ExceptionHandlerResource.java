package be.piyush.controller;

// @formatter:off

import be.piyush.darkside.NotFound;
import be.piyush.darkside.ProductNotFound;
import be.piyush.dto.ErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 3/5/16, 3:20 AM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@ControllerAdvice
public class ExceptionHandlerResource extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFound.class)
    protected ResponseEntity<Object> handleNotFound(NotFound ex, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage());
        return handleExceptionInternal(ex, errorDTO, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
