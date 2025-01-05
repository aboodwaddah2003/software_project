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

    public static void fillDataProgram() {
        Program p1 = ProgramService.getProgramByName("Muscle Gain Program");
        Program p2 = ProgramService.getProgramByName("Weight Loss Program");
        Program p3 = ProgramService.getProgramByName("Flexibility Program");
        Program p4 = ProgramService.getProgramByName("Yoga Program");

        LocalDate startDateP1 = LocalDate.of(2024, 12, 1);
        LocalDate startDateP2 = LocalDate.of(2024, 12, 12);
        LocalDate startDateP3 = LocalDate.of(2024, 11, 1);
        LocalDate startDateP4 = LocalDate.of(2024, 11, 15);

        if (p1 != null) {
            p1.setStartDate(startDateP1);
        } else {
            System.out.println("Program 'Muscle Gain Program' not found.");
        }

        if (p2 != null) {
            p2.setStartDate(startDateP2);
        } else {
            System.out.println("Program 'Weight Loss Program' not found.");
        }

        if (p3 != null) {
            p3.setStartDate(startDateP3);
        } else {
            System.out.println("Program 'Flexibility Program' not found.");
        }

        if (p4 != null) {
            p4.setStartDate(startDateP4);
        } else {
            System.out.println("Program 'Yoga Program' not found.");
        }
    }
    public  static  void fillData4()
    {
        Client n1 = new Client("sead", "moh@gmail.com", "10203040", "Client", "Gold");
        Instructor I1 =new Instructor("khader","khader@gmail.com","20304050",
                "Instructor","Gold");
        ProgramService.enrollClientInProgram(n1,"Muscle Gain Program");
        I1.addMilestone(1,"sead","90","5","present","1/9/2024");
        I1.addMilestone(1,"sead","86","4.2","present","12/9/2024");
        I1.addMilestone(1,"sead","78","4","present","30/9/2024");
        I1.addMilestone(1,"sead","75","3.2"," not present","4/10/2024");
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



    public static String getProgramSchedule(String programName) {
        Program program = getProgramByName(programName);
        if (program != null) {
            return "Schedule for " + program.getName() + ": Monday 10AM, Wednesday 10AM, Friday 10AM";
        } else {
            return "Program '" + programName + "' not found.";
        }
    }





}
