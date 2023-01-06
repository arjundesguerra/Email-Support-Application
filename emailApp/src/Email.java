import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String suffix = "company.com";
    private int defaultPaswordLength = 8;

    // Constructor to receive first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department, then return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = generatePassword(defaultPaswordLength);
        System.out.println("Your password is " + this.password);

        // Combine elements to generate an email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + suffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " + firstName + "\nDepartment codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice == 1) {
            return "Sales";
        } else if (choice == 2) {
            return "Development";
        } else if (choice == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String generatePassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int random = (int)(Math.random() * passwordSet.length());
             password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set a mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }

    public String getAlternateEmail() { return alternateEmail; }

    public String getPassword() { return password; }

    public String showInfo() {
        return "Display name: " + firstName + " " + lastName+
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";

    }

}


