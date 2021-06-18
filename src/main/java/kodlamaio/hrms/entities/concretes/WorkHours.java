package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "work_hours")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisement"})
public class WorkHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_hours_id")
	private int workHoursId;
	
	@Column(name = "work_hours")
	private String workHours;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workHours")
	private List<JobAdvertisement> jobAdvertisement;
}
