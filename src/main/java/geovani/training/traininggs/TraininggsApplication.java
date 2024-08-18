package geovani.training.traininggs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TraininggsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraininggsApplication.class, args);
	}

}
