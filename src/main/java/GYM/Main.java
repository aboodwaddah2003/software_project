package GYM;

import io.cucumber.java.bs.A;

import java.time.LocalDate;
import java.util.Scanner;
import static GYM.Admin.*;
import static GYM.ContentMangerService.*;
import static GYM.FeedbackService.*;
import static GYM.FeedbackService.resolveComplaint;
import static GYM.ManageAccountHelper.showAllInstructorRequest;
import static GYM.Userlist.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Userlist.fillData();
        ManageAccountHelper.fillData2();
        ManageAccountHelper.fillRecordActivity();
        Userlist.fillData3();
        ProgramService programService=new ProgramService();
        ProgramService.fillDataProgram();
        Userlist.fillDataClientEnrollInProgram();
        ContentMangerServiceFill();
        FeedbackService.fillDataFeedback();
        FeedbackService.fillDataComplements();

        while (true) {
            System.out.println("=== Welcome to the System ===");
            System.out.println("1. Log In");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logIn(scanner);
                    break;
                case 2:
                    signUp(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void logIn(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int userIndex = Userlist.search(username);

        if (userIndex == -1 || !Userlist.users.get(userIndex).getPassword().equals(password)) {
            System.out.println("Invalid username or password. Returning to the main menu...");
            return;
        }

        User currentUser = Userlist.users.get(userIndex);
        boolean isAdmin = currentUser.getType().equalsIgnoreCase("Admin");

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View Profile");
            System.out.println("2. View Activity Records");
            System.out.println("3. Logout");

            if (isAdmin) {
                System.out.println("\n--- Admin Options ---");
                System.out.println("4. View All Users");
                System.out.println("5. Create a New Client");
                System.out.println("6. Update Client Details");
                System.out.println("7. Approve New Instructor Registrations");
                System.out.println("8. Deactivate a Client Account");
                System.out.println("9. Monitor User Activity");
                System.out.println("10. View Revenue Report");
                System.out.println("11. View Active Programs");
                System.out.println("12. View Completed Programs");
                System.out.println("13. View Content");
                System.out.println("14.show all feedback");
                System.out.println("15. show all Complaints");
            }

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n=== Your Profile ===");
                    System.out.println(currentUser);
                    break;

                case 2:
                    System.out.println("\n=== Activity Records ===");
                    for (String record : Userlist.ActivityRecords) {
                        System.out.println(record);
                    }
                    break;

                case 3:
                    System.out.println("Logging out... Returning to main menu.");
                    return;

                case 4:
                    if (isAdmin) {
                        System.out.println("\n=== All Users ===");
                        for (User user : Userlist.users) {
                            System.out.println(user);
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 5:
                    if (isAdmin) {
                        System.out.print("Enter new client's username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter new client's password: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Enter new client's email: ");
                        String newEmail = scanner.nextLine();
                        System.out.print("Enter subscription plan: ");
                        String newSubPlan = scanner.nextLine();

                        if (Userlist.IsCanBeUser(newUsername, newPassword, newEmail, newSubPlan)) {
                            User newClient = new User(newUsername, newPassword, newEmail, "Client", newSubPlan);
                            Userlist.users.add(newClient);
                            System.out.println("New client created successfully!");
                        } else {
                            System.out.println("Failed to create new client. Please check the details.");
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 6:
                    if (isAdmin) {
                        System.out.print("Enter the username of the client to update: ");
                        String clientUsername = scanner.nextLine();


                        System.out.print("Enter new email (or leave empty to keep current): ");
                        String newEmail = scanner.nextLine();

                        System.out.print("Enter new password (or leave empty to keep current): ");
                        String newPassword = scanner.nextLine();

                        System.out.print("Enter new subscription plan (or leave empty to keep current): ");
                        String newSubscription = scanner.nextLine();


                        boolean updateResult = updateClientDetails(clientUsername, newEmail.isEmpty() ? null : newEmail,
                                newPassword.isEmpty() ? null : newPassword, newSubscription.isEmpty() ? null : newSubscription);

                        if (updateResult) {
                            System.out.println("Client details updated successfully!");
                        } else {
                            System.out.println("Failed to update client details.");
                        }
                    } else {
                        System.out.println("You do not have permission to update client details.");
                    }
                    break;

                case 7:
                    if (isAdmin) {
                        boolean keepRunning = true;
                        while (keepRunning) {
                            System.out.println("\n=== Admin Menu ===");
                            System.out.println("1. Show all Instructor Requests");
                            System.out.println("2. Approve Instructor Registration");
                            System.out.println("3. Exit");

                            System.out.print("Choose an option: ");
                            int c = scanner.nextInt();
                            scanner.nextLine();

                            switch (c) {
                                case 1:
                                    showAllInstructorRequest();
                                    break;

                                case 2:
                                    System.out.println("Enter the name of the Instructor to approve: ");
                                    String instructorName = scanner.nextLine();
                                    if (approveNewInstructor(instructorName)) {
                                        System.out.println("Instructor registration approved successfully!");
                                    } else {
                                        System.out.println("Instructor name not found!");
                                    }
                                    break;

                                case 3:
                                    keepRunning = false;
                                    break;

                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("You do not have permission to approve instructor registrations.");
                    }
                    break;

                case 8:
                    if (isAdmin) {
                        System.out.print("Enter the username of the client to deactivate: ");
                        String deactivateUsername = scanner.nextLine();
                        int deactivateIndex = Userlist.search(deactivateUsername);

                        if (deactivateIndex != -1) {
                            Userlist.users.remove(deactivateIndex);
                            System.out.println("Client account deactivated successfully!");
                        } else {
                            System.out.println("Client not found.");
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 9:
                    if (isAdmin) {
                        System.out.println("\n=== Monitoring User Activity ===");
                        for (String activity : Userlist.ActivityRecords) {
                            System.out.println(activity);
                        }
                            System.out.println("\n  to show user activity enter the name \n");
                            String user = scanner.nextLine();
                            if(ShowUserAction(user));
                            else System.out.println("the user not found");

                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 10:
                    if (isAdmin) {
                        System.out.println("\n=== Revenue Report ===");
                        generateRevenueReport();
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
//
                case 11:
                    if (isAdmin) {
                        System.out.println("\n=== Active Programs ===");
                        LocalDate currentDate = LocalDate.now();
                        showActivePrograms(currentDate);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 12:
                    if (isAdmin) {
                        System.out.println("\n=== Completed Programs ===");
                        LocalDate currentDate = LocalDate.now();
                        showCompletedPrograms(currentDate);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                case 13:
                    if (isAdmin) {
                      boolean  stayInMenu=true;
                        while (stayInMenu) {
                            System.out.println("=== Content Status Menu ===");
                            System.out.println("1. Show all pending content");
                            System.out.println("2. Show all approved content");
                            System.out.println("3. Show all rejected content");
                            System.out.println("4. update statues content ");
                            System.out.print("Enter your choice: ");

                            int contentChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (contentChoice) {
                                case 1:
                                    showAllContent();
                                    break;
                                case 2:
                                    showApprovedContent();
                                    break;
                                case 3:
                                    showRejectedContent();
                                    break;

                                case 4:
                                    System.out.print("Enter content title: ");
                                    String title = scanner.nextLine();
                                    System.out.print("Approve it? (yes/no): ");
                                    String approvalResponse = scanner.nextLine().toLowerCase();

                                    if (approvalResponse.equals("yes") || approvalResponse.equals("no")) {
                                        String newStatus = approvalResponse.equals("yes") ? "approve" : "rejected";
                                        boolean updated = updateContentStatus(title, newStatus);
                                        System.out.println(updated ? "Content status updated successfully!" : "Failed to update content status.");
                                    } else {
                                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                    }
                                    break;
                                case 5:
                                    System.out.println("Returning to the main menu...");
                                    stayInMenu = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 14:
                    if (isAdmin) {
                        System.out.println("====================FeedBack page=====================\n");
                          displayAllFeedbacks();
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;

                case 15:
                    if (isAdmin) {
                        boolean comp = true;
                        System.out.println("=================== Complaint Page =====================");
                        displayAllComplaints();

                        while (comp) {
                            System.out.println("Enter the complaint ID to handle (or enter 0 to exit, -1 to completely exit the program): ");
                            int id = scanner.nextInt();

                            if (id == 0) {
                                System.out.println("The id is not valid.");
                            } else if (id == -1) {
                                System.out.println("Exiting the program...");
                                break;
                            } else {
                                if (resolveComplaint(id)) {
                                    System.out.println("Complaint resolved successfully.");
                                } else {
                                    System.out.println("Failed to resolve complaint. Please check the ID.");
                                }
                            }
                        }
                    }

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void signUp(Scanner scanner) {
        System.out.println("\n=== Sign-Up ===");

        System.out.print("Enter a new username: ");
        String username = scanner.nextLine();

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your role (e.g., Client): ");
        String role = scanner.nextLine();

        System.out.print("Enter your Subscription plan (Basic, Silver, Gold, Premium): ");
        String subPlan = scanner.nextLine();


        if (!Userlist.IsCanBeUser(username, password, email,subPlan)) {
            System.out.println("Sign-Up failed. Please try again.");
            return;
        }


        User newUser = new User(username, email,password, role, subPlan);
        Userlist.users.add(newUser);
        System.out.println("Sign-Up successful! Welcome, " + username + ". You can now log in.");
    }









}

