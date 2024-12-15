package GYM;

import java.util.ArrayList;
import java.util.List;

public class ProgramService {
    private final List<Program> allPrograms;
    private final List<Client> registeredClients;

    public ProgramService() {
        allPrograms = new ArrayList<>();
        registeredClients = new ArrayList<>();


        allPrograms.add(new Program("Muscle Gain Program", "Advanced", "Muscle building"));
        allPrograms.add(new Program("Weight Loss Program", "Beginner", "Weight loss"));
        allPrograms.add(new Program("Flexibility Program", "Intermediate", "Flexibility"));
        allPrograms.add(new Program("Yoga Program", "Beginner", "Flexibility"));
    }


    public List<Program> filterProgramsByDifficulty(String difficulty) {
        List<Program> filteredPrograms = new ArrayList<>();
        for (Program program : allPrograms) {
            if (program.getDifficultyLevel() != null && program.getDifficultyLevel().equalsIgnoreCase(difficulty)) {
                filteredPrograms.add(program);
            }
        }
        return filteredPrograms;
    }


    public List<Program> filterProgramsByFocusArea(String focusArea) {
        List<Program> filteredPrograms = new ArrayList<>();
        for (Program program : allPrograms) {
            if (program.getFocusArea() != null && program.getFocusArea().equalsIgnoreCase(focusArea)) {
                filteredPrograms.add(program);
            }
        }
        return filteredPrograms;
    }


    public String enrollClientInProgram(Client client, String programName) {
        Program program = getProgramByName(programName); // البحث عن البرنامج بالاسم
        if (program == null) {
            return "Error: Program '" + programName + "' not found.";
        }

        if (client.getEnrolledPrograms().contains(program)) {
            return "Client is already enrolled in " + program.getName();
        } else {
            client.enrollInProgram(program);

            if (!registeredClients.contains(client)) {
                registeredClients.add(client);
            }
            return "Client successfully enrolled in " + program.getName();
        }
    }


    public String getProgramSchedule(String programName) {
        Program program = getProgramByName(programName);
        if (program != null) {
            return "Schedule for " + program.getName() + ": Monday 10AM, Wednesday 10AM, Friday 10AM";
        } else {
            return "Program '" + programName + "' not found.";
        }
    }


    public Program getProgramByName(String programName) {
        for (Program program : allPrograms) {
            if (program.getName().equalsIgnoreCase(programName)) {
                return program;
            }
        }
        return null;
    }


    public void addClient(Client client) {
        if (!registeredClients.contains(client)) {
            registeredClients.add(client);
        }
    }


    public List<Client> getRegisteredClients() {
        return registeredClients;
    }


    public List<Program> getAllPrograms() {
        return allPrograms;
    }
}
