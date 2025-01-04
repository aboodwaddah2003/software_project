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

