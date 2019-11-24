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

public class RecordPlayerOntologyEntitiesConverter extends ProductOntologyEntitiesConverter {
    @Autowired
    OntModel musicGalleryOntologyModel;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private Property hasRadio = new PropertyImpl(MUSIC_GALLERY_URI + "hasRadio");
    private Property hasUSBPort = new PropertyImpl(MUSIC_GALLERY_URI + "hasUSBPort");
    private Property voltage = new PropertyImpl(MUSIC_GALLERY_URI + "voltage");

    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {
        return ProductDTO.builder()
                .hasRadio(Boolean.parseBoolean(productIndividual.getProperty(hasRadio).getLiteral().getValue().toString()))
                .hasUSBPort(Boolean.parseBoolean(productIndividual.getProperty(hasUSBPort).getLiteral().getValue().toString()))
                .voltage(Integer.parseInt(productIndividual.getProperty(voltage).getLiteral().getValue().toString()))
                .build();
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {
        return ProductDTO.builder()
                .hasRadio(Boolean.parseBoolean(productResource.getProperty(hasRadio).getLiteral().getValue().toString()))
                .hasUSBPort(Boolean.parseBoolean(productResource.getProperty(hasUSBPort).getLiteral().getValue().toString()))
                .voltage(Integer.parseInt(productResource.getProperty(voltage).getLiteral().getValue().toString()))
                .build();
    }

    @Override
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = super.getPropertiesAndTypes();
        mapOfPropertiesAndTypes.put("voltage", musicGalleryURI + "voltage");
        mapOfPropertiesAndTypes.put("hasRadio", musicGalleryURI + "hasRadio");
        mapOfPropertiesAndTypes.put("hasUSBPort", musicGalleryURI + "hasUSBPort");
        return mapOfPropertiesAndTypes;
    }
}
