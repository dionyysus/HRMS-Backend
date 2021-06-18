package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> findByJobAdvertisementIsActiveTrue();
	List<JobAdvertisement> findByOrderByJobAdvertisementPostedDate();
	
	List<JobAdvertisement> getAllByJobAdvertisementIsConfirmedFalse();
	
	@Query("From JobAdvertisement where jobAdvertisementIsActive = true and id =: id")
	List<JobAdvertisement> getAllActiveJobAdvertisementByEmployer(int id);
	
	
	
}
