import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShortDateConverter {
    public static void main(String[] args) {
        // Step 1: Ask the user to enter a short date
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a short date (YYYY-MM-DD): ");
        String shortDateInput = scanner.nextLine();

        try {
            // Step 2: Extract year, month, and day
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(shortDateInput);

            // Extracting year, month, and day
            SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
            SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd");

            int year = Integer.parseInt(yearFormat.format(date));
            int month = Integer.parseInt(monthFormat.format(date));
            int day = Integer.parseInt(dayFormat.format(date));

            // Step 3: Convert month number to month name
            String monthName = convertMonthNumberToName(month);

            // Step 4: Display the full date representation
            System.out.println("Full Date Representation: " + monthName + " " + day + ", " + year);

        } catch (ParseException | NumberFormatException e) {
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
        } finally {
            scanner.close();
        }
    }

    private static String convertMonthNumberToName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        if (month >= 1 && month <= 12) {
            return monthNames[month];
        } else {
            return "Invalid Month";
        }
    }
}
