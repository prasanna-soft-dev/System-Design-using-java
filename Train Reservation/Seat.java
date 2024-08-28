public class Seat {
    private String coachType;
    private int seatNumber;

    public Seat(String coachType, int seatNumber) {
        this.coachType = coachType;
        this.seatNumber = seatNumber;
    }

    public String getCoachType() {
        return coachType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setCoachType(String coachType){
        this.coachType = coachType;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "coachType='" + coachType + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
