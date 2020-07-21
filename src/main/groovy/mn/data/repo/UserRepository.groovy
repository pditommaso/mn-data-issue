package mn.data.repo

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mn.data.domain.User

@Repository
interface UserRepository extends CrudRepository<User, Long> {

    @Query("UPDATE User SET enabled = false WHERE id = :id")
    void deleteById(Long id)

    @Query("SELECT u FROM User u WHERE u.enabled = false")
    List<User> findDisabled()
}
