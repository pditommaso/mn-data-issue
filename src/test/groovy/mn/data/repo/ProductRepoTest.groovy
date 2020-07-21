package mn.data.repo

import javax.inject.Inject

import io.micronaut.test.annotation.MicronautTest
import mn.data.domain.Product
import spock.lang.Specification
/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@MicronautTest
class ProductRepoTest extends Specification {

    @Inject ProductRepository productRepository

    def 'should save product' () {
        when:
        def m = productRepository.saveManufacturer('Big corp')
        then:
        m.id

        when:
        def p = productRepository.save(new Product('Red pen', m))
        then:
        p.id
        and:
        productRepository.count() == 1
    }

    def 'should fetch manufacturers' () {
        given:
        def m = productRepository.saveManufacturer('Big corp')
        and:
        productRepository.save(new Product('First', m))
        productRepository.save(new Product('Second', m))

        when:
        def products = productRepository.list()
        then:
        products.size() == 2
        products[0].manufacturer == m
    }
}
