package app.repo;

import app.models.UserMassage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserMassage, Integer> {


}
