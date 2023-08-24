package app.models;

import lombok.Data;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "UserMassage")
public class UserMassage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    String name;
    String massage;

  /*  @OneToMany(mappedBy = "userMassage")
    private List<UserMassage> massages;*/

    public  UserMassage(){

    }

    public UserMassage(User user, String name, String massage) {
        this.user = user;
        this.massage = massage;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Id: %s massage: %s", id, massage);
    }
}
