package mn.data.repo

import javax.inject.Inject
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.Id

import groovy.transform.CompileStatic
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mn.data.domain.Book
import mn.data.domain.BookDTO

@Singleton
@Repository
@CompileStatic
abstract class BookRepository implements CrudRepository<Book, Long> {

    @Inject EntityManager entityManager

    abstract  Book findByTitle(String title)

    List<Book> listByTitle(String title) {
        return entityManager.createQuery("from Book b where b.title = :title", Book)
                .setParameter("title", title)
                .getResultList()
    }

    @Query("FROM Book b WHERE b.title = :t ORDER BY b.title")
    abstract List<Book> listBooks(String t)

    abstract List<Book> listOrderByTitle()

    abstract BookDTO findOne(String title)

    abstract List<String> findTitle()

    @Query(value = "select * from book b where b.title like :title limit 5", nativeQuery = true)
    abstract List<Book> findNativeBooks(String title)

    abstract Book persist(String title, int pages)

    abstract void updatePages(@io.micronaut.data.annotation.Id Long id, int pages)
}
