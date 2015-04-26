package toulousemusee

import grails.test.spock.IntegrationSpec

/**
 *
 */
class MuseeServiceIntegrationSpec extends IntegrationSpec {

    MuseeService museeService
    JeuTestService jeuTestService

    void "test insertion ou mise à jour d'un musée avec gestionnaire"(){
        given: "un musée et son adresse"
        Adresse adresse = new Adresse(numero: "2", rue: "Rue des archives", codePostal: "31500", ville: "Toulouse")
        Musee unMusee = new Musee(nom:"ARCHIVES MUNICIPALES TOULOUSE" , horairesOuverture: "Ouvert du lundi au vendredi de 9h à  17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.",
                telephone: "05 61 61 63 33" , accesMetro: "Roseraie (A)", accesBus: "36, 38", adresseMusee: adresse, isPrefere: false)

        and: "un gestionnaire"
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")

        when: "on tente de répercuter en base la création ou la modification du musée"
        Musee resultMusee = museeService.insertOrUpdateMusee(unMusee, adresse, unGestionnaire)

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
        Adresse adresse = new Adresse(numero: "2", rue: "Rue des archives", codePostal: "31500", ville: "Toulouse")
        Musee unMusee = new Musee(nom:"ARCHIVES MUNICIPALES TOULOUSE" , horairesOuverture: "Ouvert du lundi au vendredi de 9h à  17h. Fermeture de 12h à 13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet.",
                telephone: "05 61 61 63 33" , accesMetro: "Roseraie (A)", accesBus: "36, 38", adresseMusee: adresse, isPrefere: false)
        Gestionnaire unGestionnaire = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture")
        unMusee = museeService.insertOrUpdateMusee(unMusee, adresse, unGestionnaire)

        when: "on tente de supprimer le musée"
        museeService.deleteMusee(unMusee)

        then: "le musée n'existe plus en base"
        Musee.findById(unMusee.id) == null

        and: "le gestionnaire est toujours dans la base"
        Gestionnaire.findById(unGestionnaire.id) != null
    }

    void "test du moteur de recherche sur les musées"(){

        given: "les musées, les gestionnares et les adresses fournis par le jeu de test"
        jeuTestService

        when: "on cherche les musées dont le nom contient 'MUNI' "
        List<Musee> res = museeService.searchMusees("MUNI",null,null)

        then: "on récupère le muséee dont le nom est ARCHIVES MUNICIPALES TOULOUSE"
        res.size() == 1
        res*.id.contains(jeuTestService.musee1.id)

        when: "on cherche les musées dont le code postal de l'adresse est '31500'"
        res = museeService.searchMusees(null,"31500",null)

        then:"on récupère le musee dont le code postal de l'adresse est '31500'"
        res.size() == 1
        res*.id.contains(jeuTestService.adresse1.id)

        when: "on cherche le musée dont le nom de rue de l'adresse contient 'rch'"


        then: "on récupère le musée dont le nom de rue de l'adresse est 'Rue des archives'"
        res.size() == 1
        res*.id.contains(jeuTestService.adresse1.id)

        when:"on positionne tous les critères à null"
        res = museeService.searchMusees(null, null, null)

        then: "on récupère toutes les inscriptions"
        res.size() == 5

    }
}
