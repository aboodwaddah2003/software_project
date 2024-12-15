package GYM;

import java.util.List;
import java.util.ArrayList;


class ClientRepository {

    private List<Client> clients;

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


public class AccountHelper {

    private ClientRepository clientRepository;  // حقن التبعية


    public AccountHelper(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


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


    public boolean allFieldsAreFull(String age, String goals) {
        if (age == null || age.isEmpty()) {
            System.out.println("Age is required.");
            return false;
        }
        if (goals == null || goals.isEmpty()) {
            System.out.println("Goals are required.");
            return false;
        }
        return true;
    }


    public boolean updatePersonalDetails(String userName, String name, int age, String goals) {
        Client client = clientRepository.findClientByUserName(userName);

        if (client == null) {
            System.out.println("Client with username " + userName + " not found.");
            return false;
        }

        if (name != null && !name.isEmpty()) client.setUserName(name);
        if (age > 0) client.setAge(age);
        if (goals != null && !goals.isEmpty()) client.setFitnessGoals(goals);

        System.out.println("Personal details updated for " + userName + ": " + name + ", " + age + ", " + goals);
        return true;
    }
}
