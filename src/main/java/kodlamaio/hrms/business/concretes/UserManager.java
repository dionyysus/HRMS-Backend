package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager<T extends User> implements UserService<T>{

	private UserDao<T> userDao;
	
	
	@Autowired
	public UserManager(UserDao<T> userDao) {
		
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<T>> getAll() {
		
		return new SuccessDataResult<List<T>>(userDao.findAll(), "");
		
	}

	@Override
	public Result add(T t) {
		
		this.userDao.save(t);
		
		return new SuccessDataResult<T>("");
	}

	public Result isEmailExist(String email) {
		
		if(userDao.findByEmail(email).isPresent()) {
			
			return new ErrorResult("email exist!");
		}
		
		return new SuccessResult("gk");
	}

	
	@Override
	public Result userNullCheck(User user) {

		if ((user.getEmail() == null || user.getEmail().isBlank()) || (user.getPassword() == null || user.getPassword().isBlank())) {
            return new ErrorResult("Bütün alanları doldurunuz");
		}
		return new SuccessResult();
	}
}
