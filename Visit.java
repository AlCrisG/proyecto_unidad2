import java.util.ArrayList;

public class Visit {
    private Employee guideInCharge;
    private ArrayList<Visitor> visitors = new ArrayList<>();
    private double totalCost;
    private String visitDate;
    private int childrenQuantity;
    private int adultsQuantity = 0;
    private int numberOfVisitors = 0;

    public Visit(String visitDate, Employee guideInCharge, ArrayList<Visitor> visitors, int numberOfVisitors){
        this.visitDate = visitDate;
        this.guideInCharge = guideInCharge;
        this.visitors = visitors;
        this.numberOfVisitors = numberOfVisitors;
        adultsQuantity = calculateNumberOfAdults();
        childrenQuantity = numberOfVisitors - adultsQuantity;
        totalCost = calculateTotalCost();

        System.out.printf("Cantidad de visitantes: %s%n", getNumberOfVisitors());
        System.out.printf("Cantidad de adultos: %s%n", getAdultsQuantity());
        System.out.printf("Cantidad de niños: %s%n", getChildrenQuantity());
        System.out.printf("COSTO TOTAL DE LA VISITA: %s%n", getTotalCost());
    }

    public int calculateNumberOfAdults(){
        if(visitors.isEmpty()){
            System.out.println("No se han agregado visitantes.");
        }
        else{
            int[] date = new int[3]; 
            date = getVisitDate();
            for(Visitor visitor : visitors){
                visitor.setIsAnAdult(false);//Reinicio en caso de que la fecha cambie hacia atrás
                int[] visitorBirthDate = new int[3];
                visitorBirthDate[0] = Integer.parseInt(visitor.getBirthDate().substring(0, 2));
                visitorBirthDate[1] = Integer.parseInt(visitor.getBirthDate().substring(3, 5));
                visitorBirthDate[2] = Integer.parseInt(visitor.getBirthDate().substring(6));

                if(visitorBirthDate[2]<=date[2]-18){
                    if(visitorBirthDate[1]<=date[1]){
                        if(visitorBirthDate[0]<=date[0]){
                            visitor.setIsAnAdult(true);
                            adultsQuantity++;
                        }
                    }
                }
            }
        }
        return adultsQuantity;
    }

    private int[] getVisitDate(){
        int[] date = new int[3];
        date[0] = Integer.parseInt(visitDate.substring(0, 2));
        date[1] = Integer.parseInt(visitDate.substring(3, 5));
        date[2] = Integer.parseInt(visitDate.substring(6));
        return date;
    }

    public double calculateTotalCost(){
        for(Visitor visitor : visitors){
            int numberOfVisits = visitor.getNumberOfVisits();
            if(visitor.getIsAnAdult()){
                if((numberOfVisits+1)%5==0){
                    totalCost += 80;
                }
                else{
                    totalCost += 100;
                }
            }
            else{
                if((numberOfVisits+1)%5==0){
                    totalCost += 40;
                }
                else{
                    totalCost += 50;
                }
            }
            visitor.setNumberOfVisits(visitor.getNumberOfVisits()+1);
        }
        return totalCost;
    }

    public int getAdultsQuantity(){
        return adultsQuantity;
    }

    public int getChildrenQuantity(){
        return childrenQuantity;
    }

    public int getNumberOfVisitors(){
        return numberOfVisitors;
    }

    public double getTotalCost(){
        return totalCost;
    }
}
