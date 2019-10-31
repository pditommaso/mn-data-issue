package mn.data

import javax.inject.Inject

import io.micronaut.test.annotation.MicronautTest
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

}
