package app.service;

import app.models.UserMassage;
import app.repo.MassageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MessageService {

    private final MassageRepo repo;

    public  void create(UserMassage massage){
        repo.save(massage);
    }

    public  List<UserMassage> findAll(){
        return repo.findAll();
    }



    public void getUserMassageByUserId(int id){
        repo.getUserMassageByUserId(id);
    }

}
