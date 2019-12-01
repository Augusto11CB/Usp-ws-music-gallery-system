package ws.music.gallery.system.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.domain.dto.TShirtDTO;
import ws.music.gallery.system.enums.ClothSize;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

@Component
public class MockObjects {

    private @Value("${music.gallery.uri}")
    String MUSIC_URI;


    public StoreDTO mockStore = StoreDTO.builder()
            .name("All Rock TShirts")
            .typeBusiness(TypeProductAndBusiness.CLOTHING)
            .URI(MUSIC_URI + "AllRockTshirts")
            .description("GENERICO")
            .build();

    public StoreDTO mockStore1 = StoreDTO.builder()
            .name("Pierre Instrumentos Musicais")
            .typeBusiness(TypeProductAndBusiness.MUSICAL_EQUIPMENT)
            .URI(MUSIC_URI + "PierreInstrumentosMusicais")
            .description("GENERICO")
            .build();

    public StoreDTO mockStore2 = StoreDTO.builder()
            .name("Rock Planet")
            .typeBusiness(TypeProductAndBusiness.MUSICAL_MEDIA)
            .URI(MUSIC_URI + "RockPlanet")
            .description("GENERICO")
            .build();

    public ProductDTO mockProduct = ProductDTO.builder()
            .brand("Hering")
            .price(30.50)
            .URI(MUSIC_URI)
            .name("Camiseta Preta")
            .soldByStore(mockStore)
            .typeProductAndBusiness(TypeProductAndBusiness.CLOTHING)
            .build();

    public TShirtDTO mockThirt1 = TShirtDTO.builder()
            .designatedGender(Gender.MALE)
            .brand("Levis")
            .soldByStore(mockStore)
            .price(80)
            .URI(MUSIC_URI)
            .typeProductAndBusiness(TypeProductAndBusiness.CLOTHING)
            .size(ClothSize.SMALL)
            .name("Camiseta Branca")
            .mainColor("Branca")
            .typeOfFiber("Algodão")
            .build();

    public TShirtDTO mockThirt2 = TShirtDTO.builder()
            .designatedGender(Gender.MALE)
            .brand("Renner")
            .soldByStore(mockStore)
            .price(180)
            .URI(MUSIC_URI)
            .typeProductAndBusiness(TypeProductAndBusiness.CLOTHING)
            .size(ClothSize.MEDIUM)
            .name("Camisa Polo")
            .mainColor("Azul")
            .typeOfFiber("Algodão")
            .build();
}
