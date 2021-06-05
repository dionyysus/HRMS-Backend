package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Education;

public interface EducationService {
	
	Result add(Education education);
	Result update(Education education);
	Result delete(int id);
	
	//DataResult<Education> getById(int id);
	
	DataResult<List<Education>> getAllByEmployeeIdOrderByGraduatedYearDesc(int id);
	DataResult<List<Education>> getAllByEmployeeId(int id);
	DataResult<List<Education>> gettAll();

}
