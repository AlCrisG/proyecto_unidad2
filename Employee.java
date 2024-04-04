public class Employee{
    private String entryDate, rfc, workingHours, role;
    private double salary;
    private String registerDate,name,lastName,birthDate,curp;
    private int id;
    private boolean isInAVisit = false;
    private boolean isInAMaintenanceProcess = false;

    public Employee(String name, String lastName, String birthDate, String entryDate, String rfc, String curp, double salary, String workingHours, String role, int id){
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.curp = curp;
        this.id = id;
        this.entryDate = entryDate;
        this.rfc = rfc;
        this.salary = salary;
        this.workingHours = workingHours;
        this.role = role;
        System.out.printf("Empleado registrado con éxito. ID: %s%n", id);
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        if(getIsInAMaintenanceProcess() && hasMaintenanceRole()){
            System.out.println("No se puede cambiar el rol de empleados que estén en algún proceso de mantenimiento.");
        }
        else if(getIsInAVisit() && isGuide()){
            System.out.println("No se puede cambiar el rol de guías que estén en alguna visita.");
        }
        else{
            this.role = role;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public boolean isGuide(){
        if(role.toLowerCase().equals("guia")){
            return true;
        }
        else{
            return false;
        }
    }

    public void setIsInAVisit(boolean isInAVisit){
        this.isInAVisit = isInAVisit;
    }

    public boolean getIsInAVisit(){
        return isInAVisit;
    }

    public boolean hasMaintenanceRole(){
        if(role.toLowerCase().equals("mantenimiento")){
            return true;
        }
        else{
            return false;
        }
    }

    public void setIsInAMaintenanceProcess(boolean isInAMaintenanceProcess){
        this.isInAMaintenanceProcess = isInAMaintenanceProcess;
    }

    public boolean getIsInAMaintenanceProcess(){
        return isInAMaintenanceProcess;
    }
}
