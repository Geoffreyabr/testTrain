package testTrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class TestTrainApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestTrainApplication.class, args);
		System.out.println("mes glinches");
	}

}
