
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    private int id;
    private Set<Authority> auths=new HashSet<Authority>(0);
    private String email,password;
    @Id

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
    @Column(name="passsword")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @JoinTable(name="Table",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="auth_id")
    )
    @ManyToMany
    public Set<Authority> getAuthority() {
        return this.auths;
    }

    public void setAuthority(Set<Authority> auths) {
        this.auths = auths;
    }
}
