package ma.enset.patients_spring_mvc_practice_n1.security.repositories;

import ma.enset.patients_spring_mvc_practice_n1.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
