package ws.music.gallery.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VynlDTO extends ProductDTO {

    private String musicalGenre; //TODO Enum?
    private int releaseYear;
    private String band;
}
