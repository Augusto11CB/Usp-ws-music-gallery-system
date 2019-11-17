package ws.music.gallery.system.controller;

/*
2.2 Simular uma compra, permitindo colocar ou tirar produtos do carrinho de compras

2.3 Para efetivar a compra, o usuário devera estar registrado no sistema
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.List;

@Controller
@RequestMapping(value = "/purchase")
public class PurchaseController {


    @PostMapping("/make-purchase")
    public void performPurchase(
            @RequestBody(required = true) List<ProductDTO> purchasedProducts,
            @RequestParam(name = "userCPF", required = true) String userCPF
    ) {

    }

    //TODO Maybe create a controller to register the user purchase simulation in order to make recommendations
}
