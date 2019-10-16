import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority {

    private int id;
    private Set<User> users=new HashSet<User>(0);
    private String name;
    @Id
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

    @JoinTable(name="Table",
            joinColumns=@JoinColumn(name="auth_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )

    @ManyToMany
    public Set<User> getUser() {
        return this.users;
    }

    public void setUser(Set<User> users) {
        this.users = users;
    }

}
