package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> findByJobAdvertisementIsActive();
	
	DataResult<List<JobAdvertisement>> findByOrderByJobAdvertisementPostedDate();
	
	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployer(int id);
}