package example.springdata.jpa.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class BusinessObject {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User lastModifiedBy;
    private Date lastModifiedDate;
    private final String data;
    @ManyToOne
    private final User owner;

    @SuppressWarnings("unused")
    public BusinessObject() {
        this.data = null;
        this.owner = null;
    }

    public BusinessObject(String data, User owner) {
        this.data = data;
        this.owner = owner;
    }
}
