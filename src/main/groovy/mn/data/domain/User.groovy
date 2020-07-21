package mn.data.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import io.micronaut.data.annotation.Where

@CompileStatic
@Entity
@Where("enabled = true")
@EqualsAndHashCode(includes = "name")
@ToString
class User {
    @Id
    @GeneratedValue
    Long id
    String name
    boolean enabled = true

    User(String name) {
        this.name = name
    }
}
