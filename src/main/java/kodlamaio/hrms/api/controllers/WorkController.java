package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.Work;

@RestController
@RequestMapping("/api/work")
@CrossOrigin
public class WorkController {
	
	private WorkService workService;

	@Autowired
	public WorkController(WorkService workService) {
		this.workService = workService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Work>> getAll(){
		return this.workService.getAll();
	}
	

}
