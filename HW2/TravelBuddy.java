import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class TravelBuddy {
    public static void main(String[] args) {
        System.out.print("Welcome to Travel Buddy Service! Please enter your name here: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        name = name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase(); 
        System.out.printf("\nWhere would you like to go, %s?\n", name);

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.printf("The Hive - %s\n", currencyFormat.format(6));
        System.out.printf("Invention Studio - %s\n", currencyFormat.format(7.5));
        System.out.printf("Klaus - %s\n", currencyFormat.format(6.9));
        System.out.printf("CULC - %s\n", currencyFormat.format(3.2));
        
        String choice = input.nextLine();
        double cost = 0.0;

        if (choice.equals("CULC") || choice.equals("Klaus")) {
            
            if (choice.equals("CULC")) {
                cost = 3.2;
            }
            else {
                cost = 6.9;
            }
            System.out.println("Would you like to stop by Chick-fil-a on the way? (Yes/No)");
            String extra = input.nextLine();
            if (extra.equals("Yes")) {
                cost *= 1.5;
            }
            else if (!extra.equals("No")) {
                return;
            }

        }
        else if (choice.equals("The Hive")) {
            cost = 6.0;
        }

        else if (choice.equals("Invention Studio")){
            cost = 7.5;
        }

        else {
            System.out.println("\nThat destination is invalid, goodbye!");
            return;
        }

        System.out.printf("\nYour current total is %s\n", currencyFormat.format(cost));

        System.out.println("\nDo you have a discount? (Yes/No)");
        String discount = input.nextLine();

        if (discount.equals("Yes")){
            System.out.println("\nWhat is the discount code?");
            String code = input.nextLine();
            double userAmount;
            if (code.equals("CS1331")) {
                userAmount = cost * 0.25;
                System.out.println("\nYou have received 25% off your ride!");
                System.out.printf("\nTaking off %s from your total...\n", currencyFormat.format(userAmount));

            }
            else if (code.equals("IKNOWTHEOWNER")) {
                System.out.println("\nHow much would you like to take off?");
                if (input.hasNextDouble()){
                    userAmount = Math.min(cost, input.nextDouble());
                }
                else {
                    userAmount = 1.00;
                }
                System.out.printf("\nTaking off %s from your total...\n", currencyFormat.format(userAmount));
            }
            else {
                System.out.println("\nThat discount does not exist! Better luck next time!");
                userAmount = 0.00;
            }
            cost = Math.max(0, cost - userAmount);
        }

        System.out.printf("\nThank you for riding with the Travel Buddy Service, %s! You are now %s poorer! We hope you ride with us again! :)\n", name, currencyFormat.format(cost));
    }
}