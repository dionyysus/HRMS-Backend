package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverletter")
public class CoverLetterController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLetterController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.update(coverLetter);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.coverLetterService.delete(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
	
	/*@GetMapping("/getById")
	public DataResult<CoverLetter> getById(@RequestParam("id") int id){
		return this.coverLetterService.getById(id);
	}*/
}
