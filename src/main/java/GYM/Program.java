package GYM;

import java.time.LocalDate;

public class Program {
    private String name;
    private String difficultyLevel;
    private String focusArea;



    private int duration;



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
        if (this == obj) return true; // Same object comparison
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        Program program = (Program) obj; // Cast to the correct type
        return name.equals(program.name); // Compare relevant fields
    }

    @Override
    public int hashCode() {
        return name.hashCode(); // Ensure consistency with equals()
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




}
