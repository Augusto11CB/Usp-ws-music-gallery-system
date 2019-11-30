package ws.music.gallery.system.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.util.MockObjects;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/recommendation")
public class RecommendationController {

    @Autowired
    MockObjects mockObject;

    @ApiOperation(value = "Get recommended stores given a client", hidden = true, response = StoreDTO.class, responseContainer = "List")
    @GetMapping("/get-recommended-stores/")
    public List<StoreDTO> getRecommendedStores(@RequestParam(name = "userCPF", required = true) String userCPF) {
        return Arrays.asList(mockObject.mockStore, mockObject.mockStore1, mockObject.mockStore2);
    }

    @ApiOperation(value = "Get recommended products for a client", response = ProductDTO.class, responseContainer = "List")
    @GetMapping("/get-recommended-products/")
    public List<ProductDTO> getRecommendedProducts(@RequestParam(name = "userCPF", required = true) String userCPF) {
        return Arrays.asList(mockObject.mockProduct, mockObject.mockThirt1, mockObject.mockThirt2);
    }


}
