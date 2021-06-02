package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService  {

	private JobAdvertisementDao jobAdvertisementDao;
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		
		if(checkAllColumns(jobAdvertisement).isSuccess()) {
			
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessResult("Job advertisement added.");			
		}	
		
		return new ErrorResult("Job advertisement couldn't added");
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByJobAdvertisementIsActive() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByJobAdvertisementIsActiveTrue(), "Active job postings listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByOrderByJobAdvertisementPostedDate() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByOrderByJobAdvertisementPostedDate(), "Job postings listed by date.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllActiveJobAdvertisementByEmployer(id), "Job postings of employers.");
	}

	public Result checkAllColumns(JobAdvertisement jobAdvertisement) {
		
		if((jobAdvertisement.getCity() != null) && (!jobAdvertisement.getJobDescription().isBlank()) && (jobAdvertisement.getJobPosition() != null)){
				return new SuccessResult();	
		}	
		return new ErrorResult("");
			
		
	}

	

	
}
