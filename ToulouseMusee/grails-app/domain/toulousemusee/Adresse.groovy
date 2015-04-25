package toulousemusee

class Adresse {

    String numero
    String rue
    String codePostal
    String ville

    static constraints = {
    }

    @Override
    String toString() {
        return numero + " " + rue + " " + codePostal + " " + ville
    }
}
