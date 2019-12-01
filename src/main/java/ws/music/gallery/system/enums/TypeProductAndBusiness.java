package ws.music.gallery.system.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TypeProductAndBusiness {
    MUSICAL_EQUIPMENT("MusicalEquipment"),
    MUSICAL_MEDIA("MusicalMedia"),
    CLOTHING("Clothing");

    private String value;

    public static TypeProductAndBusiness getEnum(String value) {
        System.out.println("Enum" + value);
        return Arrays.stream(TypeProductAndBusiness.values()).filter(x -> x.getValue().toUpperCase().equals(value)).findFirst().orElse(null);
    }

}