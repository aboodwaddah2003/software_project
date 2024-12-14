package GYM;

import java.util.ArrayList;
import java.util.List;

public class UserProgress {

    private List<Milestone> milestones = new ArrayList<>();


    public boolean logMilestone(String weight, String bmi, String attendance) {

        if ((weight == null || weight.isEmpty()) &&
                (bmi == null || bmi.isEmpty()) &&
                (attendance == null || attendance.isEmpty())) {
            return false;
        }


        milestones.add(new Milestone(weight, bmi, attendance));
        return true;
    }




    public List<Milestone> getMilestones() {
        return milestones;
    }


    public List<String> getBadges() {
        List<String> badges = new ArrayList<>();
        for (Milestone milestone : milestones) {
            if (milestone.getAttendance().contains("4 days")) {
                badges.add("Consistent Attendee");
            }
            if (Double.parseDouble(milestone.getBmi()) >= 18.5 && Double.parseDouble(milestone.getBmi()) <= 24.9) {
                badges.add("Healthy BMI Achiever");
            }
        }
        return badges;
    }

    public boolean displayProgressChart() {
        
        List<String> progressData = getProgressData(); 

        if (progressData.isEmpty()) {
            System.out.println("No progress data available to display.");
            return false;  
        }

        
        System.out.println("Displaying Progress Chart:");
        System.out.println("-------------------------------------------------");
        System.out.println("Date\t\tWeight\tBMI\tAttendance");
        for (String data : progressData) {
            System.out.println(data);  
        }
        
        return true;
    }

    private List<String> getProgressData() {

        List<String> progress = new ArrayList<>();
        progress.add("2024-12-01\t70kg\t22.0\t5 days");
        progress.add("2024-12-05\t71kg\t22.1\t4 days");
        progress.add("2024-12-10\t72kg\t22.2\t6 days");
        return progress;
    }

    public boolean updateMilestone(int index, String milestoneType, String newValue) {

        if (milestoneType == null || milestoneType.isEmpty() || newValue == null || newValue.isEmpty()) {
            System.out.println("Milestone type or new value cannot be empty.");
            return false;
        }


        if (index < 0 || index >= milestones.size()) {
            System.out.println("Invalid milestone index.");
            return false;
        }


        Milestone milestone = milestones.get(index);


        switch (milestoneType.toLowerCase()) {
            case "weight":

                try {
                    milestone = new Milestone(newValue, milestone.getBmi(), milestone.getAttendance());
                    milestones.set(index, milestone);
                    System.out.println("Weight updated to: " + newValue);
                    return true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid weight format.");
                    return false;
                }

            case "bmi":
                // تحديث الـ BMI
                try {
                    milestone = new Milestone(milestone.getWeight(), newValue, milestone.getAttendance());
                    milestones.set(index, milestone);
                    System.out.println("BMI updated to: " + newValue);
                    return true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid BMI format.");
                    return false;
                }

            case "attendance":

                if (newValue.contains("days")) {

                    String days = newValue.split(" ")[0];
                    milestone = new Milestone(milestone.getWeight(), milestone.getBmi(), newValue);
                    milestones.set(index, milestone);
                    System.out.println("Attendance updated to: " + newValue);
                    return true;
                } else {
                    System.out.println("Invalid attendance format.");
                    return false;
                }

            default:
                System.out.println("Unknown milestone type: " + milestoneType);
                return false;
        }
    }

    public boolean deleteMilestone(String weight, String bmi, String attendance) {

        if (weight == null || weight.isEmpty() || bmi == null || bmi.isEmpty() || attendance == null || attendance.isEmpty()) {
            System.out.println("All fields must be provided to delete a milestone.");
            return false;
        }


        for (Milestone milestone : milestones) {
            if (milestone.getWeight().equals(weight) && milestone.getBmi().equals(bmi) && milestone.getAttendance().equals(attendance)) {
                milestones.remove(milestone); // حذف المعلم
                System.out.println("Milestone deleted: Weight = " + weight + ", BMI = " + bmi + ", Attendance = " + attendance);
                return true;
            }
        }


        System.out.println("Milestone not found.");
        return false;
    }

    public boolean updateMilestone(String weight, String bmi, String attendance, String newWeight, String newBmi, String newAttendance) {

        if (weight == null || bmi == null || attendance == null || newWeight == null || newBmi == null || newAttendance == null) {
            System.out.println("All fields must be provided to update a milestone.");
            return false;
        }


        for (Milestone milestone : milestones) {
            if (milestone.getWeight().equals(weight) && milestone.getBmi().equals(bmi) && milestone.getAttendance().equals(attendance)) {

                milestone.setWeight(newWeight);
                milestone.setBmi(newBmi);
                milestone.setAttendance(newAttendance);
                System.out.println("Milestone updated: New Weight = " + newWeight + ", New BMI = " + newBmi + ", New Attendance = " + newAttendance);
                return true;
            }
        }


        System.out.println("Milestone not found.");
        return false;
    }


    public boolean updateMilestone(int index, Milestone newMilestone) {
        if (index < 0 || index >= milestones.size()) {
            System.out.println("Invalid index.");
            return false;
        }

        Milestone milestoneToUpdate = milestones.get(index);


        if (newMilestone.getWeight() != null && !newMilestone.getWeight().isEmpty()) {
            milestoneToUpdate.setWeight(newMilestone.getWeight());
        }
        if (newMilestone.getBmi() != null && !newMilestone.getBmi().isEmpty()) {
            milestoneToUpdate.setBmi(newMilestone.getBmi());
        }
        if (newMilestone.getAttendance() != null && !newMilestone.getAttendance().isEmpty()) {
            milestoneToUpdate.setAttendance(newMilestone.getAttendance());
        }

        System.out.println("Milestone updated successfully.");
        return true;
    }


}

