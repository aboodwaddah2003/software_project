package GYM;


import java.time.LocalDate;
import java.util.Objects;

public class ProgramManagementPage {


    private Message m1;

    public void CreateNewProgram(Program p){
        if (p.getName().isEmpty()){
            System.out.println("Program name cannot be empty");
            return;
        } else if (ProgramIsEmpty(p)) return;
        ProgramService.allPrograms.add(p);
        System.out.println("Program added");
    }


//the name of the program can't be updated .
    public void UpdateProgram(Program p) {
        for (int i = 0; i < ProgramService.allPrograms.size(); i++) {
            if(Objects.equals(p.getName(), ProgramService.allPrograms.get(i).getName())){

                if (ProgramIsEmpty(p)) return;
                ProgramService.allPrograms.remove(ProgramService.allPrograms.get(i));
                ProgramService.allPrograms.add(p);
                System.out.println("Program updated successfully");
                Instructor.notifiesAll(p);

            }

        }
        System.out.println("Program does not exist(you can't update the Name)");
    }



    public void Delete(Program p, LocalDate LD) {
        for (int i = 0; i < ProgramService.allPrograms.size(); i++) {
            if(Objects.equals(p.getName(), ProgramService.allPrograms.get(i).getName())){
                if (!p.isCompleted(LD)){
                    System.out.println("program assigned to active gym members(Program Uncompleted)");
                    return;
                }
                ProgramService.allPrograms.remove(p);
                System.out.println("Program deleted successfully!");
                return;

            }
        }
        System.out.println("Program does not exist");

    }

    private boolean ProgramIsEmpty(Program p) {
        if (p.getDifficultyLevel().isEmpty()) {
            System.out.println("Program difficulty level cannot be empty");
            return true;
        } else if (p.getPrice()==0) {
            System.out.println("Program focus area cannot be empty or zero");
            return true;
        } else if (p.getDuration()==0) {
            System.out.println("Program duration cannot be empty or zero");
            return true;
        } else if (p.getGoals().isEmpty()) {
            System.out.println("Program goals cannot be empty");
            return true;
        } else if (p.getSchedules().isEmpty()) {
            System.out.println("Program schedules cannot be empty");
            return true;
        } else if (p.getImgPath().isEmpty()) {
            System.out.println("Program image path cannot be empty");
            return true;
        }
        return false;
    }

    public void ActiveProgram(Program p2) {

    }

}

