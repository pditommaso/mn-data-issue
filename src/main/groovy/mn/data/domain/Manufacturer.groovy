package mn.data.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@Entity
@EqualsAndHashCode
@ToString
class Manufacturer {

    @Id
    @GeneratedValue
    Long id
    String name
}
