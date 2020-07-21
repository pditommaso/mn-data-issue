package mn.data.repo

import javax.inject.Inject

import io.micronaut.test.annotation.MicronautTest
import mn.data.domain.User
import spock.lang.Specification

/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@MicronautTest
class UserRepoTest extends Specification {

    @Inject UserRepository userRepository

    def 'should find a user' () {
        when:
        userRepository.save(new User('Paolo'))
        
        then:
        userRepository.count() > 0
    }

    def 'should delete user' () {
        given:
        def u = userRepository.save(new User('Paolo'))

        when:
        userRepository.deleteById(u.id)
        then:
        userRepository.count() == 0

        when:
        def list = userRepository.findDisabled()
        then:
        list == [new User('Paolo')]
    }
}
