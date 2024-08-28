import java.util.*;

public class Booking implements BookingService {
    private TrainImpl trainService;
    private Scanner sc = new Scanner(System.in);
    private List<User> bookedUsers = new ArrayList<>();

    public Booking(TrainImpl trainService) {
        this.trainService = trainService;
    }

    @Override
    public void bookTickets() {
        System.out.print("Enter the train number: ");
        int trainNum = sc.nextInt();
        System.out.print("Enter the coach type (AC/Non-AC/Seater): ");
        String coach = sc.next();
        System.out.print("Enter the number of seats required: ");
        int seatsReq = sc.nextInt();

        HashMap<Integer, Train> trains = trainService.getTrain();
        if (trains.containsKey(trainNum)) {
            Train train = trains.get(trainNum);
            boolean isBooked = false;

            if ((coach.equalsIgnoreCase("ac") && train.getAc() >= seatsReq) ||
                (coach.equalsIgnoreCase("non-ac") && train.getNonAc() >= seatsReq) ||
                (coach.equalsIgnoreCase("seater") && train.getSeater() >= seatsReq)) {

                System.out.print("Enter your name: ");
                String userName = sc.next();
                System.out.print("Enter your age: ");
                int userAge = sc.nextInt();

                Random rand = new Random();
                int userId = rand.nextInt(1000);

                User user = new User(userId, userName, userAge);

                for (int i = 0; i < seatsReq; i++) {
                    int seatNumber = rand.nextInt(60) + 1; // Random seat number generation
                    user.addSeat(coach, seatNumber);
                }

                if (coach.equalsIgnoreCase("ac")) {
                    train.setAc(train.getAc() - seatsReq);
                } else if (coach.equalsIgnoreCase("non-ac")) {
                    train.setNonAc(train.getNonAc() - seatsReq);
                } else if (coach.equalsIgnoreCase("seater")) {
                    train.setSeater(train.getSeater() - seatsReq);
                }

                bookedUsers.add(user);
                user.printTicket();
            } else {
                System.out.println("Insufficient seats available in the selected coach.");
            }
        } else {
            System.out.println("Train not found.");
        }
    }
    public void cancelBooking() {
        System.out.print("Enter your user ID to cancel booking: ");
        int userId = sc.nextInt();
        Optional<User> userOpt = bookedUsers.stream().filter(u -> u.getId() == userId).findFirst();

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            List<Seat> seats = new ArrayList<>(user.getBookedSeats());

            // Retrieve the train details
            System.out.print("Enter the train number for cancellation: ");
            int trainNum = sc.nextInt();
            System.out.print("Enter the coach type (AC/Non-AC/Seater): ");
            String coach = sc.next();

            HashMap<Integer, Train> trains = trainService.getTrain();
            if (trains.containsKey(trainNum)) {
                Train train = trains.get(trainNum);

                for (Seat seat : seats) {
                    if (seat.getCoachType().equalsIgnoreCase(coach)) {
                        if (coach.equalsIgnoreCase("ac")) {
                            train.setAc(train.getAc() + 1);
                        } else if (coach.equalsIgnoreCase("non-ac")) {
                            train.setNonAc(train.getNonAc() + 1);
                        } else if (coach.equalsIgnoreCase("seater")) {
                            train.setSeater(train.getSeater() + 1);
                        }

                        // Remove the seat from the user
                        user.removeSeat(coach, seat.getSeatNumber());
                    }
                }

                // Remove user from bookedUsers list if no seats left
                if (user.getBookedSeats().isEmpty()) {
                    bookedUsers.remove(user);
                }

                System.out.println("Booking canceled successfully.");
            } else {
                System.out.println("Train not found.");
            }
        } else {
            System.out.println("User not found.");
        }
    }
}

