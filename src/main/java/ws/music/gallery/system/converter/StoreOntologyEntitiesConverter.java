package ws.music.gallery.system.converter;

/*
*
* TODO Create interface to define the convertion behavior
*   Create inside this interface methods with generic parameters
*
* TODO For each entity that needs to implement this interface, the methods parameters will be adapted for attending their necessity
* */

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.StoreDTO;

@Component
public class StoreOntologyEntitiesConverter {

    public Individual StoredtoToIndividual(StoreDTO storeDTO){
        //TODO
        return null;
    }

    public StoreDTO individualToStoreDTO(Individual storeIndividual){
        //TODO
        return null;
    }

    public Resource StoredtoToResource(StoreDTO storeDTO){
        //TODO
        return null;
    }

    public StoreDTO resourceToStoreDTO(Resource storeResource){
        //TODO
        return null;
    }

}
