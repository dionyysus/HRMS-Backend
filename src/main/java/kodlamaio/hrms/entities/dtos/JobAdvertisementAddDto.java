package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementAddDto {

	private String jobDescription;
	@JsonIgnore
	private boolean jobAdvertisementIsConfirmed = false;
	private int jobMaxWage;
	private int jobMinWage;
	private int jobNumberOpenPosition;
	@JsonIgnore
	private boolean jobAdvertisementIsActive = false;
	private Date jobAppDeadline;

	private int employerId;
	private int cityId;
	private int jobPositionId;
	private int workTypeId;
	private int workHoursId;
	
	
}
