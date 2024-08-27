public class User{
    private int id;
    private String name;
    private int age;
    private String coach;

    // Constructor
    public User(int id, String name, int age, String coach) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coach = coach;
    }

    // Getter for id
    public int getId(){
        return id;
    }

    // Setter for id
    public void setId(int id){
        this.id = id;
    }

    // Getter for name
    public String getName(){
        return name;
    }

    // Setter for name
    public void setName(String name){
        this.name = name;
    }

    // Getter for age
    public int getAge(){
        return age;
    }

    // Setter for age
    public void setAge(int age){
        this.age = age;
    }

    // Getter for coach
    public String getCoach(){
        return coach;
    }

    // Setter for coach
    public void setCoach(String coach) {
        this.coach = coach;
    }

    // Overriding toString method for better output
    @Override
    public String toString() {
        return "User [ID=" + id + ", Name=" + name + ", Age=" + age + ", Coach=" + coach + "]";
    }
}
