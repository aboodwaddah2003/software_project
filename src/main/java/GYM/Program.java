package GYM;

public class Program {
    private String name;
    private String difficultyLevel;
    private String focusArea;



    private  double price;
    private  int count ;

    public Program(String name, String difficultyLevel, String focusArea,double price) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.focusArea = focusArea;
        count=0;
       this.price=price;
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
        return "Program{" +
                "name='" + name + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", focusArea='" + focusArea + '\'' +
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
}
