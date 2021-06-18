package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;

public interface JobAdvertisementService {

	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	Result update(JobAdvertisement jobAdvertisement);
	Result remove(int id);
	Result changeActiveToPassive(int id);
	
	Result changePassiveToActive(int id);

	Result changeConfirmedFalseToTrue(int id);

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<JobAdvertisement> getById(int id);

	DataResult<List<JobAdvertisement>> findByJobAdvertisementIsActive();
	
	DataResult<List<JobAdvertisement>> findByOrderByJobAdvertisementPostedDate();
	
	DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployer(int id);

	DataResult<List<JobAdvertisement>> getAllByJobAdvertisementIsConfirmedFalse();
}