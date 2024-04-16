import java.lang.StringBuilder;
import java.util.ArrayList;
public class FoodQueue {
    private final Customer[] customerArray;

    public FoodQueue(int queueSize) {
        customerArray = new Customer[queueSize];

        // Assign customer objects to each position of the "customerArray".
        for (int i = 0; i < queueSize; i++) {
            customerArray[i] = new Customer();
        }
    }

    public int getCustomerArraySize() {
        return customerArray.length;
    }

    public Customer getArrayElement(int k) {
        return customerArray[k];
    }

    public String printMark(int position) {
        if (customerArray[position - 1].getFirstName().equals("X")) {
            return "  X   ";
        }
        else {
            return "  O   ";
        }
    }

    public String printSpaceForEmpty(int position) {
        if (!customerArray[position - 1].getFirstName().equals("X")) {
            return "      ";
        }
        else {
            return "  X   ";
        }
    }

    public boolean checkEmpty(int position) {
        return customerArray[position].getFirstName().equals("X");
    }

    public void listOutEmptyPositions(int queueNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n = 0; n < customerArray.length; n++) {
            if (checkEmpty(n)) {
                stringBuilder.append(n + 1);
                stringBuilder.append(", ");
            }
        }

        if (!(stringBuilder.length() - 2 <= 0)) {
            if (stringBuilder.length() > 3) {
                System.out.println("\t" + "⁎ In queue " + queueNumber + " -> positions " + stringBuilder.deleteCharAt(stringBuilder.length() - 2) + " are empty.");
            }
            else {
                System.out.println("\t" + "⁎ In queue " + queueNumber + " -> position " + stringBuilder.deleteCharAt(stringBuilder.length() - 2) + " is empty.");
            }
        }
    }

    public void setDataToFront() {
        for (int n = 0; n < customerArray.length - 1; n++) {
            if (checkEmpty(n) && !checkEmpty(n + 1)) {
                String temp1 = getArrayElement(n + 1).getFirstName();
                String temp2 = getArrayElement(n + 1).getSecondName();
                int temp3 = getArrayElement(n + 1).getID();
                int temp4 = getArrayElement(n + 1).getNumberOfPizzaRequired();

                getArrayElement(n + 1).setCustomerDetails("X", null, 0 , 0);

                getArrayElement(n).setCustomerDetails(temp1, temp2, temp3, temp4);
            }
        }
    }

    public void sortingProcess(int queueNumber) {
        ArrayList<String> sortFirstName = new ArrayList<>();
        for (int n = 0; n < customerArray.length; n++) {
            if (!checkEmpty(n)) {
                sortFirstName.add(customerArray[n].getFirstName());
            }
        }

        for (int n = sortFirstName.size() - 1; n > 0; n--) {
            for (int m = 0; m < n; m++) {
                if (sortFirstName.get(m).compareTo(sortFirstName.get(m + 1)) > 0) {
                    String temp = sortFirstName.get(m);
                    sortFirstName.remove(m);
                    sortFirstName.add(m + 1, temp);
                }
            }
        }

        System.out.print("   ➞ Sorted customer names in queue " + queueNumber + ": ");
        for (String element : sortFirstName) {
            if (!((sortFirstName.get(sortFirstName.size() - 1)).equals(element))) {
                System.out.print(element);
                System.out.print(", ");
            }
            else {
                System.out.print(element);
            }
        }
        System.out.println();
    }

    public int pizzaAmount(int position) {
        return customerArray[position].getNumberOfPizzaRequired() * 1350;
    }

    public void setCustomerFromWaiting(int position, Customer customer) {
        customerArray[position - 1].setCustomerDetails(customer.getFirstName(), customer.getSecondName(), customer.getID(), customer.getNumberOfPizzaRequired());
        customer.setCustomerDetails("X", null, 0, 0);
    }
}
