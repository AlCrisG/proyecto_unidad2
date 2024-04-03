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
        System.out.println(id);//////////////SOLO ES PARA PROBAR, HAY Q BORRARLO DESPUÉS XD
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

    public void setDiseases(int option){
        boolean diseaseFound = false;
        switch(option){
            case 1:
                if(diseases.isEmpty()){
                    System.out.println("Este animal no presenta enfermedades.");
                }
                else{
                    System.out.println("Ha elegido cambiar una enfermedad.");
                    System.out.println("Ingrese el nombre de la enfermedad a cambiar: ");
                    String diseaseToChange = readString.nextLine();
                    
                    for(String disease : diseases){
                        if(disease.equals(diseaseToChange)){
                            diseaseFound = true;
                            System.out.println("Nombre de la enfermedad actualizada: ");
                            String newDisease = readString.nextLine();
                            disease = newDisease;
                            System.out.println("Enfermedad cambiada éxitosamente.");
                        }
                    }

                    if(!diseaseFound){
                        System.out.println("No se ha podido encontrar dicha enfermedad.");
                    }
                }
                break;
            
            case 2:
                if(diseases.isEmpty()){
                    System.out.println("Este animal no presenta enfermedades.");
                }
                else{
                    System.out.println("Ha elegido eliminar enfermedad.");
                    System.out.println("Ingrese el nombre de la enfermedad que será eliminada: ");
                    String diseaseToRemove = readString.nextLine();

                    for(String disease : diseases){
                        if(disease.equals(diseaseToRemove)){
                            diseaseFound = true;
                            diseases.remove(disease);
                            System.out.println("Enfermedad eliminada con éxito.");
                        }
                    }

                    if(!diseaseFound){
                        System.out.println("No se ha podido encontrar dicha enfermedad.");
                    }
                }
                break;

            case 3:
                System.out.println("Ha elegido añadir una nueva enfermedad.");
                System.out.println("Ingrese el nombre de la nueva enfermedad: ");
                String diseaseToAdd = readString.nextLine();

                diseases.add(diseaseToAdd);
                System.out.println("Enfermedad añadida con éxito.");
                break;

            default:
                System.out.println("Ingrese una opción válida.");
                break;
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
