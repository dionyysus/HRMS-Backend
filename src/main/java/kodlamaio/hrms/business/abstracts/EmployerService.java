package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Work;

public interface EmployerService extends UserService<Employer> {

	DataResult<Employer> getById(int id);

}
