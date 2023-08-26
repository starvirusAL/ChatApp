package app.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE },fetch =FetchType.EAGER ,mappedBy = "chats")
    private List<UserMassage> userMassage;

   public Chats(){

    }


    public Chats(User userFirst, User userSecond){
       this.userFirst = userFirst;
       this.userSecond = userSecond;


    }

}
