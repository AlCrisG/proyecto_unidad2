public class Maintenance {
    private Employee employeeInCharge;
    private Animal animal;
    private String processName, date, observations;

    public Maintenance(Employee employeeInCharge, Animal animal, String processName, String date, String observations){
        this.employeeInCharge = employeeInCharge;
        this.animal = animal;
        this.processName = processName;
        this.date = date;
        this.observations = observations;
    }
}
