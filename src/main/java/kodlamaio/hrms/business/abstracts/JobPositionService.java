package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.Work;


public interface JobPositionService {
	
	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobPosition);
	DataResult<JobPosition> getById(int id);


}
