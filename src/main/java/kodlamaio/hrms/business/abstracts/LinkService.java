package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);
	Result update(Link link);
	Result delete(int id);
	
	DataResult<Link> getById(int id);
	
	DataResult<List<Link>> getAllByEmployeeId(int id);
	DataResult<List<Link>> getAll();

}
