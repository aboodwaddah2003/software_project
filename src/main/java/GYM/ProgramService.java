package GYM;

import java.util.ArrayList;
import java.util.List;

public class ProgramService {
    public static List<Program> allPrograms=new ArrayList<>();
    public static List<Client> registeredClients=new ArrayList<>();

    public  ProgramService() {


        if (allPrograms.isEmpty()) {
            allPrograms.add(new Program("Muscle Gain Program", "Advanced", "Muscle building",100));
            allPrograms.add(new Program("Weight Loss Program", "Beginner", "Weight loss",120));
            allPrograms.add(new Program("Flexibility Program", "Intermediate", "Flexibility",135.50));
            allPrograms.add(new Program("Yoga Program", "Beginner", "Flexibility",160));
        }
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


    public  static String enrollClientInProgram(Client client, String programName) {
        Program program = getProgramByName(programName);
        if (program == null) {
            return "Error: Program '" + programName + "' not found.";
        }

        if (client.getEnrolledPrograms().contains(program)) {
            return "Client is already enrolled in " + program.getName();
        }
        else {
            client.enrollInProgram(program);
            program.increaseSubProgramCount();

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


    public static Program getProgramByName(String programName) {
        for (Program program : allPrograms) {
            if (program.getName().equals(programName)) {
                return program;
            }
        }
        return null; // Return null if no match found
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
