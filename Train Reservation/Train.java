public class Train {
    private int id;
    private String source;
    private String destination;
    private int ac;
    private int nonAc;
    private int seater;
    private int waitingList;

    // Constructor
    public Train(int id, String source, String destination, int ac, int nonAc, int seater, int waitingList) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.ac = ac;
        this.nonAc = nonAc;
        this.seater = seater;
        this.waitingList = waitingList;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getAc() {
        return ac;
    }

    public int getNonAc() {
        return nonAc;
    }

    public int getSeater() {
        return seater;
    }

    public int getWaitingList() {
        return waitingList;
    }

    // Setters with basic validation
    public void setId(int id) {
        this.id = id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAc(int ac) {
        if (ac >= 0) {
            this.ac = ac;
        } else {
            System.out.println("Invalid value for AC seats. It cannot be negative.");
        }
    }

    public void setNonAc(int nonAc) {
        if (nonAc >= 0) {
            this.nonAc = nonAc;
        } else {
            System.out.println("Invalid value for Non-AC seats. It cannot be negative.");
        }
    }

    public void setSeater(int seater) {
        if (seater >= 0) {
            this.seater = seater;
        } else {
            System.out.println("Invalid value for Seater seats. It cannot be negative.");
        }
    }

    public void setWaitingList(int waitingList) {
        if (waitingList >= 0) {
            this.waitingList = waitingList;
        } else {
            System.out.println("Invalid value for Waiting List. It cannot be negative.");
        }
    }

    @Override
    public String toString() {
        return "Train[" + id + ", Source - " + source + ", Destination - " + destination + 
                "\nSeat Availability: AC - " + ac + "\tNon-AC - " + nonAc + 
                "\tSeater - " + seater + "\tWaiting List - " + waitingList + "]";
    }
}
