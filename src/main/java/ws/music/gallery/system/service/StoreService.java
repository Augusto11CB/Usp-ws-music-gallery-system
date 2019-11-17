package ws.music.gallery.system.service;

import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

import java.util.List;
import java.util.Map;

public interface StoreService {

    List<StoreDTO> getAllStores();

    List<StoreDTO> getAllStoresOrderByName();

    List<StoreDTO> getStoresByBusinessType(TypeProductAndBusiness type);

    Map<TypeProductAndBusiness, List<StoreDTO>> getAllStoresByBusinessType();
}
