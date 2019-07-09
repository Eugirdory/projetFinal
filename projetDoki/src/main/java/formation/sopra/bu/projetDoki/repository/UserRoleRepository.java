package formation.sopra.bu.projetDoki.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.sopra.bu.projetDoki.metier.UserRole;

public interface UserRoleRepository extends JpaRepository <UserRole, Integer>{

}
