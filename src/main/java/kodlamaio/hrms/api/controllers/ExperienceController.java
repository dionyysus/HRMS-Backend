package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experience/")
public class ExperienceController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.add(experience);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Experience experience) {
		return this.experienceService.update(experience);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.experienceService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<Experience> getById(@RequestParam int id){
		return this.experienceService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll(){
		return this.experienceService.gettAll();
	}
	
	@GetMapping("/getAllByEmployeeIdOrderByEndDateDesc")
	public DataResult<List<Experience>> getAllByEmployeeIdOrderByEndDateDesc(@RequestParam int id){
		return this.experienceService.getAllByEmployeeIdOrderByEndDateDesc(id);
	}

	@GetMapping("/getAllByEmployeeId")
	public DataResult<List<Experience>> getAllByEmployeeId(@RequestParam int id){
		return this.experienceService.getAllByEmployeeId(id);
	}
	
}
