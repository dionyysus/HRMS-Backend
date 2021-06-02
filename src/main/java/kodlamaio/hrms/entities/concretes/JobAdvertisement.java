package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int jobAdvertisementId;
	
	@Column(name = "job_advertisement_description")
	private String jobDescription;
	
	@Column(name = "job_advertisement_max_wage")
	private int jobMaxWage;
	
	@Column(name = "job_advertisement_min_wage")
	private int jobMinWage;
	
	@Column(name = "job_advertisement_number_open_position")
	private int jobNumberOpenPosition;
	
	@Column(name = "job_advertisement_posted_date")
	private LocalDate jobAdvertisementPostedDate;
	
	@Column(name="job_advertisement_is_active")
	private boolean jobAdvertisementIsActive;
	
	@Column(name = "job_advertisement_app_deadline")
	private LocalDate jobAppDeadline;
	
	
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	
	@ManyToOne()
	@JoinColumn(name = "id")
	private Employer employer;
	
	
	

	
	
}
