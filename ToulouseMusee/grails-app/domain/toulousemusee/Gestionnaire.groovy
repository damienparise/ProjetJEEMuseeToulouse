package toulousemusee

class Gestionnaire {

    String nom

    static hasMany = [musees:Musee]

    static constraints = {
    }
}
