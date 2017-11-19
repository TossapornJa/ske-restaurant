package restaurant;
import java.util.ArrayList;
import java.util.Scanner;
import static restaurant.RestaurantManager.setMenu;
public class Restaurant {
    public static Scanner s = new Scanner(System.in);
    public static String[] MenuOrder = RestaurantManager.getMenuItem();
    public static double[] PriceOrder = RestaurantManager.getPrices();
    private static ArrayList<Integer> addOrder = new ArrayList<Integer>();


    
    public static void MenuList(){
        setMenu();
        System.out.println("");
        System.out.printf("\t|||Welcome to SKE Restaraunt|||\n");
        for(int i=0;i<MenuOrder.length;i++) {
		System.out.printf("[%d] %s \t\t Price %d \tBath\n",i+1,MenuOrder[i],PriceOrder[i]);
	}
        System.out.println("(l) List Order");
	System.out.println("(p) Print");
        System.out.println("(c) Checkbill");
	System.out.println("(x) Exit Order");
    }
    public static void ListOrder(){
        for(int i=0; i<RestaurantManager.getMenuItem().length;i++){
            addOrder.add(i);
        }
    }
    public static double print(String choice){
    double totalprice =0;
    if(choice.equalsIgnoreCase("p")){
        System.out.println();
	System.out.printf("\t |||Print MenuOrder|||\n");
        for (int i = 0; i < PriceOrder.length; i++) {
	    if (PriceOrder[i] * addOrder.get(i) != 0) {
	        System.out.printf("|%s\t\t   |\t%d    |\t%.2f  |\n", MenuOrder[i], addOrder.get(i),PriceOrder[i]*addOrder.get(i));}}
        for (int j = 0; j < MenuOrder.length; j++) {
	    totalprice += addOrder.get(j);}
        System.out.println();
	System.out.printf("Total\t \t\t%.2f \tBath\n",totalprice);
	System.out.println();
    }
    return totalprice;
    }
    public static void Checkbill(double sum){
        double pay;
        do{
            System.out.print("Pay : ");
	    pay = s.nextDouble();
            if(pay<sum){
                System.out.println("Your money is not enough money.");
                System.out.println("Sorry,try again pleaes.");
            
            }
        }while(pay<sum);
        System.out.printf("Change : %.2f\n", pay - sum);
    }
    public static void Again(){
        MenuList();
        choice();
    }
    public static double Total(String choice,int quantity){
        double price=0;
        int order,allorder;
        double[] PrintPrices = RestaurantManager.getPrices();
        ArrayList<Integer>finalQuantity = new ArrayList<Integer>();
        for(int i=0;i<PrintPrices.length;i++){
            finalQuantity.add(i);
        }
        int manychoice = Integer.parseInt(choice);
        for(int j =0;j<PrintPrices.length;j++){
            if(manychoice == j+1){
                order = addOrder.get(j)+quantity;
                addOrder.add(j,order);
                addOrder.remove(j+1);
                allorder = quantity - finalQuantity.get(j);
                finalQuantity.add(j,allorder);
                finalQuantity.remove(j+1);
                price = allorder*PrintPrices[j];
                break;
            }
        }
        return price;
    }
    public static void choice(){
        int quantity=0,total=0;
        double price=0;
        String choice;
        do{
            System.out.println("");
	    System.out.print("Enter Choice: ");
            choice = s.next();
            price = print(choice);
            if (!choice.equalsIgnoreCase("l") && !choice.equalsIgnoreCase("p") && !choice.equalsIgnoreCase("c")
                && !choice.equalsIgnoreCase("x")) {
		System.out.print("Enter Quantity: ");
		quantity = s.nextInt();
            }
            else if(choice.equalsIgnoreCase("l")){
                Again();
            
            }
            else if(choice.equalsIgnoreCase("p")){
                print(choice);
                
            }
            else if(choice.equalsIgnoreCase("c")){
                Checkbill(price);
                System.out.print("||||Thank you to come SKE restaurant||||");
                break;
            
            }
            else if(choice.equalsIgnoreCase("x")){
                System.out.printf("\t[Thank you and good bye]\n");
                break;
            }else {
		continue;
	    }
	    total += Total(choice, quantity);
        }while(!choice.equalsIgnoreCase("x"));
    }


    public static void main(String[] args) {
	MenuList();
	ListOrder();
	choice();
    }
}