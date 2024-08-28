import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private int age;
    private List<Seat> bookedSeats;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bookedSeats = new ArrayList<>();
    }

    public void addSeat(String coachType, int seatNumber) {
        bookedSeats.add(new Seat(coachType, seatNumber));
    }

    public boolean removeSeat(String coachType, int seatNumber) {
        return bookedSeats.removeIf(seat -> seat.getCoachType().equalsIgnoreCase(coachType) && 
                seat.getSeatNumber() == seatNumber);
    }

    public void printTicket() {
        System.out.println("-------- Ticket Details --------");
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Booked Seats:");
        for (Seat seat : bookedSeats) {
            System.out.println(seat);
        }
        System.out.println("--------------------------------");
    }

    // Other getters and setters
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public List<Seat> getBookedSeats(){
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookSeats){
        this.bookedSeats = new ArrayList<>();
    }
}

