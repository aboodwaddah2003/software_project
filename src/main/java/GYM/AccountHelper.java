package GYM;

import java.util.List;
import java.util.ArrayList;


class ClientRepository {

    private List<Client> clients;

    //constructor
    public ClientRepository(List<Client> clients) {
        this.clients = clients;
    }


    public void saveClient(Client client) {
        clients.add(client);
    }


    public Client findClientByUserName(String userName) {
        for (Client client : clients) {
            if (client.getUserName().equals(userName)) {
                return client;
            }
        }
        return null;
    }
}

//the base class
public class AccountHelper {

    private ClientRepository clientRepository;





    public AccountHelper() {

        this.clientRepository = new ClientRepository(new ArrayList<>());
    }


    public boolean createProfile(String name, String age, String goals) {

        if (name == null || name.isEmpty()) {
            System.out.println("Name is required.");
            return false;
        }
        if (age == null || age.isEmpty()) {
            System.out.println("Age is required.");
            return false;
        }
        if (goals == null || goals.isEmpty()) {
            System.out.println("Goals are required.");
            return false;
        }

        int parsedAge = 0;
        try {
            parsedAge = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format.");
            return false;
        }

        Client newClient = new Client(name);
        newClient.setAge(parsedAge);
        newClient.setFitnessGoals(goals);


        clientRepository.saveClient(newClient);

        System.out.println("Creating profile with name: " + name + ", age: " + age + ", goals: " + goals);
        return true;
    }


    public boolean updateDietaryPreferences(String userName, String preferences) {

        if (preferences == null || preferences.isEmpty()) {
            System.out.println("Preferences are required.");
            return false;
        }

        Client client = clientRepository.findClientByUserName(userName);

        if (client == null) {
            System.out.println("Client with username " + userName + " not found.");
            return false;
        }

        client.setDietaryPreferences(preferences);
        System.out.println("Dietary preferences for " + userName + " updated to: " + preferences);
        return true;
    }






}
