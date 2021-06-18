package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employer/")
@CrossOrigin
public class EmployerControl {
	
	private EmployerService employerService;
	

	@Autowired
	public EmployerControl(UserService<Employer> userService) {
		super();
		this.employerService = (EmployerService) userService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@GetMapping("getById")
	public DataResult<Employer> getById(int id){
		return this.employerService.getById(id);
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Employer employer) {
		
		return this.employerService.add(employer);
	}
	
	

}
