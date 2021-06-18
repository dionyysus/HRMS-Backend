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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "job_advertisement_is_confirmed")
	private boolean jobAdvertisementIsConfirmed = false;
	
	@Column(name = "job_advertisement_max_wage")
	private int jobMaxWage;
	
	@Column(name = "job_advertisement_min_wage")
	private int jobMinWage;
	
	@Column(name = "job_advertisement_number_open_position")
	private int jobNumberOpenPosition;
	
	@Column(name = "job_advertisement_posted_date")
	private Date jobAdvertisementPostedDate;
	
	@Column(name="job_advertisement_is_active")
	private boolean jobAdvertisementIsActive = false;
	
	@Column(name = "job_advertisement_app_deadline")
	private Date jobAppDeadline;
	
	
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

	
	@ManyToOne()
	@JoinColumn(name = "id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "work_id")
	private Work work;	
	
	@ManyToOne()
	@JoinColumn(name = "work_hours_id")
	private WorkHours workHours;	


	
	

	
	
}
