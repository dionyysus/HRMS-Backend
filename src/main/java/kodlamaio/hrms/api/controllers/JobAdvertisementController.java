package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		
		return this.jobAdvertisementService.add(jobAdvertisement);
		
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


}
