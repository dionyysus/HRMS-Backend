package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.User;


public interface UserService<T extends User>{

	DataResult<List<T>> getAll();
	Result add(T t);
	Result userNullCheck(T t);
	
	
}
