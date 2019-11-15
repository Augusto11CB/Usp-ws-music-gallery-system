package ws.music.gallery.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.Collections;
import java.util.List;

@Controller
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
