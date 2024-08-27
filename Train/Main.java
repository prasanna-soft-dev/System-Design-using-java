import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        TrainImpl trainService = new TrainImpl();

        while(true){
            System.out.println("1 - view all train");
            System.out.println("2 - view trian by train number");
            System.out.println("3 - exit");

            System.out.println("enter your choice");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    trainService.viewAllTrain();
                    break;
                case 2:
                    trainService.viewTrain();
                    break;
                case 3:
                    System.out.println("exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}
