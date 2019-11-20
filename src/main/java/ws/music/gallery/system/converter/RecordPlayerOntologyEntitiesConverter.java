package ws.music.gallery.system.converter;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.Map;

@Data

public class RecordPlayerOntologyEntitiesConverter extends ProductOntologyEntitiesConverter {

    public Individual productDTOToindividual(ProductDTO productDTO) {
        //TODO
        return null;
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {
        //TODO
        return null;
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        //TODO
        return null;
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {
        //TODO
        return null;
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
