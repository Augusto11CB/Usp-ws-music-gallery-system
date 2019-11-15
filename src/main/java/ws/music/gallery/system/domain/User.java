package ws.music.gallery.system.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import ws.music.gallery.system.enums.Gender;

import javax.persistence.*;

@Entity
@Table(name = "USER", schema = "MUSIC_GALLERY_INDOOR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
