package ws.music.gallery.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.util.MockObjects;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    MockObjects mockObject;


    @GetMapping()
    public List<ProductDTO> searchForProducts(@RequestParam(value = "product") String productSearched) {
        return Arrays.asList(mockObject.mockProduct, mockObject.mockThirt1, mockObject.mockThirt2);
    }

    @GetMapping("/{userCPF}/")
    public List<ProductDTO> userSearchForProducts(
            @PathVariable(value = "userCPF") String userCPF,
            @RequestParam(value = "product") String productSearched) {
        return Arrays.asList(mockObject.mockProduct, mockObject.mockThirt1, mockObject.mockThirt2);
    }
}
