package ws.music.gallery.system.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ws.music.gallery.system.enums.Gender;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "USER", schema = "MUSIC_GALLERY")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USER", unique = true, nullable = false)
    private Long idUser;

    @Column(name = "CPF_USER", nullable = false, unique = true)
    private String cpfUser;

    @Column(name = "PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "AGE")
    private int age;
}
