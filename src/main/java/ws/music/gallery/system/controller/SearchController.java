package ws.music.gallery.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @GetMapping()
    public List<ProductDTO> searchForProducts(@RequestParam(value = "product") String productSearched) {
        return Collections.emptyList();
    }

    @GetMapping("/{userCPF}/")
    public List<ProductDTO> userSearchForProducts(
            @PathVariable(value = "userCPF") String userCPF,
            @RequestParam(value = "product") String productSearched) {
        return Collections.emptyList();
    }
}
