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
import ws.music.gallery.system.domain.dto.MusicalnstrumentDTO;
import ws.music.gallery.system.domain.dto.ProductDTO;

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

    @Override
    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    @Override
    public ProductDTO individualToProductDTO(Individual productIndividual) {
        return MusicalnstrumentDTO.builder()
                .typeOfInstrument(productIndividual.getProperty(typeOfInstrument).getLiteral().getValue().toString())
                .isSecondHand(Boolean.parseBoolean(productIndividual.getProperty(isSecondHand).getLiteral().getValue().toString()))
                .build();
    }

    @Override
    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    @Override
    public ProductDTO resourceToProductDTO(Resource productResource) {
        return MusicalnstrumentDTO.builder()
                .typeOfInstrument(productResource.getProperty(typeOfInstrument).getLiteral().getValue().toString())
                .isSecondHand(Boolean.parseBoolean(productResource.getProperty(isSecondHand).getLiteral().getValue().toString()))
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
