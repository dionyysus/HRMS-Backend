package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkDao;
import kodlamaio.hrms.entities.concretes.Work;

@Service
public class WorkManager implements WorkService{

	private WorkDao workDao;
	
	@Autowired
	public WorkManager(WorkDao workDao) {
		this.workDao = workDao;
	}

	@Override
	public DataResult<List<Work>> getAll() {
		return new SuccessDataResult<List<Work>>(this.workDao.findAll(), "Succesful listed");
	}

	@Override
	public DataResult<Work> getById(int id) {
		return new SuccessDataResult<Work>(this.workDao.findById(id));
	}

}
