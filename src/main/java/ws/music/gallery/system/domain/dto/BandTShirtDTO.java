package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BandTShirtDTO extends TShirtDTO {

    private String band;
    private String musicalGenre; //TODO Enum?
}
