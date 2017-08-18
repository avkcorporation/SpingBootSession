package ua.avk.shopbuilder.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private Long id;

    //@Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> userses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUserses() {
        return userses;
    }

    public void setUserses(Set<User> userses) {
        this.userses = userses;
    }
}
