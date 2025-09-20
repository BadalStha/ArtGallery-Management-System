# Art Gallery Management System

A comprehensive Java-based GUI application for managing art gallery visitors, their registrations, artwork purchases, and visit tracking with different visitor tiers and benefits.

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Classes Description](#classes-description)
- [Installation](#installation)
- [Usage](#usage)
- [Visitor Types](#visitor-types)
- [System Requirements](#system-requirements)
- [Author](#author)

## 🎨 Overview

The Art Gallery Management System is a Java Swing-based desktop application that provides a complete solution for managing art gallery operations. The system handles visitor registration, visit logging, artwork purchases, billing, and visitor record management with two distinct visitor categories: Standard and Elite visitors.

## ✨ Features

- **Visitor Registration**: Register new visitors with personal details
- **Visit Tracking**: Log and track visitor visits to the gallery
- **Dual Visitor Tiers**: Support for Standard and Elite visitor types with different benefits
- **Artwork Purchase System**: Allow visitors to purchase artworks with automated billing
- **Discount System**: Automatic discount calculations based on visitor type and visit history
- **Reward Points**: Points system for Elite visitors
- **Bill Generation**: Generate detailed bills for purchases
- **Data Persistence**: Save and load visitor data from text files
- **Comprehensive GUI**: User-friendly graphical interface with intuitive navigation

## 📁 Project Structure

```
Art Gallery Management System/
│
├── ArtGalleryGUI.java          # Main GUI application class
├── ArtGalleryVisitor.java      # Abstract parent class for all visitors
├── StandardVisitor.java        # Standard visitor implementation
├── EliteVisitor.java          # Elite visitor implementation
├── VisitorDetails.txt         # Data persistence file
└── README.md                  # This file
```

## 🏗️ Classes Description

### ArtGalleryGUI
- **Purpose**: Main application class providing the graphical user interface
- **Features**: 
  - Visitor registration form
  - Visit logging functionality
  - Artwork purchase interface
  - Bill generation and display
  - Data persistence management

### ArtGalleryVisitor (Abstract Class)
- **Purpose**: Base class for all visitor types using abstraction
- **Properties**:
  - Visitor ID, name, gender, contact information
  - Registration date and ticket details
  - Visit count and cancellation tracking
  - Purchase history and reward points
- **Abstract Methods**: Implemented by subclasses for specific visitor behaviors

### StandardVisitor
- **Purpose**: Implementation for standard gallery visitors
- **Features**:
  - Visit limit of 5 visits
  - 10% discount eligibility after reaching visit limit
  - Discount upgrade system
- **Special Benefits**: Discount upgrades based on visit frequency

### EliteVisitor
- **Purpose**: Implementation for premium gallery visitors
- **Features**:
  - Personal art advisor assignment
  - Exclusive event access
  - Enhanced reward points system
- **Special Benefits**: Premium services and exclusive access

## 🚀 Installation

1. **Prerequisites**:
   - Java Development Kit (JDK) 8 or higher
   - Java Swing library (included in standard JDK)

2. **Setup**:
   ```bash
   # Clone or download the project files
   git clone [repository-url]
   cd art-gallery-management-system
   ```

3. **Compilation**:
   ```bash
   # Compile all Java files
   javac *.java
   ```

4. **Execution**:
   ```bash
   # Run the main application
   java ArtGalleryGUI
   ```

## 💻 Usage

1. **Starting the Application**:
   - Run `java ArtGalleryGUI`
   - The main GUI window will appear

2. **Visitor Registration**:
   - Fill in visitor details (ID, name, gender, contact)
   - Select visitor type (Standard or Elite)
   - Set registration date and ticket price
   - Click "Add Visitor" to register

3. **Logging Visits**:
   - Select registered visitor
   - Click "Log Visit" to record a gallery visit
   - System automatically tracks visit counts

4. **Artwork Purchases**:
   - Select visitor and enter artwork details
   - System calculates discounts and final prices
   - Generates detailed bills with breakdown

5. **Viewing Records**:
   - Use "Display Details" to view all visitor information
   - Data is automatically saved to `VisitorDetails.txt`

## 👥 Visitor Types

### Standard Visitors
- **Ticket Price**: Variable (set during registration)
- **Visit Limit**: 5 visits for discount eligibility
- **Discount**: 10% after reaching visit limit
- **Benefits**: Discount upgrade system

### Elite Visitors
- **Ticket Price**: Premium pricing (typically higher)
- **Visit Limit**: No limits
- **Discount**: Premium discount rates
- **Benefits**: 
  - Personal art advisor (when reward points > 5000)
  - Exclusive event access
  - Enhanced reward points system

## 🔧 System Requirements

- **Operating System**: Cross-platform (Windows, macOS, Linux)
- **Java Version**: JDK 8 or higher
- **Memory**: Minimum 512MB RAM
- **Storage**: 50MB available space
- **Display**: 1024x768 minimum resolution

## 📊 Data Format

The system stores visitor data in `VisitorDetails.txt` with the following format:
```
ID | Name | Gender | Contact | Registration Date | Ticket Type | Ticket Price | Artwork Name | Artwork Price | Discount | Reward Points | Total Amount
```

## 🎯 Key Features Explained

### Abstraction Implementation
- Uses abstract `ArtGalleryVisitor` class as base
- Implements polymorphism through visitor type hierarchy
- Encapsulates visitor-specific behaviors in subclasses

### GUI Components
- Swing-based interface with multiple panels
- Form validation and error handling
- Real-time data display and updates
- File I/O for data persistence

### Business Logic
- Automatic discount calculations
- Visit tracking and limit management
- Reward points system for Elite visitors
- Cancellation tracking with limits

## 👨‍💻 Author

**Badal Shrestha**
- Student ID: 24058961
- Version: 1.0
- Contact: Available in the application

## 📝 License

This project is developed as an academic assignment. All rights reserved by the author.

## 🤝 Contributing

This is an academic project. For suggestions or improvements, please contact the author.

## 📞 Support

For technical support or questions about the application, please refer to the code documentation or contact the author through the provided contact information.

---

*Last updated: September 2025*