/**
 * This is an subclass of ArtGalleryVisitor abstract class parent. It is for elite visitors.
 * @author Badal Shrestha
 * Version 1.0
 */
public class EliteVisitor extends ArtGalleryVisitor {
    private boolean assignedPersonalArtAdvisor;
    private boolean exclusiveEventAccess;

    /**
     * Constructs an EliteVisitor with the given details.
     * Initializes assignedPersonalArtAdvisor and exclusiveEventAccess to true.
     *
     * @param visitorId
     * @param fullName
     * @param gender
     * @param contactNumber
     * @param registrationDate
     * @param ticketCost
     * @param ticketType
     */
    public EliteVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate, double ticketCost, String ticketType) {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);

        this.assignedPersonalArtAdvisor = true;
        this.exclusiveEventAccess = true;
    }

    // Getter methods
    public boolean IsAssignedPersonalArtAdvisor() {
        return assignedPersonalArtAdvisor;
    }

    public boolean IsExclusiveEventAccess() {
        return exclusiveEventAccess;
    }

    /**
     * Checks if the visitor is eligible for a personal art advisor.
     * Sets assignedPersonalArtAdvisor to true if rewardPoints > 5000.
     *
     * @return true if eligible for personal art advisor, false otherwise.
     */
    public boolean assignedPersonalArtAdvisor() {
        if (rewardPoints > 5000) {
            this.assignedPersonalArtAdvisor = true;
        }
        return assignedPersonalArtAdvisor;
    }

    /**
     * Checks if the visitor is eligible for exclusive event access.
     * Sets exclusiveEventAccess to true if assignedPersonalArtAdvisor is true.
     *
     * @return true if eligible for exclusive event access, false otherwise.
     */
    public boolean exclusiveEventAccess() {
        if (assignedPersonalArtAdvisor) {
            this.exclusiveEventAccess = true;
        }
        return exclusiveEventAccess;
    }

    /**
     * Allows the visitor to buy an artwork if active and not already bought.
     * Updates purchase details and returns a message indicating the result.
     *
     * @param artworkName
     * @param artworkPrice
     * @return Message indicating the result of the purchase.
     */
    @Override
    public String buyProduct(String artworkName, double artworkPrice) {
        if (isActive) {
            if(!artworkName.isEmpty()){
                if (this.artworkName == null && !artworkName.equals(this.artworkName)) {
                    this.artworkName = artworkName;
                    this.artworkPrice = artworkPrice;

                    isBought = true;
                    buyCount++;
                    return "Thanks for Purchasing";
                } else {
                    return "This product has already been purchased";
                }
            } else {
                return "Artwork Name Can not Be Empty";
            }
        } else {
            return "Kindly login Before Making Purchase";
        }
    }
    
    /**
     * Calculates the discount amount for the visitor if an artwork is bought.
     * Applies 40% discount and updates final price.
     *
     * @return The calculated discount amount.
     */
    @Override
    public double calculateDiscount() {
        if (isBought) {
            this.discountAmount = artworkPrice * 0.40;
            this.finalPrice = artworkPrice - discountAmount;
        }
        return discountAmount;
    }
    
    /**
     * Calculates and updates the reward points for the visitor if an artwork is bought.
     * Adds (final price × 10) to reward points.
     *
     * @return The updated reward points.
     */
    @Override
    public double calculateRewardPoint() {
        if (isBought) {
            this.rewardPoints += finalPrice * 10;
        }
        return rewardPoints;
    }
    
    /**
     * Displays the bill for the visitor, including visitor ID, name, artwork details, discount amount, and final price.
     * If no artwork has been purchased, displays a message indicating so.
     */
    @Override
    public void generateBill() {
        if (isBought) {
            System.out.println("BILL RECEIPT");
            System.out.println("Visitor ID: " + visitorId);
            System.out.println("Visitor Name: " + fullName);
            System.out.println("Artwork Name: " + artworkName);
            System.out.println("Artwork Price: " + artworkPrice);
            System.out.println("Discount Amount: " + discountAmount);
            System.out.println("Final Price: " + finalPrice);
        } else {
            System.out.println("There are no items that you have purchased to generate bill.");
        }
    }
    
    /**
     * Resets the visitor's visit count, cancel count, and reward points if not active and not eligible for advisor or event access.
     * This method is private and used internally for visitor termination.
     */
    private void terminateVisitor() {
        if (!isActive && !assignedPersonalArtAdvisor && !exclusiveEventAccess) {
            this.visitCount = 0;
            this.cancelCount = 0;
            this.rewardPoints = 0.0;
        }
    }
    
    /**
     * Cancels a purchased artwork if conditions are met.
     * Updates cancellation details, calculates refundable amount, and adjusts reward points.
     *
     * @param artworkName
     * @param cancellationReason
     * @return Message indicating the result of the cancellation.
     */
    @Override
    public String cancelProduct(String artworkName, String cancellationReason) {
        if (isBought) {
            if (cancelCount >= 3) {
                terminateVisitor();
            }
            if (buyCount > 0) {
                if (artworkName.equals(this.artworkName)) {
                    this.artworkName = null;
                    this.isBought = false;
                } else {
                    return "The given Artwork name is incorrect";
                }
            }
            if (buyCount == 0) {
                return "You haven't purchased any product to cancel.";
            }

            this.refundableAmount = artworkPrice - (artworkPrice * 0.05);
            this.rewardPoints -= finalPrice * 10;

            this.cancelCount++;
            this.buyCount--;

            this.cancellationReason = cancellationReason;

            return "Your purchase has been successfully cancelled, Your refundable amount is:" + refundableAmount;
        } else {
            return "No Product Has been purchased to cancel.";
        }
    }
    
    /**
     * Displays the visitor's details by calling the parent display method and adds information about
     * personal art advisor and exclusive event access.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Art Advisor: " + assignedPersonalArtAdvisor);
        System.out.println("Exclusive Event Access: " + exclusiveEventAccess);
    }
}
