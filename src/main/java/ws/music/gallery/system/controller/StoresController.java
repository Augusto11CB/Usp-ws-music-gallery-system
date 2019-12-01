package ws.music.gallery.system.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.service.StoreService;
import ws.music.gallery.system.util.MockObjects;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
*
Listar as Lojas por Nome

Listar as Lojas por Atividade

Listar as Lojas por Ordem Alfabética

*/


@RestController
@RequestMapping(value = "/store")
public class StoresController {

    @Autowired
    StoreService storeService;


    @Autowired
    MockObjects mockObject;

    @ApiOperation(value = "Get all stores in the Music Gallery", response = StoreDTO.class, responseContainer = "List")
    @GetMapping("/get-all")
    public List<StoreDTO> getStores() {

        return storeService.getAllStores();
//        return Arrays.asList(mockObject.mockStore, mockObject.mockStore1, mockObject.mockStore2);
    }

    @ApiOperation(value = "Return all stores in the Music Gallery in alphabetic order", response = StoreDTO.class, responseContainer = "List")
    @GetMapping("/get-all/order-by-name")
    public List<StoreDTO> getStoresOrderByName() {

        return storeService.getAllStoresOrderByName();
        //      List<StoreDTO> list = Arrays.asList(mockObject.mockStore, mockObject.mockStore1, mockObject.mockStore2);
        //    list.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        //  return list;
    }

    @ApiOperation(value = "Get stores in the Music Gallery of a certain type", response = StoreDTO.class, responseContainer = "List")
    @GetMapping("/get-stores-of-type")
    public List<StoreDTO> getStoresByBusinessType(
            @RequestParam(name = "type", required = true) TypeProductAndBusiness type) {

        return storeService.getStoresByBusinessType(type);
//        List<StoreDTO> list = Arrays.asList(mockObject.mockStore, mockObject.mockStore1, mockObject.mockStore2);return list.stream().filter(store -> store.getTypeBusiness().equals(type)).collect(Collectors.toList());
    }

    @ApiIgnore
    @GetMapping("/get-all/by-business-type")
    public Map<TypeProductAndBusiness, List<StoreDTO>> getAllStoresByBusinessType() {

        return Collections.emptyMap();
    }
}
