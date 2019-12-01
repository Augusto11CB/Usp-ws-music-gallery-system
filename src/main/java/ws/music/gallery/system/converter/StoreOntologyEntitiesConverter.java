package ws.music.gallery.system.converter;

import lombok.Data;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

@Component
@Data
public class StoreOntologyEntitiesConverter {

    @Autowired
    private OntModel musicGalleryOntologyModel;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

   public Individual storedtoToIndividual(StoreDTO storeDTO) {

        return musicGalleryOntologyModel.getIndividual(storeDTO.getURI());
    }

    public StoreDTO individualToStoreDTO(Individual storeIndividual) {

        return StoreDTO.builder()
                .name(storeIndividual.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                .typeBusiness(TypeProductAndBusiness.getEnum(storeIndividual.getProperty(OntologyPropertyAndResourceUtils.typeBusiness).getResource().getLocalName()))
                .URI(storeIndividual.getURI())
                .build();
    }

    public Resource storedtoToResource(StoreDTO storeDTO) throws Exception {

        return musicGalleryOntologyModel.getResource(storeDTO.getURI());

    }

    public StoreDTO resourceToStoreDTO(Resource storeResource) {
        System.out.println(storeResource.getProperty(OntologyPropertyAndResourceUtils.typeBusiness).getResource().getLocalName());
        return StoreDTO.builder()
                .name(storeResource.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                .typeBusiness(TypeProductAndBusiness.getEnum(storeResource.getProperty(OntologyPropertyAndResourceUtils.typeBusiness).getResource().getLocalName().toUpperCase()))
                .URI(storeResource.getURI())
                .description("")
                .build();
    }

}
