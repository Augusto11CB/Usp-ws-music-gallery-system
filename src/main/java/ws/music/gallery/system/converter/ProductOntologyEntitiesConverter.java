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
import ws.music.gallery.system.domain.dto.StoreDTO;

public class ProductOntologyEntitiesConverter {

    public Individual productDTOToindividual(StoreDTO productDTO){
        //TODO
        return null;
    }

    public StoreDTO individualToProductDTO(Individual productIndividual){
        //TODO
        return null;
    }

}
