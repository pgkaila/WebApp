package be.piyush.darkside;

// @formatter:off

import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 3/5/16, 3:26 AM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@NoArgsConstructor
public class NotFound extends Exception {
    public NotFound(String message) {
        super(message);
    }
}
