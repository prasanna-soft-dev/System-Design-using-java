import java.util.HashSet;
import java.util.Scanner;

public class UserI implements UserService {
    HashSet<User> setUser = new HashSet<>();

    User u1 = new User(1, "prasanna", 21, "AC");

    Scanner sc = new Scanner(System.in);

    public UserI() {
        setUser.add(u1);
    }

    // View all users
    @Override
    public void viewAllUser() {
        for (User u : setUser) {
            System.out.println(u);
        }
    }

    // View user by id
    @Override
    public void viewUser() {
        System.out.println("Enter the id: ");
        int id = sc.nextInt();
        boolean found = false;
        for (User u : setUser) {
            if (u.getId() == id) {
                System.out.println(u);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Enter a valid user id");
        }
    }

    // Delete user by id
    @Override
    public void deleteUser() {
        System.out.println("Enter the user id you want to delete: ");
        int id = sc.nextInt();
        boolean found = false;
        User delUser = null;
        for (User u : setUser) {
            if (u.getId() == id) {
                delUser = u;
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("User does not exist");
        } else {
            setUser.remove(delUser);
            System.out.println("Successfully deleted");
        }
    }

    // Add new user
    @Override
    public void addUser() {
        System.out.println("Enter the user id: ");
        int id = sc.nextInt();

        System.out.println("Enter user name: ");
        String name = sc.next();

        System.out.println("Enter the user age: ");
        int age = sc.nextInt();

        System.out.println("Enter the preferred coach: ");
        String coach = sc.next();

        User newUser = new User(id, name, age, coach);

        if (setUser.add(newUser)) {
            System.out.println(newUser);
            System.out.println("Successfully added");
        } else {
            System.out.println("User with this ID already exists");
        }
    }

    // Update user by id
    @Override
    public void updateUser() {
        System.out.println("Enter the user id you want to update: ");
        int id = sc.nextInt();
        boolean found = false;
        for (User u : setUser) {
            if (u.getId() == id) {
                System.out.println("Enter new name: ");
                String name = sc.next();
                System.out.println("Enter new age: ");
                int age = sc.nextInt();
                System.out.println("Enter new coach: ");
                String coach = sc.next();

                // Update user details
                u.setName(name);
                u.setAge(age);
                u.setCoach(coach);

                System.out.println("User details updated successfully");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("User not found with the given ID");
        }
    }
}
