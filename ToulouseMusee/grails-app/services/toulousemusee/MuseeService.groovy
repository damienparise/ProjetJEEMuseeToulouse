package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    Musee insertOrUpdateMusee(Musee musee, Adresse adresse, Gestionnaire gestionnaire){
        gestionnaire.addToMusees(musee)
        gestionnaire.save(flush: true)
        musee
    }

    def deleteMusee(Musee musee) {
        if (musee){
            musee.gestionnaire.removeFromMusees(musee)
            musee.delete()
        }
    }

    List<Musee> searchMusees(String sousNom, String cp, String sousRue) {
        def musee = Musee.createCriteria()
        List<Musee> results = musee {
            if (sousNom){
                like 'nom', "%${sousNom}%"
            }
            if (cp) {
                adresseMusee {
                    like 'codePostal', "${cp}"
                }
            }
            if (sousRue) {
                adresseMusee {
                    like 'rue', "%${sousRue}%"
                }
            }
            /*ordonner????*/
            join 'musee.adresse'
            join 'musee.gestionnaire'
        }
        results
    }
}
