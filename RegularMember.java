public class RegularMember extends GymMember{
    private int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //constructor for the class RegularMember
    public RegularMember(int id, String name, String location, String phone, String email,
    String gender,String DOB, String membershipStartDate, String referralSource){
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = "";
    }
    
    //getter methods
    public int getAttendanceLimit() { 
        return attendanceLimit; 
    }
    public boolean isEligibleForUpgrade() { 
        return isEligibleForUpgrade; 
    }
    public String getRemovalReason() { 
        return removalReason; 
    }
    public String getReferralSource() { 
        return referralSource; 
    }
    public String getPlan(){
        return plan;
    }
    public double getPrice(){
        return price;
    }
    
    //implementation of markAttendance method that checks if the member is eligible for upgrade
    //if the number of attendance is greater than attendance limit 30 add it adds 5 loyaltypoints
    //for every one attendance
    @Override
    public void markAttendance(){
        this.attendance++;
        this.loyaltyPoints += 5;
        if(this.attendance >= this.attendanceLimit){
            this.isEligibleForUpgrade = true;
        }
    }
    
    // Get Plan Price Method to display the price for every plan 
    //the plan data is converted into lowercase and checks the case and returns value 
    //accordingly
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic": 
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default: 
                return -1;
        }
    }

    // A method to upgradePlan is set to upgrade the plan subscribed by the member
    // only if the member is elligible for upgrade. this method accepts plan as a parameter.
    // if the user is eligible for upgrade then the plan and price will be updated accordingly
    // calling getPlanPrice() method. if not eligible then appropriate messsage is displayed after 
    // validation
    public String upgradePlan(String newPlan) {
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Invalid plan selected.";
        }
        if (!isEligibleForUpgrade) {
            return "Not eligible for upgrade yet.";
        }
        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "You are already subscribed to this plan.";
        }
        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded to " + newPlan + " successfully.";
    }

    // Revert Regular Member Method which accepts removalReason as parameter.
    // superclass resetMember() is called here and isEligibleForUpgrade is set to false.
    // plan is set to basic and price is set to 6500.
    public void revertRegularMember(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "Basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    // Display Method to display the regular member detail
    public void display(){
        super.displayMemberInfo(); // calling the displayMemberInfo() method from GymMember class
        // that displays the member detail
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}


