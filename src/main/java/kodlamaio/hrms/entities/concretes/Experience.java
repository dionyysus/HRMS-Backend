package kodlamaio.hrms.entities.concretes;

import java.util.Date;

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
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experience")
public class Experience {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    private int id;
	
	
	@Column(name = "company_name")
	@NotNull
	@NotBlank
	private String companyName;
	
	@Column(name = "position")
	@NotNull
	@NotBlank
	private String position;
	
	@Column(name = "started_date")
	@NotNull
	@NotBlank
	private Date startedDate;
	
	@Column(name = "end_date")
	@NotNull
	@NotBlank
	private Date endDate;
	
	@ManyToOne()
	@JsonIgnore()
    @JoinColumn(name = "id")
	private Employee employee;
	
}
