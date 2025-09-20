import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.FileWriter;
import java.io.FileReader;

/**
 * Art Gallery Management System GUI
 *
 * This class provides a graphical user interface for managing an art gallery
 * visitor system. It allows to add visitors. log visits, purchase artworks,
 * generate bills and display visitor details.
 *
 * The art gallery has two types of visitors: Standard and Elite, each visitor
 * ticket price is different with its benefit.
 *
 * @author Badal Shrestha
 * @version 1.0
 */
public class ArtGalleryGUI {

    private JFrame frame, recordFrame;

    private JPanel mainPanel, detailsPanel, displayPanel, buttonPanel, genderPanel, comboPanel, typePanel;

    private JLabel idLabel, nameLabel, genderLabel, contactLabel, dateLabel, typeLabel, priceLabel, artworkNameLabel,
            artworkPriceLabel, cancelReasonLabel;

    private JTextField idField, nameField, contactField, priceField, artworkNameField, artworkPriceField,
            cancelReasonField;

    private JTextArea displayArea, fileArea;

    private JRadioButton maleBtn, femaleBtn, otherBtn;

    private ButtonGroup genderGroup;

    private JComboBox<String> monthCombo, dayCombo, yearCombo, typeCombo;

    private JButton addVisitorBtn, logVisitBtn, buyProductBtn, assignPersonalArtAdvisorBtn, checkUpgradeBtn,
            calculateDiscountBtn, calculateRewardPointsBtn,
            cancelProductBtn, generateBillBtn, displayVisitorDetailsBtn, clearFieldsBtn, saveToFileBtn, readFromFileBtn;

    private String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    private String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30" };
    private String[] year = { "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015",
            "2014", "2013", "2012", "2011", "2010", "2009",
            "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996",
            "1995", "1994", "1993", "1992", "1991", "1990", "1989",
            "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976",
            "1975", "1974", "1973", "1972", "1971", "1970", "1969",
            "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956",
            "1955", "1954", "1953", "1952", "1951", "1950", "1949",
            "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936",
            "1935", "1934", "1933", "1932", "1931", "1930", "1929",
            "1928", "1927", "1926", "1925" };
    private String[] type = { "Standard", "Elite" };
    private ArrayList<ArtGalleryVisitor> artGalleryVisitorList;

    /**
     * Constructor for ArtGalleryGUI.
     * 
     * Initializes the GUI system, including all components, layouts, and event
     * listeners.
     * Sets up the main window, panels, and all user interface elements for managing
     * visitors,
     * purchases, and records in the art gallery system.
     */
    public ArtGalleryGUI() {
        // Initializing arraylist
        artGalleryVisitorList = new ArrayList<>();

        // Section for setting up frame
        frame = new JFrame("Art Gallery Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);

        // Initializing Panels
        mainPanel = new JPanel(new BorderLayout());
        detailsPanel = new JPanel(new GridLayout(10, 2, 10, 20));
        displayPanel = new JPanel();
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        genderPanel = new JPanel();
        comboPanel = new JPanel();
        typePanel = new JPanel();

        // Setting Border For Panel to create space on the left and right side
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        displayPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Initializing Detail panel gui Components
        idLabel = new JLabel("Visitor ID:");
        idField = new JTextField();

        nameLabel = new JLabel("Full Name:");
        nameField = new JTextField();

        genderLabel = new JLabel("Gender:");
        genderGroup = new ButtonGroup();
        maleBtn = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        otherBtn = new JRadioButton("Other");

        contactLabel = new JLabel("Contact Number:");
        contactField = new JTextField();

        dateLabel = new JLabel("Registration Date:");
        monthCombo = new JComboBox<>(month);
        dayCombo = new JComboBox<>(day);
        yearCombo = new JComboBox<>(year);

        typeLabel = new JLabel("Ticket Type:");
        typeCombo = new JComboBox<>(type);

        priceLabel = new JLabel("Ticket Price:");
        priceField = new JTextField("1000");

        artworkNameLabel = new JLabel("Artwork's Name:");
        artworkNameField = new JTextField();

        artworkPriceLabel = new JLabel("Artwork's Price:");
        artworkPriceField = new JTextField();

        cancelReasonLabel = new JLabel("Cancellation Reason:");
        cancelReasonField = new JTextField();

        // Adding gui components of details panel
        detailsPanel.add(idLabel);
        detailsPanel.add(idField);

        detailsPanel.add(nameLabel);
        detailsPanel.add(nameField);

        detailsPanel.add(genderLabel);
        genderPanel.add(maleBtn);
        genderPanel.add(femaleBtn);
        genderPanel.add(otherBtn);
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        genderGroup.add(otherBtn);
        detailsPanel.add(genderPanel);

        detailsPanel.add(contactLabel);
        detailsPanel.add(contactField);

        detailsPanel.add(dateLabel);
        comboPanel.add(monthCombo);
        comboPanel.add(dayCombo);
        comboPanel.add(yearCombo);
        detailsPanel.add(comboPanel);

        detailsPanel.add(typeLabel);
        typePanel.add(typeCombo);
        detailsPanel.add(typePanel);

        detailsPanel.add(priceLabel);
        priceField.setEditable(false);
        detailsPanel.add(priceField);

        detailsPanel.add(artworkNameLabel);
        detailsPanel.add(artworkNameField);

        detailsPanel.add(artworkPriceLabel);
        detailsPanel.add(artworkPriceField);

        detailsPanel.add(cancelReasonLabel);
        detailsPanel.add(cancelReasonField);

        // Setting Size of the details panel and type combo
        detailsPanel.setPreferredSize(new Dimension(800, 500));
        typeCombo.setPreferredSize(new Dimension(200, 25));

        // Initializing Textarea for the display panel
        displayArea = new JTextArea(37, 70);
        displayArea.setEditable(false);
        displayPanel.add(displayArea);

        // Initializing buttons for the button panel
        addVisitorBtn = new JButton("Add Visitor");
        logVisitBtn = new JButton("Log Visit");
        buyProductBtn = new JButton("Buy Product");
        assignPersonalArtAdvisorBtn = new JButton("Assign Personal Art Advisor");
        checkUpgradeBtn = new JButton("Check Upgrade");
        calculateDiscountBtn = new JButton("Calculate Discount");
        calculateRewardPointsBtn = new JButton("Calculate Reward Points");
        cancelProductBtn = new JButton("Cancel Product");
        generateBillBtn = new JButton("Generate Bill");
        displayVisitorDetailsBtn = new JButton("Display Visitor Details");
        clearFieldsBtn = new JButton("Clear Fields");
        saveToFileBtn = new JButton("Save to File");
        readFromFileBtn = new JButton("Read from File");

        // Setting Preferred Size of Button
        addVisitorBtn.setPreferredSize(new Dimension(200, 50));
        logVisitBtn.setPreferredSize(new Dimension(200, 50));
        buyProductBtn.setPreferredSize(new Dimension(200, 50));
        assignPersonalArtAdvisorBtn.setPreferredSize(new Dimension(200, 50));
        checkUpgradeBtn.setPreferredSize(new Dimension(200, 50));
        calculateDiscountBtn.setPreferredSize(new Dimension(200, 50));
        calculateRewardPointsBtn.setPreferredSize(new Dimension(200, 50));
        cancelProductBtn.setPreferredSize(new Dimension(200, 50));
        generateBillBtn.setPreferredSize(new Dimension(200, 50));
        displayVisitorDetailsBtn.setPreferredSize(new Dimension(200, 50));
        clearFieldsBtn.setPreferredSize(new Dimension(200, 50));
        saveToFileBtn.setPreferredSize(new Dimension(200, 50));
        readFromFileBtn.setPreferredSize(new Dimension(200, 50));

        // Adding Buttons to Button Panel
        buttonPanel.add(addVisitorBtn);
        buttonPanel.add(logVisitBtn);
        buttonPanel.add(buyProductBtn);
        buttonPanel.add(assignPersonalArtAdvisorBtn);
        buttonPanel.add(checkUpgradeBtn);
        buttonPanel.add(calculateDiscountBtn);
        buttonPanel.add(calculateRewardPointsBtn);
        buttonPanel.add(cancelProductBtn);
        buttonPanel.add(generateBillBtn);
        buttonPanel.add(displayVisitorDetailsBtn);
        buttonPanel.add(clearFieldsBtn);
        buttonPanel.add(saveToFileBtn);
        buttonPanel.add(readFromFileBtn);
        buttonPanel.setPreferredSize(new Dimension(50, 250));

        // Adding Items to frame and Main Panel
        mainPanel.add(detailsPanel, BorderLayout.WEST);
        mainPanel.add(displayPanel, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);

        // Setting the frame visibility to true
        frame.setVisible(true);

        /**
         * Add Visitor Button Action Listener.
         * Adds a new visitor to the system after validating all input fields and
         * checking for duplicate IDs.
         * Displays appropriate messages for success or validation errors.
         *
         * @param e
         */
        addVisitorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Do you want to Submit?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    String idText = idField.getText().trim();
                    int id;
                    if (idText.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Id Field is required!", "Empty Field",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    try {
                        id = Integer.parseInt(idText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String name = nameField.getText().trim();
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Name Field is required!", "Empty Field",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String gender = "";
                    if (maleBtn.isSelected()) {
                        gender = "Male";
                    }
                    if (femaleBtn.isSelected()) {
                        gender = "Female";
                    }
                    if (otherBtn.isSelected()) {
                        gender = "Other";
                    }
                    if (gender.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Selection of Gender is required!", "No Selection",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String contact = contactField.getText().trim();
                    if (contact.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Contact Field is required!", "Empty Field",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    String month = (String) monthCombo.getSelectedItem();
                    String day = (String) dayCombo.getSelectedItem();
                    String year = (String) yearCombo.getSelectedItem();

                    String[] date = { month, day, year };
                    String allDate = String.join("/", date);

                    String type = (String) typeCombo.getSelectedItem();

                    String priceText = priceField.getText().trim().replace("Rs.", "");
                    double price = Double.parseDouble(priceText);

                    for (ArtGalleryVisitor v : artGalleryVisitorList) {
                        if (v.getVisitorId() == id) {
                            JOptionPane.showMessageDialog(frame, "Visitor already Exists", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    if (type.equals("Standard")) {
                        artGalleryVisitorList.add(new StandardVisitor(id, name, gender, contact, allDate, price, type));
                    } else {
                        artGalleryVisitorList.add(new EliteVisitor(id, name, gender, contact, allDate, price, type));
                    }

                    String display = "Visitor Added!\n" + "ID: " + id + "\nName: " + name + "\nGender: " + gender
                            + "\nContact: " + contact + "\nDate: "
                            + allDate + "\nTicket Type: " + type + "\nTicket Cost: " + price;
                    displayArea.setText(display);
                    JOptionPane.showMessageDialog(frame, "Visitor Added Successfully", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        /**
         * Log Visit Button Action Listener.
         * Activates a visitor's account and increments their visit count after
         * validating the visitor ID.
         * Displays appropriate messages for success or errors.
         *
         * @param e
         */
        logVisitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");
                int id;

                for (ArtGalleryVisitor v : artGalleryVisitorList) {

                    if (searchId.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Id Field is required!", "Empty Field",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    try {
                        id = Integer.parseInt(searchId);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if (v.getVisitorId() == id) {
                        v.logVisit();

                        String display = "Account activated!\n" + "Visit Count: " + v.visitCount + "\nActive: "
                                + v.isActive;
                        displayArea.setText(display);

                        JOptionPane.showMessageDialog(frame, "Visitor is Active now!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);

                        return;
                    } else {
                        JOptionPane.showMessageDialog(frame, "No Such visitor has been added!", "Not Found",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                }

            }
        });

        /**
         * Buy Product Button Action Listener.
         * Handles the purchase of an artwork by a visitor after validating visitor ID,
         * artwork name, and price.
         * Updates purchase details and displays confirmation or error messages.
         *
         * @param e
         */
        buyProductBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                int result = JOptionPane.showConfirmDialog(frame, "Do you want purchase the Artwork?", "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {

                    for (ArtGalleryVisitor v : artGalleryVisitorList) {
                        if (v.isActive) {

                            String name = artworkNameField.getText().trim();
                            if (name.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Artwork Name field is required!", "Empty Field",
                                        JOptionPane.WARNING_MESSAGE);
                                return;
                            }

                            String priceText = (String) artworkPriceField.getText().trim();
                            double price;
                            if (priceText.isEmpty()) {
                                JOptionPane.showMessageDialog(frame, "Artwork Price field is required!", "Empty Field",
                                        JOptionPane.WARNING_MESSAGE);
                                return;
                            }

                            try {
                                price = Double.parseDouble(priceText);
                                System.out.println(price);
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(frame, "Price must be in digits!", "Validation Error",
                                        JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                            if (v.getVisitorId() == id) {
                                if (name.equals(v.getArtworkName())) {
                                    JOptionPane.showMessageDialog(frame, "This artwork has already been purchased!",
                                            "Not Avialable", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }

                                v.buyProduct(name, price);

                                String display = "Artwork Purchased Successfully!\n" + "Artwork Name: "
                                        + v.getArtworkName() + "\nArtwork Price: " +
                                        v.getArtworkPrice();

                                displayArea.setText(display);

                                JOptionPane.showMessageDialog(frame, "Purchased Successfully", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                return;
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Visitor Should be Active!", "Inactive",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    }
                }
            }
        });

        /**
         * Assign Personal Art Advisor Button Action Listener.
         * Assigns a personal art advisor to eligible elite visitors based on their
         * reward points.
         * Displays assignment status messages.
         *
         * @param e
         */
        assignPersonalArtAdvisorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");
                int id;
                if (searchId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Id Field is required!", "Empty Field",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    id = Integer.parseInt(searchId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (ArtGalleryVisitor v : artGalleryVisitorList) {
                    if (v instanceof EliteVisitor) {
                        EliteVisitor ev = (EliteVisitor) v;
                        boolean assign = ev.assignedPersonalArtAdvisor();
                        if (assign) {
                            JOptionPane.showMessageDialog(frame, "Visitor is assigned to Personal Art Advisor",
                                    String.valueOf(assign),
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Visitor is not assigned to Personal Art Advisor",
                                    String.valueOf(assign),
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            }
        });

        /**
         * Check Upgrade Button Action Listener.
         * Checks if a standard visitor is eligible for a discount upgrade based on
         * their visit count.
         * Displays upgrade eligibility status.
         *
         * @param e
         */
        checkUpgradeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");
                int id;
                if (searchId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Id Field is required!", "Empty Field",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    id = Integer.parseInt(searchId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (ArtGalleryVisitor v : artGalleryVisitorList) {
                    if (v.getVisitorId() == id) {
                        if (v instanceof StandardVisitor) {
                            StandardVisitor sv = (StandardVisitor) v;
                            String upgradable = String.valueOf(sv.checkDiscountUpgrade());
                            JOptionPane.showMessageDialog(frame, upgradable, "Upgradeable Check",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(frame, "This button is only for Standard Visitors.",
                                    "Not Standard", JOptionPane.WARNING_MESSAGE);
                        }
                        return;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Visitor not found.", "Not Found",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        /**
         * Calculate Discount Button Action Listener.
         * Calculates and displays the discount for a visitor after validating the
         * visitor ID.
         *
         * @param e
         */
        calculateDiscountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");
                int id;
                if (searchId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Id Field is required!", "Empty Field",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    id = Integer.parseInt(searchId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (ArtGalleryVisitor v : artGalleryVisitorList) {
                    if (v instanceof StandardVisitor) {
                        StandardVisitor sv = (StandardVisitor) v;
                        double discount = sv.calculateDiscount();
                        displayArea.setText("Standard Visitor ID: " + sv.getVisitorId() +
                                " | Discount: " + discount + "\n");

                    } else if (v instanceof EliteVisitor) {
                        EliteVisitor ev = (EliteVisitor) v;
                        double discount = ev.calculateDiscount();
                        displayArea.setText("Elite Visitor ID: " + ev.getVisitorId() +
                                " | Discount: " + discount + "\n");
                    }
                }

            }
        });

        /**
         * Calculate Reward Points Button Action Listener.
         * Calculates and displays the reward points for a visitor after validating the
         * visitor ID.
         *
         * @param e
         */
        calculateRewardPointsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");
                int id;

                try {
                    id = Integer.parseInt(searchId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (ArtGalleryVisitor v : artGalleryVisitorList) {
                    if (v instanceof StandardVisitor) {
                        StandardVisitor sv = (StandardVisitor) v;
                        double rewardPoint = sv.calculateRewardPoint();
                        displayArea.setText("Standard Visitor ID: " + sv.getVisitorId() +
                                " | Reward Point: " + rewardPoint + "\n");

                    } else if (v instanceof EliteVisitor) {
                        EliteVisitor ev = (EliteVisitor) v;
                        double rewardPoint = ev.calculateRewardPoint();
                        displayArea.setText("Elite Visitor ID: " + ev.getVisitorId() +
                                " | Reward Point: " + rewardPoint + "\n");
                    }
                }
            }
        });

        /**
         * Cancel Product Button Action Listener
         *
         * This listener handles the cancellation of artwork purchases. It
         * validates visitor ID, artwork name, and cancellation reason before
         * cancelling.
         *
         * @param e
         */
        cancelProductBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");
                int id;

                try {
                    id = Integer.parseInt(searchId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                for (ArtGalleryVisitor v : artGalleryVisitorList) {
                    if (v.isBought) {
                        String name = artworkNameField.getText().trim();
                        if (name.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Artwork Name field is required!", "Empty Field",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        String cancel = cancelReasonField.getText().trim();
                        if (cancel.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Cancellation reason field is required!",
                                    "Empty Field", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        if (v.getVisitorId() == id) {
                            v.cancelProduct(name, cancel);
                            String display = "Artwork Has been Successfully Cancelled!\n" + "Artwork Name: " + name
                                    + "\nCancellation Reason: "
                                    + v.getCancellationReason() + "\nRefund Amount: " + v.refundableAmount;
                            displayArea.setText(display);
                            JOptionPane.showMessageDialog(frame, "Artwork Cancelled Successfully!", "Cancellation",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "None Product has been Purchased!", "Does Not Exist",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                }

            }
        });

        /**
         * Generate Bill Button Action Listener.
         * Generates and displays a bill for a visitor's purchase after validating the
         * visitor ID.
         * Shows a detailed bill or error messages if no purchase exists.
         *
         * @param e
         */
        generateBillBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");
                int id;
                try {
                    id = Integer.parseInt(searchId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for (ArtGalleryVisitor v : artGalleryVisitorList) {
                    if (v.getVisitorId() == id) {
                        if (v.isBought) {
                            v.generateBill();
                            String display = "BILL RECIPT!\n" + "Visitor ID: " + v.visitorId + "\nVisitor Name: "
                                    + v.fullName + "\nArtwork Name: "
                                    + v.artworkName + "\nArtwork Price: " + v.artworkPrice + "\nDiscount Amount: "
                                    + v.discountAmount + "\nFinal Price: "
                                    + v.finalPrice;

                            displayArea.setText(display);
                            JOptionPane.showMessageDialog(frame, "Bill has Been Generated!", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            return;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Purchase an Artwork to generate bill.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "The user with does not exist.");
                    }
                }
            }
        });

        /**
         * Display Visitor Details Button Action Listener.
         * Displays all personal and registration details of a visitor after validating
         * the visitor ID.
         *
         * @param e
         */
        displayVisitorDetailsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchId = JOptionPane.showInputDialog(frame, "Enter a Visitor Id:");

                int id;

                for (ArtGalleryVisitor v : artGalleryVisitorList) {
                    if (v.isActive) {
                        if (searchId.isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Id Field is required!", "Empty Field",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        try {
                            id = Integer.parseInt(searchId);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Id must be a number!", "Validation Error",
                                    JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                        if (v.getVisitorId() == id) {
                            v.display();

                            String display = "Visitor Details!\n" + "ID: " + v.getVisitorId() + "\nName: "
                                    + v.getFullName() + "\nGender: " + v.getGender()
                                    + "\nContact: " + v.getContactNumber() + "\nDate: " + v.getRegistrationDate()
                                    + "\nTicket Type: " + v.getTicketType()
                                    + "\nTicket Cost: " + v.getTicketCost();

                            displayArea.setText(display);
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Visitor Activation is needed!", "Not Active",
                                JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                }

            }
        });

        /**
         * Clear Fields Button Action Listener.
         * Clears all input fields and resets combo boxes to default values after user
         * confirmation.
         *
         * @param e
         */
        clearFieldsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(frame, "Do you want to clear?", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (result == JOptionPane.YES_OPTION) {
                    idField.setText("");
                    nameField.setText("");
                    contactField.setText("");
                    monthCombo.setSelectedIndex(0);
                    dayCombo.setSelectedIndex(0);
                    yearCombo.setSelectedIndex(0);
                    typeCombo.setSelectedIndex(0);
                    priceField.setText("1000");
                    artworkNameField.setText("");
                    artworkPriceField.setText("");
                    cancelReasonField.setText("");
                    displayArea.setText("");
                }
            }
        });

        /**
         * Save to File Button Action Listener.
         * Saves all visitor records to a text file, writing the header only if the file
         * is new or empty.
         * Formats numeric values to two decimal places and prevents duplicate entries.
         *
         * @param e
         */
        saveToFileBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    java.io.File file = new java.io.File("VisitorDetails.txt");
                    boolean isNewFile = file.length() == 0;
                    FileWriter writer = new FileWriter(file, true);

                    if (isNewFile) {
                        writer.write(String.format(
                                "%-5s %-20s %-10s %-15s %-20s %-15s %-12s %-20s %-15s %-15s %-15s %-15s\n",
                                "ID", "Name", "Gender", "Contact Number", "Registration Date", "Ticket Type",
                                "Ticket Price", "Artwork Name", "Artwork Price", "Discount", "Reward Points.",
                                "Total Amount"));
                    }

                    for (ArtGalleryVisitor v : artGalleryVisitorList) {
                        String artworkName = v.getArtworkName();
                        String artworkPrice = String.format("%.2f", v.getArtworkPrice());

                        String discount = "-";
                        if (v.discountAmount > 0) {
                            discount = String.format("%.2f", v.discountAmount);
                        }
                        String reward = "-";
                        if (v instanceof StandardVisitor) {
                            StandardVisitor sv = (StandardVisitor) v;
                            reward = String.format("%.2f", sv.calculateRewardPoint());
                        }
                        if (v instanceof EliteVisitor) {
                            EliteVisitor ev = (EliteVisitor) v;
                            reward = String.format("%.2f", ev.calculateRewardPoint());
                        }
                        String total = "-";
                        if (v.finalPrice > 0) {
                            total = String.format("%.2f", v.finalPrice);
                        }
                        writer.write(String.format(
                                "%-5s %-20s %-10s %-15s %-20s %-15s %-12s %-20s %-15s %-15s %-15s %-15s\n",
                                v.getVisitorId(),
                                v.getFullName(),
                                v.getGender(),
                                v.getContactNumber(),
                                v.getRegistrationDate(),
                                v.getTicketType(),
                                v.getTicketCost(),
                                artworkName,
                                artworkPrice,
                                discount,
                                reward,
                                total));
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Visitor details added to VisitorDetails.txt", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Unable to write to file.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        /**
         * Read from File Button Action Listener.
         * Reads and displays the contents of the visitor records file in a new window
         * using a monospaced font.
         *
         * @param e ActionEvent triggered when Read from File button is clicked.
         */
        readFromFileBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recordFrame = new JFrame("Visitor Records");
                fileArea = new JTextArea(30, 100);
                fileArea.setEditable(false);
                fileArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));

                String visitorDetailFile = "";
                try {
                    FileReader reader = new FileReader("VisitorDetails.txt");
                    int character;
                    while ((character = reader.read()) != -1) {
                        visitorDetailFile += (char) character;
                    }
                    reader.close();
                    fileArea.setText(visitorDetailFile);
                } catch (Exception ex) {
                    fileArea.setText("Unable to read from VisitorDetails.txt.\n");
                }
                recordFrame.add(new javax.swing.JScrollPane(fileArea));
                recordFrame.pack();
                recordFrame.setLocationRelativeTo(frame);
                recordFrame.setVisible(true);
            }
        });

        /**
         * Type ComboBox Item Listener.
         * Updates the ticket price field based on the selected ticket type.
         *
         * @param e ItemEvent triggered when the ticket type combo box selection
         *          changes.
         */
        typeCombo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String type = (String) typeCombo.getSelectedItem();
                if (type.equals("Standard")) {
                    priceField.setText("1000");
                } else {
                    priceField.setText("2000");
                }
            }
        });
    }

    /**
     * Main method to launch the Art Gallery Management System GUI.
     *
     * @param args
     */
    public static void main(String[] args) {
        new ArtGalleryGUI();
    }
}
