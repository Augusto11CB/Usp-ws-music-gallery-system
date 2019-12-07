package ws.music.gallery.system.domain;

import javax.persistence.*;


@Entity
@Table(name = "PRODUCT", schema = "MUSIC_GALLERY")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER_PURCHASE", unique = true, nullable = false)
    private long idProduct;

    @Column(name = "PRODUCT_URL", nullable = false)
    private String productURI;

    @Column(name = "AVAILABLE_QUANTITY", nullable = false)
    private int availableQuantity;

}
