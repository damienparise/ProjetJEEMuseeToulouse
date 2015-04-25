package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    def insertOrUpdateMusee(Musee musee, Gestionnaire gestionnaire){
        gestionnaire.addToMusees(musee)
        gestionnaire.save flush:true
        musee
    }
}
