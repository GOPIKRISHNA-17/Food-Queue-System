// PROJECT:- SNACK KING QUEUE MANAGEMENT SYSTEM (CLASS VERSION).
// IF THERE ARE ANY REFERENCES TAKEN FROM EXTERNAL SOURCE, THE CREDITS GIVEN TO THOSE SOURCES IN THE RESPECTIVE SECTIONS OF THE CODE BELOW.

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClassVersion {
    public static int pizzaCount = 100;                                     // Initial pizza count is set to be 100.
    public static Scanner scanner = new Scanner(System.in);                 // Creating an instance of Scanner class to deal with user input.
    public static int incomeOfCashier1 = 0;                                 // For the purpose of income of cashier 1.
    public static int incomeOfCashier2 = 0;                                 // For the purpose of income of cashier 2.
    public static int incomeOfCashier3 = 0;                                 // For the purpose of income of cashier 3.
    public static ArrayList<String> namesOfVisitedCustomers = new ArrayList<>();        // For the purpose of storing the names of all visited customers.
    public static  int totalCustomerCount = 0;
    public static ArrayList<String> storeItBackArray = new ArrayList<>();               // For the purpose of storing data in the text file.
    public static int storeItBackCount = 0;
    private static final FoodQueue[] foodQueue = {new FoodQueue(2), new FoodQueue(3), new FoodQueue(5)};
    private static final WaitingList waitingObject = new WaitingList(5);      // For the purpose of storing the names of waiting customers.

    public static void main(String[] args) {
        while (true) {
            if (pizzaCount == 20) {
                System.out.println("Alert: Pizza stock reaches/below the value of 20 !!!");
            }

            MenuDisplay();

            System.out.println();
            System.out.print("➜ Which option you want to proceed: ");
            String operatorChoice = scanner.next();

            if (operatorChoice.equals("100") || operatorChoice.equalsIgnoreCase("VFQ")) {
                viewAllQueues();
                System.out.println();
            }
            else if (operatorChoice.equals("101") || operatorChoice.equalsIgnoreCase("VEQ")) {
                viewAllEmptyQueues();
                System.out.println();
            }
            else if (operatorChoice.equals("102") || operatorChoice.equalsIgnoreCase("ACQ")) {
                addCustomerToQueue();
                System.out.println();
            }
            else if (operatorChoice.equals("103") || operatorChoice.equalsIgnoreCase("RCQ")) {
                removeCustomerFromQueue();
                System.out.println();
            }
            else if (operatorChoice.equals("104") || operatorChoice.equalsIgnoreCase("PCQ")) {
                removeServedCustomerFromQueue();
                System.out.println();
            }
            else if (operatorChoice.equals("105") || operatorChoice.equalsIgnoreCase("VCS")) {
                customersNameSort();
                System.out.println();
            }
            else if (operatorChoice.equals("106") || operatorChoice.equalsIgnoreCase("SPD")) {
                storeDataToFile();
                System.out.println();
            }
            else if (operatorChoice.equals("107") || operatorChoice.equalsIgnoreCase("LPD")) {
                loadDataFromFile();
                System.out.println();
            }
            else if (operatorChoice.equals("108") || operatorChoice.equalsIgnoreCase("STK")) {
                viewPizzaStock();
                System.out.println();
            }
            else if (operatorChoice.equals("109") || operatorChoice.equalsIgnoreCase("AFS")) {
                addPizzaToStock();
                System.out.println();
            }
            else if (operatorChoice.equals("110") || operatorChoice.equalsIgnoreCase("IFQ")){
                printIncomeOfQueues();
                System.out.println();
            }
            else if (operatorChoice.equals("999") || operatorChoice.equalsIgnoreCase("EXT")) {
                System.out.println("    Program exiting, Thank you.");
                scanner.close();
                break;
            }
            else {
                System.out.println("    INVALID OPTION. Choose a valid one.");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println();
            }
        }
    }

    public static void MenuDisplay() {
        System.out.println("****************************");
        System.out.println("** SNACK KING FOOD CENTER **");
        System.out.println("****************************");
        System.out.println("Menu options for Operator:");
        System.out.println("❊ Press 100 or VFQ: View all Queues.");
        System.out.println("❊ Press 101 or VEQ: View all Empty Queues.");
        System.out.println("❊ Press 102 or ACQ: Add customer to a Queue.");
        System.out.println("❊ Press 103 or RCQ: Remove a customer from a Queue.");
        System.out.println("❊ Press 104 or PCQ: Remove a served customer.");
        System.out.println("❊ Press 105 or VCS: View Customers Sorted in alphabetical order.");
        System.out.println("❊ Press 106 or SPD: Store Program Data into file.");
        System.out.println("❊ Press 107 or LPD: Load Program Data from file.");
        System.out.println("❊ Press 108 or STK: View Remaining pizza Stock.");
        System.out.println("❊ Press 109 or AFS: Add pizza to Stock.");
        System.out.println("❊ Press 110 or IFQ: Print income of each queue.");
        System.out.println("❊ Press 999 or EXT: Exit the Program.");
    }

    public static  void viewAllQueues() {
        System.out.println();
        System.out.println("\t" + "*****************");
        System.out.println("\t" + "*    Cashiers   *");
        System.out.println("\t" + "*****************");
        System.out.println("\t" + foodQueue[0].printMark(1) + foodQueue[1].printMark(1) + foodQueue[2].printMark(1));
        System.out.println("\t" + foodQueue[0].printMark(2) + foodQueue[1].printMark(2) + foodQueue[2].printMark(2));
        System.out.println("\t" + "      " + foodQueue[1].printMark(3) + foodQueue[2].printMark(3));
        System.out.println("\t" + "            " + foodQueue[2].printMark(4));
        System.out.println("\t" + "            " + foodQueue[2].printMark(5));

        System.out.println();
        System.out.println("\t"+ "\"X\" - Not Occupied." + "\n" + "\t" + "\"O\" - Occupied.");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void addCustomerToQueue() {
        while (true) {
            System.out.print("  ⤷ " + "Enter the first name of the customer: ");
            String customerFirstName = scanner.next();

            // Regular expression pattern for alphabets only (line 134 and 142) is taken from external source.
            // Code taken from : TutorialKart
            // URL : https://www.tutorialkart.com/java/how-to-check-if-string-contains-only-alphabets-in-java/#:~:text=To%20check%20if%20String%20contains%20only%20alphabets%20in%20Java%2C%20call,String.&gsc.tab=0

            // check whether the customer name only contain alphabets or not.
            if (!customerFirstName.matches("[A-Za-z]+")) {
                System.out.println("      Note: Customer first Name looks like invalid.");
                break;
            }

            System.out.print("  ⤷ " + "Enter the second name of the customer: ");
            String customerSecondName = scanner.next();

            if (!customerSecondName.matches("[A-Za-z]+")) {
                System.out.println("      Note: Customer second Name looks like invalid.");
                break;
            }

            int customerIdNumber;
            try {
                System.out.print("  ⤷ " + "Enter ID number: ");
                customerIdNumber = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("      Note: ID must contain integer.");
                scanner.next();
                break;
            }

            if (!(String.valueOf(customerIdNumber).length() == 6)) {
                System.out.println("      Note: ID must contain 6 digits.");
                System.out.println();
                break;
            }

            int customerPizzaRequired;
            try {
                System.out.print("  ⤷ " + "How many pizza/s customer want: ");
                customerPizzaRequired = scanner.nextInt();

                if (customerPizzaRequired < 0) {
                    System.out.println("      Note: Pizza count not comes in negative.");
                    break;
                }
                else if (customerPizzaRequired == 0) {
                    System.out.println("      Note: Minimum pizza count is 1.");
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("      Note: Pizza count looks like not a valid one.");
                scanner.next();
                break;
            }

            if (String.valueOf(customerIdNumber).length() == 6) {
                for (int n = 0; n < 5; n++) {
                    try {
                        if (foodQueue[0].checkEmpty(n) && n < 2) {
                            foodQueue[0].getArrayElement(n).setCustomerDetails(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);

                            namesOfVisitedCustomers.add(totalCustomerCount, customerFirstName);
                            totalCustomerCount++;

                            System.out.println("      ✔ Customer \"" + customerFirstName + " " + customerSecondName + "\" added to queue 1 at position " + (n + 1) + " successfully.");
                            break;
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e1) {
                        try {
                            if(foodQueue[1].checkEmpty(n) && n < 3) {
                                foodQueue[1].getArrayElement(n).setCustomerDetails(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);

                                namesOfVisitedCustomers.add(totalCustomerCount, customerFirstName);
                                totalCustomerCount++;

                                System.out.println("      ✔ Customer \"" + customerFirstName + " " + customerSecondName + "\" added to queue 2 at position " + (n + 1) + " successfully.");
                                break;
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e2) {
                            if (foodQueue[2].checkEmpty(n)) {
                                foodQueue[2].getArrayElement(n).setCustomerDetails(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);

                                namesOfVisitedCustomers.add(totalCustomerCount, customerFirstName);
                                totalCustomerCount++;

                                System.out.println("      ✔ Customer \"" + customerFirstName + " " + customerSecondName + "\" added to queue 3 at position " + (n + 1) + " successfully.");
                                break;
                            }
                        }
                    }

                    try {
                        if(foodQueue[1].checkEmpty(n) && n < 3) {
                            foodQueue[1].getArrayElement(n).setCustomerDetails(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);

                            namesOfVisitedCustomers.add(totalCustomerCount, customerFirstName);
                            totalCustomerCount++;

                            System.out.println("      ✔ Customer \"" + customerFirstName + " " + customerSecondName + "\" added to queue 2 at position " + (n + 1) + " successfully.");
                            break;
                        }
                    }
                    catch (ArrayIndexOutOfBoundsException e1) {
                        if (foodQueue[2].checkEmpty(n)) {
                            foodQueue[2].getArrayElement(n).setCustomerDetails(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);

                            namesOfVisitedCustomers.add(totalCustomerCount, customerFirstName);
                            totalCustomerCount++;

                            System.out.println("      ✔ Customer \"" + customerFirstName + " " + customerSecondName + "\" added to queue 3 at position " + (n + 1) + " successfully.");
                            break;
                        }
                    }

                    if (foodQueue[2].checkEmpty(n)) {
                        foodQueue[2].getArrayElement(n).setCustomerDetails(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);

                        namesOfVisitedCustomers.add(totalCustomerCount, customerFirstName);
                        totalCustomerCount++;

                        System.out.println("      ✔ Customer \"" + customerFirstName + " " + customerSecondName + "\" added to queue 3 at position " + (n + 1) + " successfully.");
                        break;
                    }
                    else {
                        int queue1 = 0;
                        int queue2 = 0;
                        int queue3 = 0;

                        for (int k = 0; k < foodQueue[0].getCustomerArraySize(); k++) {
                            if (!foodQueue[0].checkEmpty(k)) {
                                queue1++;
                            }
                        }

                        for (int k = 0; k < foodQueue[1].getCustomerArraySize(); k++) {
                            if (!foodQueue[1].checkEmpty(k)) {
                                queue2++;
                            }
                        }

                        for (int k = 0; k < foodQueue[2].getCustomerArraySize(); k++) {
                            if (!foodQueue[2].checkEmpty(k)) {
                                queue3++;
                            }
                        }

                        if (queue1 == 2 && queue2 == 3 && queue3 == 5) {
                            if (waitingObject.checkAtLeastOneEmpty()) {
                                waitingObject.addToWaitingList(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);
                                namesOfVisitedCustomers.add(totalCustomerCount, customerFirstName);
                                totalCustomerCount++;
                            }
                            else {
                                waitingObject.addToWaitingList(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);
                            }
                            break;
                        }
                    }
                }
                break;
            }
            else {
                System.out.println("      Note: ID must contain 6 digits.");
                System.out.println();
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void viewAllEmptyQueues() {
        System.out.println();
        System.out.println("\t" + "*****************");
        System.out.println("\t" + "*    Cashiers   *");
        System.out.println("\t" + "*****************");
        System.out.println("\t" + foodQueue[0].printSpaceForEmpty(1) + foodQueue[1].printSpaceForEmpty(1) + foodQueue[2].printSpaceForEmpty(1));
        System.out.println("\t" + foodQueue[0].printSpaceForEmpty(2) + foodQueue[1].printSpaceForEmpty(2) + foodQueue[2].printSpaceForEmpty(2));
        System.out.println("\t" + "      " + foodQueue[1].printSpaceForEmpty(3) + foodQueue[2].printSpaceForEmpty(3));
        System.out.println("\t" + "            " + foodQueue[2].printSpaceForEmpty(4));
        System.out.println("\t" + "            " + foodQueue[2].printSpaceForEmpty(5));

        System.out.println("\n" + "\t"+ "\"X\" - Not Occupied.");

        System.out.println();

        foodQueue[0].listOutEmptyPositions(1);
        foodQueue[1].listOutEmptyPositions(2);
        foodQueue[2].listOutEmptyPositions(3);

        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void removeCustomerFromQueue() {
        while (true) {
            System.out.print("  ⤷ " + "From which queue you want to remove the customer (Queue1 or Queue2 or Queue3): ");
            String removeCustomerQueue = scanner.next();

            if (removeCustomerQueue.equalsIgnoreCase("Queue1") || removeCustomerQueue.equalsIgnoreCase("Queue2") || removeCustomerQueue.equalsIgnoreCase("Queue3")) {
                if (removeCustomerQueue.equalsIgnoreCase("Queue1")) {
                    try {
                        System.out.print("  ⤷ " + "Which position in queue 1 you want to remove (1 or 2): ");
                        int queue1Position = scanner.nextInt();

                        if (queue1Position > 0 && queue1Position < 3) {
                            if (!foodQueue[0].checkEmpty(queue1Position - 1)) {
                                foodQueue[0].getArrayElement(queue1Position - 1).setCustomerDetails("X", null, 0,0);
                                System.out.println("      ✔ Customer removed successfully from queue 1 at position " + queue1Position + ".");

                                System.out.println();
                                System.out.println("   ➞ At the time of removing the customer.");
                                viewAllQueues();

                                foodQueue[0].setDataToFront();

                                if (waitingObject.checkWaiting()) {
                                    foodQueue[0].setCustomerFromWaiting(2, waitingObject.removeFromWaitingList());
                                }

                                System.out.println();
                                System.out.println("   ➞ After the removal of customer.");
                                viewAllQueues();
                            }
                            else {
                                System.out.println("      Note: No customer in that position.");
                                System.out.println("-----------------------------------------------------------------------------------------");
                            }
                        }
                        else {
                            System.out.println("      Note: Position out of range.");
                            System.out.println("-----------------------------------------------------------------------------------------");
                        }
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("      Note: Invalid input type.");
                        scanner.next();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                }
                else if (removeCustomerQueue.equalsIgnoreCase("Queue2")) {
                    try {
                        System.out.print("  ⤷ " + "Which position in queue 2 you want to remove (1 or 2 or 3): ");
                        int queue2Position = scanner.nextInt();

                        if (queue2Position > 0 && queue2Position < 4) {
                            if (!foodQueue[1].checkEmpty(queue2Position - 1)) {
                                foodQueue[1].getArrayElement(queue2Position - 1).setCustomerDetails("X", null, 0,0);
                                System.out.println("      ✔ Customer removed successfully from queue 2 at position " + queue2Position + ".");

                                System.out.println();
                                System.out.println("   ➞ At the time of removing the customer.");
                                viewAllQueues();

                                foodQueue[1].setDataToFront();

                                if (waitingObject.checkWaiting()) {
                                    foodQueue[1].setCustomerFromWaiting(3, waitingObject.removeFromWaitingList());
                                }

                                System.out.println();
                                System.out.println("   ➞ After the removal of customer.");
                                viewAllQueues();
                            }
                            else {
                                System.out.println("      Note: No customer in that position.");
                                System.out.println("-----------------------------------------------------------------------------------------");
                            }
                        }
                        else {
                            System.out.println("      Note: Position out of range.");
                            System.out.println("-----------------------------------------------------------------------------------------");
                        }
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("      Note: Invalid input type.");
                        scanner.next();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                }
                else if (removeCustomerQueue.equalsIgnoreCase("Queue3")) {
                    try {
                        System.out.print("  ⤷ " + "Which position in queue 3 you want to remove (1 or 2 or 3 or 4 or 5): ");
                        int queue3Position = scanner.nextInt();

                        if (queue3Position > 0 && queue3Position < 6) {
                            if (!foodQueue[2].checkEmpty(queue3Position - 1)) {
                                foodQueue[2].getArrayElement(queue3Position - 1).setCustomerDetails("X", null, 0,0);
                                System.out.println("      ✔ Customer removed successfully from queue 3 at position " + queue3Position + ".");

                                System.out.println();
                                System.out.println("   ➞ At the time of removing the customer.");
                                viewAllQueues();

                                foodQueue[2].setDataToFront();

                                if (waitingObject.checkWaiting()) {
                                    foodQueue[2].setCustomerFromWaiting(5, waitingObject.removeFromWaitingList());
                                }

                                System.out.println();
                                System.out.println("   ➞ After the removal of customer.");
                                viewAllQueues();
                            }
                            else {
                                System.out.println("      Note: No customer in that position.");
                                System.out.println("-----------------------------------------------------------------------------------------");
                            }
                        }
                        else {
                            System.out.println("      Note: Position out of range.");
                            System.out.println("-----------------------------------------------------------------------------------------");
                        }
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("      Note: Invalid input type.");
                        scanner.next();
                        System.out.println("-----------------------------------------------------------------------------------------");
                        break;
                    }
                }
            }
            else {
                System.out.println("      Note: Invalid queue choice.");
                System.out.println("-----------------------------------------------------------------------------------------");
            }
        }
    }

    public static void removeServedCustomerFromQueue() {
        while (true) {
            System.out.print("  ⤷ " + "From which queue you want to remove the served customer (Queue1 or Queue2 or Queue3): ");
            String servedCustomerQueue = scanner.next();

            if (servedCustomerQueue.equalsIgnoreCase("Queue1") || servedCustomerQueue.equalsIgnoreCase("Queue2") || servedCustomerQueue.equalsIgnoreCase("Queue3")) {
                if (servedCustomerQueue.equalsIgnoreCase("Queue1")) {
                    if (!foodQueue[0].checkEmpty(0)) {
                        incomeOfCashier1 += foodQueue[0].pizzaAmount(0);
                        pizzaCount -= foodQueue[0].getArrayElement(0).getNumberOfPizzaRequired();
                        foodQueue[0].getArrayElement(0).setCustomerDetails("X", null, 0,0);
                        System.out.println("      ✔ Served customer removed from queue 1 successfully.");

                        System.out.println();
                        System.out.println("   ➞ At the time of removing the customer.");
                        viewAllQueues();

                        foodQueue[0].setDataToFront();

                        if (waitingObject.checkWaiting()) {
                            foodQueue[0].setCustomerFromWaiting(2, waitingObject.removeFromWaitingList());
                        }

                        System.out.println();
                        System.out.println("   ➞ After the removal of customer.");
                        viewAllQueues();
                    }
                    else {
                        System.out.println("      Note: Queue 1 is empty.");
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    break;
                }
                else if (servedCustomerQueue.equalsIgnoreCase("Queue2")) {
                    if (!foodQueue[1].checkEmpty(0)) {
                        incomeOfCashier2 += foodQueue[1].pizzaAmount(0);
                        pizzaCount -= foodQueue[1].getArrayElement(0).getNumberOfPizzaRequired();
                        foodQueue[1].getArrayElement(0).setCustomerDetails("X", null, 0,0);
                        System.out.println("      ✔ Served customer removed from queue 2 successfully.");

                        System.out.println();
                        System.out.println("   ➞ At the time of removing the customer.");
                        viewAllQueues();

                        foodQueue[1].setDataToFront();

                        if (waitingObject.checkWaiting()) {
                            foodQueue[1].setCustomerFromWaiting(3, waitingObject.removeFromWaitingList());
                        }

                        System.out.println();
                        System.out.println("   ➞ After the removal of customer.");
                        viewAllQueues();
                    }
                    else {
                        System.out.println("      Note: Queue 2 is empty.");
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    break;
                }
                else if (servedCustomerQueue.equalsIgnoreCase("Queue3")) {
                    if (!foodQueue[2].checkEmpty(0)) {
                        incomeOfCashier3 += foodQueue[2].pizzaAmount(0);
                        pizzaCount -= foodQueue[2].getArrayElement(0).getNumberOfPizzaRequired();
                        foodQueue[2].getArrayElement(0).setCustomerDetails("X", null, 0,0);
                        System.out.println("      ✔ Served customer removed from queue 3 successfully.");

                        System.out.println();
                        System.out.println("   ➞ At the time of removing the customer.");
                        viewAllQueues();

                        foodQueue[2].setDataToFront();

                        if (waitingObject.checkWaiting()) {
                            foodQueue[2].setCustomerFromWaiting(5, waitingObject.removeFromWaitingList());
                        }

                        System.out.println();
                        System.out.println("   ➞ After the removal of customer.");
                        viewAllQueues();
                    }
                    else {
                        System.out.println("      Note: Queue 3 is empty.");
                        System.out.println("-----------------------------------------------------------------------------------------");
                    }
                    break;
                }
            }
            else {
                System.out.println("      Note: Invalid queue choice.");
                System.out.println("-----------------------------------------------------------------------------------------");
                break;
            }
        }
    }

    public static void customersNameSort() {
        if (namesOfVisitedCustomers.size() != 0) {
            foodQueue[0].sortingProcess(1);
            foodQueue[1].sortingProcess(2);
            foodQueue[2].sortingProcess(3);
        }
        else {
            System.out.println("      Note: No customers to sort.");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void viewPizzaStock() {
        System.out.println("   ⁎ Remaining pizza stock: " + pizzaCount + ".");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void addPizzaToStock() {
        try {
            System.out.print("  ⤷ " + "How many pizzas are you going to add: ");
            int addPizzaStock = scanner.nextInt();
            pizzaCount = pizzaCount + addPizzaStock;
            System.out.println("      ✔ Pizzas added to the stock successfully.");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
        catch (InputMismatchException e1) {
            System.out.println("      Note: Pizza count must be integer.");
            scanner.next();
        }
    }

    public static void printIncomeOfQueues() {
        try {
            System.out.print("  ⤷ " + "Would you like to see the income of each cashier (Yes or No): ");
            String userChoice = scanner.next();

            if (userChoice.equalsIgnoreCase("Yes") || userChoice.equalsIgnoreCase("No")) {
                if (userChoice.equalsIgnoreCase("Yes")) {
                    System.out.println();
                    System.out.println("     ⁎ Income of Cashier 1: " + "Rs " + incomeOfCashier1 + ".");
                    System.out.println("     ⁎ Income of Cashier 2: " + "Rs " + incomeOfCashier2 + ".");
                    System.out.println("     ⁎ Income of Cashier 3: " + "Rs " + incomeOfCashier3 + ".");
                }
                else {
                    System.out.println("      Thank You.");
                }
            }
            else {
                System.out.println("      Note: Invalid input.");
            }
        }
        catch (InputMismatchException e1) {
            System.out.println("      Note: Invalid input.");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void storeDataToFile() {
        // Concept of "BufferedWriter" is referred from external source.
        // URL: https://www.javatpoint.com/java-bufferedwriter-class

        if (!foodQueue[0].checkEmpty(0)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("SnackKingDetails(C).txt"))) {
                writer.write("*********************************");
                writer.newLine();
                writer.write("** SNACK KING CUSTOMER DETAILS **");
                writer.newLine();
                writer.write("*********************************");
                writer.newLine();
                writer.newLine();
                writer.write("Order of visited customers: ");
                writer.newLine();

                for (int l = 0; l < totalCustomerCount; l++) {
                    if (namesOfVisitedCustomers.get(l) != null) {
                        writer.write("  ➞ " + namesOfVisitedCustomers.get(l));
                        writer.newLine();
                    }
                }
                System.out.println("   ✔ Data wrote to the file successfully.");
            }
            catch (IOException e1) {
                System.out.println("    Note: Error.");
            }
        }
        else {
            System.out.println("    Note: No customers visited yet. Therefore no data to store.");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void loadDataFromFile() {
        // Concept of "BufferedReader" is referred from external source.
        // URL: https://www.javatpoint.com/java-bufferedreader-class

        if (namesOfVisitedCustomers.size() != 0) {
            System.out.println();
            try (BufferedReader reader = new BufferedReader(new FileReader("SnackKingDetails(C).txt"))) {
                String textLine;
                while ((textLine = reader.readLine()) != null) {
                    System.out.print("   ");
                    System.out.println(textLine);
                    storeItBackArray.add(storeItBackCount, textLine);
                    storeItBackCount++;
                }
            }
            catch (IOException e1) {
                System.out.println("    Note: Error.");
            }
        }
        else {
            System.out.println("    Note: No data to read.");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}