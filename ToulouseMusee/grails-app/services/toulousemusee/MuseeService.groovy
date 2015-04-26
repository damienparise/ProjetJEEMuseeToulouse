package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    Musee insertOrUpdateMuseeWithAdresse(Musee unMusee, Adresse uneAdresse){
        unMusee.adresseMusee  = uneAdresse
        unMusee.save(flush: true)
    }

    Musee insertOrUpdateMusee(Musee unMusee, Adresse uneAdresse, Gestionnaire unGestionnaire){
        insertOrUpdateMuseeWithAdresse(unMusee, uneAdresse)
        unGestionnaire.addToMusees(unMusee)
        unGestionnaire.save(flush: true)
        unMusee
    }


    def deleteMusee(Musee unMusee) {
        if (unMusee){
            unMusee.gestionnaire.removeFromMusees(unMusee)
            unMusee.delete()
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
            join 'unMusee.adresse'
            join 'unMusee.gestionnaire'
        }
        results
    }

//    Musee addFavoris(Musee unMusee){
//        unMusee.isPrefere = true
//        unMusee.save(flush: true)
//        unMusee
//    }

    List<Musee> addFavoris(String id){
        Musee musee = Musee.findById(Long.parseLong(id))
        musee.isPrefere = true
        musee.save(flush: true)
        Musee.findAll()
    }
}
