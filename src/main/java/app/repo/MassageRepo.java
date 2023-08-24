package app.repo;

import app.models.UserMassage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MassageRepo extends JpaRepository<UserMassage, Integer> {


}
