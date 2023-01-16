package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "admin")
public class Admin extends NguoiDung implements Serializable {

}
