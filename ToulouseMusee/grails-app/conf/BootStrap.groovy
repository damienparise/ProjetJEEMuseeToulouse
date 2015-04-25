import toulousemusee.JeuTestService

class BootStrap {

    JeuTestService jeuTestService

    def init = {
        jeuTestService.insertToMusee()
    }
    def destroy = {
    }
}
