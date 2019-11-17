package ws.music.gallery.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/get-all")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get-products/{store-name}/")
    public List<ProductDTO> getProducstOfStore(@PathVariable(value = "store-name") String storeName) {
        return productService.getAllProductsOfStore(storeName);
    }

    @GetMapping("/get-products/{product-type}")
    public List<ProductDTO> getProducstOfType(@PathVariable(value = "product-type") TypeProductAndBusiness productType) {
        return productService.getProductsByType(productType);
    }
}
