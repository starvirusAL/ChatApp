package app.service;

import app.models.User;
import app.models.UserMassage;
import app.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepo repo;

    public void create(User user){
        repo.save(user);
    }

    public List<User> findAll(){
        return repo.findAll();
    }


    public User getUserById (int id){
        return repo.getUserById(id);
    }

}
