AndroidMobileNumberVerification
===============================

 A sample android app that validates user entered mobile number based identity. It sends an SMS to the number entered by the user, and intercepts the SMS to verify it. If the user enters a wrong mobile number, the verification fails. Useful for mobile apps and games that want to use phone number as unique id.

What it does?

1. Seeks a phone number from the user.
2. Sends an SMS to the mobile number entered by the user.
3. Intercepts the SMS to read the message it had sent (in #2)

If the message is received successfully, then the mobile number can be considered as verified. 

Variations:

This sample app sends the message from the users device directly. A variation can to have a third party service send an SMS, which is then intercepted by the app (#3)...
