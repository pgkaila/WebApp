package be.piyush.dto;

// @formatter:off

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 3/5/16, 3:04 AM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO {
    private String errorMessage;
}
