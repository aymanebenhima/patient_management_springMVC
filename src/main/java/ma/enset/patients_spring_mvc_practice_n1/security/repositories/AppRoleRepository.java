package ma.enset.patients_spring_mvc_practice_n1.security.repositories;

import ma.enset.patients_spring_mvc_practice_n1.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
