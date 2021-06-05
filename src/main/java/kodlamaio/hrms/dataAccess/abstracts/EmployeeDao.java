package kodlamaio.hrms.dataAccess.abstracts;


import java.util.Optional;

import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeDao extends UserDao<Employee>{

	Optional<Employee> findByIdentityNumber(String identityNumber);
	Employee getById(int id);
}
