package OnlineShop;

import java.time.LocalDate;
import java.util.List;

public class Congradulations {
    public void congratulateWithHolidays(List<Customer> customers) {
        LocalDate todayDate = LocalDate.now();
        Holiday holiday = Holiday.NONE;
        if (todayDate.getDayOfMonth() == 1 && todayDate.getMonthValue() == 1) {
            holiday = Holiday.NEW_YEAR;
        }
        if (todayDate.getDayOfMonth() == 8 && todayDate.getMonthValue() == 3) {
            holiday = Holiday.EIGHT_OF_MARCH;
        }
        if (todayDate.getDayOfMonth() == 23 && todayDate.getMonthValue() == 2) {
            holiday = Holiday.TWENTY_THREE_OF_FEBRUARY;
        }

        for (Customer customer : customers) {
            switch (holiday) {
                case NEW_YEAR:
                    System.out.println(customer.getFIO() + " We Wish You a Merry Christmas and Happy New Year!");
                    break;
                case TWENTY_THREE_OF_FEBRUARY:
                    if (customer.getGender() == Gender.MALE) {
                        System.out.println(customer.getFIO() + " We Wish You a February 23!");
                    }
                    break;
                case EIGHT_OF_MARCH:
                    if (customer.getGender() == Gender.FEMALE) {
                        System.out.println(customer.getFIO() + " We Wish You a Happy Women's Day!");
                    }
                    break;
            }
        }
    }
}
