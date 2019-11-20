package ws.music.gallery.system.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.StoreDTO;

@Component
@Data
public class StoreOntologyEntitiesConverter {

    public Individual StoredtoToIndividual(StoreDTO storeDTO) {
        //TODO
        return null;
    }

    public StoreDTO individualToStoreDTO(Individual storeIndividual) {
        //TODO
        return null;
    }

    public Resource StoredtoToResource(StoreDTO storeDTO) {
        //TODO
        return null;
    }

    public StoreDTO resourceToStoreDTO(Resource storeResource) {
        //TODO
        return null;
    }

}
