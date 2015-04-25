package toulousemusee

import grails.transaction.Transactional
import toulousemusee.Adresse
import toulousemusee.Gestionnaire
import toulousemusee.Musee
import toulousemusee.MuseeService

@Transactional
class JeuTestService {

    MuseeService museeService

    Gestionnaire gestionnaire1
    Gestionnaire gestionnaire2
    Gestionnaire gestionnaire3
    Gestionnaire gestionnaire4

    Adresse adresse1
    Adresse adresse2
    Adresse adresse3
    Adresse adresse4
    Adresse adresse5
    Adresse adresse6

    Musee musee1
    Musee musee2
    Musee musee3
    Musee musee4
    Musee musee5

    def insertToMusee(){
        gestionnaire1 = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture").save()
        gestionnaire2 = new Gestionnaire(nom: "Association").save()
        gestionnaire3 = new Gestionnaire(nom: "Autre institution publique").save()
        gestionnaire4 = new Gestionnaire(nom: "Structure commerciale").save()

        adresse1 = new Adresse(numero: "2", rue: "Rue des archives", codePostal: "31500", ville: "Toulouse").save()
        adresse2 = new Adresse(numero: "5", rue: "Rue Saint Pantaleon", codePostal: "31000", ville: "Toulouse").save()
        adresse3 = new Adresse(numero: "69", rue: "Rue Pargaminieres", codePostal: "31000", ville: "Toulouse").save()
        adresse4 = new Adresse(numero: "31", rue: "Rue de la fonderie", codePostal: "31000", ville: "Toulouse").save()
        adresse5 = new Adresse(numero: "Tout", rue: "Rue MontMorency", codePostal: "31200", ville: "Toulouse").save()
        adresse6 = new Adresse(numero: "2", rue: "Rue Viguerie", codePostal: "31300", ville: "Toulouse").save()

        musee1 = museeService.insertOrUpdateMusee(new Musee(nom:"ARCHIVES MUNICIPALES TOULOUSE" , horairesOuverture: "Ouvert du lundi au vendredi de 9h Ã  17h. Fermeture de 12h Ã  13h30 pendant toutes les vacances scolaires. Fermeture annuelle la derniÃ¨re quinzaine de juillet." , telephone: "05 61 61 63 33" , accesMetro: "Roseraie (A)", accesBus: "36, 38",adresseMusee: adresse1),gestionnaire1)
        musee2 = museeService.insertOrUpdateMusee(new Musee(nom: "CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE", horairesOuverture: "Ouvert du mardi au samedi de 13h Ã  19hfermÃ© les dimanches, jours fÃ©riÃ©s et du 1er au 15 aoÃ»t", telephone: "05 61 23 30 49", accesMetro: "Capitole (A), Jean JaurÃ¨s (B)" , accesBus: "ncv, 2, 10, 12, 14, 38, 78 et 80",adresseMusee: adresse2),gestionnaire2)
        musee3 = museeService.insertOrUpdateMusee(new Musee(nom: "ENSEMBLE CONVENTUEL DES JACOBINS", horairesOuverture: "Ouvert tous les jours de 9h Ã  19h.", telephone: "05 61 22 21 92", accesMetro: "Esquirol, Capitole (A)", accesBus: "NCV, 2, 10, 12, 14, 38, 78, 80",adresseMusee: adresse3),gestionnaire1)
        musee4 = museeService.insertOrUpdateMusee(new Musee(nom: "ENSEMBLE CONVENTUEL DES JACOBINS", horairesOuverture: "Ouvert le premier vendredi de chaque mois de 18h Ã  20h.", telephone:"05 61 36 81 12" , accesMetro: "Carmes (B)", accesBus:"2, 38" ,adresseMusee: adresse4),gestionnaire3)
        musee5 = museeService.insertOrUpdateMusee(new Musee(nom: "INSTITUT CATHOLIQUE DE TOULOUSE - ESPACE MUSEOGRAPHIQUE BACCRABERE - SALLE TOLOSA", horairesOuverture: "Ouvert le lundi et le mercredi de 14h Ã  17h et le mardi de 9h Ã  12h", telephone: "05 61 93 93 57" , accesMetro: "", accesBus: "15" ,adresseMusee: adresse5 ),gestionnaire4)
        //musee1 = museeService.insertOrUpdateMusee(new Musee(nom: , horairesOuverture: , telephone: , accesMetro: , accesBus: ,adresseMusee: ),gestionnaire1)

    }

}
