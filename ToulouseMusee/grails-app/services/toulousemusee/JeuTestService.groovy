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
    Adresse adresse7
    Adresse adresse8
    Adresse adresse9
    Adresse adresse10
    Adresse adresse11
    Adresse adresse12
    Adresse adresse13

    Musee musee1
    Musee musee2
    Musee musee3
    Musee musee4
    Musee musee5
    Musee musee6
    Musee musee7
    Musee musee8
    Musee musee9
    Musee musee10
    Musee musee11
    Musee musee12

    def insertToMusee(){
        gestionnaire1 = new Gestionnaire(nom: "Mairie de Toulouse - DGA Culture").save()
        gestionnaire2 = new Gestionnaire(nom: "Association").save()
        gestionnaire3 = new Gestionnaire(nom: "Autre institution publique").save()
        gestionnaire4 = new Gestionnaire(nom: "Structure commerciale").save()

        adresse1 = new Adresse(numero: "2", rue: "RUE DES ARCHIVES", codePostal: "31500", ville: "TOULOUSE").save()
        adresse2 = new Adresse(numero: "5", rue: "RUE SAINT PANTALEON", codePostal: "31000", ville: "TOULOUSE").save()
        adresse3 = new Adresse(numero: "69", rue: "RUE PARGAMINIERES", codePostal: "31000", ville: "TOULOUSE").save()
        adresse4 = new Adresse(numero: "31", rue: "RUE DE LA FONDERIE", codePostal: "31000", ville: "TOULOUSE").save()
        adresse5 = new Adresse(numero: "TOUT", rue: "RUE MONTMORENCY", codePostal: "31200", ville: "TOULOUSE").save()
        adresse6 = new Adresse(numero: "2", rue: "RUE VIGUERIE", codePostal: "31300", ville: "TOULOUSE").save()
        adresse7 = new Adresse(numero: "21", rue: "RUE DE METZ",codePostal: "31000",ville: "TOULOUSE").save()
        adresse8 = new Adresse(numero: "2", rue: "RUE TRIPIERE",codePostal: "31000",ville: "TOULOUSE").save()
        adresse9 = new Adresse(numero: "7", rue: "RUE DU MAY",codePostal: "31000",ville: "TOULOUSE").save()
        adresse10 = new Adresse(numero: "TOUT", rue: "RUE DU JAPON",codePostal: "31400",ville: "TOULOUSE").save()
        adresse11 = new Adresse(numero: "13", rue: "RUE DE LA PLEAU",codePostal: "31000",ville: "TOULOUSE").save()

        musee1 = museeService.insertOrUpdateMusee(
                new Musee(
                        nom:"ARCHIVES MUNICIPALES TOULOUSE" , horairesOuverture: "Ouvert du lundi au vendredi de 9h à  17h. Fermeture de 12h à  13h30 pendant toutes les vacances scolaires. Fermeture annuelle la dernière quinzaine de juillet." ,
                        telephone: "05 61 61 63 33" ,
                        accesMetro: "Roseraie (A)",
                        accesBus: "36, 38",
                        isPrefere: false), adresse1, gestionnaire1)
        musee2 = museeService.insertOrUpdateMusee(
                new Musee(
                        nom: "CMAV - CENTRE MERIDIONAL DE L'ARCHITECTURE DE LA VILLE",
                        horairesOuverture: "Ouvert du mardi au samedi de 13h à  19h fermé les dimanches, jours fériés et du 1er au 15 août",
                        telephone: "05 61 23 30 49",
                        accesMetro: "Capitole (A), Jean Jaurès (B)",
                        accesBus: "ncv, 2, 10, 12, 14, 38, 78 et 80",
                        isPrefere: false), adresse2, gestionnaire2)
        musee3 = museeService.insertOrUpdateMusee(
                new Musee(nom: "ENSEMBLE CONVENTUEL DES JACOBINS",
                        horairesOuverture: "Ouvert tous les jours de 9h à  19h.",
                        telephone: "05 61 22 21 92",
                        accesMetro: "Esquirol, Capitole (A)",
                        accesBus: "NCV, 2, 10, 12, 14, 38, 78, 80",
                        isPrefere: false), adresse3, gestionnaire1)
        musee4 = museeService.insertOrUpdateMusee(
                new Musee(nom: "INSTITUT CATHOLIQUE DE TOULOUSE - ESPACE MUSEOGRAPHIQUE BACCRABERE - SALLE TOLOSA",
                        horairesOuverture: "Ouvert le premier vendredi de chaque mois de 18h à  20h.",
                        telephone:"05 61 36 81 12" ,
                        accesMetro: "Carmes (B)",
                        accesBus:"2, 38",
                        isPrefere: false), adresse4, gestionnaire3)
        musee5 = museeService.insertOrUpdateMusee(
                new Musee(nom: "L'AEROTHEQUE",
                        horairesOuverture: "Ouvert le lundi et le mercredi de 14h à  17h et le mardi de 9h à  12h",
                        telephone: "05 61 93 93 57" ,
                        accesMetro: "",
                        accesBus: "15",
                        isPrefere: false), adresse5, gestionnaire4)

        musee6 = museeService.insertOrUpdateMusee(
                new Musee(nom: "MUSEE DE L'HISTOIRE DE LA MEDECINE DE TOULOUSE",
                        horairesOuverture: "Ouvert tous les jeudi et vendredi de 11h à 17h, et le dimande de 10h à 18h.Visites guidées sur demande.",
                        telephone: "05 61 77 84 25",
                        accesMetro: "Saint-Cyprien-République, Esquirol (A)",
                        accesBus: "2, 10, 12, 14, 78, 80",
                        isPrefere: false), adresse6, gestionnaire2)
        musee7 = museeService.insertOrUpdateMusee(
                new Musee(nom: "MUSEE DES AUGUSTINS - MUSEE DES BEAUX ARTS DE TOULOUSE",
                        horairesOuverture: "Tous les jours : 10h - 18h /  nocturne le mercredi jusqu'à 21h.",
                        telephone: "05 61 22 21 82",
                        accesMetro: "Esquirol (A) ou Carmes (B)",
                        accesBus: "ncv, 2, 10, 14, 38, 78, 80",
                        isPrefere: false), adresse7, gestionnaire1)
        musee8 = museeService.insertOrUpdateMusee(
                new Musee(nom: "MUSEE DES COMPAGNONS",
                        horairesOuverture: "Le Mercredi et le 1er dimanche de chaque mois de 14h à 17h",
                        telephone: "05 62 47 41 77",
                        accesMetro: "Esquirol, Capitole (A)",
                        accesBus: "2, 10, 12, 14, 38, 78, 80",
                        isPrefere: false), adresse8, gestionnaire2)
        musee9 = museeService.insertOrUpdateMusee(
                new Musee(nom: "MUSEE DES INSTRUMENTS DE MEDECINE DES HOPITAUX DE TOULOUSE",
                        horairesOuverture: "Ouvert tous les jeudi et vendredi de 13h à 17h. Ouvert le premier dimanche du mois.Visites guidées sur demande.",
                        telephone: "05 61 77 82 72",
                        accesMetro: "Saint-Cyprien-République, Esquirol (A)",
                        accesBus: "2, 10, 12, 14, 78, 80",
                        isPrefere: false), adresse6, gestionnaire4)
        musee10 = museeService.insertOrUpdateMusee(
                new Musee(nom: "MUSEE DU VIEUX TOULOUSE",
                        horairesOuverture: "Ouvert tous les jours du 2 mai au 31 octobre de 14h00 à 18h00.Fermé le dimanche et jours fériés.",
                        telephone: "05 62 27 11 50",
                        accesMetro: "Esquirol, Capitole (A)",
                        accesBus: "2, 10, 12, 14, 38, 78, 80",
                        isPrefere: false), adresse9, gestionnaire2)
        musee11 = museeService.insertOrUpdateMusee(
                new Musee(nom: "MUSEE GEORGES-LABIT",
                        horairesOuverture: "Musée ouvert de 10h à 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermeture hebdomadaire le mardi.Bibliothèque ouverte le lundi de 14h à 17h, le mardi et le mercredi : 9h-12h et 14h-17h." ,
                        telephone: "05 61 14 65 50",
                        accesMetro: "François Verdier (B)",
                        accesBus: "10, 2, 27",
                        isPrefere: false), adresse10, gestionnaire1)
        musee12 = museeService.insertOrUpdateMusee(
                new Musee(nom: "MUSEE PAUL-DUPUY - ARTS GRAPHIQUES ET ARTS DECORATIFS",
                        horairesOuverture: "Ouvert de 10h - 17h en hiver et de 10h à 18h en été (du 1er juin au 30 septembre). Fermé le mardi et jours fériés.",
                        telephone: "05 61 14 65 50" ,
                        accesMetro: "Esquirol (A) Carmes (B)",
                        accesBus: "ncv, 2, 12, 52",
                        isPrefere: false), adresse11, gestionnaire1)


    }

}
