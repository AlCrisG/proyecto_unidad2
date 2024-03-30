public class Person {
    protected String name, lastName, birthDate, curp;
    protected int id;

    public Person(String name, String lastName, String birthDate, String curp, int id){
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.curp = curp;
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
