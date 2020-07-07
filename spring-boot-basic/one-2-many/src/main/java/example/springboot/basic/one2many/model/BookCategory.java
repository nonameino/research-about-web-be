package example.springboot.basic.one2many.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book_category")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
    private Set<Book> books;

    public BookCategory() {
    }

    public BookCategory(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        String result = String.format("Category[id=%d, name=%s]%n", id, name);
        if (books != null) {
            for(Book book : books) {
                result += String.format("Book[id=%d, title=%s]%n", book.getId(), book.getTitle());
            }
        }
        return result;
    }
}
