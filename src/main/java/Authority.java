import javax.persistence.*;
import java.io.Serializable;
import java.security.AuthProvider;
import java.util.HashSet;
import java.util.Iterator;
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

    @Override
    public String toString() {
        String result=id+", "+name+", users: \n";
        for(User u: this.users)
        {
            result+=u.toString();
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;

        if(!(o instanceof Authority)) return false;

        Authority authority=(Authority) o;

        return this.id!=authority.id &&
                this.name.equals(authority.name) &&
                this.users.equals(authority.users);
    }

    @Override
    public int hashCode() {
        int result=17;
        result=result*31+this.id;
        result=result*31+this.name.hashCode();
        result=result*31+this.users.hashCode();
        return result;
    }
}
