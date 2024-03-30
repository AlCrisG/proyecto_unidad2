public class Visitor extends Person{
    private int numberOfVisits;
    private String registerDate;

    public Visitor(String name, String lastName, String birthDate, String curp, String registerDate, int id){
        super(name, lastName, birthDate, curp, id);
        this.numberOfVisits = 0;
        this.registerDate = registerDate;
    }
}
