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
import ws.music.gallery.system.domain.dto.TShirtDTO;
import ws.music.gallery.system.enums.ClothSize;
import ws.music.gallery.system.enums.Gender;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TShirtOntologyEntitiesConverter extends ProductOntologyEntitiesConverter {

    @Autowired
    private OntModel musicGalleryOntologyModel;

    @Autowired
    private StoreOntologyEntitiesConverter storeOntologyEntitiesConverter;

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Override
    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {
        System.out.println("TShirt individualToProductDTO" + productIndividual);
        System.out.println(productIndividual.hasOntClass(OntologyPropertyAndResourceUtils.tshirtClass));

        if (productIndividual.hasProperty(RDF.type, new ResourceImpl(OntologyPropertyAndResourceUtils.tshirtClass))) {

            StoreDTO storeDTO = storeOntologyEntitiesConverter.resourceToStoreDTO(productIndividual.getProperty(OntologyPropertyAndResourceUtils.soldByStore).getResource());
            System.out.println(ClothSize.valueOf(productIndividual.getProperty(OntologyPropertyAndResourceUtils.size).getResource().getLocalName().toUpperCase()));

            return TShirtDTO.builder()
                    .name(productIndividual.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                    .typeProductAndBusiness(TypeProductAndBusiness.valueOf(productIndividual.getProperty(OntologyPropertyAndResourceUtils.typeIs).getResource().getLocalName().toUpperCase()))
                    .brand(productIndividual.getProperty(OntologyPropertyAndResourceUtils.brand).getLiteral().getValue().toString())
                    .price(productIndividual.getProperty(OntologyPropertyAndResourceUtils.price).getDouble())
                    .soldByStore(storeDTO)
                    .URI(productIndividual.getURI())

                    .designatedGender(Gender.valueOf(productIndividual.getProperty(OntologyPropertyAndResourceUtils.designatedGender).getResource().getLocalName().toUpperCase()))
                    .size(ClothSize.valueOf(productIndividual.getProperty(OntologyPropertyAndResourceUtils.size).getResource().getLocalName().toUpperCase()))
                    .typeOfFiber(productIndividual.getProperty(OntologyPropertyAndResourceUtils.typeOfFiber).getLiteral().getValue().toString())
                    .mainColor(productIndividual.getProperty(OntologyPropertyAndResourceUtils.mainColor).getLiteral().getValue().toString())
                    .build();
        }
        return checkNextIndvToDto(productIndividual).orElse(null);
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {

        System.out.println("TShirt resourceToProductDTO:" + productResource);

        Resource storeResource = productResource.getProperty(OntologyPropertyAndResourceUtils.soldByStore).getResource();
        System.out.println(storeResource);

        StoreDTO storeDTO = storeOntologyEntitiesConverter.resourceToStoreDTO(storeResource);
        if (productResource.hasProperty(RDF.type, new ResourceImpl(OntologyPropertyAndResourceUtils.tshirtClass))) {

            return TShirtDTO.builder()
                    .name(productResource.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                    .typeProductAndBusiness(TypeProductAndBusiness.valueOf(productResource.getProperty(OntologyPropertyAndResourceUtils.typeIs).getResource().getLocalName().toUpperCase()))
                    .brand(productResource.getProperty(OntologyPropertyAndResourceUtils.brand).getLiteral().getValue().toString())
                    .price(productResource.getProperty(OntologyPropertyAndResourceUtils.price).getDouble())
                    .soldByStore(storeDTO)
                    .URI(productResource.getURI())

                    .designatedGender(Gender.valueOf(productResource.getProperty(OntologyPropertyAndResourceUtils.designatedGender).getResource().getLocalName().toUpperCase()))
                    .size(ClothSize.valueOf(productResource.getProperty(OntologyPropertyAndResourceUtils.size).getResource().getLocalName().toUpperCase()))
                    .typeOfFiber(productResource.getProperty(OntologyPropertyAndResourceUtils.typeOfFiber).getLiteral().getValue().toString())
                    .mainColor(productResource.getProperty(OntologyPropertyAndResourceUtils.mainColor).getLiteral().getValue().toString())
                    .build();
        }

        return checkNextResourceToDto(productResource).orElse(null);

    }

    @Override
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = super.getPropertiesAndTypes();
        mapOfPropertiesAndTypes.put("gender", MUSIC_GALLERY_URI + "gender");
        mapOfPropertiesAndTypes.put("clothSize", MUSIC_GALLERY_URI + "clothSize");
        mapOfPropertiesAndTypes.put("typeOfFiber", MUSIC_GALLERY_URI + "typeOfFiber");
        mapOfPropertiesAndTypes.put("mainColor", MUSIC_GALLERY_URI + "mainColor");

        return mapOfPropertiesAndTypes;
    }
}
