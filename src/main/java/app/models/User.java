package app.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    String name;

    String username;

    String password;

    User(){

    }
    User(String name, String username, String password){
this.name =name;
this.username = username;
this.password = password;

    }
}
