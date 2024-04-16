// PROJECT:- SNACK KING QUEUE MANAGEMENT SYSTEM (ARRAY VERSION).
// IF THERE ARE ANY REFERENCES TAKEN FROM EXTERNAL SOURCE, THE CREDITS GIVEN TO THOSE SOURCES IN THE RESPECTIVE SECTIONS OF THE CODE BELOW.

import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArrayVersion {
    public static String[] queueOfCashier1 = {"X", "X"};                    // Maximum customer capacity of queue 1 is 2, initially no customers so all 2 array elements are set to be "X".
    public static String[] queueOfCashier2 = {"X", "X", "X"};               // Maximum customer capacity of queue 1 is 3, initially no customers so all 3 array elements are set to be "X".
    public static String[] queueOfCashier3 = {"X", "X", "X", "X", "X"};     // Maximum customer capacity of queue 1 is 5, initially no customers so all 5 array elements are set to be "X".
    public static String[] customerNamesOfCashier1 = new String[2];         // Store the customer names that belongs to cashier 1.
    public static String[] customerNamesOfCashier2 = new String[3];         // Store the customer names that belongs to cashier 2.
    public static String[] customerNamesOfCashier3 = new String[5];         // Store the customer names that belongs to cashier 3.
    public static int pizzaCount = 100;                                     // Initial pizza count is set to be 100.
    public static Scanner scanner = new Scanner(System.in);                 // Creating an instance of Scanner class to deal with user input.
    public static String[] namesOfVisitedCustomers = new String[40];        // For the purpose of storing the names of all visited customers.
    public static int totalCustomerCount = 0;
    public static String[] storeItBackArray = new String[40];               // For the purpose of storing data in the text file.
    public static int storeItBackCount = 0;

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
        System.out.println("❊ Press 999 or EXT: Exit the Program.");
    }

    public static void viewAllQueues() {
        System.out.println();
        System.out.println("\t" + "*****************");
        System.out.println("\t" + "*    Cashiers   *");
        System.out.println("\t" + "*****************");
        System.out.print("\t" + "  " +  queueOfCashier1[0] + "     " + queueOfCashier2[0] + "     " + queueOfCashier3[0] + "\n");
        System.out.print("\t" + "  " +  queueOfCashier1[1] + "     " + queueOfCashier2[1] + "     " + queueOfCashier3[1] + "\n");
        System.out.print("\t" + "        " + queueOfCashier2[2] + "     " + queueOfCashier3[2] + "\n");
        System.out.print("\t" + "              " + queueOfCashier3[3] + "\n");
        System.out.print("\t" + "              " + queueOfCashier3[4] + "\n");

        System.out.println();
        System.out.println("\t"+ "\"X\" - Not Occupied." + "\n" + "\t" + "\"O\" - Occupied.");
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void addCustomerToQueue() {
        while (true) {
            System.out.print("  ⤷ " + "Enter the name of the customer: ");
            String customerName = scanner.next();

            // Regular expression pattern for alphabets only (line 132) is taken from external source.
            // Code taken from : TutorialKart
            // URL : https://www.tutorialkart.com/java/how-to-check-if-string-contains-only-alphabets-in-java/#:~:text=To%20check%20if%20String%20contains%20only%20alphabets%20in%20Java%2C%20call,String.&gsc.tab=0

            // check whether the customer name only contain alphabets or not.
            if (customerName.matches("[A-Za-z]+")) {
                while (true) {
                    System.out.print("  ⤷ " + "Where you want to add this customer (Queue1 or Queue2 or Queue3): ");
                    String customerAddQueue = scanner.next();

                    if (customerAddQueue.equalsIgnoreCase("Queue1") || customerAddQueue.equalsIgnoreCase("Queue2") || customerAddQueue.equalsIgnoreCase("Queue3")) {
                        if (customerAddQueue.equalsIgnoreCase("Queue1")) {
                            if (queueOfCashier1[0].equals("X")) {
                                queueOfCashier1[0] = "O";
                                customerNamesOfCashier1[0] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 1 at position 1 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else if (queueOfCashier1[1].equals("X")) {
                                queueOfCashier1[1] = "O";
                                customerNamesOfCashier1[1] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 1 at position 2 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else {
                                System.out.println("      Note: Queue 1 is FULL !!");
                                break;
                            }
                        }
                        else if (customerAddQueue.equalsIgnoreCase("Queue2")) {
                            if (queueOfCashier2[0].equals("X")) {
                                queueOfCashier2[0] = "O";
                                customerNamesOfCashier2[0] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 2 at position 1 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else if (queueOfCashier2[1].equals("X")) {
                                queueOfCashier2[1] = "O";
                                customerNamesOfCashier2[1] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 2 at position 2 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else if (queueOfCashier2[2].equals("X")) {
                                queueOfCashier2[2] = "O";
                                customerNamesOfCashier2[2] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 2 at position 3 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else {
                                System.out.println("      Note: Queue 2 is FULL !!");
                                break;
                            }
                        }
                        else if (customerAddQueue.equalsIgnoreCase("Queue3")) {
                            if (queueOfCashier3[0].equals("X")) {
                                queueOfCashier3[0] = "O";
                                customerNamesOfCashier3[0] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 3 at position 1 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else if (queueOfCashier3[1].equals("X")) {
                                queueOfCashier3[1] = "O";
                                customerNamesOfCashier3[1] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 3 at position 2 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else if (queueOfCashier3[2].equals("X")) {
                                queueOfCashier3[2] = "O";
                                customerNamesOfCashier3[2] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 3 at position 3 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else if (queueOfCashier3[3].equals("X")) {
                                queueOfCashier3[3] = "O";
                                customerNamesOfCashier3[3] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 3 at position 4 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else if (queueOfCashier3[4].equals("X")) {
                                queueOfCashier3[4] = "O";
                                customerNamesOfCashier3[4] = customerName;
                                System.out.println("      ✔ Customer \"" + customerName + "\" added to queue 3 at position 5 successfully.");

                                namesOfVisitedCustomers[totalCustomerCount] = customerName;
                                totalCustomerCount++;

                                break;
                            }
                            else {
                                System.out.println("     Note: Queue 3 is FULL !!");
                                break;
                            }
                        }
                    }
                    else {
                        System.out.println("      Note: Invalid queue selection.");
                        break;
                    }
                }
                break;
            }
            else {
                System.out.println("      ✘ Customer name looks like invalid !!.");
            }
        }

        int queue1 = 0;
        int queue2 = 0;
        int queue3 = 0;

        for (String n : queueOfCashier1) {
            if (n.equals("O")) {
                queue1 += 1;
            }
        }

        for (String n : queueOfCashier2) {
            if (n.equals("O")) {
                queue2 += 1;
            }
        }

        for (String n : queueOfCashier3) {
            if (n.equals("O")) {
                queue3 += 1;
            }
        }

        if (queue1 == 2 && queue2 == 3 && queue3 == 5) {
            System.out.println();
            System.out.println("     Note: All queues are FULL !!");
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static void viewAllEmptyQueues() {
        String[] queueOfCashier1Copy = Arrays.copyOfRange(queueOfCashier1, 0, 2);
        String[] queueOfCashier2Copy = Arrays.copyOfRange(queueOfCashier2, 0, 3);
        String[] queueOfCashier3Copy = Arrays.copyOfRange(queueOfCashier3, 0, 5);

        for (int i = 0; i < 2; i++) {
            if (queueOfCashier1Copy[i].equals("O")) {
                queueOfCashier1Copy[i] = " ";
            }
        }

        for (int i = 0; i < 3; i++) {
            if (queueOfCashier2Copy[i].equals("O")) {
                queueOfCashier2Copy[i] = " ";
            }
        }

        for (int i = 0; i < 5; i++) {
            if (queueOfCashier3Copy[i].equals("O")) {
                queueOfCashier3Copy[i] = " ";
            }
        }
        System.out.println();
        System.out.println("\t" + "*****************");
        System.out.println("\t" + "*    Cashiers   *");
        System.out.println("\t" + "*****************");
        System.out.print("\t" + "  " +  queueOfCashier1Copy[0] + "     " + queueOfCashier2Copy[0] + "     " + queueOfCashier3Copy[0] + "\n");
        System.out.print("\t" + "  " +  queueOfCashier1Copy[1] + "     " + queueOfCashier2Copy[1] + "     " + queueOfCashier3Copy[1] + "\n");
        System.out.print("\t" + "        " + queueOfCashier2Copy[2] + "     " + queueOfCashier3Copy[2] + "\n");
        System.out.print("\t" + "              " + queueOfCashier3Copy[3] + "\n");
        System.out.print("\t" + "              " + queueOfCashier3Copy[4] + "\n");

        System.out.println("\n" + "\t"+ "\"X\" - Not Occupied.");

        // Concept of "StringBuilder" is referred from external source.
        // URL: https://www.simplilearn.com/tutorials/java-tutorial/stringbuilder-in-java#:~:text=StringBuilder%20in%20Java%20is%20a,an%20immutable%20succession%20of%20characters.

        StringBuilder queue1EmptyCount = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            if (queueOfCashier1[i].equals("X")) {
                queue1EmptyCount.append(i + 1);
                queue1EmptyCount.append(", ");
            }
        }

        StringBuilder queue2EmptyCount = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (queueOfCashier2[i].equals("X")) {
                queue2EmptyCount.append(i + 1);
                queue2EmptyCount.append(", ");
            }
        }

        StringBuilder queue3EmptyCount = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (queueOfCashier3[i].equals("X")) {
                queue3EmptyCount.append(i + 1);
                queue3EmptyCount.append(", ");
            }
        }

        System.out.println();

        if (!(queue1EmptyCount.length() - 2 <= 0)) {
            if (queue1EmptyCount.length() > 3) {
                System.out.println("\t" + "⁎ In queue 1 -> positions " + queue1EmptyCount.deleteCharAt(queue1EmptyCount.length() - 2) + " are empty.");
            }
            else {
                System.out.println("\t" + "⁎ In queue 1 -> position " + queue1EmptyCount.deleteCharAt(queue1EmptyCount.length() - 2) + " is empty.");
            }
        }

        if (!(queue2EmptyCount.length() - 2 <= 0)) {
            if (queue2EmptyCount.length() > 3) {
                System.out.println("\t" + "⁎ In queue 2 -> positions " + queue2EmptyCount.deleteCharAt(queue2EmptyCount.length() - 2) + " are empty.");
            }
            else {
                System.out.println("\t" + "⁎ In queue 2 -> position " + queue2EmptyCount.deleteCharAt(queue2EmptyCount.length() - 2) + " is empty.");
            }
        }

        if (!(queue3EmptyCount.length() - 2 <= 0)) {
            if (queue2EmptyCount.length() > 3) {
                System.out.println("\t" + "⁎ In queue 3 -> positions " + queue3EmptyCount.deleteCharAt(queue3EmptyCount.length() - 2) + " are empty.");
            }
            else {
                System.out.println("\t" + "⁎ In queue 3 -> position " + queue3EmptyCount.deleteCharAt(queue3EmptyCount.length() - 2) + " is empty.");
            }
        }

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
                            if (queueOfCashier1[queue1Position - 1].equals("O")) {
                                queueOfCashier1[queue1Position - 1] = "X";
                                System.out.println("      ✔ Customer removed successfully from queue 1 at position " + queue1Position + ".");

                                System.out.println();
                                System.out.println("   ➞ At the time of removing the customer.");
                                viewAllQueues();

                                System.out.println();
                                System.out.println("   ➞ After the removal of customer.");
                                frontMovement();
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
                            if (queueOfCashier2[queue2Position - 1].equals("O")) {
                                queueOfCashier2[queue2Position - 1] = "X";
                                System.out.println("      ✔ Customer removed successfully from queue 2 at position " + queue2Position + ".");

                                System.out.println();
                                System.out.println("   ➞ At the time of removing the customer.");
                                viewAllQueues();

                                System.out.println();
                                System.out.println("   ➞ After the removal of customer.");
                                frontMovement();
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
                            if (queueOfCashier3[queue3Position - 1].equals("O")) {
                                queueOfCashier3[queue3Position - 1] = "X";
                                System.out.println("      ✔ Customer removed successfully from queue 3 at position " + queue3Position + ".");

                                System.out.println();
                                System.out.println("   ➞ At the time of removing the customer.");
                                viewAllQueues();

                                System.out.println();
                                System.out.println("   ➞ After the removal of customer.");
                                frontMovement();
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
                break;
            }
        }
    }

    public static void frontMovement() {
        for (int i = 0; i < 1; i++) {
            if (queueOfCashier1[i].equals("X") && queueOfCashier1[i + 1].equals("O")) {
                queueOfCashier1[i] = "O";
                queueOfCashier1[i + 1] = "X";
            }
        }

        for (int i = 0; i < 2; i++) {
            if (queueOfCashier2[i].equals("X") && queueOfCashier2[i + 1].equals("O")) {
                queueOfCashier2[i] = "O";
                queueOfCashier2[i + 1] = "X";
            }
        }

        for (int i = 0; i < 4; i++) {
            if (queueOfCashier3[i].equals("X") && queueOfCashier3[i + 1].equals("O")) {
                queueOfCashier3[i] = "O";
                queueOfCashier3[i + 1] = "X";
            }
        }
    }
    public static void removeServedCustomerFromQueue() {
        while (true) {
            System.out.print("  ⤷ " + "From which queue you want to remove the served customer (Queue1 or Queue2 or Queue3): ");
            String servedCustomerQueue = scanner.next();

            if (servedCustomerQueue.equalsIgnoreCase("Queue1") || servedCustomerQueue.equalsIgnoreCase("Queue2") || servedCustomerQueue.equalsIgnoreCase("Queue3")) {
                if (servedCustomerQueue.equalsIgnoreCase("Queue1")) {
                    if (queueOfCashier1[0].equals("O")) {
                        queueOfCashier1[0] = "X";
                        pizzaCount -= 10;
                        System.out.println("      ✔ Served customer removed from queue 1 successfully.");

                        System.out.println();
                        System.out.println("   ➞ At the time of removing the customer.");
                        viewAllQueues();

                        for (int i = 0; i < 1; i++) {
                            if (queueOfCashier1[i].equals("X") && queueOfCashier1[i + 1].equals("O")) {
                                queueOfCashier1[i] = "O";
                                queueOfCashier1[i + 1] = "X";
                            }
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
                    if (queueOfCashier2[0].equals("O")) {
                        queueOfCashier2[0] = "X";
                        pizzaCount -= 10;
                        System.out.println("      ✔ Served customer removed from queue 2 successfully.");

                        System.out.println();
                        System.out.println("   ➞ At the time of removing the customer.");
                        viewAllQueues();

                        for (int i = 0; i < 2; i++) {
                            if (queueOfCashier2[i].equals("X") && queueOfCashier2[i + 1].equals("O")) {
                                queueOfCashier2[i] = "O";
                                queueOfCashier2[i + 1] = "X";
                            }
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
                    if (queueOfCashier3[0].equals("O")) {
                        queueOfCashier3[0] = "X";
                        pizzaCount -= 10;
                        System.out.println("      ✔ Served customer removed from queue 3 successfully.");

                        System.out.println();
                        System.out.println("   ➞ At the time of removing the customer.");
                        viewAllQueues();

                        for (int i = 0; i < 4; i++) {
                            if (queueOfCashier3[i].equals("X") && queueOfCashier3[i + 1].equals("O")) {
                                queueOfCashier3[i] = "O";
                                queueOfCashier3[i + 1] = "X";
                            }
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
                System.out.println("      Invalid queue choice.");
                System.out.println("-----------------------------------------------------------------------------------------");
                break;
            }
        }
    }

    public static void customersNameSort() {
        if (!(namesOfVisitedCustomers[0] == null)) {
            int customerCountInQueue1 = 0;
            for (int i = 0; i < 2; i++) {
                if (customerNamesOfCashier1[i] != null) {
                    customerCountInQueue1++;
                }
            }

            int customerCountInQueue2 = 0;
            for (int i = 0; i < 3; i++) {
                if (customerNamesOfCashier2[i] != null) {
                    customerCountInQueue2++;
                }
            }

            int customerCountInQueue3 = 0;
            for (int i = 0; i < 5; i++) {
                if (customerNamesOfCashier3[i] != null) {
                    customerCountInQueue3++;
                }
            }

            String[] queue1CustomerNamesOnly = new String[customerCountInQueue1];
            String[] queue2CustomerNamesOnly = new String[customerCountInQueue2];
            String[] queue3CustomerNamesOnly = new String[customerCountInQueue3];

            for (int i = 0; i < 2; i++) {
                if (customerNamesOfCashier1[i] != null) {
                    queue1CustomerNamesOnly[i] = customerNamesOfCashier1[i];
                }
            }

            for (int i = 0; i < 3; i++) {
                if (customerNamesOfCashier2[i] != null) {
                    queue2CustomerNamesOnly[i] = customerNamesOfCashier2[i];
                }
            }

            for (int i = 0; i < 5; i++) {
                if (customerNamesOfCashier3[i] != null) {
                    queue3CustomerNamesOnly[i] = customerNamesOfCashier3[i];
                }
            }

            for (int j = queue1CustomerNamesOnly.length - 1; j > 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (queue1CustomerNamesOnly[k].compareTo(queue1CustomerNamesOnly[k + 1]) > 0) {
                        String temp = queue1CustomerNamesOnly[k];
                        queue1CustomerNamesOnly[k] = queue1CustomerNamesOnly[k + 1];
                        queue1CustomerNamesOnly[k + 1] = temp;
                    }
                }
            }

            for (int j = queue2CustomerNamesOnly.length - 1; j > 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (queue2CustomerNamesOnly[k].compareTo(queue2CustomerNamesOnly[k + 1]) > 0) {
                        String temp = queue2CustomerNamesOnly[k];
                        queue2CustomerNamesOnly[k] = queue2CustomerNamesOnly[k + 1];
                        queue2CustomerNamesOnly[k + 1] = temp;
                    }
                }
            }

            for (int j = queue3CustomerNamesOnly.length - 1; j > 0; j--) {
                for (int k = 0; k < j; k++) {
                    if (queue3CustomerNamesOnly[k].compareTo(queue3CustomerNamesOnly[k + 1]) > 0) {
                        String temp = queue3CustomerNamesOnly[k];
                        queue3CustomerNamesOnly[k] = queue3CustomerNamesOnly[k + 1];
                        queue3CustomerNamesOnly[k + 1] = temp;
                    }
                }
            }

            System.out.print("   ➞ Sorted customer names in queue1: ");
            for (int j = 0; j < customerCountInQueue1; j++) {
                if (j != customerCountInQueue1 - 1) {
                    System.out.print(queue1CustomerNamesOnly[j]);
                    System.out.print(", ");
                }
                else {
                    System.out.print(queue1CustomerNamesOnly[j]);
                }
            }
            System.out.println();

            System.out.print("   ➞ Sorted customer names in queue2: ");
            for (int j = 0; j < customerCountInQueue2; j++) {
                if (j != customerCountInQueue2 - 1) {
                    System.out.print(queue2CustomerNamesOnly[j]);
                    System.out.print(", ");
                }
                else {
                    System.out.print(queue2CustomerNamesOnly[j]);
                }
            }
            System.out.println();

            System.out.print("   ➞ Sorted customer names in queue3: ");
            for (int j = 0; j < customerCountInQueue3; j++) {
                if (j != customerCountInQueue3 - 1) {
                    System.out.print(queue3CustomerNamesOnly[j]);
                    System.out.print(", ");
                }
                else {
                    System.out.print(queue3CustomerNamesOnly[j]);
                }
            }
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------");
        }
        else {
            System.out.println("     Note: There is no customers to sort.");
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }

    public static void storeDataToFile() {
        // Concept of "BufferedWriter" is referred from external source.
        // URL: https://www.javatpoint.com/java-bufferedwriter-class

        if (namesOfVisitedCustomers[0] != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("SnackKingDetails(A).txt"))){
                writer.write("*********************************");
                writer.newLine();
                writer.write("** SNACK KING CUSTOMER DETAILS **");
                writer.newLine();
                writer.write("*********************************");
                writer.newLine();
                writer.newLine();
                writer.write("Order of visited customers: ");
                writer.newLine();
                for (int i = 0; i < totalCustomerCount; i++) {
                    if (namesOfVisitedCustomers[i] != null) {
                        writer.write("  ➞ " + namesOfVisitedCustomers[i]);
                        writer.newLine();
                    }
                }
                System.out.println("   ✔ Data wrote to the file successfully.");
            } catch (IOException e) {
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

        if (namesOfVisitedCustomers[0] != null) {
            System.out.println();
            try (BufferedReader reader = new BufferedReader(new FileReader("SnackKingDetails(A).txt"))) {
                String textLine;
                while ((textLine = reader.readLine()) != null) {
                    System.out.print("   ");
                    System.out.println(textLine);
                    storeItBackArray[storeItBackCount] = textLine;
                    storeItBackCount++;
                }
            } catch (IOException e) {
                System.out.println("    Note: Error.");
            }
        }
        else {
            System.out.println("    Note: No data to read.");
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
        } catch (InputMismatchException e) {
            System.out.println("      Note: Pizza count must be integer.");
            scanner.next();
        }
    }
}