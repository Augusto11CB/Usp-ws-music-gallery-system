package ws.music.gallery.system.service.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.converter.ProductOntologyEntitiesConverter;
import ws.music.gallery.system.domain.dto.ProductDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.repository.ProductOntologyRepository;
import ws.music.gallery.system.repository.StoreOntologyRepository;
import ws.music.gallery.system.service.ProductService;
import ws.music.gallery.system.utils.OntologyResourcesAndPropertiesUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private StoreOntologyRepository storeOntologyRepository;

    @Autowired
    private ProductOntologyRepository productOntologyRepository;

    @Autowired
    private ProductOntologyEntitiesConverter productConverter;

    @Override
    public List<ProductDTO> getAllProducts() {

        List<Individual> indvList = productOntologyRepository.getAllProducts();
        List<ProductDTO> productDTOList = indvList.stream().map(indv ->
                productConverter.individualToProductDTO(indv)).collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public List<ProductDTO> getAllProductsOfStore(String storeName) {

        Resource store = storeOntologyRepository.getStore(storeName);
        List<Resource> indvList = productOntologyRepository.getAllProductsOfStore(store);
        List<ProductDTO> productDTOList = indvList.stream().map(indv ->
                productConverter.resourceToProductDTO(indv)).collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public List<ProductDTO> getProductsByType(TypeProductAndBusiness type) {

        Resource productType = OntologyResourcesAndPropertiesUtil.getBusinessOrProductType(type);

        List<Resource> indvList = productOntologyRepository.getAllProductsOfStore(productType);
        List<ProductDTO> productDTOList = indvList.stream().map(indv ->
                productConverter.resourceToProductDTO(indv)).collect(Collectors.toList());

        return productDTOList;
    }

    @Override
    public Map<TypeProductAndBusiness, List<ProductDTO>> getAllProductsByType() {
        //TODO implement getAllProductsByType
        return null;
    }
}
