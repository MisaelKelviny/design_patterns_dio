package one.digitalInnovation.gof.facade;

public class Facade {
    public void migrateClient(String name, String cep){
        String city = CepApi.getInstance().getCity();
        String state = CepApi.getInstance().getState();
        CrmService.saveClient(name, cep, state, city);
    }
}
