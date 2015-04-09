package toulousemusee

class DemandeVisite {

    String codeVisite
    Date dateDebutPeriode
    Date dateFinPeriode
    int nbPersonnes
    String statut

    static constraints = {
        nbPersonnes inList: [1,2,3,4,5,6]
        statut      inList: ["Attente","Valider"]
    }
}
