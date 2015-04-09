package toulousemusee

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Adresse)
class AdresseSpec extends Specification {

    @Unroll
    void "test la validite d'une adresse valide"(String unNumero, String uneRue, String unCodePostal, String uneVille) {

        given: "une adresse initialise avec un numero, une rue, un code postal et une ville, le tout non vide"
        Adresse adresse = new Adresse(numero: unNumero, rue:uneRue, codePostal: unCodePostal, ville: uneVille)

        expect: "l'adresse est valide"
        adresse.validate() == true

        where:
        unNumero    | uneRue    | unCodePostal  | uneVille
        "100"       | "rue"     | "31100"       | "Toulouse"

    }

    @Unroll
    void "test l'invalidite d'une adresse non valide"(String unNumero, String uneRue, String unCodePostal, String uneVille) {

        given: "une adresse initialise  avec un numero, une rue, un code postal et une ville, le tout vide"
        Adresse adresse = new Adresse(numero: unNumero, rue:uneRue, codePostal: unCodePostal, ville: uneVille)

        expect: "l'activite est invalide"
        adresse.validate() == false

        where:
        unNumero    | uneRue    | unCodePostal  | uneVille
        ""          | "rue"     | "31100"       | "Toulouse"
        null        | "rue"     | "31100"       | "Toulouse"
        "100"       | ""        | "31100"       | "Toulouse"
        "100"       | null      | "31100"       | "Toulouse"
        "100"       | "rue"     | ""            | "Toulouse"
        "100"       | "rue"     | null          | "Toulouse"
        "100"       | "rue"     | "31100"       | ""
        "100"       | "rue"     | "31100"       | null

    }
}
