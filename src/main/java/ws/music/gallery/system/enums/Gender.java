package ws.music.gallery.system.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public enum Gender {

    FEMALE("MULHER"),
    MALE("HOMEM");

    private String value;
}
