package app.service;

import app.models.UserMassage;
import app.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepo repo;

    public  void create(UserMassage user){
        repo.save(user);
    }

    public  List<UserMassage> findAll(){
        return repo.findAll();
    }

}
