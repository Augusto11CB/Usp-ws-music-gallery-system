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
import ws.music.gallery.system.domain.dto.RecordPlayerDTO;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RecordPlayerOntologyEntitiesConverter extends ProductOntologyEntitiesConverter {

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    @Autowired
    private OntModel musicGalleryOntologyModel;

    @Autowired
    private StoreOntologyEntitiesConverter storeOntologyEntitiesConverter;

    @Override
    public Individual productDTOToindividual(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getIndividual(productDTO.getURI());
    }

    public ProductDTO individualToProductDTO(Individual productIndividual) {

        Resource storeResource = productIndividual.getProperty(OntologyPropertyAndResourceUtils.soldByStore).getResource();
        StoreDTO storeDTO = storeOntologyEntitiesConverter.resourceToStoreDTO(storeResource);

        if (!productIndividual.hasProperty(RDF.type, new ResourceImpl(OntologyPropertyAndResourceUtils.recordPlayer))) {
            return checkNextIndvToDto(productIndividual).orElse(null);
        }
        return RecordPlayerDTO.builder()
                .name(productIndividual.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                .typeProductAndBusiness(TypeProductAndBusiness.valueOf(productIndividual.getProperty(OntologyPropertyAndResourceUtils.typeIs).getResource().getLocalName().toUpperCase()))
                .brand(productIndividual.getProperty(OntologyPropertyAndResourceUtils.brand).getLiteral().getValue().toString())
                .price(productIndividual.getProperty(OntologyPropertyAndResourceUtils.price).getDouble())
                .soldByStore(storeDTO)
                .URI(productIndividual.getURI())

                .hasRadio(Boolean.parseBoolean(productIndividual.getProperty(OntologyPropertyAndResourceUtils.hasRadio).getLiteral().getValue().toString()))
                .hasUSBPort(Boolean.parseBoolean(productIndividual.getProperty(OntologyPropertyAndResourceUtils.hasUSBPort).getLiteral().getValue().toString()))
                .voltage(Integer.parseInt(productIndividual.getProperty(OntologyPropertyAndResourceUtils.voltage).getLiteral().getValue().toString()))
                .build();
    }


    public Resource productDTOToResource(ProductDTO productDTO) {
        return musicGalleryOntologyModel.getResource(productDTO.getURI());
    }

    public ProductDTO resourceToProductDTO(Resource productResource) {

        Resource storeResource = productResource.getProperty(OntologyPropertyAndResourceUtils.soldByStore).getResource();
        StoreDTO storeDTO = storeOntologyEntitiesConverter.resourceToStoreDTO(storeResource);

        if (!productResource.hasProperty(RDF.type, new ResourceImpl(OntologyPropertyAndResourceUtils.recordPlayer))) {
            return checkNextResourceToDto(productResource).orElse(null);
        }
        return RecordPlayerDTO.builder()
                .name(productResource.getProperty(OntologyPropertyAndResourceUtils.name).getLiteral().getValue().toString())
                .typeProductAndBusiness(TypeProductAndBusiness.valueOf(productResource.getProperty(OntologyPropertyAndResourceUtils.typeIs).getResource().getLocalName().toUpperCase()))
                .brand(productResource.getProperty(OntologyPropertyAndResourceUtils.brand).getLiteral().getValue().toString())
                .price(productResource.getProperty(OntologyPropertyAndResourceUtils.price).getDouble())
                .soldByStore(storeDTO)
                .URI(productResource.getURI())

                .hasRadio(Boolean.parseBoolean(productResource.getProperty(OntologyPropertyAndResourceUtils.hasRadio).getLiteral().getValue().toString()))
                .hasUSBPort(Boolean.parseBoolean(productResource.getProperty(OntologyPropertyAndResourceUtils.hasUSBPort).getLiteral().getValue().toString()))
                .voltage(Integer.parseInt(productResource.getProperty(OntologyPropertyAndResourceUtils.voltage).getLiteral().getValue().toString()))
                .build();
    }


    @Override
    protected Map<String, String> getPropertiesAndTypes() {
        Map<String, String> mapOfPropertiesAndTypes = super.getPropertiesAndTypes();
        mapOfPropertiesAndTypes.put("voltage", MUSIC_GALLERY_URI + "voltage");
        mapOfPropertiesAndTypes.put("hasRadio", MUSIC_GALLERY_URI + "hasRadio");
        mapOfPropertiesAndTypes.put("hasUSBPort", MUSIC_GALLERY_URI + "hasUSBPort");
        return mapOfPropertiesAndTypes;
    }
}
