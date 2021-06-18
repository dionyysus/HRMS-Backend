package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.business.abstracts.WorkHoursService;
import kodlamaio.hrms.business.abstracts.WorkService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService  {

	private JobAdvertisementDao jobAdvertisementDao;
	
	private CityService cityService;
	private EmployerService employerService;
	private JobPositionService jobPositionService;
	private WorkService workService;
	private WorkHoursService workHoursService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityService cityService,
			EmployerService employerService, JobPositionService jobPositionService, WorkService workService,
			WorkHoursService workHoursService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService = cityService;
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.workService = workService;
		this.workHoursService = workHoursService;
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {
		
		if(!checkAllColumns(jobAdvertisementAddDto).isSuccess()) {
			
			return new ErrorResult("Job advertisement couldn't added");
		}	

		JobAdvertisement jobAdd = new JobAdvertisement();
		
		jobAdd.setCity(cityService.getById(jobAdvertisementAddDto.getCityId()).getData());
		jobAdd.setEmployer(employerService.getById(jobAdvertisementAddDto.getEmployerId()).getData());
		jobAdd.setJobPosition(jobPositionService.getById(jobAdvertisementAddDto.getJobPositionId()).getData());
		jobAdd.setWork(workService.getById(jobAdvertisementAddDto.getWorkTypeId()).getData());
		jobAdd.setWorkHours(workHoursService.getById(jobAdvertisementAddDto.getWorkHoursId()).getData());
		jobAdd.setJobDescription(jobAdvertisementAddDto.getJobDescription());
		jobAdd.setJobMaxWage(jobAdvertisementAddDto.getJobMaxWage());
		jobAdd.setJobMinWage(jobAdvertisementAddDto.getJobMinWage());
		jobAdd.setJobAppDeadline(jobAdvertisementAddDto.getJobAppDeadline());
		jobAdd.setJobNumberOpenPosition(jobAdvertisementAddDto.getJobNumberOpenPosition());
		jobAdd.setJobAdvertisementIsActive(jobAdvertisementAddDto.isJobAdvertisementIsActive());
		jobAdd.setJobAdvertisementIsConfirmed(jobAdvertisementAddDto.isJobAdvertisementIsConfirmed());
		
		jobAdvertisementDao.save(jobAdd);
		
		return new SuccessResult("Job advertisement added.");	
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

	public Result checkAllColumns(JobAdvertisementAddDto jobAdvertisementAddDto) {
		
		if((jobAdvertisementAddDto.getCityId() != 0) && (!jobAdvertisementAddDto.getJobDescription().isBlank()) || (jobAdvertisementAddDto.getJobPositionId() != 0)){
				return new SuccessResult();	
		}	
		return new ErrorResult("");
			
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data listed");
		
	}

	@Override
	public Result changeActiveToPassive(int id) {
		
		if(getById(id)== null) {
			return new ErrorResult("Job advertisement not found");
		}
		
		if(getById(id).getData().isJobAdvertisementIsActive() == false) {
			return new ErrorResult("This job advertisement already close");
		}
		
		JobAdvertisement jobAd = getById(id).getData();
		jobAd.setJobAdvertisementIsActive(false);
		update(jobAd);
		
		return new SuccessResult("Job Advertisement has become inactive");
	}

	@Override
	public Result changeConfirmedFalseToTrue(int id) {
		
		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setJobAdvertisementIsConfirmed(true);
		update(jobAdvertisement);
		
		return new SuccessResult("Job advertisement confirmed");
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).get());
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {

		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement updated");
	}

	@Override
	public Result remove(int id) {
		this.jobAdvertisementDao.deleteById(id);
		return new SuccessResult("Job advertisement deleted");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByJobAdvertisementIsConfirmedFalse() {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByJobAdvertisementIsConfirmedFalse());
	}

	@Override
	public Result changePassiveToActive(int id) {
		
		JobAdvertisement jobAdvertisement = getById(id).getData();
		jobAdvertisement.setJobAdvertisementIsActive(true);
		update(jobAdvertisement);
		
		return new SuccessResult("Job advertisement activated");
	}



	
	

	

	
}
