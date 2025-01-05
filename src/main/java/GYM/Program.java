package GYM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Program {
    private String name;
    private String difficultyLevel;
    private String focusArea;
    private int id;
    private String goals;
    private String imgPath;
    private String Scheduels;

    private int duration;

    private LocalDate startDate;
    private  double price;
    private  int count=0 ;

    private List<Milestone> programMilestones;
    public Program(String name, String difficultyLevel, String focusArea,double price,int duration) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.focusArea = focusArea;
       this.price=price;
       this.duration=duration;
       this.startDate=LocalDate.now();
       this.programMilestones= new ArrayList<>();
       this.id=++count;
    }

    public Program(String name, String difficultyLevel, double price,
                   int duration, String goals, String Scheduels, String imgPath)
    {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.price=price;
        this.duration=duration;
        this.goals=goals;
        this.Scheduels = Scheduels;
        this.imgPath=imgPath;
    }


    //default constructor
    public Program() {
        this.name = "";
        this.difficultyLevel = "";
        this.price=0;
        this.duration=0;
        this.goals="";
        this.Scheduels ="";
        this.imgPath="";
    }





    public String getName() {
        return name;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getFocusArea() {
        return focusArea;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class type
        Program program = (Program) obj;
        return name.equals(program.name); // Compare the 'name' field for equality
    }

    @Override
    public int hashCode() {
        return name.hashCode(); // Generate a hash code based on the 'name' field
    }



    @Override
    public String toString() {
        return "FitnessProgram{" +
                "title='" + name + '\'' +
                ", duration=" + duration + " weeks" +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", startDate=" + startDate +
                '}';
    }
    public  void  increaseSubProgramCount()
    {
        this.count++;
    }
    public int numOfClientSub()
    {
        return this.count;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public boolean isCompleted(LocalDate fakeToday) {
        startDate=fakeToday;
        LocalDate endDate = startDate.plusWeeks(duration);

        return fakeToday.isAfter(endDate);
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String getGoals() {

        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getSchedules() {
        return Scheduels;
    }

    public void setSchedules(String schedules) {
        this.Scheduels = schedules;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addMilestone(Milestone milestone) {
        programMilestones.add(milestone);
    }

    public double calculateAttendancePercentage() {
        int totalMilestones = programMilestones.size();
        int attendedCount = 0;

        for (Milestone milestone : programMilestones) {
            if (milestone.getAttendance().equalsIgnoreCase("present")) {
                attendedCount++;
            }
        }

        if (totalMilestones == 0) {
            return 0.0;
        }
        return (double) attendedCount / totalMilestones * 100;
    }
}
