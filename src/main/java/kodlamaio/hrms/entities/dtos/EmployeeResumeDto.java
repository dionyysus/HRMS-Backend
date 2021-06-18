package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.Skill;

public class EmployeeResumeDto {
	
	public Employee employee;
	
	public List<Education> educations;
	
	public List<CoverLetter> coverLetter;
	
	public List<JobAdvertisement> jobAdvertisement;
	
	public List<Skill> skills;
	
	public List<Language> languages;
	
	public List<Experience> experiences;
	
	public List<Link> links;
	
	public Image image;
	
}
