package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeResumeDto;

public interface EmployeeService extends UserService<Employee>{
	
	DataResult<Employee> getById(int id);
	
	DataResult<EmployeeResumeDto> getEmployeeById(int id);

}
