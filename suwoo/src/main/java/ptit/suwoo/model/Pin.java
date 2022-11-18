package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pin")
public class Pin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dungluong")
    private Integer dungLuong;
    @Column(name = "loaipin")
    private String loaiPin;
    @Column(name = "congnghe")
    private String congNghe;
}
