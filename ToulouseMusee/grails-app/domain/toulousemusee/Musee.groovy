package toulousemusee

class Musee {

    String nom
    String horairesOuverture //à revoir
    String telephone
    String accesMetro
    String accesBus
    Adresse adresseMusee
    Gestionnaire gestionnaire

    static constraints = {
        accesMetro  blank: true, nullable: true
        accesBus    blank: true, nullable: true
    }

    static mapping = {
        gestionnaire fetch: 'join'
        adresseMusee fetch: 'join'
    }
}
