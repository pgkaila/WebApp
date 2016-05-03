package be.piyush.controller;

// @formatter:off

import be.piyush.dto.ErrorDTO;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 3/5/16, 11:21 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@RestController
public class ErrorHandlerResource implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(PATH)
    public ErrorDTO errorHandler() {
        return new ErrorDTO("Internal server error...");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}
