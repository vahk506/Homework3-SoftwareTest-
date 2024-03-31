import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountStatusTest {

// ---------------checkAccountActivity--------------------
    @Test
    void testCheckAccountActivityActive() {
        AccountStatus accountStatus = new AccountStatus();
        String result = accountStatus.checkAccountActivity(100); // less than 365 days
        Assertions.assertEquals("Account is active", result);
    }
    @Test
    void testCheckAccountActivityActiveEquality() {
        AccountStatus accountStatus = new AccountStatus();

        String resultAtBoundary = accountStatus.checkAccountActivity(365); // equal to 365 days
        Assertions.assertEquals("Account is inactive", resultAtBoundary);

        String resultBeyondBoundary = accountStatus.checkAccountActivity(500); // more than 365 days
        Assertions.assertEquals("Account is inactive", resultBeyondBoundary);
    }


// ---------------checkAccountActivity--------------------

//-----------------CheckBalance--------------------------------
    @Test
    void testCheckBalanceOverdrawn() {
        AccountStatus accountStatus = new AccountStatus();

        String resultBelowBoundary = accountStatus.checkBalance(-10.0); // negative balance
        Assertions.assertEquals("Your account is overdrawn", resultBelowBoundary);

        String resultAtBoundary = accountStatus.checkBalance(0.0); // negative balance
        Assertions.assertEquals("Your account is overdrawn", resultAtBoundary);
    }

    @Test
    void testCheckBalanceLow(){
        AccountStatus accountStatus = new AccountStatus();

        String result1 = accountStatus.checkBalance(20.0); // positive balance < 100
        Assertions.assertEquals("Your balance is low", result1);

        String result2 = accountStatus.checkBalance(99.9); // positive balance < 100
        Assertions.assertEquals("Your balance is low", result2);
    }

    @Test
    void testCheckBalanceHealthyExactly(){
        AccountStatus accountStatus = new AccountStatus();

        String resultAtBoundary = accountStatus.checkBalance(100.0); // positive balance < 100
        Assertions.assertEquals("Your balance is healthy", resultAtBoundary);

        String resultAtBeyond = accountStatus.checkBalance(100.1); // positive balance < 100
        Assertions.assertEquals("Your balance is healthy", resultAtBeyond);
    }
//---------------CheckBalance------------------------------

//-----------------checkForPremiumStatus-----------------
@Test
    void testDoesNotQualifyForPremium() {
        AccountStatus accountStatus = new AccountStatus();

        String result = accountStatus.checkForPremiumStatus(1000, 5);
        Assertions.assertEquals("You do not qualify for premium status", result);

        String result1 = accountStatus.checkForPremiumStatus(10000, 10);
        Assertions.assertEquals("You do not qualify for premium status", result1);

        String result2 = accountStatus.checkForPremiumStatus(20000, 9);
        Assertions.assertEquals("You do not qualify for premium status", result2);

        String result3 = accountStatus.checkForPremiumStatus(5000, 20);
        Assertions.assertEquals("You do not qualify for premium status", result3);

        String result4 = accountStatus.checkForPremiumStatus(9999, 9);
        Assertions.assertEquals("You do not qualify for premium status", result4);
}
    @Test
    void testQualifiesForPremiumJustAbove() {
        AccountStatus accountStatus = new AccountStatus();
        String result = accountStatus.checkForPremiumStatus(10001, 11);
        Assertions.assertEquals("You qualify for premium status", result);
    }

//-----------------checkForPremiumStatus-----------------


//----------------suggestAccountUpdate------------------
    @Test
    void testSuggestAccountUpdateNotNeeded() {
    AccountStatus accountStatus = new AccountStatus();
    // Test for years below the threshold
    String resultBelowTheRequirement = accountStatus.suggestAccountUpdate(4);
    Assertions.assertEquals("No update needed.", resultBelowTheRequirement);

    // Test exactly at the threshold
    String resultAtRequirement = accountStatus.suggestAccountUpdate(5);
    Assertions.assertEquals("No update needed.", resultAtRequirement);
}

    @Test
    void testSuggestAccountUpdateNeeded() {
        AccountStatus accountStatus = new AccountStatus();
        // Test for years just above the threshold
        String resultJustAbove = accountStatus.suggestAccountUpdate(6);
        Assertions.assertEquals("Consider updating your account details.", resultJustAbove);
    }

//----------------suggestAccountUpdate------------------

//------------checkEmailVerification--------------
@Test
void testEmailVerificationStatusVerified() {
    AccountStatus accountStatus = new AccountStatus();
    String resultVerified = accountStatus.checkEmailVerification(true);
    Assertions.assertEquals("Email verified", resultVerified);
}

    @Test
    void testEmailVerificationStatusNotVerified() {
        AccountStatus accountStatus = new AccountStatus();
        String resultNotVerified = accountStatus.checkEmailVerification(false);
        Assertions.assertEquals("Email not verified", resultNotVerified);
    }
//--------------checkEmailVerification----------

}
