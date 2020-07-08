package example.springboot.basic.many2many.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    @ManyToMany(mappedBy = "books")
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "book_authors",
//            joinColumns = @JoinColumn(name="book_id", referencedColumnName = "id"),
//            inverseJoinColumns =@JoinColumn(name = "author_id", referencedColumnName = "id"))
    Set<Author> authors;

    @OneToMany(mappedBy = "book")
    private Set<BookPublisher> bookPublishers;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<BookPublisher> getBookPublishers() {
        return bookPublishers;
    }

    public void setBookPublishers(Set<BookPublisher> bookPublishers) {
        this.bookPublishers = bookPublishers;
    }
}
