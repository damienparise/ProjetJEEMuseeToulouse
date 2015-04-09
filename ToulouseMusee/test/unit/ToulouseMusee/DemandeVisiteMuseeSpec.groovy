package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisiteMusee)
class DemandeVisiteMuseeSpec extends Specification {

    @Unroll
    void "test la validite d'une demande de visite de musee valide"(
            Date uneDate,
            DemandeVisite uneDemandeVisite,
            Musee unMusee
    ) {

        given: "une demande de visite de musee initialise correctement"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(
                date: uneDate,
                demandeVisite: uneDemandeVisite,
                musee: unMusee
        )

        expect: "la demande de visite de musee est valide"
        demandeVisiteMusee.validate() == true

        where:
        uneDate             | uneDemandeVisite      | unMusee
        new Date(2015,1,1)  | new DemandeVisite()   | new Musee()

    }

    @Unroll
    void "test l'invalidite d'une demande de visite de musee non valide"(
            Date uneDate,
            DemandeVisite uneDemandeVisite,
            Musee unMusee
    ) {
        given: "une demande de visite de musee initialise de maniere non valide"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(
                date: uneDate,
                demandeVisite: uneDemandeVisite,
                musee: unMusee
        )
        expect: "la demande de visite du musee est invalide"
        demandeVisiteMusee.validate() == false

        where:
        uneDate             | uneDemandeVisite      | unMusee
        null                | new DemandeVisite()   | new Musee()
        new Date(2015,1,1)  | null                  | new Musee()
        new Date(2015,1,1)  | new DemandeVisite()   | null

    }
}
