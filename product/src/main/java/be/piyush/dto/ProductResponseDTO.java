package be.piyush.dto;

// @formatter:off

import be.piyush.domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 25/4/16, 10:28 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Getter
@Setter
public class ProductResponseDTO {
    private String id;
    private String name;
    private String description;
    private Double price;
    private String brand;
    private List<String> categories;

    public ProductResponseDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.brand = product.getBrand();
        this.categories = product.getCategories();
    }
}
