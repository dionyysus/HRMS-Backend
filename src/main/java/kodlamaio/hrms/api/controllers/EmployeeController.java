package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {
	
	private EmployeeService employeeService;


	@Autowired
	public EmployeeController(UserService<Employee> userService) {
		super();
		this.employeeService = (EmployeeService) userService;
	}
	
	@GetMapping("getAll")
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody Employee employee) {
		
		return this.employeeService.add(employee);
	}
	
	

}
