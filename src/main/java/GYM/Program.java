package GYM;

public class Program {
    private String name;
    private String difficultyLevel;
    private String focusArea;

    public Program(String name, String difficultyLevel, String focusArea) {
        this.name = name;
        this.difficultyLevel = difficultyLevel;
        this.focusArea = focusArea;
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
}
