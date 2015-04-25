package toulousemusee

import grails.test.spock.IntegrationSpec

/**
 *
 */
class MuseeServiceIntegrationSpec extends IntegrationSpec {

    MuseeService museeService
    JeuTestService jeuTestService

    void "test insertion ou mise à jour d'un musée avec gestionnaire"(){
        given: "un musée"
        Musee unMusee = new Musee(nom:"ARCHIVES MUNICIPALES TOULOUSE" , horairesOuverture: "Ouvert du lundi au vendredi de 9h à  17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.", telephone: "05 61 61 63 33" , accesMetro: "Roseraie (A)", accesBus: "36, 38")

        and: "un gestionnaire"
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")

        when: "on tente de répercuter en base la création ou la modification du musée"
        Musee resultMusee = museeService.insertOrUpdateMusee(unMusee, unGestionnaire)

        then: "le musée résultant pointe sur le musée initial"
        resultMusee == unMusee

        and: "le musée résultante n'a pas d'erreur"
        !resultMusee.hasErrors()

        and: "le musée a pour gestionnaire le gestionnaire passé en paramètre"
        resultMusee.gestionnaire == unGestionnaire

        and: "le gestionnaire a dans sa liste le musée le musée passé en paramètre"
        unGestionnaire.musees.contains(resultMusee)
    }

    void "test de la suppression d'un musée"(){
        given: "un musée existant en base"
        Musee unMusee = new Musee(nom:"ARCHIVES MUNICIPALES TOULOUSE" , horairesOuverture: "Ouvert du lundi au vendredi de 9h à  17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.", telephone: "05 61 61 63 33" , accesMetro: "Roseraie (A)", accesBus: "36, 38")
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")
        unMusee = museeService.insertOrUpdateMusee(unMusee, unGestionnaire)

        when: "on tente de supprimer le musée"
        museeService.deleteMusee(unMusee)

        then: "le musée n'existe plus en base"

        and: "le gestionnaire n'a plus le musée dans sa liste de musées"
    }

    void "test du moteur de recherche sur les musées"(){

        given: "les musées, les gestionnares et les adresses fournis par le jeu de test"
        jeuTestService

        when: "on cherche les musées dont le nom contient 'MUNI' "
        List<Musee> res = museeService.searchMusees("MUNI",null,null)

        then: "on récupère le muséee dont le nom est ARCHIVES MUNICIPALES TOULOUSE"
        res.size() == 1
        res*.id.contains(jeuTestService.musee1.id)

        when: "on cherche les musées dont l'adresse se trouve au code postal '31500'"
        res.size() == 1
        res*.id.contains(jeuTestService.adresse1.id)


    }
}
