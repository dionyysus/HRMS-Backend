package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.utilities.result.BusinessRules.BusinessRules;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.Work;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Job positions listed");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result result = BusinessRules.Run(isJobPositionExist(jobPosition));
		
		if(result.isSuccess()) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("Job position added");
		}
		return result;
		
	}
	
	private Result isJobPositionExist(JobPosition jobPosition){
        if(jobPositionDao.findByPositionName(jobPosition.getPositionName()).isPresent()){
            return new ErrorResult("Job exist");
        }
        return new SuccessResult();
    }

	@Override
	public DataResult<JobPosition> getById(int id) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findById(id));
	}

}
