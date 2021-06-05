package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skill/")
public class SkillController {
	
	private SkillService skillService;

	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody Skill skill) {
		return this.skillService.update(skill);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.skillService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}

	@GetMapping("/getAllByEmployeeId")
	public DataResult<List<Skill>> getAllByEmployeeId(@RequestParam int id){
		return this.skillService.getAllByEmployeeId(id);
	}


}
