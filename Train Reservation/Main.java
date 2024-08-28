import java.util.*;
public class Main {
    public static void main(String args[]){
        TrainImpl trainService = new TrainImpl();
        Booking book = new Booking(trainService);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1 - Booking");
            System.out.println("2 - Availability checking");
            System.out.println("3 - Cancellation");
            System.out.println("4 - prepare chart");
            System.out.println("5 - Exit");


            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    book.bookTickets();
                    break;
                case 2:
                    {
                        System.out.println("1 - view your train with train number");
                        System.out.println("2 - view all train details");
                        System.out.println("3 - Exit");

                        System.out.print("Enter your choice : " );
                        int choice2 = sc.nextInt();

                        switch (choice2) {
                            case 1:
                                trainService.viewTrain();
                                break;
                            case 2:
                                trainService.viewAllDetails();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Select the valid option");
                        }
                        break;
                    }
                case 3:
                    book.cancelBooking();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Select a valid option");
            }

        }
    }
}