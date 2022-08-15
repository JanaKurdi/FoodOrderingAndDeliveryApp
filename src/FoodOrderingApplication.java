//CPCS202
//13/11/2019
import java.util.Scanner;

public class FoodOrderingApplication {
     public static void displayWelcomeMessage() {//method display message
        System.out.println("Welcome to the Food ordering system. Please place your order using the menu below");
             System.out.println();
    }
         public static  boolean isPhoneNumberOK(long x) {//method check th length of phone number
         if(x>=966500000000L && x<=966599999999L)
            return (true); //if correct return ture
        else
         return (false);// if wrong return false
}
         public static  long getPhoneNumber(){
             Scanner input=new Scanner(System.in);//create Scanner
             long num;//declare varaible
       System.out.print("Please enter your phone number : ");//ask user to enter
            num=input.nextLong();//promote the user to enter number
           while(!isPhoneNumberOK(num)){//if the number is wrong countinue and invoke isPhoneNumberOk method
           System.out.print("Please enter your phone number : ");
            num=input.nextLong();
            
           }
            return num;//return true number
           
       }
         public static   boolean  isZipCodeOK(int len){//check zip code
        if(len>=20001&&len<=29999)
             return (true);//if it is correct return true
         else
             return (false);// if it is wrong return false
               }
         public static  int   getZipCode(){
                Scanner input=new Scanner(System.in);//create Scanner
                 int zip;
         System.out.print("Please enter your zipcode :");//ask user to enter
         zip=input.nextInt();//promote the user to enter zip code
         while(!isZipCodeOK(zip)){//if the zip code wrong countinue
        System.out.print("Please enter your zipcode :");
        zip=input.nextInt();
         }
         return zip;
        }
         public static  double   displayOrderMenu(){
             Scanner input=new Scanner(System.in);//create Scanner
             int choice=0;//declare and initilize 
             int quantities=0;//
              String coupon;
             double price=0;
             double totalPrice =0;
                     do{//keep reading data until the choice are not equal -1
                             drawLine(60);//invoke drawLine method
                System.out.println("                    Food Menu        ");
                             drawLine(60);
                System.out.println("Item                                       Price (SR)     ");
                System.out.println("1.	Chicken Burger                      12 SR");
                System.out.println("2.	Beef Burger                         15 SR");
                System.out.println("3.	Mac and Cheese                      10 SR");
                System.out.println("4.	Cesar Salad                         11 SR");
                System.out.println("5.	House Salad                         10 SR");
                System.out.println("6.	Fries                                7 SR");
                System.out.println("7.	Soft Drink                           3 SR");
                do{ //keep reading data until the choice are less than -1 or greater than 7 or equal zero 
                System.out.print("Enter your choice (1 to 7) or -1 to exit:");
                        choice =input.nextInt();//promote the user to choose
                }while(choice<-1||choice>7||choice==0);
                
             if(choice!=-1&&choice<=7&&choice>=1&&quantities>=0)
                do{//keep reading data until the quantities are greater and equal to zero
                    System.out.print("Enter quantities:");
                       quantities =input.nextInt();
                           }while(quantities<=0);
             
               switch (choice) {//if choice= any number forom 1 to7 count the price 
                        case 1:
                      price=price+(12*quantities);
                           break;
                        case 2:
                      price=price+(15*quantities);
                          break;
                        case 3:
                      price=price+(10*quantities);
                          break;
                        case 4:
                      price=price+(11*quantities);
                          break;
                       case 5:
                      price=price+(10*quantities);
                          break;
                       case 6:
                       price=price+(7*quantities);
                           break;
                      case 7:
                      price=price+(3*quantities);
                            break;
                     default:
                            break;
                            }
             
             
                 }while (choice!=-1);
             
               if(choice==-1||quantities>=1) {
       System.out.print("Enter coupon code (or any other word to continue): ");
              coupon =input.next();
            
                    
         if(getCouponDiscount(coupon)==0) {//invoke getCouponDiscount
    System.out.println("Sorry your coupon code is not accepted");
           return price;//return total without discount
         }
         else
       totalPrice = (1-FoodOrderingApplication.getCouponDiscount(coupon))*price;//count the total if the coupon is correct
               }
            return totalPrice;//return total after discount
            
         }
         public static  double  getCouponDiscount(String coupon){//method check coupon discout
             String discount;
            
       if(coupon.length()==6 &&coupon.startsWith("FXER")&&//check if coupon start with FXER
           Character.isDigit(coupon.charAt(4))&&
           Character.isDigit(coupon.charAt(5))){
              discount=coupon.substring(4, 6);
           double xx=(Double.parseDouble(discount)/100);//count the discount 
         
          return xx;//return the discont 
          }else
          return 0;//return zero if the coupon code is wrong
        }
        public static  String  displayDeliveryMenu(){//method display delivery menue
            Scanner input=new Scanner(System.in);
            System.out.println();
             System.out.print("Enter your first name only :");
             String name=input.next();
            long x = 0;
            
         getPhoneNumber();  //invoke method
         getZipCode();//invoke method
         System.out.println();
           System.out.println("***********Thank you. We will deliver your order shortly************* ");
           System.out.println();
            return name;
         }
         public static  void   displaySummary(String name, double total){//method display summary
                            FoodOrderingApplication.drawLine(60);//invoke drawLine method
                    System.out.println("                     Summary      ");
                             FoodOrderingApplication.drawLine(60);
                    System.out.println("   ");
                    System.out.println("Your full name is: "+ name);
                   System.out.println("Your total order is: "+total);
         }
         
         
	public static void drawLine(int len)//draw (-) 
	{
		for(int i=0; i<len; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public static void main(String[] args) {//main method
            //invoke method
		displayWelcomeMessage();
		double total = displayOrderMenu();
		System.out.println("Thank you for ordering! Your total is SR " + total);
		String name = displayDeliveryMenu();
		displaySummary(name, total);
	}
}

 
