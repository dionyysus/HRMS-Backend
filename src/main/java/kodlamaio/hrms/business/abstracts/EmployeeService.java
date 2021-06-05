package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeService extends UserService<Employee>{
	
	DataResult<Employee> getById(int id);

}
