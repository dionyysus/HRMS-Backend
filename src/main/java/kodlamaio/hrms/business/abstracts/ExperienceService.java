package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Experience;

public interface ExperienceService {

	Result add(Experience experience);
	Result update(Experience experience);
	Result delete(int id);

	DataResult<Experience> getById(int id);
	DataResult<List<Experience>> getAllByEmployeeIdOrderByEndDateDesc(int id);
	DataResult<List<Experience>> getAllByEmployeeId(int id);
	DataResult<List<Experience>> gettAll();

}
