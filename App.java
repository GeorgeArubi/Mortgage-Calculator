import java.text.NumberFormat;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {int loan;
            double rate;
            double monthlyRate;
            int years;
            int noMonths;
    
            while (true){
                System.out.print("Principal: ");
                loan = scanner.nextInt();
                if (loan >= 1000 && loan <= 1_000_000)
                    break;
                System.out.println("Enter a value between 1,000 and 1,000,000");
            }
    
            while (true) {
                System.out.print("Annual Interest Rate: ");
                rate = scanner.nextDouble();
                if (rate >= 1 && rate <=30) {
                    monthlyRate = (rate/100) / 12;
                    break;
                }
                System.out.println("Enter a value between 1 and 30");
            }
    
            while (true) {
                System.out.print("Period (Years): ");
                years = scanner.nextInt();
                if (years >=1 && years <= 30){
                    noMonths = years * 12;
                    break;
                }
                System.out.println("Enter a value between 1 and 30");
            }
    
            double finalPayment;
            finalPayment = (double) loan *
                    ((monthlyRate * Math.pow((1 + monthlyRate), noMonths)) /
                            ((Math.pow((1 + monthlyRate), noMonths)) - 1));
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String result = currency.format(finalPayment);
            System.out.println("Mortgage: " + result);
        }
    }
}
