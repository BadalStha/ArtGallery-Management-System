/**
 * This class is Parent Class of StandarVisitor and EliteVisitor. It is an abstract class which contains five abstract methods. Abstract class parent
 * has been used to achieve abstraction and to provide a base for subclasses.
 * @author Badal Shrestha
 * Version 1.0
 */

public abstract class ArtGalleryVisitor {
    protected int visitorId;
    protected String fullName;
    protected String gender;
    protected String contactNumber;
    protected String registrationDate;
    protected double ticketCost;
    protected String ticketType;
    protected int visitCount;
    protected final int cancelLimit;
    protected int cancelCount;
    protected String cancellationReason;
    protected boolean isActive;
    protected boolean isBought;
    protected int buyCount;
    protected double finalPrice;
    protected double discountAmount;
    protected double rewardPoints;
    protected double refundableAmount;
    protected String artworkName;
    protected double artworkPrice;

    /**
     * Constructor to initialize an ArtGalleryVisitor with basic details and default values.
     * 
     * @param visitorId
     * @param fullName
     * @param gender
     * @param contactNumber
     * @param registrationDate
     * @param ticketCost
     * @param ticketType
     */
    public ArtGalleryVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate, double ticketCost, String ticketType) {
        this.visitorId = visitorId;
        this.fullName = fullName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.registrationDate = registrationDate;
        this.ticketCost = ticketCost;
        this.ticketType = ticketType;

        this.visitCount = 0;
        this.rewardPoints = 0.0;
        this.cancelCount = 0;
        this.buyCount = 0;
        this.discountAmount = 0.0;
        this.finalPrice = 0.0;
        this.refundableAmount = 0.0;
        this.isActive = false;
        this.isBought = false;
        this.cancellationReason = null;
        this.cancelLimit = 3;

    }
    
    // Getter Methods
    public int getVisitorId(){
        return visitorId;
    }

    public String getFullName(){
        return fullName;
    }

    public String getGender(){
        return gender;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public String getRegistrationDate(){
        return registrationDate;
    }

    public double getTicketCost(){
        return ticketCost;
    }

    public String getTicketType(){
        return ticketType;
    }

    public int getVisitCount(){
        return visitCount;
    }

    public double getRewardsPoints(){
        return rewardPoints;
    }

    public final int getCancelLimit(){
        return cancelLimit;
    }

    public int getCancelCount(){
        return cancelCount;
    }

    public String getCancellationReason(){
        return cancellationReason;
    }

    public double getRefundableAmount(){
        return refundableAmount;
    }

    public boolean IsActive(){
        return isActive;
    }

    public boolean IsBought(){
        return isBought;
    }

    public int getBuyCount(){
        return buyCount;
    }

    public double getFinalPrice(){
        return finalPrice;
    }

    public double getDiscountAmount(){
        return discountAmount;
    }

    public String getArtworkName(){
        return artworkName;
    }

    public double getArtworkPrice(){
        return artworkPrice;
    }

    // Setter Methods
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    /**
     * Increments the visit count and marks the visitor as active.
     */
    public void logVisit(){
        this.visitCount++;
        this.isActive = true;
    }

    /**
     * Abstract method to buy artwork, to be implemented in subclasses.
     * @param artworkName
     * @param artworkPrice
     * @return Message after purchase.
     */
    public abstract String buyProduct(String artworkName, double artworkPrice);

    /**
     * Abstract method to calculate discount, to be implemented in subclasses.
     * @return Calculated discount amount.
     */
    public abstract double calculateDiscount();

    /**
     * Abstract method to calculate reward points, to be implemented in subclasses.
     * @return Calculated reward points.
     */
    public abstract double calculateRewardPoint();

    /**
     * Abstract method to cancel a product, to be implemented in subclasses.
     * @param artworkName
     * @param cancellationReason
     * @return Message after cancellation.
     */
    public abstract String cancelProduct(String artworkName, String cancellationReason);

    /**
     * Abstract method for generating bill, to be implemented in subclasses.
     */
    public abstract void generateBill();

    /**
     * Displays visitor details such as id, name, gender, phone number, ticket price, ticket type, and visit count.
     */
    public void display(){
        System.out.println("Visitor Details:");
        System.out.println("Id: "+ visitorId);
        System.out.println("Name: " + fullName);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + contactNumber);
        System.out.println("Ticket Price: " + ticketCost);
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Visit Count: " + visitCount);
    }
}