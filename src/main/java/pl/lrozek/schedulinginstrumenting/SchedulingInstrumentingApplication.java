package pl.lrozek.schedulinginstrumenting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedulingInstrumentingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulingInstrumentingApplication.class, args);
	}

}
