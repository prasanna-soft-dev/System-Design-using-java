import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrainImpl implements TrainService {
    private HashMap<Integer, Train> setTrain = new HashMap<>();
    
    // Initializing a sample train
    Train t1 = new Train(1, "Trichy", "Chennai", 60, 60, 60, 10);

    Scanner sc = new Scanner(System.in);

    // Constructor to populate the map with initial data
    public TrainImpl() {
        setTrain.put(t1.getId(), t1);
    }

    // Getter method to access the train map
    public HashMap<Integer, Train> getTrain() {
        return setTrain;
    }

    // Method to view all train details
    @Override
    public void viewAllDetails() {
        for (Map.Entry<Integer, Train> entry : setTrain.entrySet()) {
            Train train = entry.getValue();
            System.out.println("Train ID: " + train.getId() +
                               "\nSource: " + train.getSource() +
                               "\nDestination: " + train.getDestination() +
                               "\nAvailable seats - AC: " + train.getAc() +
                               ", Non-AC: " + train.getNonAc() +
                               ", Seater: " + train.getSeater() +
                               ", Waiting List: " + train.getWaitingList() + "\n");
        }
    }

    // Method to view available seats in all trains
    @Override
    public void viewSeat() {
        for (Map.Entry<Integer, Train> entry : setTrain.entrySet()) {
            Train train = entry.getValue();
            System.out.println("Source: " + train.getSource() +
                               "\nDestination: " + train.getDestination() +
                               "\nAvailable seats - AC: " + train.getAc() +
                               ", Non-AC: " + train.getNonAc() +
                               ", Seater: " + train.getSeater() +
                               ", Waiting List: " + train.getWaitingList() + "\n");
        }
    }

    // Method to view a specific train's details by train number
    @Override
    public void viewTrain() {
        System.out.println("Enter the number of the train you want to find:");
        int trainNum = sc.nextInt();

        // Loop through the trains to find the one with the matching train number
        for (Map.Entry<Integer, Train> entry : setTrain.entrySet()) {
            if (entry.getKey() == trainNum) {
                Train train = entry.getValue();
                System.out.println("Source: " + train.getSource() +
                                   "\nDestination: " + train.getDestination() +
                                   "\nAvailable seats - AC: " + train.getAc() +
                                   ", Non-AC: " + train.getNonAc() +
                                   ", Seater: " + train.getSeater() +
                                   ", Waiting List: " + train.getWaitingList() + "\n");
                return; // Exit after finding the train
            }
        }
        // If the train number is not found
        System.out.println("Train number " + trainNum + " not found.\n");
    }
}
