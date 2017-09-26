package ske;
import java.util.Scanner;
public class SKE {
static int food;static int num;
static int fb;static int hd;static int nd;
static int sumf;static int sumh;static int sumn;
static int total1;static int total2;static int total3;
public static int a(int food,int num) {
    switch (food) {
        case 1:
            fb = num;
            sumf = 50*fb;
            total1 = 99;
            break;
        case 2:
            hd = num;
            sumh = 70*hd;
            total2 = 99;
            break;
        case 3:
            nd = num;
            sumn = 120*nd;
            total3 = 99;
            break;
        default:
            break;
    }
return total1|total2|total3;
}
static void main1() {
System.out.println("------WELCOME TO SKE RESTAURANT------");
System.out.println("1.) Fish Burger  50 Baht");
System.out.println("2.) Hotdog\t 70 Baht");
System.out.println("3.) Noodle\t 120 Baht");
System.out.println("4.) Total");
System.out.println("5.) Exit");
System.out.println("");
}
static void checkbill(){
if (food==4){
System.out.println("+------ Menu ------+-- Qty --+-- Price --+");
if(total1==99){
System.out.printf("| Fish Burger\t   |  %5d  |  %5d    |\n",fb,sumf);
}
if(total2==99){
System.out.printf("| Hotdog\t   |  %5d  |  %5d    |\n",hd,sumh);
}
if(total3==99){
System.out.printf("| Noodle\t   |  %5d  |  %5d    |\n",nd,sumn);
}
System.out.println("+------------------+---------+-----------+");
System.out.printf("| Total\t\t\t     |  %5d    |\n",sumf+sumh+sumn);
System.out.println("+------------------+---------+-----------+");
System.out.println("");
}
}
public static void main(String[] args){
Scanner s = new Scanner(System.in);
main1();
do{
System.out.print("Enter your Choice: ");
food = s.nextInt();
if (food==5){
System.out.print("===== Thank You =====");}
else if(food!=4){
System.out.print("Enter Quantity: ");
num = s.nextInt();
}
System.out.println("");
a(food,num);
checkbill();
}while(food!=5);
}
}