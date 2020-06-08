package example.springdata.jpa.querybyexample;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Data
//@NoArgsConstructor(force = true)
//@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private final String firstname, lastname;
    private final Integer age;

    public User() {
        this.firstname = null;
        this.lastname = null;
        this.age = 0;
    }

    public User(String firstname, String lastname, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }
}
