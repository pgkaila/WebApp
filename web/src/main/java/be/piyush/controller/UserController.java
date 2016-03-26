package be.piyush.controller;

// @formatter:off

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 26/3/16, 9:59 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO to current update version
 */
// @formatter:on

@Controller
public class UserController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello() {
        return "index";
    }
}
