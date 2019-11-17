package ws.music.gallery.system.service.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.music.gallery.system.converter.StoreOntologyEntitiesConverter;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.repository.StoreOntologyRepository;
import ws.music.gallery.system.service.StoreService;
import ws.music.gallery.system.utils.PropertiesWrapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreOntologyRepository storeOntologyRepository;

    @Autowired
    private StoreOntologyEntitiesConverter storeConverter;


    @Override
    public List<StoreDTO> getAllStores() {
        List<Individual> individualsList = storeOntologyRepository.getAllStores();
        List<StoreDTO> storeDTOList = individualsList.stream().map(indv ->
                storeConverter.individualToStoreDTO(indv)).collect(Collectors.toList());
        return storeDTOList;

    }

    @Override
    public List<StoreDTO> getAllStoresOrderByName() {
        List<Individual> individualsList = storeOntologyRepository.getAllStoresOrderByName();
        List<StoreDTO> storeDTOList = individualsList.stream().map(indv ->
                storeConverter.individualToStoreDTO(indv)).collect(Collectors.toList());
        return storeDTOList;

    }

    @Override
    public List<StoreDTO> getStoresByBusinessType(TypeProductAndBusiness type) {
        Property typeBusiness = PropertiesWrapper.getBusinessOrProductType(type);
        List<Resource> resourceList = storeOntologyRepository.getAllStoresByBusinessType(typeBusiness);
        List<StoreDTO> storeDTOList = resourceList.stream().map(indv ->
                storeConverter.resourceToStoreDTO(indv)).collect(Collectors.toList());
        return storeDTOList;
    }

    @Override
    public Map<TypeProductAndBusiness, List<StoreDTO>> getAllStoresByBusinessType() {
        //TODO implement getAllStoresByBusinessType
        return null;
    }
}
