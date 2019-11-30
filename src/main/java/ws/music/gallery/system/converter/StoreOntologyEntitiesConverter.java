package ws.music.gallery.system.converter;

import lombok.Data;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.PropertyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

@Component
@Data
public class StoreOntologyEntitiesConverter {

    @Autowired
    OntModel musicGalleryOntologyModel;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private Property typeBusiness = new PropertyImpl(MUSIC_GALLERY_URI + "typeBusiness");
    private Property name = new PropertyImpl(MUSIC_GALLERY_URI + "name");
    private Property description = new PropertyImpl(MUSIC_GALLERY_URI + "description");

    public Individual storedtoToIndividual(StoreDTO storeDTO) {

        return musicGalleryOntologyModel.getIndividual(storeDTO.getURI());
    }

    public StoreDTO individualToStoreDTO(Individual storeIndividual) {

        return StoreDTO.builder()
                .name(storeIndividual.getProperty(name).getLiteral().getValue().toString())
                .typeBusiness(TypeProductAndBusiness.valueOf(storeIndividual.getProperty(typeBusiness).getResource().getLocalName()))
                .build();
    }

    public Resource storedtoToResource(StoreDTO storeDTO) throws Exception {

        return musicGalleryOntologyModel.getResource(storeDTO.getURI());

    }

    public StoreDTO resourceToStoreDTO(Resource storeResource) {

        return StoreDTO.builder()
                .name(storeResource.getProperty(name).getLiteral().getValue().toString())
                .typeBusiness(TypeProductAndBusiness.valueOf(storeResource.getProperty(typeBusiness).getResource().getLocalName()))
                .URI("")
                .description("")
                .build();
    }

}
