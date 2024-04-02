import java.util.ArrayList;

public class Animal {
    private String animalType, birthDate, arriveDate, feedFrequency, feedType;
    private int weight, id;
    private ArrayList<String> diseases = new ArrayList<>();
    private boolean hasVaccines;

    public Animal(String animalType, String birthDate, String arriveDate, int weight, ArrayList<String> diseases, String feedFrequency, String feedType, boolean hasVaccines, int id){
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

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void getDiseases(){
        if(diseases.isEmpty()){
            System.out.println("Este animal no presenta enfermedades");
        }
        else{
            System.out.println("+-----ENFERMEDADES----+");
            int i = 1;
            for(String disease : diseases){
                System.out.printf("Enfermedad %s: %s%n", i, disease);
            }
            System.out.println("+---------------------+");
        }
    }

    
}
