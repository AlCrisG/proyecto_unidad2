public class Employee extends Person{
    private String entryDate, rfc, workingHours, role;
    private double salary;

    public Employee(String name, String lastName, String birthDate, String entryDate, String rfc, String curp, double salary, String workingHours, String role, int id){
        super(name, lastName, birthDate, curp, id);
        this.entryDate = entryDate;
        this.rfc = rfc;
        this.salary = salary;
        this.workingHours = workingHours;
        this.role = role;
    }
}
