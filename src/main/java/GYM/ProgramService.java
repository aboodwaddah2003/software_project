package GYM;

import java.util.ArrayList;
import java.util.List;

public class ProgramService {
    private final List<Program> allPrograms;


    public ProgramService() {
        allPrograms = new ArrayList<>();
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

    public String enrollInProgram(Program program) {

        return "Successfully enrolled in " + program.getName();
    }

    public String getProgramSchedule(Program program) {

        return "Schedule for " + program.getName() + ": Monday 10AM, Wednesday 10AM, Friday 10AM";
    }


    public Program getProgramByName(String programName) {
        for (Program program : allPrograms) {
            if (program.getName().equalsIgnoreCase(programName)) {
                return program;
            }
        }
        return null;
    }
}
