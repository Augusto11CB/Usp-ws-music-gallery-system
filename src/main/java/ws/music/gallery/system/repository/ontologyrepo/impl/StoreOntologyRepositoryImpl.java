package ws.music.gallery.system.repository.ontologyrepo.impl;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ws.music.gallery.system.converter.StoreOntologyEntitiesConverter;
import ws.music.gallery.system.repository.ontologyrepo.MusicGalleryOntologyRepository;
import ws.music.gallery.system.repository.ontologyrepo.StoreOntologyRepository;
import ws.music.gallery.system.util.OntologyPropertyAndResourceUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Repository
public class StoreOntologyRepositoryImpl implements StoreOntologyRepository {

    @Value("${music.gallery.uri}")
    private String MUSIC_GALLERY_URI;

    private OntModel musicGalleryOntologyModel;

    private MusicGalleryOntologyRepository musicGalleryOntologyRepository;

    private StoreOntologyEntitiesConverter individualAndDTOStoreConverter;

    private final Resource storeResourceDef;

    private final Property typeBusinessProp;

    public StoreOntologyRepositoryImpl(
            OntModel musicGalleryOntologyModel,
            StoreOntologyEntitiesConverter individualAndDTOStoreConverter,
            MusicGalleryOntologyRepository musicGalleryOntologyRepository
    ) {
        this.musicGalleryOntologyRepository = musicGalleryOntologyRepository;
        this.musicGalleryOntologyModel = musicGalleryOntologyModel;
        this.individualAndDTOStoreConverter = individualAndDTOStoreConverter;
        this.storeResourceDef = new ResourceImpl(OntologyPropertyAndResourceUtils.store);
        this.typeBusinessProp = OntologyPropertyAndResourceUtils.typeBusiness;
    }

    @Override
    public Resource getStore(String storeName) {
        return musicGalleryOntologyModel.getResource(MUSIC_GALLERY_URI + storeName);
    }

    @Override
    public List<Individual> getAllStores() {
//        List<Individual> storeIndvList = Collections.emptyList();
//        ExtendedIterator<Individual> iterator = musicGalleryOntologyModel.listIndividuals(storeResourceDef);
//
//        iterator.forEachRemaining(individual ->
//                storeIndvList.add(individual));
//
//        this.printIteratorItens(iterator);
//
//        return storeIndvList;

        return musicGalleryOntologyRepository.getAllResources(storeResourceDef);

    }

    @Override
    public List<Individual> getAllStoresOrderByName() {

        List<Individual> storeIndvList = this.getAllStores();
        storeIndvList.sort(Comparator.comparing(Individual::getLocalName)); //TODO verify format of getLocalName() return

        //List<StoreDTO> storeDTOList = this.getAllStores();
        //storeDTOList.sort(Comparator.comparing(StoreDTO::getName));
        return storeIndvList;
    }

    @Override
    public List<Resource> getAllStoresByBusinessType(Resource typeBusiness) {
//        List<Resource> storeIndvList = Collections.emptyList();
//
//        ResIterator iterator = musicGalleryOntologyModel.listResourcesWithProperty(typeBusiness, type);
//        iterator.forEachRemaining(indv -> storeIndvList.add(indv));
//        return storeIndvList;
        return musicGalleryOntologyRepository.getAllResourcesByProperty(typeBusinessProp, typeBusiness);

    }

    private <T> void printIteratorItens(Iterator<T> ite) {
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }

}
