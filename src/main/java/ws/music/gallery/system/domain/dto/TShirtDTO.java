package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ws.music.gallery.system.enums.ClothSize;
import ws.music.gallery.system.enums.Gender;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TShirtDTO extends ProductDTO{

    private ClothSize size;
    private Gender designatedGender;
    private String mainColor;
    private String typeOfFiber;

}
