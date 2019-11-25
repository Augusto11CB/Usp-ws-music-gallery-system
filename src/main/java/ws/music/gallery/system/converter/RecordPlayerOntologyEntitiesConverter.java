package ws.music.gallery.system.converter;


import lombok.Data;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.RecordPlayerDTO;

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

    @Override
    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    @Override
    public ProductDTO individualToProductDTO(Individual productIndividual) {
        return RecordPlayerDTO.builder()
                .hasRadio(Boolean.parseBoolean(productIndividual.getProperty(hasRadio).getLiteral().getValue().toString()))
                .hasUSBPort(Boolean.parseBoolean(productIndividual.getProperty(hasUSBPort).getLiteral().getValue().toString()))
                .voltage(Integer.parseInt(productIndividual.getProperty(voltage).getLiteral().getValue().toString()))
                .build();
    }

    @Override
    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    @Override
    public ProductDTO resourceToProductDTO(Resource productResource) {
        return RecordPlayerDTO.builder()
                .hasRadio(Boolean.parseBoolean(productResource.getProperty(hasRadio).getLiteral().getValue().toString()))
                .hasUSBPort(Boolean.parseBoolean(productResource.getProperty(hasUSBPort).getLiteral().getValue().toString()))
                .voltage(Integer.parseInt(productResource.getProperty(voltage).getLiteral().getValue().toString()))
                .build();
    }

}
