import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="authority")
public class Authority {

    private int id;
    private String name;
    private Set<User> users=new HashSet<User>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "authorities")
    public Set<User> getUsers() {
        return this.users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    public void addUser(User user) {this.users.add(user);}

}
