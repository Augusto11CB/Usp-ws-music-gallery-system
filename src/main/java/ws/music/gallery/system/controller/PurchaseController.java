package ws.music.gallery.system.controller;

/*
2.2 Simular uma compra, permitindo colocar ou tirar produtos do carrinho de compras

2.3 Para efetivar a compra, o usuário devera estar registrado no sistema
*/

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.service.PurchaseService;

import java.util.List;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/make-purchase")
    @ApiOperation(value = "Perform a purchase given a client and a list of products")
    public ResponseEntity performPurchase(
            @RequestBody(required = true) List<ProductDTO> purchasedProducts,
            @RequestParam(required = true, name = "cpf") String cpf,
            @RequestParam(name = "gender", required = false) Gender gender,
            @RequestParam(name = "age", required = false) int age

    ) {
        purchaseService.performPurchase(purchasedProducts, cpf, gender, age);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    //TODO Maybe create a controller to register the user purchase simulation in order to make recommendations
}
