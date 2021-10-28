package devyatovski.yar.scrollx2.domain;


import com.fasterxml.jackson.annotation.JsonView;
import devyatovski.yar.scrollx2.domain.views.EntityView;
import devyatovski.yar.scrollx2.domain.views.UserView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usr")
@Setter
@Getter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JsonView(EntityView.MainView.class)
    private Long id;
    @JsonView(EntityView.MainView.class)
    private String username;
    @JsonView(EntityView.MainView.class)
    private String password;
    private Boolean active = true;
    @JsonView(EntityView.MainView.class)
    private String firstName;
    @JsonView(EntityView.MainView.class)
    private String lastName;
    private String country;
    private Integer age;
    private String avatar;


    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    @OneToMany(mappedBy = "commentator")
    private List<Comments> comments;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword());
    }
}
