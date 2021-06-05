package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter);
	Result update(CoverLetter coverLetter);
	Result delete(int id);
	
	//DataResult<CoverLetter> getById(int id);
	DataResult<List<CoverLetter>> getAll();

	
}
