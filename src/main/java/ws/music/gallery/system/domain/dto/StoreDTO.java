package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ws.music.gallery.system.enums.TypeProductAndBusiness;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private String name;
    private TypeProductAndBusiness typeBusiness;
    private String URI;
    private String description;

}
