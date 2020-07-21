package mn.data.domain

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@Entity
@EqualsAndHashCode
@ToString
class Product {

    @Id
    @GeneratedValue
    Long id
    String name
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    Manufacturer manufacturer

    Product(String name, Manufacturer manufacturer) {
        this.name = name
        this.manufacturer = manufacturer
    }

    Product() {
    }
}
