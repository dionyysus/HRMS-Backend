package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Work;
import kodlamaio.hrms.entities.concretes.WorkHours;

public interface WorkDao extends JpaRepository<Work, Integer>{

	Work findById(int id);
}
