package ws.music.gallery.system.controller;

/*
2.2 Simular uma compra, permitindo colocar ou tirar produtos do carrinho de compras

2.3 Para efetivar a compra, o usuário devera estar registrado no sistema
*/

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {


    @PostMapping("/make-purchase")
    @ApiOperation(value = "Perform a purchase given a client and a list of products")
    public void performPurchase(
            @RequestBody(required = true) List<ProductDTO> purchasedProducts,
            @RequestParam(name = "userCPF", required = true) String userCPF
    ) {

    }

    //TODO Maybe create a controller to register the user purchase simulation in order to make recommendations
}
