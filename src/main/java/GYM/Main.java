package GYM;

import io.cucumber.java.bs.A;

import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

import static GYM.Admin.*;
import static GYM.ContentMangerService.*;
import static GYM.FeedbackService.*;
import static GYM.Client.*;
import static GYM.FeedbackService.resolveComplaint;
import static GYM.ManageAccountHelper.showAllInstructorRequest;
import static GYM.ProgramService.*;
import static GYM.Userlist.*;

public class Main {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        Userlist.fillData();
//        ManageAccountHelper.fillData2();
//        ManageAccountHelper.fillRecordActivity();
//        Userlist.fillData3();
//        ProgramService programService = new ProgramService();
//        ProgramService.fillDataProgram();
//        Userlist.fillDataClientEnrollInProgram();
//        ContentMangerServiceFill();
//        FeedbackService.fillDataFeedback();
//        FeedbackService.fillDataComplements();
//
//
//        while (true) {
//            System.out.println("=== Welcome to the System ===");
//            System.out.println("1. Log In");
//            System.out.println("2. Sign Up");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            switch (choice) {
//                case 1:
//                    logIn(scanner);
//                    break;
//                case 2:
//                    signUp(scanner);
//                    break;
//                case 3:
//                    System.out.println("Exiting... Goodbye!");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void logIn(Scanner scanner) {
//        System.out.print("Enter your username: ");
//        String username = scanner.nextLine();
//        System.out.print("Enter your password: ");
//        String password = scanner.nextLine();
//
//        int userIndex = Userlist.search(username);
//
//        if (userIndex == -1 || !Userlist.users.get(userIndex).getPassword().equals(password)) {
//            System.out.println("Invalid username or password. Returning to the main menu...");
//            return;
//        }
//
//        User currentUser = Userlist.users.get(userIndex);
//        boolean isAdmin = currentUser.getType().equalsIgnoreCase("Admin");
//        boolean isClient = currentUser.getType().equalsIgnoreCase("Client");
//
//        if (isAdmin) {
//            // Admin menu
//            while (true) {
//                System.out.println("\n===  Main Menu ===");
//                System.out.println("1. View Profile");
//                System.out.println("2. Logout");
//                System.out.println("============= Admin Page ==================");
//                System.out.println("3. Account Management");
//                System.out.println("4. User Monitor");
//                System.out.println("5. Report");
//                System.out.println("6. Program");
//                System.out.println("7. Content");
//                System.out.println("8. Feedback");
//                System.out.print("Enter your choice: ");
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                switch (choice) {
//                    case 1:
//                        System.out.println("\n=== Your Profile ===");
//                        System.out.println(currentUser);
//                        break;
//
//                    case 2:
//                        System.out.println("Logging out... Returning to main menu.");
//                        return;
//
//                    case 3:
//                        handleAdminMenu(scanner);
//                        break;
//
//                    case 4:
//                        adminUserMonitor(scanner);
//                        break;
//
//                    case 5:
//                        adminReportPage(scanner);
//                        break;
//
//                    case 6:
//                        adminProgramPage(scanner);
//                        break;
//
//                    case 7:
//                        adminContentPage(scanner);
//                        break;
//
//                    case 8:
//                        adminFeedbackPage(scanner);
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
//            }
//        } else if (isClient) {
//            // Client menu
//            Client client = (Client) currentUser;
//            boolean running = true;
//            while (running) {
//                System.out.println("\n=== Client Main Menu ===");
//                System.out.println("1. Account Management");
//                System.out.println("2. Explore Programs and Enroll");
//                System.out.println("3. Track Progress");
//                System.out.println("4. Feedback and Reviews");
//                System.out.println("5. Log Out");
//                System.out.print("Enter your choice: ");
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                switch (choice) {
//                    case 1:
//                        clientAccountManagement(scanner, client);
//                        break;
//
//                    case 2:
//                        programExploration(scanner, client);
//                        break;
//
//                    case 3:
//                        //progressTracking(scanner, client);
//                        break;
//
//                    case 4:
//                        feedbackAndReviews(scanner, client);
//                        break;
//
//                    case 5:
//                        System.out.println("Logging out... Returning to main menu.");
//                        running = false;
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice, please try again.");
//                }
//            }
//        } else {
//            System.out.println("Invalid user type. Returning to main menu...");
//        }
//    }
//
//
//
//
//    private static void adminFeedbackPage(Scanner scanner) {
//        while (true)
//
//        {
//            System.out.println("\n========== Feedback Page ========");
//            System.out.println("1. Show All Feedback");
//            System.out.println("2. Show All Complaint");
//            System.out.println("3. Resolve Complaint");
//            System.out.println("4. Return to Admin Menu");
//            int d = scanner.nextInt();
//            scanner.nextLine();
//       switch (d)
//       {
//           case 1:
//          displayAllFeedbacks();
//             break;
//           case 2:
//               displayAllComplaints();
//                  break;
//           case 3:
//               while (true) {
//                   System.out.println("Enter the complaint ID to handle (or enter 0 to exit): ");
//                   int id = scanner.nextInt();
//                   if (id == 0) {
//                       System.out.println("The id is not valid.");
//                   }
//                    else {
//                       if (resolveComplaint(id)) {
//                           System.out.println("Complaint resolved successfully.");
//                       } else {
//                           System.out.println("Failed to resolve complaint. Please check the ID.");
//                       }
//                   }
//               }
//           case 4:
//               return;
//
//           default:
//               System.out.println("Invalid choice. Please try again.");
//
//       }
//
//
//        }
//
//    }
//    private static void adminContentPage(Scanner scanner) {
//        while (true) {
//            System.out.println("=== Content Status Menu ===");
//            System.out.println("1. Show all pending content");
//            System.out.println("2. Show all approved content");
//            System.out.println("3. Show all rejected content");
//            System.out.println("4. update statues content ");
//            System.out.println("5.Return to Admin Menu ");
//            System.out.print("Enter your choice: ");
//
//            int contentChoice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (contentChoice) {
//                case 1:
//                    showAllContent();
//                    break;
//                case 2:
//                    showApprovedContent();
//                    break;
//                case 3:
//                    showRejectedContent();
//                    break;
//
//                case 4:
//                    System.out.print("Enter content title: ");
//                    String title = scanner.nextLine();
//                    System.out.print("Approve it? (yes/no): ");
//                    String approvalResponse = scanner.nextLine().toLowerCase();
//
//                    if (approvalResponse.equals("yes") || approvalResponse.equals("no")) {
//                        String newStatus = approvalResponse.equals("yes") ? "approve" : "rejected";
//                        boolean updated = updateContentStatus(title, newStatus);
//                        System.out.println(updated ? "Content status updated successfully!" : "Failed to update content status.");
//                    } else {
//                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
//                    }
//                    break;
//                case 5:
//                   return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//
//    }
//    private static void adminProgramPage(Scanner scanner) {
//        while (true) {
//            System.out.println("\n========== Program Page ========");
//            System.out.println("1. Show All Active Programs");
//            System.out.println("2. Show All Completed Programs");
//            System.out.println("3. Return to Admin Menu");
//
//            int d = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (d) {
//                case 1:
//                    LocalDate currentDate = LocalDate.now();
//                    showActivePrograms(currentDate);
//                    break;
//
//                case 2:
//                    LocalDate currentDate1 = LocalDate.now();
//                    showCompletedPrograms(currentDate1);
//                    break;
//
//                case 3:
//                    return;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//    private static void adminUserMonitor(Scanner scanner) {
//        while (true) {
//            System.out.println("\n========== Monitoring User Page ========");
//            System.out.println("1. Show All User Activity");
//            System.out.println("2. Search for user activity");
//            System.out.println("3. Return to Admin Menu");
//
//            int d = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (d) {
//                case 1:
//                    for (String activity : Userlist.ActivityRecords) {
//                        System.out.println(activity);
//                    }
//                    break;
//
//                case 2:
//                    System.out.println("\nTo show user activity, enter the name: ");
//                    String user = scanner.nextLine();
//                    if (ShowUserAction(user)) {
//
//                    } else {
//                        System.out.println("The user not found.");
//                    }
//                    break;
//
//                case 3:
//                    return;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void adminReportPage(Scanner scanner) {
//        while (true) {
//            System.out.println("\n======= Report Page ========");
//            System.out.println("1. Revenue Report");
//            System.out.println("2. Return to Admin Menu");
//            int n = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (n) {
//                case 1:
//                    generateRevenueReport();
//                    break;
//
//                case 2:
//                    return; // Return to the admin menu
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void handleAdminMenu(Scanner scanner) {
//        System.out.println("\n=== Account Management Page ===");
//        while (true) {
//            System.out.println("1. Show All Users");
//            System.out.println("2. Add Client Account");
//            System.out.println("3. Update Client Account");
//            System.out.println("4. Deactivate Client Account");
//            System.out.println("5. Manage Instructor Registrations");
//            System.out.println("6. Return to Main Menu");
//            System.out.print("Choose an option: ");
//            int adminChoice = scanner.nextInt();
//            scanner.nextLine(); // Clear buffer
//
//            switch (adminChoice) {
//                case 1:
//                    for (User user : Userlist.users) {
//                        System.out.println(user);
//                    }
//                    break;
//
//                case 2:
//                    addClientAccount(scanner);
//                    break;
//
//                case 3:
//                    updateClientAccount(scanner);
//                    break;
//
//                case 4:
//                    deactivateClientAccount(scanner);
//                    break;
//
//                case 5:
//                    manageInstructorRegistrations(scanner);
//                    break;
//
//                case 6:
//                    System.out.println("Returning to main menu...");
//                    return;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void addClientAccount(Scanner scanner) {
//        System.out.print("Enter new client's username: ");
//        String newUsername = scanner.nextLine();
//        System.out.print("Enter new client's password: ");
//        String newPassword = scanner.nextLine();
//        System.out.print("Enter new client's email: ");
//        String newEmail = scanner.nextLine();
//        System.out.print("Enter subscription plan: ");
//        String newSubPlan = scanner.nextLine();
//
//        if (Userlist.IsCanBeUser(newUsername, newPassword, newEmail, newSubPlan)) {
//            User newClient = new User(newUsername, newPassword, newEmail, "Client", newSubPlan);
//            Userlist.users.add(newClient);
//            System.out.println("New client created successfully!");
//        } else {
//            System.out.println("Failed to create new client. Please check the details.");
//        }
//    }
//
//    private static void updateClientAccount(Scanner scanner) {
//        System.out.print("Enter the username of the client to update: ");
//        String clientUsername = scanner.nextLine();
//        System.out.print("Enter new email (or leave empty to keep current): ");
//        String newEmail = scanner.nextLine();
//        System.out.print("Enter new password (or leave empty to keep current): ");
//        String newPassword = scanner.nextLine();
//        System.out.print("Enter new subscription plan (or leave empty to keep current): ");
//        String newSubscription = scanner.nextLine();
//
//        boolean updateResult = updateClientDetails(clientUsername,
//                newEmail.isEmpty() ? null : newEmail,
//                newPassword.isEmpty() ? null : newPassword,
//                newSubscription.isEmpty() ? null : newSubscription);
//
//        if (updateResult) {
//            System.out.println("Client details updated successfully!");
//        } else {
//            System.out.println("Failed to update client details.");
//        }
//    }
//
//    private static void deactivateClientAccount(Scanner scanner) {
//        System.out.print("Enter the username of the client to deactivate: ");
//        String deactivateUsername = scanner.nextLine();
//        int deactivateIndex = Userlist.search(deactivateUsername);
//
//        if (deactivateIndex != -1) {
//            Userlist.users.remove(deactivateIndex);
//            System.out.println("Client account deactivated successfully!");
//        } else {
//            System.out.println("Client not found.");
//        }
//    }
//
//    private static void manageInstructorRegistrations(Scanner scanner) {
//        System.out.println("\n=== Instructor Registrations ===");
//        boolean keepRunning = true;
//        while (keepRunning) {
//            System.out.println("1. Show All Instructor Requests");
//            System.out.println("2. Approve Instructor Registration");
//            System.out.println("3. Return to Account Management");
//            System.out.print("Choose an option: ");
//            int instructorChoice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (instructorChoice) {
//                case 1:
//                    showAllInstructorRequest();
//                    break;
//
//                case 2:
//                    System.out.print("Enter the name of the instructor to approve: ");
//                    String instructorName = scanner.nextLine();
//                    if (approveNewInstructor(instructorName)) {
//                        System.out.println("Instructor registration approved successfully!");
//                    } else {
//                        System.out.println("Instructor name not found!");
//                    }
//                    break;
//
//                case 3:
//                    keepRunning = false;
//                    break;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void signUp(Scanner scanner) {
//        System.out.println("\n=== Sign-Up ===");
//
//        System.out.print("Enter a new username: ");
//        String username = scanner.nextLine();
//
//        System.out.print("Enter a password: ");
//        String password = scanner.nextLine();
//
//        System.out.print("Enter your email: ");
//        String email = scanner.nextLine();
//
//        System.out.print("Enter your role (e.g., Client): ");
//        String role = scanner.nextLine();
//
//        System.out.print("Enter your Subscription plan (Basic, Silver, Gold, Premium): ");
//        String subPlan = scanner.nextLine();
//
//        if (!Userlist.IsCanBeUser(username, password, email, subPlan)) {
//            System.out.println("Sign-Up failed. Please try again.");
//            return;
//        }
//
//        User newUser = new User(username, email, password, role, subPlan);
//        Userlist.users.add(newUser);
//        System.out.println("Sign-Up successful! Welcome, " + username + ". You can now log in.");
//    }
//    private static void clientAccountManagement(Scanner scanner, Client client) {
//        boolean running = true;
//
//        while (running) {
//            System.out.println("\n=== Account Management ===");
//            System.out.println("1. Enter Details");
//            System.out.println("2. Update Details");
//            System.out.println("3. Show Profile");
//            System.out.println("4. Return to Main Menu");
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//
//                    if (client.getAge() != 0 || client.getFitnessGoals() != null || client.getDietaryPreferences() != null) {
//                        System.out.println("Details already entered. Use 'Update Details' to modify them.");
//                        break;
//                    }
//                    int age;
//                    do {
//                        System.out.print("Enter age (15-70): ");
//                        age = scanner.nextInt();
//                        scanner.nextLine();
//                        if (age < 15 || age > 70) {
//                            System.out.println("Invalid age. Please enter an age between 15 and 70.");
//                        }
//                    } while (age < 15 || age > 70);
//                    client.setAge(age);
//
//                    System.out.println("Enter fitness goals: ");
//                    String s=scanner.nextLine();
//                    client.setFitnessGoals(s);
//
//                    System.out.println("Enter dietary preferences: ");
//                    String b=scanner.nextLine();
//                    client.setDietaryPreferences(b);
//
//                    System.out.println("Details entered successfully!");
//                    break;
//
//
//                case 2:
//
//                    if (client.getAge() == 0 && client.getFitnessGoals() == null && client.getDietaryPreferences() == null) {
//                        System.out.println("No details found. Please use 'Enter Details' first.");
//                        break;
//                    }
//                    // Update details
//                    System.out.println("Which detail would you like to update?");
//                    System.out.println("1. Update Age");
//                    System.out.println("2. Update Fitness Goals");
//                    System.out.println("3. Update Dietary Preferences");
//                    System.out.print("Enter your choice: ");
//                    int updateChoice = scanner.nextInt();
//                    scanner.nextLine();
//
//                    switch (updateChoice) {
//                        case 1:
//                            int newAge;
//                            do {
//                                System.out.print("Enter new age (15-70): ");
//                                newAge = scanner.nextInt();
//                                scanner.nextLine();
//                                if (newAge < 15 || newAge > 70) {
//                                    System.out.println("Invalid age. Please enter an age between 15 and 70.");
//                                }
//                            } while (newAge < 15 || newAge > 70);
//                            client.setAge(newAge);
//                            System.out.println("Age updated successfully!");
//                            break;
//                        case 2:
//                            System.out.println("enter new  Fitness Goals");
//                            client.setFitnessGoals(scanner.nextLine());
//                            System.out.println("Fitness goals updated successfully!");
//                            break;
//                        case 3:
//                            System.out.println("enter new  Dietary preferences");
//                            client.setDietaryPreferences(scanner.nextLine());
//                            System.out.println("Dietary preferences updated successfully!");
//                            break;
//                        default:
//                            System.out.println("Invalid choice.");
//                    }
//                    break;
//
//
//                case 3:
//
//                    System.out.println("\n=== Profile Details ===");
//                    System.out.println("Name: " + client.getUserName());
//                    System.out.println("Age: " + client.getAge());
//                    System.out.println("Fitness Goals: " + (client.getFitnessGoals() != null ? client.getFitnessGoals() : "Not Set"));
//                    System.out.println("Dietary Preferences: " + (client.getDietaryPreferences() != null ? client.getDietaryPreferences() : "Not Set"));
//                    System.out.println("Email: " + client.getEmail());
//                    System.out.println("Subscription Level: " + client.getSubscriptionPlans());
//                 client.getEnrolledPrograms();
//                    break;
//
//                case 4:
//                    System.out.println("Returning to main menu...");
//                    running = false;
//                    break;
//
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
//
//    private static void programExploration(Scanner scanner, Client client) {
//        boolean running = true;
//
//        while (running) {
//            System.out.println("\n=== Explore Programs ===");
//            System.out.println("1. List All Programs");
//            System.out.println("2. Filter Programs by Difficulty");
//            System.out.println("3. Filter Programs by Focus Area");
//            System.out.println("4. Enroll in a Program");
//            System.out.println("5. View Program Schedule");
//            System.out.println("6. view my Program");
//            System.out.println("7. Return to Main Menu");
//            System.out.print("Enter your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                  showActivePrograms(LocalDate.now());
//                    break;
//                case 2:
//                    System.out.println("Select difficulty level:");
//                    System.out.println("1. Beginner");
//                    System.out.println("2. Intermediate");
//                    System.out.println("3. Advanced");
//                    System.out.print("Enter your choice: ");
//                    int difficultyChoice = scanner.nextInt();
//                    scanner.nextLine();
//
//                    String difficulty = switch (difficultyChoice) {
//                        case 1 -> "Beginner";
//                        case 2 -> "Intermediate";
//                        case 3 -> "Advanced";
//                        default -> {
//                            System.out.println("Invalid choice. Defaulting to Beginner.");
//                            yield "Beginner";
//                        }
//                    };
//                    listFilteredProgramsByDifficulty(difficulty);
//                    break;
//                case 3:
//                    System.out.println("Select focus area:");
//                    System.out.println("1. Weight loss");
//                    System.out.println("2. Muscle building");
//                    System.out.println("3. Flexibility");
//                    System.out.println("4. Cardio Fitness");
//                    System.out.print("Enter your choice: ");
//                    int focusChoice = scanner.nextInt();
//                    scanner.nextLine();
//
//                    String focusArea = switch (focusChoice) {
//                        case 1 -> "Weight loss";
//                        case 2 -> "Muscle building";
//                        case 3 -> "Flexibility";
//                        case 4 -> "Cardio Fitness";
//                        default -> {
//                            System.out.println("Invalid choice. Defaulting to 'Weight loss'.");
//                            yield "Weight loss";
//                        }
//                    };
//                    listFilteredProgramsByFocusArea(focusArea);
//                    break;
//
//                case 4:
//                    System.out.println("\n=== Available Programs ===");
//                    showActivePrograms(LocalDate.now());
//                    System.out.print("Enter the number of the program to enroll: ");
//                    int enrollChoice = scanner.nextInt();
//                    scanner.nextLine();
//                    if (enrollChoice >= 1) {
//                        Program selectedProgram = getProgramById(enrollChoice);
//                        client.enrollInProgram(selectedProgram);
//                    } else {
//                        System.out.println("Invalid choice. Returning to menu.");
//                    }
//                    break;
//
//                case 5:
//                    System.out.println("\n=== Available Programs ===");
//
//                    allPrograms = ProgramService.getAllPrograms();
//
//                    for (int i = 0; i < allPrograms.size(); i++) {
//                        System.out.println((i + 1) + ". " + allPrograms.get(i).getName());
//                    }
//                    System.out.print("Enter the number of the program to view its schedule: ");
//                    int scheduleChoice = scanner.nextInt();
//                    scanner.nextLine();
//                    if (scheduleChoice >= 1 && scheduleChoice <= allPrograms.size()) {
//                        Program selectedProgram = allPrograms.get(scheduleChoice - 1);
//                        System.out.println("\nSchedule for " + selectedProgram.getName() + ":");
//                        System.out.println( getProgramSchedule(selectedProgram.getName()));
//                    } else {
//                        System.out.println("Invalid choice. Returning to menu.");
//                    }
//                    break;
//
//                case 6:
//                   client.displayEnrolledPrograms();
//                    break;
//                case 7:
//                    System.out.println("Returning to main menu...");
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//    private static void listFilteredProgramsByDifficulty(String difficulty) {
//        ProgramService programService = new ProgramService();
//        List<Program> filteredPrograms = programService.filterProgramsByDifficulty(difficulty);
//        if (filteredPrograms.isEmpty()) {
//            System.out.println("No programs found for the specified difficulty level.");
//        } else {
//            System.out.println("\n=== Filtered Programs by Difficulty: " + difficulty + " ===");
//            for (Program program : filteredPrograms) {
//                System.out.println(program);
//            }
//        }
//    }
//
//    private static void listFilteredProgramsByFocusArea(String focusArea) {
//        ProgramService programService = new ProgramService();
//        List<Program> filteredPrograms = programService.filterProgramsByFocusArea(focusArea);
//        if (filteredPrograms.isEmpty()) {
//            System.out.println("No programs found for the specified focus area.");
//        } else {
//            System.out.println("\n=== Filtered Programs by Focus Area: " + focusArea + " ===");
//            for (Program program : filteredPrograms) {
//                System.out.println(program);
//            }
//        }
//    }
//
//
////    private static void progressTracking(Scanner scanner, Client client) {
////        boolean running = true;
////
////        while (running) {
////            System.out.println("\n=== Track Progress ===");
////            System.out.println("1. View Progress");
////            System.out.println("2.  View Milestones");
////            System.out.println("4. Return to Main Menu");
////            System.out.print("Enter your choice: ");
////            int choice = scanner.nextInt();
////            scanner.nextLine();
////
////            switch (choice) {
////                case 1:
////                    client.viewProgress();
////                    break;
////                case 2:
////                    client.viewMilestones();
////                    break;
////                case 3:
////                    System.out.println("Returning to main menu...");
////                    running = false;
////                    break;
////                default:
////                    System.out.println("Invalid choice.");
////            }
////        }
////    }
//
//    private static void feedbackAndReviews(Scanner scanner, Client client) {
//        System.out.println("\n=== Feedback and Reviews ===");
//        System.out.println("1. Submit Feedback");
//        System.out.println("2. View Feedback for a Program");
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//        switch (choice) {
//            case 1:
//                List<Program> enrolledPrograms = client.getEnrolledPrograms();
//                if (enrolledPrograms.isEmpty()) {
//                    System.out.println("You are not enrolled in any programs to submit feedback.");
//                    break;
//                }
//
//                System.out.println("\n=== Your Enrolled Programs ===");
//                for (Program program : enrolledPrograms) {
//                    System.out.println("- " + program.getName() + " (ID: " + program.getId() + ")");
//                }
//
//                System.out.print("Enter the ID of the program to submit feedback: ");
//                int programId = scanner.nextInt();
//                scanner.nextLine();
//                String selectedProgramForSubmit="";
//                for (Program program : enrolledPrograms) {
//                    if (program.getId() == programId) {
//                      selectedProgramForSubmit = program.getName();
//                        break;
//                    }
//                }
//
//                if (selectedProgramForSubmit != null && !selectedProgramForSubmit.isEmpty()) {
//                    ProgramService.getProgramByName(selectedProgramForSubmit);
//                    System.out.print("Enter your rating (1-5): ");
//                    int rating = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Enter your review: ");
//                    String review = scanner.nextLine();
//
//                    System.out.print("Enter your improvement Suggestions: ");
//                    String comment = scanner.nextLine();
//
//                    client.submitFeedback(selectedProgramForSubmit, rating, review,comment);
//                    System.out.println("Feedback submitted successfully!");
//                } else {
//                    System.out.println("Invalid program ID.");
//                }
//                break;
//
//            case 2:
//                System.out.print("Feedback for Completed Program: ");
//                showFeedbackCompletedProgram();
//            default:
//                System.out.println("Invalid choice.");
//        }
//    }
//
//    public static void showFeedbackCompletedProgram() {
//        if (feedbackList.isEmpty()) {
//            System.out.println("No feedback available.");
//            return;
//        }
//
//        Map<String, List<Feedback>> feedbackByProgram = new HashMap<>();
//
//        for (Feedback feedback : feedbackList) {
//            Program program = feedback.getProgram();
//            if (program.isCompleted(LocalDate.now())) {
//                String programName = program.getName();
//                feedbackByProgram
//                        .computeIfAbsent(programName, k -> new ArrayList<>())
//                        .add(feedback);
//            }
//        }
//
//        if (feedbackByProgram.isEmpty()) {
//            System.out.println("No feedback for completed programs.");
//            return;
//        }
//
//        System.out.println("Feedback for Completed Programs:");
//        for (Map.Entry<String, List<Feedback>> entry : feedbackByProgram.entrySet()) {
//            String programName = entry.getKey();
//            List<Feedback> feedbacks = entry.getValue();
//
//            double averageRating = feedbacks.stream()
//                    .mapToInt(Feedback::getRating)
//                    .average()
//                    .orElse(0.0);
//
//            StringBuilder comments = new StringBuilder();
//            for (Feedback feedback : feedbacks) {
//                comments.append(feedback.getImprovementSuggestions()).append("; ");
//            }
//
//            System.out.println("Program: " + programName);
//            System.out.println("Average Rating: " + String.format("%.2f", averageRating));
//            System.out.println("Comments: " + comments.toString());
//            System.out.println("----------------------------");
//        }
//    }
//
//    public static Program getProgramById(int id) {
//        for (Program program : allPrograms) {
//            if (program.getId()==id) {
//                return program;
//            }
//        }
//        return null;
//
//
//
//  }
}
