package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "img")
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "url")
    private String url;
    @Column(name = "mota")
    private String moTa;
}
