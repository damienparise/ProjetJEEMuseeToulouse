package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Musee)
class MuseeSpec extends Specification {

    @Unroll
    void "test la validite d'une activite valide"(
            String unNom,
            String uneHoraireOuverture,
            String unTelephone,
            String unAccesMetro,
            String unAccesBus,
            Adresse uneAdresse,
            Gestionnaire unGestionnaire,
            Boolean unIsPrefere) {

        given: "un musee initialise avec " +
                "un nom, " +
                "un horaire d'ouverture, " +
                "de telephone, " +
                "un acces metro, " +
                "un acces bus, " +
                "une adresse et " +
                "un favoris et " +
                "un gestionnaire le tout non vide"
        Musee musee = new Musee(
                nom: unNom,
                horairesOuverture: uneHoraireOuverture,
                telephone: unTelephone,
                accesMetro: unAccesMetro,
                accesBus: unAccesBus,
                adresseMusee: uneAdresse,
                gestionnaire: unGestionnaire,
                isPrefere: unIsPrefere
        )

        expect: "le musee est valide"
        musee.validate() == true

        where:
        unNom   | uneHoraireOuverture   | unTelephone | unAccesMetro | unAccesBus   | uneAdresse    | unGestionnaire    | unIsPrefere
        "Musee" | "8h"                  | "0512345678"| "SortieM 10" | "SortieB 20" | new Adresse() | new Gestionnaire()| false
        "Musee" | "8h"                  | "0512345678"| ""           | "SortieB 20" | new Adresse() | new Gestionnaire()| false
        "Musee" | "8h"                  | "0512345678"| null         | "SortieB 20" | new Adresse() | new Gestionnaire()| false
        "Musee" | "8h"                  | "0512345678"| "SortieM 10" | ""           | new Adresse() | new Gestionnaire()| false
        "Musee" | "8h"                  | "0512345678"| "SortieM 10" | null         | new Adresse() | new Gestionnaire()| false

    }

    @Unroll
    void "test l'invalidite d'un musee non valide"(
            String unNom,
            String uneHoraireOuverture,
            String unTelephone,
            String unAccesMetro,
            String unAccesBus,
            Adresse uneAdresse,
            Gestionnaire unGestionnaire) {

        given: "un muse initialise avec " +
                "un nom, " +
                "un horaire d'ouverture, " +
                "de telephone, " +
                "un acces metro, " +
                "un acces bus, " +
                "une adresse et " +
                "un gestionnaire le tout vide"
        Musee musee = new Musee(
                nom: unNom,
                horairesOuverture: uneHoraireOuverture,
                telephone: unTelephone,
                accesMetro: unAccesMetro,
                accesBus: unAccesBus,
                adresseMusee: uneAdresse,
                gestionnaire: unGestionnaire
        )

        expect: "le musee est invalide"
        musee.validate() == false

        where:
        unNom   | uneHoraireOuverture   | unTelephone | unAccesMetro | unAccesBus   | uneAdresse    | unGestionnaire
        ""      | "8h"                  | "0512345678"| "SortieM 10" | "SortieB 20" | new Adresse() | new Gestionnaire()
        null    | "8h"                  | "0512345678"| "SortieM 10" | "SortieB 20" | new Adresse() | new Gestionnaire()
        "Musee" | ""                    | "0512345678"| "SortieM 10" | "SortieB 20" | new Adresse() | new Gestionnaire()
        "Musee" | null                  | "0512345678"| "SortieM 10" | "SortieB 20" | new Adresse() | new Gestionnaire()
        "Musee" | "8h"                  | ""          | "SortieM 10" | "SortieB 20" | new Adresse() | new Gestionnaire()
        "Musee" | "8h"                  | null        | "SortieM 10" | "SortieB 20" | new Adresse() | new Gestionnaire()
        "Musee" | "8h"                  | "0512345678"| "SortieM 10" | "SortieB 20" | null          | new Gestionnaire()
        "Musee" | "8h"                  | "0512345678"| "SortieM 10" | "SortieB 20" | new Adresse() | null

    }
}
