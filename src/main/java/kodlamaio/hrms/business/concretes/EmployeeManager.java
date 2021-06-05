package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.utilities.result.BusinessRules.BusinessRules;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager extends UserManager<Employee> implements EmployeeService{

	private EmployeeDao employeeDao;
	
	
	@Autowired
	public EmployeeManager(UserDao<Employee> userDao) {
		super(userDao);
		this.employeeDao = (EmployeeDao) userDao;
	}


	@Override
	public Result add(Employee employee) {
		Result result = BusinessRules.Run(isNationalityIdExist(employee.getIdentityNumber()),employeeNullCheck(employee), isEmailExist(employee.getEmail()));
		
		if(!result.isSuccess()) {
	
			return result;
		}
		return new SuccessDataResult<Employee>(this.employeeDao.save(employee), "eklendi");		
	}

	private Result isNationalityIdExist(String identityNumber) {
		
		if(employeeDao.findByIdentityNumber(identityNumber).isPresent()) {
			return new ErrorResult("there is already such an id ");
		}
		
		return new SuccessResult();
	}
	
	private Result employeeNullCheck(Employee employee) {
		
		if(!super.userNullCheck(employee).isSuccess() || (employee.getFirstName() == null || employee.getFirstName().isBlank()) ||
			(employee.getLastName() == null || employee.getLastName().isBlank()) ||
			(employee.getIdentityNumber() == null || employee.getIdentityNumber().isBlank()) ||
			  (employee.getBirthDate() ==  0)){
			
			return new ErrorResult("");
		}
		
		return new SuccessResult("");
	}


	@Override
	public Result userNullCheck(Employee t) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public DataResult<Employee> getById(int id) {
		return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
	}
}
