package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkHoursService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.WorkHours;

@RestController
@RequestMapping("/api/workHours")
@CrossOrigin
public class WorkHoursController {
	
	private WorkHoursService workHoursService;

	public WorkHoursController(WorkHoursService workHoursService) {
		super();
		this.workHoursService = workHoursService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<WorkHours>> getAll(){
		return this.workHoursService.getAll();
	}

}
