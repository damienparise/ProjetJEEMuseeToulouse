package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DemandeVisite)
class DemandeVisiteSpec extends Specification {

    @Unroll
    void "test la validite de demande de visite valide"(
            String unCodeVisite,
            Date uneDateDebutPeriode,
            Date uneDateFinPeriode,
            int unNbPersonne,
            String unStatut
    ) {

        given: "une demande de visite initialise correctement"
        DemandeVisite demandeVisite = new DemandeVisite(
                codeVisite: unCodeVisite,
                dateDebutPeriode: uneDateDebutPeriode,
                dateFinPeriode: uneDateFinPeriode,
                nbPersonnes: unNbPersonne,
                statut: unStatut
        )

        expect: "la demande de visite est valide"
        demandeVisite.validate() == true

        where:
        unCodeVisite | uneDateDebutPeriode    | uneDateFinPeriode       | unNbPersonne  | unStatut
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 1             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 2             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 3             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 4             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 5             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 6             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 3             | "Valider"


    }

    @Unroll
    void "test l'invalidite d'une demande de visite non valide"(
            String unCodeVisite,
            Date uneDateDebutPeriode,
            Date uneDateFinPeriode,
            int unNbPersonne,
            String unStatut
    ) {

        given: "une demande de visite initialise de maniere non valide"
        DemandeVisite demandeVisite = new DemandeVisite(
                codeVisite: unCodeVisite,
                dateDebutPeriode: uneDateDebutPeriode,
                dateFinPeriode: uneDateFinPeriode,
                nbPersonnes: unNbPersonne,
                statut: unStatut
        )

        expect: "la demande de visite est invalide"
        demandeVisite.validate() == false

        where:
        unCodeVisite | uneDateDebutPeriode    | uneDateFinPeriode       | unNbPersonne  | unStatut
        ""           | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 1             | "Attente"
        null         | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 1             | "Attente"
        "12345"      | null                   | new Date(2015,1,1,12,0) | 1             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | null                    | 1             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 7             | "Attente"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 1             | ""
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 1             | "autrechose"
        "12345"      | new Date(2015,1,1,8,0) | new Date(2015,1,1,12,0) | 1             | null


    }
}
