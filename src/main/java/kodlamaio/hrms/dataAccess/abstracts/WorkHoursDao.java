package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.WorkHours;

public interface WorkHoursDao extends JpaRepository<WorkHours, Integer>{

	WorkHours findById(int id);
}
