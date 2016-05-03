package be.piyush.domain;

// @formatter:off

import be.piyush.dto.ProductRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 25/4/16, 7:59 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Document
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private Double price;
    private String brand;
    private List<String> categories;

    public Product(ProductRequestDTO productRequestDTO) {
        this.name = productRequestDTO.getName();
        this.description = productRequestDTO.getDescription();
        this.price = productRequestDTO.getPrice();
        this.brand = productRequestDTO.getBrand();
        this.categories = productRequestDTO.getCategories();
    }
}
