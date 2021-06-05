package kodlamaio.hrms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.cloudinary.CloudinaryManager;
import kodlamaio.hrms.core.cloudinary.CloudinaryService;


@Configuration
public class CloudinaryConfig {
	
	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dtcdkvhjd",
                "api_key", "599751728562879",
                "api_secret", "9J8SORRdvcHd-xL91dsLkbTb7B8"));
	}

	@Bean
	public CloudinaryService cloudinaryService() {
		return new CloudinaryManager(cloudinaryUser());
	}
}
