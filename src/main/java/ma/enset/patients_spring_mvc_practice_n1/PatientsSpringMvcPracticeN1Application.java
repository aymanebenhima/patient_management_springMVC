package ma.enset.patients_spring_mvc_practice_n1;

import ma.enset.patients_spring_mvc_practice_n1.entities.Patient;
import ma.enset.patients_spring_mvc_practice_n1.repositories.PatientRepository;
import ma.enset.patients_spring_mvc_practice_n1.security.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsSpringMvcPracticeN1Application {

	public static void main(String[] args) {
		SpringApplication.run(PatientsSpringMvcPracticeN1Application.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(new Patient(null, "Aymane", new Date(), false, 34));
			patientRepository.save(new Patient(null, "Ouail", new Date(), false, 44));
			patientRepository.save(new Patient(null, "Jamal", new Date(), true, 39));
			patientRepository.save(new Patient(null, "Fatima", new Date(), false, 94));

			patientRepository.findAll().forEach(patient -> {
				System.out.println(patient.getNom());
			});
		};
	}

	//@Bean
	CommandLineRunner saveUsers(SecurityService securityService) {
		return args -> {
			securityService.saveNewUser("manager", "1234", "1234");
			securityService.saveNewUser("user2", "1234", "1234");

			securityService.saveNewRole("USER", "");
			securityService.saveNewRole("ADMIN", "");

			securityService.addRoleToUser("manager", "ADMIN");
			securityService.addRoleToUser("user2", "USER");
		};
	}

}
