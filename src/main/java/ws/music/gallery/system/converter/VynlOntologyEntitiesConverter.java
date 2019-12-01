package ws.music.gallery.system.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.apache.jena.vocabulary.RDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.domain.dto.VynlDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class VynlOntologyEntitiesConverter extends ProductOntologyEntitiesConverter {

    @Autowired
    private OntModel musicGalleryOntologyModel;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private StoreOntologyEntitiesConverter storeOntologyEntitiesConverter;


    @Override
    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {

        Resource storeResource = productIndividual.getProperty(OntologyPropertyAndResourceUtils.soldByStore).getResource();
        StoreDTO storeDTO = storeOntologyEntitiesConverter.resourceToStoreDTO(storeResource);

        if (productIndividual.hasProperty(RDF.type, new ResourceImpl(OntologyPropertyAndResourceUtils.vynl))) {
            return VynlDTO.builder()
                    .name(productIndividual.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                    .typeProductAndBusiness(TypeProductAndBusiness.valueOf(productIndividual.getProperty(OntologyPropertyAndResourceUtils.typeIs).getResource().getLocalName().toUpperCase()))
                    .brand(productIndividual.getProperty(OntologyPropertyAndResourceUtils.brand).getLiteral().getValue().toString())
                    .price(productIndividual.getProperty(OntologyPropertyAndResourceUtils.price).getDouble())
                    .soldByStore(storeDTO)
                    .URI(productIndividual.getURI())


                    .musicalGenre(productIndividual.getProperty(OntologyPropertyAndResourceUtils.musicalGenre).getLiteral().getValue().toString())
                    .releaseYear(Integer.parseInt(productIndividual.getProperty(OntologyPropertyAndResourceUtils.releaseYear).getLiteral().getValue().toString()))
                    .band(productIndividual.getProperty(OntologyPropertyAndResourceUtils.band).getLiteral().getValue().toString())
                    .build();
        }

        return checkNextIndvToDto(productIndividual).orElse(null);
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {
        Resource vynls = new ResourceImpl(OntologyPropertyAndResourceUtils.vynl);
        System.out.println("resourceToProductDTO: " + productResource);
        System.out.println(productResource.hasProperty(RDF.type, vynls));
        //System.out.println(productResource.has(productResource);

        Resource storeResource = productResource.getProperty(OntologyPropertyAndResourceUtils.soldByStore).getResource();
        StoreDTO storeDTO = storeOntologyEntitiesConverter.resourceToStoreDTO(storeResource);


        if (productResource.hasProperty(RDF.type, vynls)) {

            return VynlDTO.builder()
                    .name(productResource.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                    .typeProductAndBusiness(TypeProductAndBusiness.valueOf(productResource.getProperty(OntologyPropertyAndResourceUtils.typeIs).getResource().getLocalName().toUpperCase()))
                    .brand(productResource.getProperty(OntologyPropertyAndResourceUtils.brand).getLiteral().getValue().toString())
                    .price(productResource.getProperty(OntologyPropertyAndResourceUtils.price).getDouble())
                    .soldByStore(storeDTO)
                    .URI(productResource.getURI())

                    .musicalGenre(productResource.getProperty(OntologyPropertyAndResourceUtils.musicalGenre).getLiteral().getValue().toString())
                    .releaseYear(Integer.parseInt(productResource.getProperty(OntologyPropertyAndResourceUtils.releaseYear).getLiteral().getValue().toString()))
                    .band(productResource.getProperty(OntologyPropertyAndResourceUtils.band).getLiteral().getValue().toString())
                    .build();
        }
        return checkNextResourceToDto(productResource).orElse(null);
    }
}
