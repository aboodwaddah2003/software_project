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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Program program = (Program) obj;
        return name.equals(program.name);
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
