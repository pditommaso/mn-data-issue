package mn.data.repo

import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import mn.data.domain.Manufacturer
import mn.data.domain.Product

@Repository
interface ProductRepository extends CrudRepository<Product, Long> {
    Manufacturer saveManufacturer(String name)

    @Join(value = "manufacturer", type = Join.Type.FETCH)
    List<Product> list()
}
