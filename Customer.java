public class Customer {
    private String firstName;
    private String secondName;
    private int ID;
    private int numberOfPizzaRequired;

    public Customer() {
        this.firstName = "X";
        this.secondName = null;
        this.ID = 0;
        this.numberOfPizzaRequired = 0;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public int getID() {
        return this.ID;
    }

    public int getNumberOfPizzaRequired() {
        return this.numberOfPizzaRequired;
    }

    public void setCustomerDetails(String firstName, String secondName, int ID, int numberOfPizzaRequired) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.ID = ID;
        this.numberOfPizzaRequired = numberOfPizzaRequired;
    }
}
