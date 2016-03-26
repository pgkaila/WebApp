package be.piyush.core.repository;

// @formatter:off

import be.piyush.core.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 27/3/16, 1:36 AM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
