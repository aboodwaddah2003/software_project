package GYM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramService {
    public static List<Program> allPrograms = new ArrayList<>();
    public static List<Client> registeredClients = new ArrayList<>();

    public static List<String>AttendanceRecord = new ArrayList<>();






    public ProgramService() {

        if (allPrograms.isEmpty()) {
            allPrograms.add(new Program("Muscle Gain Program", "Advanced", "Muscle building", 100,12));
            allPrograms.add(new Program("Weight Loss Program", "Beginner", "Weight loss", 120,6));
            allPrograms.add(new Program("Flexibility Program", "Intermediate", "Flexibility", 135.50,8));
            allPrograms.add(new Program("Yoga Program", "Beginner", "Flexibility", 160,7));
        }
    }

    public static void fillDataProgram()
    {
        Program p1= ProgramService.getProgramByName("Muscle Gain Program") ;
        Program p2= ProgramService.getProgramByName("Weight Loss Program") ;
        Program p3= ProgramService.getProgramByName("Flexibility Program") ;
        Program p4= ProgramService.getProgramByName("Yoga Program") ;


        LocalDate startDateP1 = LocalDate.of(2024, 12, 1);
        LocalDate startDateP2 = LocalDate.of(2024, 12, 12);
        LocalDate startDateP3 = LocalDate.of(2024, 11, 1);
        LocalDate startDateP4 = LocalDate.of(2024, 11, 15);
        p1.setStartDate(startDateP1);
        p2.setStartDate(startDateP2);
        p3.setStartDate(startDateP3);
        p4.setStartDate(startDateP4);


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




    public static Program getProgramByName(String programName) {
        for (Program program : allPrograms) {
            if (program.getName().equals(programName)) {
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


    public static List<Program> getAllPrograms() {
        return allPrograms;
    }

    public static String getProgramSchedule(String programName) {
        Program program = getProgramByName(programName);
        if (program != null) {
            return "Schedule for " + program.getName() + ": Monday 10AM, Wednesday 10AM, Friday 10AM";
        } else {
            return "Program '" + programName + "' not found.";
        }
    }





}
