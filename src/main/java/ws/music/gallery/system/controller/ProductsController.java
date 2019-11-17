package ws.music.gallery.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductsController {

    @GetMapping("/get-all")
    public List<ProductDTO> getAllProducts() {
        return Collections.emptyList();
    }

    @GetMapping("/get-products/{store-name}/")
    public List<ProductDTO> getProducstOfStore(@PathVariable(value = "store-name") String storeName) {
        return Collections.emptyList();
    }

    @GetMapping("/get-products/{product-type}")
    public List<ProductDTO> getProducstOfType(@PathVariable(value = "product-type") String productType) {
        return Collections.emptyList();
    }
}
