public class Visitor{
    private int numberOfVisits;
    private String registerDate,name,lastName,birthDate,curp;
    private int id;
    


    public Visitor(String name, String lastName, String birthDate, String curp, String registerDate, int id){
        
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.curp = curp;
        this.id = id;
        this.numberOfVisits = 0;
        this.registerDate = registerDate;
    }

    public int getNumberOfVisits() {
        return numberOfVisits;
    }



    public void setNumberOfVisits(int numberOfVisits) {
        this.numberOfVisits = numberOfVisits;
    }



    public String getRegisterDate() {
        return registerDate;
    }



    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getBirthDate() {
        return birthDate;
    }



    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }



    public String getCurp() {
        return curp;
    }



    public void setCurp(String curp) {
        this.curp = curp;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    
}
