package polypatemding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Lienhe")
public class LienHe {
	@Id
	String name;
	String sDT;
	String email;
	@Column(name = "noidung")
	String noiDung;
	
}
