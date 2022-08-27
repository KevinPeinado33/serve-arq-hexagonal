package pe.edu.upeu.patmosapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableConfigurationProperties
@SpringBootApplication
@EnableScheduling
public class PatmosApiApplication {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PatmosApiApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		for (int i = 0; i < 4; i ++) {
//			String passwordBcrypt = passwordEncoder.encode("12345");
//			System.out.println(passwordBcrypt);
//		}
//	}

}
