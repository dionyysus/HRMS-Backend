package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Work;

public interface WorkService {

	DataResult<List<Work>> getAll();
	
	DataResult<Work> getById(int id);
	
}
