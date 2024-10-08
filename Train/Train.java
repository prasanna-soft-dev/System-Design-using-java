public class Train {
    private int id;
    private String source;
    private String destination;

    public Train(int id,String source, String destination){
        this.id = id;
        this.source = source;
        this.destination = destination;
    }

    public int getId(){
        return id;
    }

    public String getSource(){
        return source;
    }

    public String getDestination(){
        return destination;
    }


    public void setId(int id){
        this.id = id;
    }

    public void setSource(String source){
        this.source = source;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    @Override
    public String toString(){
        return "Train["+ id + ",source- "+ source + ",destination- "+ destination + "]";
    }
}
