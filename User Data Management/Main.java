import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UserI userService = new UserI();

        while (true) { 
            System.out.println("\nUser Management System");
            System.out.println("1. View All Users");
            System.out.println("2. View User by ID");
            System.out.println("3. Add New User");
            System.out.println("4. Update User by ID");
            System.out.println("5. Delete User by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();


            switch(choice){
                case 1:
                    userService.viewAllUser();
                    break;
                case 2:
                    userService.viewUser();
                    break;
                case 3:
                    userService.addUser();
                    break;
                case 4:
                    userService.updateUser();
                    break;
                case 5:
                    userService.deleteUser();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("invalid option");
            }
        }
    }
    
}
