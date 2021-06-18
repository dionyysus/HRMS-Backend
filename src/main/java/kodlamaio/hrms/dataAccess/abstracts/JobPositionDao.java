package kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.WorkHours;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	
	JobPosition findById(int id);
	Optional <JobPosition> findByPositionName(String positionName);
} 
