import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    private Scanner readString = new Scanner(System.in);
    private String animalType, birthDate, arriveDate, feedFrequency, feedType;
    private int id;
    private double weight;
    private ArrayList<String> diseases = new ArrayList<>();
    private boolean hasVaccines;
    private boolean isInAMaintenanceProcess = false;

    public Animal(String animalType, String birthDate, String arriveDate, double weight, ArrayList<String> diseases, String feedFrequency, String feedType, boolean hasVaccines, int id){
        this.animalType = animalType;
        this.birthDate = birthDate;
        this.arriveDate = arriveDate;
        this.weight = weight;
        this.diseases = diseases;
        this.feedFrequency = feedFrequency;
        this.feedType = feedType;
        this.hasVaccines = hasVaccines;
        this.id = id;
        System.out.printf("Animal registrado con éxito. ID: %s%n", id);
    }

    public int getId(){
        return id;
    }

    public String getAnimalType(){
        return animalType;
    }

    public void setAnimalType(String animalType){
        this.animalType = animalType;
    }

    public String getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public String getArriveDate(){
        return arriveDate;
    }

    public void setArriveDate(String arriveDate){
        this.arriveDate = arriveDate;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void getDiseases(){
        if(diseases.isEmpty()){
            System.out.println("Este animal no presenta enfermedades.");
        }
        else{
            System.out.println("+-----ENFERMEDADES----+");
            int i = 1;
            for(String disease : diseases){
                System.out.printf("Enfermedad %s: %s%n", i, disease);
                i++;
            }
            System.out.println("+---------------------+");
        }
    }

    public void addDisease(ArrayList<String> diseases){
        this.diseases = diseases;
    }

    public ArrayList<String> getArrayDiseases(){
        return diseases;
    }


    public void eliminateDiseases(String animalDiseaseEliminate){
        boolean diseaseFound = false;
                    

        for (String disease : diseases) {
            if (disease.equalsIgnoreCase(animalDiseaseEliminate)) {
                diseaseFound = true;
                diseases.remove(animalDiseaseEliminate);
                System.out.println("Enfermedad eliminada éxitosamente.");
                break;
            }
        }

        if (!diseaseFound) {
            System.out.println("No se ha podido encontrar dicha enfermedad.");
        }
    }
    public void setDiseases(String animalDiseaseModif){
        boolean diseaseFound = false;
                    

        for (String disease : diseases) {
            if (disease.equalsIgnoreCase(animalDiseaseModif)) {
                diseaseFound = true;
                System.out.println("Nombre de la enfermedad actualizada: ");
                String newDisease = readString.nextLine();
                int index = diseases.indexOf(disease); 
                diseases.set(index, newDisease); 
                System.out.println("Enfermedad cambiada éxitosamente.");
            }
        }

        if (!diseaseFound) {
            System.out.println("No se ha podido encontrar dicha enfermedad.");
        }
    }

    public String getFeedFrequency(){
        return feedFrequency;
    }

    public void setFeedFrequency(String feedFrequency){
        this.feedFrequency = feedFrequency;
    }

    public String getFeedType(){
        return feedType;
    }
    
    public void setFeedType(String feedType){
        this.feedType = feedType;
    }

    public String getHasVaccines(){
        if(hasVaccines){
            return "Si";
        }
        else{
            return "No";
        }
    }

    public void setHasVaccines(boolean hasVaccines){
        this.hasVaccines = hasVaccines;
    }

    public void setIsInAMaintenanceProcess(boolean isInAMaintenanceProcess){
        this.isInAMaintenanceProcess = isInAMaintenanceProcess;
    }

    public boolean getIsInAMaintenanceProcess(){
        return isInAMaintenanceProcess;
    }
}
