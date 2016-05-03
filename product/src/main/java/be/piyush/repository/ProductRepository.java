package be.piyush.repository;

// @formatter:off

import be.piyush.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 25/4/16, 8:16 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);
}
