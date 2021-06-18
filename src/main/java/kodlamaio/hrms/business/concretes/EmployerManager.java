package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.utilities.result.BusinessRules.BusinessRules;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager extends UserManager<Employer> implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(UserDao<Employer> userDao) {
		super(userDao);
		this.employerDao = (EmployerDao) userDao;
	}

	@Override
	public Result add(Employer employer) {
		Result result = BusinessRules.Run(isEmailDomainCheck(employer),userNullCheck(employer), isEmailExist(employer.getEmail()));
		
		if(result.isSuccess()) {
			return new SuccessDataResult<Employer>(this.employerDao.save(employer), "added");		
		}
		return new ErrorResult();		
	}
	
	 public Result isEmailDomainCheck(Employer employer){
		 
		 String email = employer.getEmail();
		 String webAddress = employer.getWebAddress();
		 
		 String domain = webAddress.split("www.")[1];
		 if(domain.equals(email.split("@")[1])) {
			 return new SuccessResult();
		 }
		 return new ErrorResult("Invalid domain");
	    }

	 public Result isPasswordConfirmed(String password, String confirmPassword){
	        if(password.equals(confirmPassword)){
	            return new SuccessResult();
	        }
	        return new ErrorResult("Password not confirmed");
	    }

	@Override
	public Result userNullCheck(Employer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Employer> getById(int id) {
		if(!this.employerDao.existsById(id)) {
			return new ErrorDataResult<Employer>("There isn't such an employer");
		}
		return new SuccessDataResult<Employer>(this.employerDao.getById(id),"Data listed");
	}
}
