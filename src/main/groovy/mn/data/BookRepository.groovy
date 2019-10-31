package mn.data


import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository extends CrudRepository<Book, Long> {
    Book find(String title)
}
