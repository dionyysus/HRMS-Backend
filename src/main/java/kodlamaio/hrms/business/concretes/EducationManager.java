package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public Result add(Education education) {

		this.educationDao.save(education);
		return new SuccessResult("School has been added");
	}

	@Override
	public Result update(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("School has been updated");
	}

	@Override
	public Result delete(int id) {
		this.educationDao.deleteById(id);
		return new SuccessResult("School hass been deleted");
	}


	@Override
	public DataResult<List<Education>> getAllByEmployeeIdOrderByGraduatedYearDesc(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getAllByEmployeeIdOrderByGraduatedYearDesc(id));
		
	}

	@Override
	public DataResult<List<Education>> gettAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	/*@Override
	public DataResult<Education> getById(int id) {
		return new SuccessDataResult<Education>(this.educationDao.getById(id));
	}*/

	@Override
	public DataResult<List<Education>> getAllByEmployeeId(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.getAllByEmployeeId(id));
	}

}
