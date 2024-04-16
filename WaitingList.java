public class WaitingList {
    private final Customer[] waitingList;

    private int front;

    private int rear;

    public WaitingList(int queueSize) {
        waitingList = new Customer[queueSize];

        for (int n = 0; n < queueSize; n++) {
            waitingList[n] = new Customer();
        }

        front = -1;
        rear = -1;
    }

    public void addToWaitingList(String customerFirstName, String customerSecondName, int customerIdNumber, int customerPizzaRequired) {
        if ((front == 0 && rear == waitingList.length - 1) || (front == rear + 1)) {
            System.out.println();
            System.out.println("     Note: Waiting queue is FULL !!");
        }
        else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % this.waitingList.length;
            waitingList[rear].setCustomerDetails(customerFirstName, customerSecondName, customerIdNumber, customerPizzaRequired);
            System.out.println();
            System.out.println("      ✔ Customer \"" + customerFirstName + " " + customerSecondName + "\" added to WAITING QUEUE successfully.");
        }
    }

    public Customer removeFromWaitingList() {
        Customer removedCustomer = waitingList[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            front = (front + 1) % this.waitingList.length;
        }
        return removedCustomer;
    }

    public boolean checkWaiting() {
        return this.front != -1;
    }

    public boolean checkAtLeastOneEmpty() {
        int emptyCount = 0;
        for (Customer element : waitingList) {
            if (element.getFirstName().equals("X")) {
                emptyCount++;
            }
        }
        return emptyCount != 0;
    }
}
