package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/education/")
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Education education) {
		return this.educationService.add(education);
	}
	
	@PostMapping("update")
	public Result update(@RequestBody Education education) {
		return this.educationService.update(education);
	}
	
	@PostMapping("delete")
	public Result delete(@RequestParam int id) {
		return this.educationService.delete(id);
	}
	
	
	@GetMapping("getall")
	public DataResult<List<Education>> getAll(){
		return this.educationService.gettAll();
	}
	
	@GetMapping("getAllByEmployeeIdOrderByGraduatedYearDesc")
	public DataResult<List<Education>> getAllByEmployeeIdOrderByGraduatedYearDesc(@RequestParam int id){
		return this.educationService.getAllByEmployeeIdOrderByGraduatedYearDesc(id);
	}
	
	@GetMapping("getAllByEmployeeId")
	public DataResult<List<Education>> getAllByEmployeeId(@RequestParam int id){
		return this.educationService.getAllByEmployeeId(id);
	}

}
