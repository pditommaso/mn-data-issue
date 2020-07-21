package mn.data.repo

import javax.inject.Inject

import io.micronaut.test.annotation.MicronautTest
import mn.data.domain.Book
import mn.data.domain.BookDTO
import spock.lang.Specification

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@MicronautTest
class BookRepositoryTest extends Specification {

    @Inject BookRepository bookRepository

    def 'should save book' () {

        when:
        Book book = new Book(title:"The Stand", pages:1000)
        bookRepository.save(book)
        then:
        bookRepository.count() == 1
    }

    def 'should find a book' () {
        when:
        bookRepository.save(new Book(title:"The Stand", pages:1000))
        bookRepository.save(new Book(title:"The Second", pages:2000))
        bookRepository.save(new Book(title:"The Third", pages:3000))

        then:
        bookRepository.findByTitle('The Stand').title == 'The Stand'
        and:
        bookRepository.listByTitle('The Stand').size() == 1
        and:
        bookRepository.listOrderByTitle().size() == 3
        and:
        bookRepository.listBooks('The Stand') .size() ==1
    }


    def 'should find title' () {
        given:
        Book b1 = bookRepository.save(new Book(title:"The Stand", pages:1000))
        Book b2 = bookRepository.save(new Book(title:"The Second", pages:2000))
        Book b3 = bookRepository.save(new Book(title:"The Third", pages:3000))

        when:
        def titles = bookRepository.findTitle()
        then:
        titles == ['The Stand','The Second', 'The Third']

    }

    def 'should return dto' () {
        given:
        Book b1 = bookRepository.save(new Book(title:"The Stand", pages:1000))
        when:
        def result = bookRepository.findOne('The Stand')
        then:
        result == new BookDTO(title: 'The Stand', pages: 1000)
    }

    def 'should find native' () {
        given:
        Book b1 = bookRepository.save(new Book(title:"The Stand", pages:1000))
        Book b2 = bookRepository.save(new Book(title:"The Second", pages:2000))
        Book b3 = bookRepository.save(new Book(title:"The Third", pages:3000))

        when:
        def list = bookRepository.findNativeBooks('The Stand')
        then:
        list == [new Book(id:1, title:"The Stand", pages:1000)]
    }

    def 'should persist columns' () {
        when:
        def book = bookRepository.persist('The Stand', 123)
        then:
        book.pages == 123
        book.id == 1 

        when:
        bookRepository.updatePages(1L, 200)
        then:
        bookRepository.findById(1L).get().pages == 200
    }
}
