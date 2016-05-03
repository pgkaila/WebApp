package be.piyush.controller;

// @formatter:off

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 27/3/16, 3:18 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Controller
public class AuthController {

    @RequestMapping
    public String loginPage() {
        return "login";
    }
}
