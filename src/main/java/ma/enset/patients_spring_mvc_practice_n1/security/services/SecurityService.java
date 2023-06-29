package ma.enset.patients_spring_mvc_practice_n1.security.services;

import ma.enset.patients_spring_mvc_practice_n1.security.entities.AppRole;
import ma.enset.patients_spring_mvc_practice_n1.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
}
