package be.piyush.controller;

// @formatter:off

import be.piyush.darkside.ProductNotFound;
import be.piyush.dto.ProductRequestDTO;
import be.piyush.dto.ProductResponseDTO;
import be.piyush.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: raj
 * Date: 25/4/16, 10:21 PM
 * Purpose :
 *
 * @author : Piyush <pgkaila@gmail.com>
 * @version : 1.0.0
 * @since : TODO update version
 */
// @formatter:on

@RestController
@RequestMapping("/v1/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ProductResponseDTO saveProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.saveProduct(productRequestDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductResponseDTO> getAllProduct() {
        return productService.getAllProduct();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ProductResponseDTO getProductById(@PathVariable(value = "id") String id) throws ProductNotFound {
        return productService.getProductById(id);
    }
}
