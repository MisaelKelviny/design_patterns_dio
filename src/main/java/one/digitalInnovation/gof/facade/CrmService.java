package one.digitalInnovation.gof.facade;

public class CrmService {

    private CrmService() {
        super();
    }

    public static void saveClient(String name, String cep, String state, String city){
        System.out.println("Cliente Salvo no sistema de CRM: ");
        System.out.println(name + " " + cep + " " + state + " " + city);
    }
}
