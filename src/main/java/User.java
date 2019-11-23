import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    private int id;
    private String email,password;
    private Set<Authority> authorities = new HashSet<Authority>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany
    @JoinTable(name="permission",
            joinColumns=@JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_id")
    )
    public Set<Authority> getAuthorities() {
        return this.authorities;
    }
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
    public void addAuthority(Authority authority) { this.authorities.add(authority);
    }

    @Override
    public String toString() {
        String result=this.id+", "+this.email+", "+this.password+", authorities: \n";
        for(Authority a: this.authorities)
        {
            result+=a.toString();
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if(this==o) return true;

        if(!(o instanceof User)) return false;

        User user=(User) o;

        return this.id==user.id &&
                this.email.equals(user.email) &&
                this.password.equals(user.password) &&
                this.authorities.equals(user.authorities);
    }

    @Override
    public int hashCode() {
        int result=17;
        result=result*31+this.id;
        result=result*31+this.email.hashCode();
        result=result*31+this.password.hashCode();
        result=result*31+this.authorities.hashCode();
        return result;
    }
}
