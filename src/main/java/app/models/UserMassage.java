package app.models;

import lombok.Data;
import javax.persistence.Table;
import javax.persistence.*;

@Data
@Entity
@Table(name = "UserMassage")
public class UserMassage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String name;

    String massage;

    public  UserMassage(){

    }

    public UserMassage(String name, String massage) {
        this.name = name;
        this.massage = massage;
    }

    @Override
    public String toString() {
        return String.format("Id: %s Name: %s, Age: %s massage: %s", id, name, massage);
    }
}
