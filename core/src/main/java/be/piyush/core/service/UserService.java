package be.piyush.core.service;

// @formatter:off

import be.piyush.core.entity.User;
import be.piyush.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 27/3/16, 2:04 AM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
