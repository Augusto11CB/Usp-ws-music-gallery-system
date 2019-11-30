package ws.music.gallery.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TypeProductAndBusiness
{
    MUSICAL_EQUIPMENT("MusicalEquipment"),
    MUSICAL_MEDIA("MusicalMedia"),
    CLOTHING("Clothing");

    private String value;

}