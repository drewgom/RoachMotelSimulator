/* PaymentLogger.java
 * Homework Assignment: TERM PROJECT
 * Andrew Gomez, Alexandra Felsted
 * Due: 12/09/2019
 */

package RoachMotel;

import java.io.File;

public class PaymentLogger {

    /**The file to write all payments to*/
    String paymentLog;
    /**The only payment logger*/
    private volatile static PaymentLogger paymentLogger = null;


    private PaymentLogger()
    {
        paymentLog = "";
    }

    public static PaymentLogger getPaymentLogger()
    {
        if (paymentLogger == null)
        {
            synchronized (PaymentLogger.class)
            {
                if (paymentLogger == null)
                {
                    PaymentLogger.paymentLogger = new PaymentLogger();
                }
            }

        }
        return paymentLogger;
    }

    public void writeToLogger(double amount, PaymentMethod payment)    {
        paymentLog = paymentLog + payment + " was charged $" + amount + "\n";
    }

    @Override
    public String toString() {
        return paymentLog;
    }
}
