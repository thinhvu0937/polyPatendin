package polypatemding.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "Congthuc")
public class Congthuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column(name = "Information")
	String Information;
	String image;
	String Title;
	@Temporal(TemporalType.DATE)
	@Column(name= "createdate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	 Date createDate;
	
	
}
