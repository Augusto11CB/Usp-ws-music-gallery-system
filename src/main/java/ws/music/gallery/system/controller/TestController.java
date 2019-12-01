
package ws.music.gallery.system.controller;


import io.swagger.annotations.ApiOperation;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ws.music.gallery.system.converter.MusicalInstrumentOntologyEntitiesConverter;
import ws.music.gallery.system.converter.RecordPlayerOntologyEntitiesConverter;
import ws.music.gallery.system.converter.TShirtOntologyEntitiesConverter;
import ws.music.gallery.system.converter.VynlOntologyEntitiesConverter;
import ws.music.gallery.system.domain.dto.ProductDTO;

@RestController
public class TestController {

    @Autowired
    TShirtOntologyEntitiesConverter tShirtOntologyEntitiesConverter;

    @Autowired
    VynlOntologyEntitiesConverter vynlOntologyEntitiesConverter;

    @Autowired
    RecordPlayerOntologyEntitiesConverter recordPlayerOntologyEntitiesConverter;

    @Autowired
    MusicalInstrumentOntologyEntitiesConverter musicalInstrumentOntologyEntitiesConverter;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private OntModel musicGalleryOntologyModel;


    @ApiOperation(value = "Tshirt Convert Controller Test", response = ProductDTO.class, responseContainer = "List")
    @GetMapping("/test")
    public ProductDTO testTshirtConverterIndividualToProductDTO() {
        //Individual indv = musicGalleryOntologyModel.getIndividual(MUSIC_GALLERY_URI + "ComfortableTShirt");
        //return tShirtOntologyEntitiesConverter.individualToProductDTO(indv);
        return null;
    }
}

