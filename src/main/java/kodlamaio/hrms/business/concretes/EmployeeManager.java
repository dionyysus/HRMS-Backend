package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.core.utilities.result.BusinessRules.BusinessRules;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeResumeDto;

@Service
public class EmployeeManager extends UserManager<Employee> implements EmployeeService{

	private EmployeeDao employeeDao;
	private EducationService educationService;
	private ExperienceService experienceService;
	private ImageService imageService;
	private LanguageService languageService;
	private LinkService linkService;
	private SkillService skillService;
	
	@Autowired
	public EmployeeManager(UserDao<Employee> userDao, EmployeeDao employeeDao, EducationService educationService,
			ExperienceService experienceService, ImageService imageService, LanguageService languageService,
			LinkService linkService, SkillService skillService) {
		super(userDao);
		this.employeeDao = employeeDao;
		this.educationService = educationService;
		this.experienceService = experienceService;
		this.imageService = imageService;
		this.languageService = languageService;
		this.linkService = linkService;
		this.skillService = skillService;
	}

	@Override
	public Result add(Employee employee) {
		Result result = BusinessRules.Run(isNationalityIdExist(employee.getIdentityNumber()),employeeNullCheck(employee), isEmailExist(employee.getEmail()));
		
		if(!result.isSuccess()) {
	
			return result;
		}
		return new SuccessDataResult<Employee>(this.employeeDao.save(employee), "eklendi");		
	}

	private Result isNationalityIdExist(String identityNumber) {
		
		if(employeeDao.findByIdentityNumber(identityNumber).isPresent()) {
			return new ErrorResult("there is already such an id ");
		}
		
		return new SuccessResult();
	}
	
	private Result employeeNullCheck(Employee employee) {
		
		if(!super.userNullCheck(employee).isSuccess() || (employee.getFirstName() == null || employee.getFirstName().isBlank()) ||
			(employee.getLastName() == null || employee.getLastName().isBlank()) ||
			(employee.getIdentityNumber() == null || employee.getIdentityNumber().isBlank()) ||
			  (employee.getBirthDate() ==  0)){
			
			return new ErrorResult("Please fill in completely");
		}
		
		return new SuccessResult("Successful");
	}


	@Override
	public Result userNullCheck(Employee t) {
		return null;
	}

	@Override
	public DataResult<Employee> getById(int id) {
		
		return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
	}

	@Override
	public DataResult<EmployeeResumeDto> getEmployeeById(int id) {
		
		EmployeeResumeDto cv = new EmployeeResumeDto();
		
		cv.educations = this.educationService.getAllByEmployeeId(id).getData();
		cv.experiences = this.experienceService.getAllByEmployeeId(id).getData();
		cv.image = this.imageService.getAllByImageId(id).getData();
		cv.languages = this.languageService.getAllByEmployeeId(id).getData();
		cv.links = this.linkService.getAllByEmployeeId(id).getData();
		cv.skills = this.skillService.getAllByEmployeeId(id).getData();
		return new SuccessDataResult<EmployeeResumeDto>(cv);
	}
}
