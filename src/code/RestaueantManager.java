package restaurant;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManager {

    private static ArrayList<String> MenuNameList = new ArrayList<String>();
    private static ArrayList<Double> PriceList = new ArrayList<Double>();
    
    public static String[] getMenuItem(){
            String[] MenuItem =  MenuNameList.toArray(new String[MenuNameList.size()]);
            return MenuItem;
    }
	
    public static double[] getPrices(){
            double[] Price = new double[PriceList.size()];
            for (int i = 0; i<Price.length; i++){
                    Price[i] = PriceList.get(i);
            }
            return Price;
    }
    
    static void setMenu() {
            String Menuorder = "data/menu.txt";
            ClassLoader loader = RestaurantManager.class.getClassLoader();

            InputStream in = loader.getResourceAsStream(Menuorder);
            if (in == null) {
                    System.out.println("Could not access file " + Menuorder);
                    return;
            }

            Scanner s = new Scanner(in);

            while (s.hasNextLine()) {
                    String line = s.nextLine();
                    if (line.startsWith("//") || line.startsWith(" //") || line.equals("")) {
                            continue;
                    }
                    String[] array = line.trim().split("; ");
                    MenuNameList.add(array[0]);
                    PriceList.add(Double.parseDouble(array[1]));
            }
            s.close();
    }	
}