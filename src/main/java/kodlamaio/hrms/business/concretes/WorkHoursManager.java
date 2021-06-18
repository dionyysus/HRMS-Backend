package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkHoursService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkHoursDao;
import kodlamaio.hrms.entities.concretes.Work;
import kodlamaio.hrms.entities.concretes.WorkHours;

@Service
public class WorkHoursManager implements WorkHoursService {
	
	private WorkHoursDao workHoursDao;

	@Autowired
	public WorkHoursManager(WorkHoursDao workHoursDao) {
		super();
		this.workHoursDao = workHoursDao;
	}

	@Override
	public DataResult<List<WorkHours>> getAll() {

		return new SuccessDataResult<List<WorkHours>>(this.workHoursDao.findAll(), "Succesful listed");
	}

	@Override
	public DataResult<WorkHours> getById(int id) {
		return new SuccessDataResult<WorkHours>(this.workHoursDao.findById(id));
	}
	
	
	
	
	
}
