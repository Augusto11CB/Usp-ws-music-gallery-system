package ws.music.gallery.system.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Value;
import ws.music.gallery.system.domain.dto.ProductDTO;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class ProductOntologyEntitiesConverter {

    @Value("${music.gallery.uri}")
    protected String musicGalleryURI;


    private ProductOntologyEntitiesConverter nextProductConverter;

    public ProductOntologyEntitiesConverter linkWith(ProductOntologyEntitiesConverter next) {
        this.nextProductConverter = next;
        return nextProductConverter;
    }


    abstract public Individual productDTOToindividual(ProductDTO productDTO);

    abstract public ProductDTO individualToProductDTO(Individual productIndividual);

    abstract public Resource productDTOToResource(ProductDTO productDTO);

    abstract public ProductDTO resourceToProductDTO(Resource productResource);



    protected Optional<ProductDTO> checkNextIndvToDto(Individual individual) {
        return Objects.nonNull(nextProductConverter) ?
                nextProductConverter.checkNextIndvToDto(individual) : Optional.empty();
    }

    protected Optional<Individual> checkNextDtoToIndividual(ProductDTO productDTO) {
        return Objects.nonNull(nextProductConverter) ?
                nextProductConverter.checkNextDtoToIndividual(productDTO) : Optional.empty();
    }

    protected Optional<ProductDTO> checkNextResourceToDto(Resource res) {
        return Objects.nonNull(nextProductConverter) ?
                nextProductConverter.checkNextResourceToDto(res) : Optional.empty();
    }

    protected Optional<Resource> checkNextDtoToResource(ProductDTO productDTO) {
        return Objects.nonNull(nextProductConverter) ?
                nextProductConverter.checkNextDtoToResource(productDTO) : Optional.empty();
    }

    //TODO create logic to retrive data from DB in order to keep easy the update of url and names that can change
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = Collections.emptyMap();
        mapOfPropertiesAndTypes.put("name", musicGalleryURI + "name");
        mapOfPropertiesAndTypes.put("price", musicGalleryURI + "price");
        mapOfPropertiesAndTypes.put("branch", musicGalleryURI + "branch");
        mapOfPropertiesAndTypes.put("typeIs", musicGalleryURI + "typeIs");
        mapOfPropertiesAndTypes.put("soldByStore", musicGalleryURI + "soldByStore");
        //mapOfPropertiesAndTypes.put("boughtByUser", musicGalleryURI + "boughtByUser");

        return mapOfPropertiesAndTypes;
    }
}
