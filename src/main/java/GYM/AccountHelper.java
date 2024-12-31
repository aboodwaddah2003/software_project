package GYM;

import java.util.List;
import java.util.ArrayList;

class ClientRepository {

    private List<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    public void saveClient(Client client) {
        clients.add(client);
    }

    public Client findClientByUserName(String userName) {
        return clients.stream()
                .filter(client -> client.getUserName().equals(userName))
                .findFirst()
                .orElse(null);
    }
}

public class AccountHelper {

    private ClientRepository clientRepository;

    public AccountHelper(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public AccountHelper() {
        this.clientRepository = new ClientRepository();
    }

    public boolean createProfile(String name, String age, String goals) {
        if (isInvalidInput(name, age, goals)) {
            return false;
        }

        int parsedAge = parseAge(age);
        if (parsedAge == -1) return false;

        Client newClient = new Client(name);
        newClient.setAge(parsedAge);
        newClient.setFitnessGoals(goals);

        clientRepository.saveClient(newClient);
        System.out.println("Profile created for " + name + ", age: " + age + ", goals: " + goals);
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
        return !(age == null || age.isEmpty() || goals == null || goals.isEmpty());
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

    private boolean isInvalidInput(String name, String age, String goals) {
        if (name == null || name.isEmpty()) {
            System.out.println("Name is required.");
            return true;
        }
        if (age == null || age.isEmpty()) {
            System.out.println("Age is required.");
            return true;
        }
        if (goals == null || goals.isEmpty()) {
            System.out.println("Goals are required.");
            return true;
        }
        return false;
    }

    private int parseAge(String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age format.");
            return -1;
        }
    }
}
