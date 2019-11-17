package ws.music.gallery.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ws.music.gallery.system.domain.dto.StoreDTO;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

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

    @GetMapping("/get-all")
    public List<StoreDTO> getStores() {
        return Collections.emptyList();
    }

    @GetMapping("/get-all/order-by-name")
    public List<StoreDTO> getStoresOrderByName() {
        return Collections.emptyList();
    }

    @GetMapping("/get-all/order-by-business-type")
    public Map<TypeProductAndBusiness, List<StoreDTO>> getStoresByBusinessType() {
        return Collections.emptyMap();
    }
}
