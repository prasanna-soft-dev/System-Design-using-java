//this will be the interface that will host all the methods needed for CRUD(create, read, update, delete)

public interface UserService{
    void viewAllUser();
    void viewUser();
    void deleteUser();
    void addUser();
    void updateUser();
}