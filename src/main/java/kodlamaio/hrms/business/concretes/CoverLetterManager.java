package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterDao;

	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter has been added");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult("Cover letter has been updated");
	}

	@Override
	public Result delete(int id) {
		
		this.coverLetterDao.deleteById(id);
		return new SuccessResult("Cover letter has been deleted");
	}

	/*@Override
	public DataResult<CoverLetter> getById(int id) {
		return new SuccessDataResult<CoverLetter>(this.coverLetterDao.);
	}*/

	@Override
	public DataResult<List<CoverLetter>> getAll() {
		return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll());
	}

	

}
