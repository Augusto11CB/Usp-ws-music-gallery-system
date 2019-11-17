package ws.music.gallery.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;
import ws.music.gallery.system.service.StoreService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
*
Listar as Lojas por Nome

Listar as Lojas por Atividade

Listar as Lojas por Ordem Alfabética

*/


@Controller
@RequestMapping(value = "/store")
public class StoresController {

    @Autowired
    StoreService storeService;

    @GetMapping("/get-all")
    public List<StoreDTO> getStores() {

        return storeService.getAllStores();
    }

    @GetMapping("/get-all/order-by-name")
    public List<StoreDTO> getStoresOrderByName() {

        return storeService.getAllStoresOrderByName();
    }

    @GetMapping("/get-stores-of-type/")
    public List<StoreDTO> getStoresByBusinessType(
            @RequestParam(name = "type", required = true) TypeProductAndBusiness type) {

        return storeService.getStoresByBusinessType(type);
    }

    @GetMapping("/get-all/by-business-type")
    public Map<TypeProductAndBusiness, List<StoreDTO>> getAllStoresByBusinessType() {

        return Collections.emptyMap();
    }
}
