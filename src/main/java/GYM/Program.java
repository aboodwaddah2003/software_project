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

    private List<Milestone> programMilestones;

    private LocalDate startDate;
    private  double price;
    private  int count ;

    public Program(String name, String difficultyLevel, String focusArea,double price,int duration) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.focusArea = focusArea;
        count=0;
        this.price=price;
        this.duration=duration;
        this.startDate=LocalDate.now();
    }



    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getFocusArea() {
        return focusArea;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Program program = (Program) obj;
        return name.equals(program.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
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

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
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
    public void addMilestone(Milestone milestone) {
        programMilestones.add(milestone);
    }

}
