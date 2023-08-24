package app.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Chats")
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id1")

     User userFirst;

   @ManyToOne
    @JoinColumn(name = "user_id2")

    User userSecond;

    @ManyToOne
    @JoinColumn(name = "massage_id")
    private UserMassage userMassage;

   public Chats(){

    }

    public Chats(User userFirst, User userSecond, UserMassage userMassage){
       this.userFirst = userFirst;
       this.userSecond = userSecond;
       this.userMassage = userMassage;

    }

}
