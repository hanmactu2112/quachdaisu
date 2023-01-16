package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "phukien")
public class PhuKien extends SanPham implements Serializable {
}
