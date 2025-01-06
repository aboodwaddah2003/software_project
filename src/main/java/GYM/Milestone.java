package GYM;

import java.util.List;

public class Milestone {
    private String weight;
    private String bmi;
    private String attendance;
    private String clientName;



    private String date;
    private int programId;


    public Milestone(String weight, String bmi, String attendance) {
        this.weight = weight;
        this.bmi = bmi;
        this.attendance = attendance;
    }

    public Milestone(String weight, String bmi, String attendance, String clientName) {
        this.weight = weight;
        this.bmi = bmi;
        this.attendance = attendance;
        this.clientName = clientName;
    }

    public Milestone(String weight, String bmi, String attendance, String clientName,String date,int programId) {
        this.weight = weight;
        this.bmi = bmi;
        this.attendance = attendance;
        this.clientName = clientName;
        this.date=date;
        this.programId=programId;
    }



    public String getWeight() {
        return weight;
    }

    public String getBmi() {
        return bmi;
    }

    public String getAttendance() {
        return attendance;
    }

    public String getClientName() {return clientName;}
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "Milestone [Weight=" + weight + ", BMI=" + bmi + ", Attendance=" + attendance + ", Date=" + date + "]";
    }
    public void setWeight(String newWeight) {
        if (newWeight == null || newWeight.isEmpty()) {
            System.out.println("Invalid weight value.");
            return;
        }
        this.weight = newWeight;
        System.out.println("Weight updated to: " + newWeight);
    }

    public void setBmi(String newBmi) {
        if (newBmi == null || newBmi.isEmpty()) {
            System.out.println("Invalid BMI value.");
            return;
        }

        try {
            double bmiValue = Double.parseDouble(newBmi);
            if (bmiValue < 10 || bmiValue > 50) {
                System.out.println("BMI value is out of acceptable range (10 - 50).");
            } else {
                this.bmi = newBmi;
                System.out.println("BMI updated to: " + newBmi);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid BMI format.");
        }
    }

    public void setAttendance(String newAttendance) {
        if (newAttendance == null || newAttendance.isEmpty()) {
            System.out.println("Attendance cannot be empty.");
            return;
        }

        try {
            String[] parts = newAttendance.split(" ");
            int days = Integer.parseInt(parts[0]);

            if (days < 0) {
                System.out.println("Attendance days cannot be negative.");
            } else {
                this.attendance = newAttendance;
                System.out.println("Attendance updated to: " + newAttendance);
            }
        } catch (Exception e) {
            System.out.println("Invalid attendance format. Please use 'X days'.");
        }
    }
    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }


}
