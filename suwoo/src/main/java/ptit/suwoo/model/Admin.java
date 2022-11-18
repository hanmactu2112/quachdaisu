package ptit.suwoo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "admin")
public class Admin extends NguoiDung{

}
