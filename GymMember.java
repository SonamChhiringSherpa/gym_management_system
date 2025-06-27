abstract class GymMember{
    //Attributes with protected access modifier
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    //constructor with all the necessary attributes for the GymMember class
    public GymMember(int id,String name,String location,
    String phone,String email,String gender,String DOB,String membershipStartDate){
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0; // by default the attendance is 0
        this.loyaltyPoints = 0.0; // loyaltyPoint is also 0 by default
        this.activeStatus = false; // default activeStatus is set to false
    }
    
    //getter method for each attributes that returns the value when method is called
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getDOB(){
        return DOB;
    }
    public String getMembershipStartDate(){
        return membershipStartDate;
    }
    public int getAttendance(){
        return attendance;
    }
    public double getLoyaltyPoints(){
        return loyaltyPoints;
    }
    public boolean getActiveStatus(){
        return activeStatus;
    }
    
    //void abstract method markAttendance to track attendance of the member.
    public abstract void markAttendance();
    
    //method to set active status to true when the member needs to be activated or renewed
    public void activateMembership(){
        this.activeStatus = true;
    }
    
    //method to set the active status to false if the membership needs to be deactivated or paused.
    public void deactivateMembership(){
        if(this.activeStatus){
        this.activeStatus = false;
        }
        else{
            System.out.println("The Membership is already inactive.");
        }
    }
    
    //reset method to reset the members activestatus to false and 
    //set the attendance and loyaltyPoints to 0.
    public void resetMember(){
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
    }
    
    //display method to display all the details of a member.
    public void displayMemberInfo(){
        System.out.println("Gym Member Details:");
        System.out.println("ID: "+ id);
        System.out.println("Name: "+ name);
        System.out.println("Location: "+ location);
        System.out.println("Phone: "+ phone);
        System.out.println("Email: "+ email);
        System.out.println("Gender: "+ gender);
        System.out.println("Date of Birth: "+ DOB);
        System.out.println("Membership Start Date: "+ membershipStartDate);
        System.out.println("Attendance: "+ attendance);
        System.out.println("Loyalty Points: "+ loyaltyPoints);
        System.out.println("Active Status: "+ (activeStatus ? "Active" : "Inactive"));
    }
}