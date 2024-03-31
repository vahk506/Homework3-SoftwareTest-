public class AccountStatus {
    // Method to check if the account is active based on the last login time (in days)
    public String checkAccountActivity(int daysSinceLastLogin) {
        if (daysSinceLastLogin >= 365) {
            return "Account is inactive";
        } else {
            return "Account is active";
        }
    }

    // Method to check balance and return a message
    public String checkBalance(double balance) {
        if (balance <= 0) {
            return "Your account is overdrawn";
        } else if (balance < 100) {
            return "Your balance is low";
        } else {
            return "Your balance is healthy";
        }
    }

    // Method to determine if the user qualifies for premium status
    public String checkForPremiumStatus(double balance, int transactionsPerMonth) {
        if (balance > 10000 && transactionsPerMonth > 10) {
            return "You qualify for premium status";
        } else {
            return "You do not qualify for premium status";
        }
    }

    // Method to suggest updating account based on the time since account creation (in years)
    public String suggestAccountUpdate(int yearsSinceCreation) {
        if (yearsSinceCreation > 5) {
            return "Consider updating your account details.";
        } else {
            return "No update needed.";
        }
    }
    // Method to check Email Verification
    public String checkEmailVerification(boolean isEmailVerified) {
        if (isEmailVerified) {
            return "Email verified";
        } else {
            return "Email not verified";
        }
    }
}
