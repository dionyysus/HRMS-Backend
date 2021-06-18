package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
@CrossOrigin
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		
		return this.jobAdvertisementService.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
		
	}
	
	@PostMapping("/remove")
	public Result remove(int id) {
		
		return this.jobAdvertisementService.remove(id);
		
	}
	
	
	@PostMapping("/changeActiveToPassive")
	public Result changeActiveToPassive(int id) {
		
		return this.jobAdvertisementService.changeActiveToPassive(id);
		
	}
	
	@PostMapping("/changePassiveToActive")
	public Result changePassiveToActive(int id) {
		
		return this.jobAdvertisementService.changePassiveToActive(id);
		
	}
	@GetMapping("/getById")
	public DataResult<JobAdvertisement> getById(int id){
		return this.jobAdvertisementService.getById(id);
	}
	
	
	@PostMapping("/changeConfirmedFalseToTrue")
	public Result changeConfirmedFalseToTrue(int id) {
		
		return this.jobAdvertisementService.changeConfirmedFalseToTrue(id);
		
	}
	
	@GetMapping("/findByJobAdvertisementIsActive")
	public DataResult<List<JobAdvertisement>> findByJobAdvertisementIsActive(){
		
		return this.jobAdvertisementService.findByJobAdvertisementIsActive();
		
	}
	
	@GetMapping("/findByOrderByJobAdvertisementPostedDate")
	public DataResult<List<JobAdvertisement>> findByOrderByJobAdvertisementPostedDate(){
		
		return this.jobAdvertisementService.findByOrderByJobAdvertisementPostedDate();
	
	}
	
	@GetMapping("/getAllActiveJobAdvertisementByEmployer")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisementByEmployer(int id){
		
		return this.jobAdvertisementService.getAllActiveJobAdvertisementByEmployer(id);
	
	}

	@GetMapping("/getAllByJobAdvertisementIsConfirmedFalse")
	DataResult<List<JobAdvertisement>> getAllByJobAdvertisementIsConfirmedFalse(){
		return this.jobAdvertisementService.getAllByJobAdvertisementIsConfirmedFalse();
	}

}
