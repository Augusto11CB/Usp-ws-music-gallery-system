package ws.music.gallery.system.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/recommendation")
public class RecommendationController {

    @ApiOperation(value = "Get recommended stores given a client", hidden = true, response = StoreDTO.class, responseContainer = "List")
    @GetMapping("/get-recommended-stores/")
    public List<StoreDTO> getRecommendedStores(@RequestParam(name = "userCPF", required = true) String userCPF) {
        return Collections.emptyList();
    }

    @ApiOperation(value = "Get recommended products for a client", response = ProductDTO.class, responseContainer = "List")
    @GetMapping("/get-recommended-products/")
    public List<ProductDTO> getRecommendedProducts(@RequestParam(name = "userCPF", required = true) String userCPF) {
        return Collections.emptyList();
    }


}
