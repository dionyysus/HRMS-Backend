package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="education")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int education_id;
	
	@Column(name = "school_name")
	@NotNull
	@NotBlank
	private String schoolName;
	
	@Column(name = "department_name")
	@NotNull
	@NotBlank
	private String departmentName;

	@Column(name = "started_year")
	@NotNull
	@NotBlank
	private Date startedYear;

	@Column(name = "graduated_year")
	@NotNull
	@NotBlank
	private Date graduatedYear;
	
	@ManyToOne
	@JsonIgnore()
	@JoinColumn(name = "id")
	private Employee employee;
}	
