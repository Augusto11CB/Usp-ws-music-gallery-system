package ws.music.gallery.system.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicalInstrumentOntologyEntitiesConverter extends ProductOntologyEntitiesConverter{

    @Autowired
    OntModel musicGalleryOntologyModel;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private Property typeOfInstrument = new PropertyImpl(MUSIC_GALLERY_URI + "typeOfInstrument");
    private Property isSecondHand = new PropertyImpl(MUSIC_GALLERY_URI + "isSecondHand");

    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {
        return ProductDTO.builder()
                .typeOfInstrument(productIndividual.getProperty(typeOfInstrument).getLiteral().getValue().toString())
                .isSecondHand(Boolean.parseBoolean(productIndividual.getProperty(isSecondHand).getLiteral().getValue().toString()))
                .build();
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {
        return ProductDTO.builder()
                .typeOfInstrument(productResource.getProperty(typeOfInstrument).getLiteral().getValue().toString())
                .isSecondHand(productResource.getProperty(isSecondHand).getLiteral().getValue().toString())
                .build();
    }

    @Override
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = super.getPropertiesAndTypes();
        mapOfPropertiesAndTypes.put("typeOfInstrument", musicGalleryURI + "typeOfInstrument");
        mapOfPropertiesAndTypes.put("isSecondHand", musicGalleryURI + "isSecondHand");
        return mapOfPropertiesAndTypes;
    }
}
