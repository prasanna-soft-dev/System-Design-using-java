import java.util.*;

public class TrainImpl implements TrainService{
    HashMap<Integer, Train> setTrain = new HashMap<>();

    Train t1 = new Train(1, "Trichy", "Chennai");
    Train t2 = new Train(2, "Chennai", "Trichy");

    Train t3 = new Train(3, "Trichy", "Coiambatore");

    Train t4 = new Train(4, "Trichy", "Madurai");


    Scanner sc = new Scanner(System.in);

    public TrainImpl(){
        setTrain.put(t1.getId(), t1);
        setTrain.put(t2.getId(), t2);
        setTrain.put(t3.getId(), t3);
        setTrain.put(t4.getId(), t4);
    }

    @Override
    public void viewAllTrain(){
        for(Map.Entry<Integer, Train> entry : setTrain.entrySet()){
            System.out.println(entry);
        }
    }

    @Override
    public void viewTrain(){
        System.out.println("Enter the train number : ");
        int num = sc.nextInt();
        boolean found = false;

        for(Map.Entry<Integer, Train> entry : setTrain.entrySet()){
            if(entry.getKey() == num){
                System.out.println(entry);
                found = true;
            }
        }
        if(!found){
            System.out.println("Entry the valid train number");
        }
    }
}