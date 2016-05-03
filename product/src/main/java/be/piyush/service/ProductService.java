package be.piyush.service;

// @formatter:off

import be.piyush.darkside.ProductNotFound;
import be.piyush.domain.Product;
import be.piyush.dto.ProductRequestDTO;
import be.piyush.dto.ProductResponseDTO;
import be.piyush.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 25/4/16, 8:26 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDTO saveProduct(ProductRequestDTO productRequest) {
        Product product = productRepository.save(new Product(productRequest));
        return new ProductResponseDTO(product);
    }

    public ProductResponseDTO getProductById(String id) throws ProductNotFound {
        Product product = productRepository.findOne(id);
        if (product != null) {
            return new ProductResponseDTO(product);
        }
        throw new ProductNotFound("Product not found.");
    }

    public List<ProductResponseDTO> getAllProduct() {
        //TODO Add pagination
        return productRepository.findAll()
                .stream()
                .map(p -> new ProductResponseDTO(p))
                .collect(Collectors.toList());
    }
}
