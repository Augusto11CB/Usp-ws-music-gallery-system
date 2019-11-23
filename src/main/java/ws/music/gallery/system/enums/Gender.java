package ws.music.gallery.system.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {

    FEMALE("MULHER"),
    MALE("HOMEM");

    private String value;
}
