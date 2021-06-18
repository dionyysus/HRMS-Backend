package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.WorkHours;

public interface EmployerDao extends UserDao<Employer> {
	
	Employer getById(int id);
	Employer findById(int id);

}
