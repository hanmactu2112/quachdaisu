package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "kichthuoctrongluong")
public class KichThuocTrongLuong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "dodai")
    private Double doDai;
    @Column(name = "dorong")
    private Double doRong;
    @Column(name = "domong")
    private Double doMong;
    @Column(name = "trongluong")
    private Double trongLuong;
}
