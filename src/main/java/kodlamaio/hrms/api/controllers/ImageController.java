package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Image;

@RestController
@RequestMapping("/api/image/")
public class ImageController {
	
	private ImageService imageService;
	private EmployeeService employeeService;
	
	@Autowired
	public ImageController(ImageService imageService, EmployeeService employeeService) {
		super();
		this.imageService = imageService;
		this.employeeService = employeeService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		
		Employee employee = this.employeeService.getById(id).getData();
		Image image = new Image();
		image.setEmployee(employee);
		return this.imageService.add(image, imageFile);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Image image) {
		return this.imageService.update(image);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.imageService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	}
	
	@GetMapping("/getAllByImageId")
	public DataResult<Image> getAllByImageId(@RequestParam int id){
		return this.imageService.getAllByImageId(id);
	}
	
}