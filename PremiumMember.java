class PremiumMember extends GymMember {
    // attributes with private access modifier to make them only accessible withing the 
    // declared class.
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    // Constructor for the premium member 
    public PremiumMember(int id, String name, String location, String phone, String email, 
    String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false; // isFullPayment set to false by default
        this.paidAmount = 0; // paidAmount set to 0
        this.discountAmount = 0; // discountAmount set to 0
    }

    // Accessor Methods to access the attribute inside the constructor
    public double getPremiumCharge() {
        return premiumCharge; 
    }
    public String getPersonalTrainer() {
        return personalTrainer; 
    }
    public boolean getIsFullPayment() {
        return isFullPayment; 
    }
    public double getPaidAmount() {
        return paidAmount; 
    }
    public double getDiscountAmount() {
        return discountAmount; 
    }

    // Implement markAttendance method which increases the attendance by 1 each time this 
    // method iss invoked. also loyaltyPoints increasess by 10 points
    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints += 10;
    }

    // Pay Due Amount Method 
    // this accepts paidAmount ass a parameter.
    public String payDueAmount(double amount) {
        if (isFullPayment) {
            return "Payment is already completed.";
        }
        if (this.paidAmount + amount > premiumCharge) {
            return "Payment exceeds premium charge. Please enter a valid amount.";
        }
        // the recieved Amount is added on the paidAmount attribute
        this.paidAmount += amount;
        // deducting the new total paid amount from premiumCharge to find the remaining amount
        double remainingAmount = premiumCharge - this.paidAmount;
        // if paidAmount is equal to premiumCharge then the isFullPayment is set to true otherwise
        // is set to false by default
        this.isFullPayment = this.paidAmount == premiumCharge;
        return "Payment successful. Remaining amount: " + remainingAmount;
    }

    // Calculate Discount Method if the member has done fullpayment
    // to get discount the member should do full payment
    public void calculateDiscount() {
        if (this.isFullPayment) {
            // 10% discount = 0.1 of premiumCharge
            this.discountAmount = 0.1 * premiumCharge;
            System.out.println("Discount applied: " + discountAmount);
        } else {
            //if no fullpayment is done then suitable message is displaye
            System.out.println("No discount available. Full payment required.");
        }
    }

    // Revert Premium Member Method
    public void revertPremiumMember() {
        super.resetMember(); // calling resetMember() from the GymMember class
        this.personalTrainer = ""; // reseting the personalTrainer to none using empty String
        this.isFullPayment = false; // setting isFullPayment to false
        this.paidAmount = 0; // setting paid amount to 0
        this.discountAmount = 0; // setting discount amount to 0
    }

    // Display Method to display the premiumMember detail
    public void display() {
        super.displayMemberInfo(); // calling the dispalyMemberInfo() method from GymMember class
        // that has all the required details of the gym member
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment Status: " + (isFullPayment ? "Yes" : "No"));
        double remainingAmount = premiumCharge - this.paidAmount;
        System.out.println("Remaining Amount to be Paid: " + remainingAmount);
        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}