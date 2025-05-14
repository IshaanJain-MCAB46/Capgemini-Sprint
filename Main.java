package ContactManagementSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactManager manager = new ContactManager();
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            try {
                System.out.println("\nContact Management System");
                System.out.println("1. Add Contact");
                System.out.println("2. Search by Name");
                System.out.println("3. Search by Number");
                System.out.println("4. Delete Contact by ID");
                System.out.println("5. Update Contact by ID");
                System.out.println("6. Display All Contacts");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        String name;
                        while (true) {
                            System.out.print("Enter name: ");
                            name = sc.nextLine().trim();
                            if (!name.isEmpty() && name.matches(".*[a-zA-Z]+.*") && !name.matches("\\d+"))
                                break;
                            System.out.println("Invalid name. It should contain alphabets and not be numeric-only.");
                        }

                        String num;
                        while (true) {
                            System.out.print("Enter phone number (10 digits): ");
                            num = sc.nextLine().trim();
                            if (num.matches("\\d{10}")) break;
                            System.out.println("Invalid phone number. Must be exactly 10 digits.");
                        }

                        String email;
                        while (true) {
                            System.out.print("Enter email: ");
                            email = sc.nextLine().trim();
                            if (email.matches("^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
                                break;
                            System.out.println("Invalid email. It must start with a letter and contain '@' and '.'");
                        }

                        manager.AddContact(name, num, email);
                        break;

                    case 2:
                        System.out.print("Enter name to search: ");
                        manager.SearchByName(sc.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter phone number to search: ");
                        manager.SearchByNumber(sc.nextLine());
                        break;

                    case 4:
                        try {
                            System.out.print("Enter contact ID to delete: ");
                            int delId = Integer.parseInt(sc.nextLine());
                            manager.deleteById(delId);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID format.");
                        }
                        break;

                    case 5:
                        try {
                            System.out.print("Enter contact ID to update: ");
                            int updId = Integer.parseInt(sc.nextLine());

                            String newName;
                            while (true) {
                                System.out.print("Enter new name: ");
                                newName = sc.nextLine().trim();
                                if (!newName.isEmpty() && newName.matches(".*[a-zA-Z]+.*") && !newName.matches("\\d+"))
                                    break;
                                System.out.println("Invalid name. It should contain alphabets and not be numeric-only.");
                            }

                            String newNum;
                            while (true) {
                                System.out.print("Enter new phone number (10 digits): ");
                                newNum = sc.nextLine().trim();
                                if (newNum.matches("\\d{10}")) break;
                                System.out.println("Invalid phone number. Must be exactly 10 digits.");
                            }

                            String newEmail;
                            while (true) {
                                System.out.print("Enter new email: ");
                                newEmail = sc.nextLine().trim();
                                if (newEmail.matches("^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
                                    break;
                                System.out.println("Invalid email. It must start with a letter and contain '@' and '.'");
                            }

                            manager.updateContact(updId, newName, newNum, newEmail);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid ID format.");
                        }
                        break;

                    case 6:
                        manager.DisplayAllContacts();
                        break;

                    case 0:
                        System.out.println("Exiting program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 6.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input mismatch. Please enter valid data.");
                sc.nextLine(); // clear buffer
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}