import java.util.Scanner;

public class Giveaway {
    public static void main(String[] args) {
        String[][] inventory = {
            {"x", "x", "StuffedPython", "x", "CSalt"}, 
            {"hAIrspray", "x", "x", "x", "x"}, 
            {"x", "x", "x", "JavaBeans", "x"}, 
            {"x", "RustedMetal", "SwiftShoes", "x", "x"},
            {"FuRniture", "x", "x", "GroovyGear", "RadiantRuby"}
        };
    
        Scanner input = new Scanner(System.in);

        int itemCount = 0;

        for (String[] row : inventory) {
            for (String item : row) {
                if (!item.equals("x")) {
                    itemCount += 1;
                }
            }
        }


        System.out.println("Welcome to the 1331 Giveaway!");

        
        String takeItem;
        while (itemCount > 0) {
            System.out.println("Would you like to take an item? [Y]es, [N]o, or [E]xit");

            takeItem = input.nextLine();

            if (takeItem.equals("N")) {
                System.out.println("Next person in line!");

            } 
            else if (takeItem.equals("E")) {
                System.out.println("Have a good day!");
                return;
            }
            else if (takeItem.equals("Y")) {
                for (String[] row : inventory) {
                    System.out.print("|");
                    for (String item : row) {
                        System.out.print(item + "|");
                    }
                    System.out.print("\n");
                };

                
                boolean continueLooping = true;

                while (continueLooping){
                    System.out.println("\nWhat item are you interested in taking?");
                    int rowId;
                    int colId;
                    if (input.hasNextInt()) {
                        rowId = input.nextInt();

                        if (input.hasNextInt()) {
                            colId = input.nextInt();
                        }

                        else {
                            return;
                        }
                    }
                    else {
                        return;
                    }


                    // valid location -in bounds.
                    if (rowId >= 0 && rowId < inventory.length && colId >= 0 && colId < inventory[0].length) {
                        if (!inventory[rowId][colId].equals("x")) {
                            System.out.printf("You successfully took the %s\n", inventory[rowId][colId]);
                            inventory[rowId][colId] = "x";
                            itemCount -= 1;
                            continueLooping = false;
                            for (String[] row : inventory) {
                                System.out.print("|");
                                for (String item : row) {
                                    System.out.print(item + "|");
                                }
                                System.out.print("\n");
                            };

                        }
                        else {
                            System.out.println("There is no item in this location.");
                        }


                    }
                    // invalid location - out of bounds.
                    else {
                        System.out.println("Location does not exist.");
                    }
                }




            }
            else {
                System.out.println("Please input 'Y', 'N' or 'E'.");
                continue;
            }
        }

        if (itemCount == 0) {
            System.out.println("Sorry, we have no more items!");
            return;
        }

    }


}