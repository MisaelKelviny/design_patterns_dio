package one.digitalInnovation.gof.facade;

public class CepApi {
    private static CepApi instance = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstance () {
        return instance;
    }

    public String getCity() {
        return "Pouso Alegre";
    }

    public String getState() {
        return "Minas Gerais";
    }
}
