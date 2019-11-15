package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TShirtDTO extends ProductDTO{

    private String size; // TODO Enum?
    private String designatedGender; // TODO Enum?
    private String mainColor;
    private String typeOfFiber;

}
