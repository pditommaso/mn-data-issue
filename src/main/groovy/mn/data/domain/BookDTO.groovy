package mn.data.domain

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import io.micronaut.core.annotation.Introspected
/**
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@Introspected
@EqualsAndHashCode
@ToString
@CompileStatic
class BookDTO {
    String title
    int pages
}
