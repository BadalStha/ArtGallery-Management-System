/**
 * This is an subclass of ArtGalleryVisitor abstract class parent. It is for standard visitors.
 * @author Badal Shrestha
 * Version 1.0
 */
public class StandardVisitor extends ArtGalleryVisitor {
    private boolean isEligibleForDiscountUpgrade;
    private final int visitLimit;
    private float discountPercent;

    /**
     * Constructs a StandardVisitor with the given details.
     * Initializes visit limit to 5, discount percent to 0.10, and eligibility for discount upgrade to false.
     *
     * @param visitorId
     * @param fullName
     * @param gender
     * @param contactNumber
     * @param registrationDate
     * @param ticketCost
     * @param ticketType
     */
    public StandardVisitor(int visitorId, String fullName, String gender, String contactNumber, String registrationDate, double ticketCost, String ticketType) {
        super(visitorId, fullName, gender, contactNumber, registrationDate, ticketCost, ticketType);
        this.visitLimit = 5;
        this.discountPercent = 0.10f;
        this.isEligibleForDiscountUpgrade = false;
    }

    // Getter methods
    public boolean IsEligibleForDiscountUpgrade() {
        return isEligibleForDiscountUpgrade;
    }

    public final int getVisitLimit() {
        return visitLimit;
    }

    public float getDiscountPercent() {
        return discountPercent;
    }

    /**
     * Checks if the visitor is eligible for a discount upgrade.
     * If visit count reaches the limit, sets eligibility to true and increases discount percent.
     *
     * @return true if eligible for discount upgrade, false otherwise.
     */
    boolean checkDiscountUpgrade() {
        if (visitCount >= visitLimit) {
            this.isEligibleForDiscountUpgrade = true;
            this.discountPercent = 0.15f;
        }
        return isEligibleForDiscountUpgrade;
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
     * Applies discount percent and updates final price.
     *
     * @return The calculated discount amount.
     */
    @Override
    public double calculateDiscount() {
        if (isBought) {
            checkDiscountUpgrade();
            if (isEligibleForDiscountUpgrade) {
                this.discountAmount = artworkPrice * discountPercent;
                this.finalPrice = artworkPrice - discountAmount;
            } else {
                this.discountAmount = artworkPrice * discountPercent;
                this.finalPrice = artworkPrice - discountAmount;
            }
        } else {
            this.discountAmount = 0.0;
        }
        return discountAmount;
    }

    /**
     * Calculates and updates the reward points for the visitor if an artwork is bought.
     * Adds (final price × 5) to reward points.
     *
     * @return The updated reward points.
     */
    @Override
    public double calculateRewardPoint() {
        if (isBought) {
            this.rewardPoints += finalPrice * 5;
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
     * Resets the visitor's visit count, cancel count, and reward points if not active and not eligible for discount upgrade.
     * This method is private and used internally for visitor termination.
     */
    private void terminateVisitor() {
        if (!isActive && !isEligibleForDiscountUpgrade) {
            this.visitCount = 0;
            this.cancelCount = 0;
            this.rewardPoints = 0;
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
                return ("You haven't purchased any product to cancel.");
            }

            this.refundableAmount = artworkPrice - (artworkPrice * 0.10);
            this.rewardPoints -= finalPrice * 5;

            this.cancelCount++;
            this.buyCount--;

            this.cancellationReason = cancellationReason;


            return ("Your purchase has been successfully cancelled, Your refundable amount is:" + refundableAmount);
        } else {
            return ("No Product Has been purchased to cancel.");
        }
    }

    /**
     * Displays the visitor's details by calling the parent display method and adds information about
     * discount eligibility, visit limit, and discount percent.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Discount available: " + isEligibleForDiscountUpgrade);
        System.out.println("Times You can Visit: " + visitLimit);
        System.out.println("Discount Percent: " + discountPercent);
    }

}
