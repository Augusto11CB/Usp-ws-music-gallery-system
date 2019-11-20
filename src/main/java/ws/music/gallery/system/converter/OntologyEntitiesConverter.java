package ws.music.gallery.system.converter;


import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.ProductDTO;

@Component
public interface OntologyEntitiesConverter {

    Individual productDTOToindividual(ProductDTO productDTO);

    ProductDTO individualToProductDTO(Individual productIndividual);

    Resource productDTOToResource(ProductDTO productDTO);

    ProductDTO resourceToProductDTO(Resource productResource);

}
