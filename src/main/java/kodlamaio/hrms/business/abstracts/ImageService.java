package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {
	
	Result add(Image image, MultipartFile file);
	Result update(Image image);
	Result delete(int id);
	
	//DataResult<Image> getById(int id);
	DataResult<List<Image>> getAll();
	DataResult<Image> getAllByImageId(int id);
	
	

}
