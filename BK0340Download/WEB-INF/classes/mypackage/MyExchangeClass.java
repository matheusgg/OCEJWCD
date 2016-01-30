package mypackage;

public class MyExchangeClass { 

    public static float exchangeConversion(String from, String to, float amount) { 
        float calculatedAmount = 0.0f;

        /* Example implementation code: */
        if(from.equals("GBP") && to.equals("USD")) {
            calculatedAmount = amount*1.5f;
        }

        return calculatedAmount; 
    }

}