package ws.music.gallery.system.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import ws.music.gallery.system.domain.dto.*;
import ws.music.gallery.system.enums.ClothSize;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.service.ProductService;
import ws.music.gallery.system.util.MockObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductsController {

    @Autowired
    ProductService productService;

    @Autowired
    MockObjects mockObject;


    @ApiOperation(value = "Get all products available in the Music Gallery", response = ProductDTO.class, responseContainer = "List")
    @GetMapping("/get-all")
    public List<ProductDTO> getAllProducts() {


        return productService.getAllProducts();
        //return Arrays.asList(mockObject.mockProduct, mockObject.mockThirt1, mockObject.mockThirt2);
    }

    @ApiOperation(value = "Get product of a certain type", response = ProductDTO.class, responseContainer = "List", notes = "See Types Available")
    @GetMapping("/get-products/{product-type}")
    public List<ProductDTO> getProducstOfType(@PathVariable(value = "product-type") TypeProductAndBusiness productType) {
//        return productService.getProductsByType(productType);
        return Arrays.asList(mockObject.mockProduct, mockObject.mockThirt1, mockObject.mockThirt2);
    }

    @ApiOperation(value = "Get all products available in a store", response = ProductDTO.class, responseContainer = "List")
    @GetMapping("/get-products/store/{store-name}/")
    public List<ProductDTO> getProducstOfStore(@PathVariable(value = "store-name") String storeName) {
//        return productService.getAllProductsOfStore(storeName);
        return Arrays.asList(mockObject.mockProduct, mockObject.mockThirt1, mockObject.mockThirt2);
    }

    @ApiIgnore
    @GetMapping("/test-get-products")
    public List<ProductDTO> testGetProducts() {
        StoreDTO pierreInstrumentosMusicais = StoreDTO.builder()
                .name("All Rock TShirts")
                .typeBusiness(TypeProductAndBusiness.CLOTHING)
                .build();

        StoreDTO allRockTshirts = StoreDTO.builder()
                .name("Pierre Instrumentos Musicais")
                .typeBusiness(TypeProductAndBusiness.CLOTHING)
                .build();

        BandTShirtDTO bandTShirtDTO = BandTShirtDTO.builder()
                .band("Scorpions")
                .musicalGenre("rock")
                .size(ClothSize.SMALL)
                .designatedGender(Gender.MALE)
                .mainColor("white")
                .typeOfFiber("Jeans")
                .name("Tshirt scorpinos nice")
                .typeProductAndBusiness(TypeProductAndBusiness.CLOTHING)
                .brand("scorpions")
                .price(120)
                .soldByStore(pierreInstrumentosMusicais)
                .build();

        RecordPlayerDTO recordPlayerDTO = RecordPlayerDTO.builder()
                .hasRadio(true)
                .hasRadio(false)
                .voltage(120)
                .typeProductAndBusiness(TypeProductAndBusiness.MUSICAL_EQUIPMENT)
                .brand("Phillips")
                .price(601)
                .soldByStore(allRockTshirts)
                .build();

        ArrayList<ProductDTO> products = new ArrayList<ProductDTO>(
                Arrays.asList(bandTShirtDTO, recordPlayerDTO));

        return products;
    }
}
