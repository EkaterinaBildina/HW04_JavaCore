package OnlineShop;

import OnlineShop.exceptions.CustomerNotExistException;
import OnlineShop.exceptions.ProductNotExistException;
import OnlineShop.exceptions.QuantityException;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws CustomerNotExistException, ProductNotExistException, QuantityException {
        System.out.println("online shop");

//        OnlineShop.getCustomerList().add(new Customer("Ivanov Ivan", LocalDate.of(1987, 12, 9), "+9867566473"));
//        OnlineShop.getCustomerList().add(new Customer("Petrov Petr", LocalDate.of(1988, 12, 20), "+9867566475"));

        Customer femaleCustomer = new Customer("Ekaterina Bildina", LocalDate.of(1988, 7, 13), "+79858886645", Gender.OTHER);
        femaleCustomer.setGender(Gender.FEMALE);
        OnlineShop.getCustomerList().add(femaleCustomer);

        OnlineShop.getCustomerList().add(new Customer("Ivanov Ivan", LocalDate.of(1987, 12, 9), "+9867566473", Gender.MALE));
        OnlineShop.getCustomerList().add(new Customer("Petrov Petr", LocalDate.of(1988, 12, 20), "+9867566475", Gender.MALE));


        OnlineShop.getProductList().add(new Product("apple", BigDecimal.valueOf(10L)));
        OnlineShop.getProductList().add(new Product("pineapple", BigDecimal.valueOf(50L)));
        OnlineShop.getProductList().add(new Product("milk", BigDecimal.valueOf(8L)));


        try {
            Order order = null;
            order = OnlineShop.buyProduct("Ivanov Ivan", "apple", "20");


            OnlineShop.getOrderList().add(order);
            System.out.println(OnlineShop.getOrderList());

            Order order2 = OnlineShop.buyProduct("Ivanov Ivan", "apple", "20");
            OnlineShop.getOrderList().add(order2);
            System.out.println(OnlineShop.getOrderList());

            Order order3 = OnlineShop.buyProduct("Petrov Petr", "pineapple", "300");
            OnlineShop.getOrderList().add(order3);

            Order order4 = OnlineShop.buyProduct("Ekaterina Bildina", "milk", "1");
            OnlineShop.getOrderList().add(order4);

        } catch (QuantityException e) {
            OnlineShop.getOrderList().add(OnlineShop.buyProduct(e.getCustomer(), e.getProduct(), "1"));
        } catch (ProductNotExistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw e;
        }

        System.out.println(OnlineShop.getOrderList());
        System.out.println(OnlineShop.getOrderList().size() + " orders received");


        Congradulations wishYouRequest = new Congradulations();
        wishYouRequest.congratulateWithHolidays(OnlineShop.getCustomerList());

    }

}