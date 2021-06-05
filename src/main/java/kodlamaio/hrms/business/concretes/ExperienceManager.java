package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService{

	private ExperienceDao experienceDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}
	
	@Override
	public Result add(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience has been added");
	}

	@Override
	public Result update(Experience experience) {
		this.experienceDao.save(experience);
		return new SuccessResult("Experience has been updated");	}


	@Override
	public Result delete(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("Experience has been deleted");
	}

	@Override
	public DataResult<Experience> getById(int id) {
		return new SuccessDataResult<Experience>(this.experienceDao.getById(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByEmployeeIdOrderByEndDateDesc(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByEmployeeIdOrderByEndDateDesc(id));
	}

	@Override
	public DataResult<List<Experience>> getAllByEmployeeId(int id) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByEmployeeId(id));
	}

	@Override
	public DataResult<List<Experience>> gettAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
	}

}
