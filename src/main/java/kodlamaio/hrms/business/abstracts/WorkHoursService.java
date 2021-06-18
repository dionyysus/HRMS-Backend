package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Work;
import kodlamaio.hrms.entities.concretes.WorkHours;

public interface WorkHoursService {
	
	DataResult<List<WorkHours>> getAll();

	DataResult<WorkHours> getById(int id);

}
