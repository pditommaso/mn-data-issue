package mn.data.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@CompileStatic
@Entity
@EqualsAndHashCode
@ToString
class Book {
    @Id
    @GeneratedValue
    Long id
    String title
    int pages

    Book(String title, int pages) {
        this.title = title
        this.pages = pages
    }

    Book() {
    }
}
