package food.service;

import food.model.FoodOrder;
import food.model.Discountable;
public class OrderService {
    public double calculateFinalAmount(FoodOrder order)
    {
        double discount=((Discountable) order).applyDiscount();
        double deliveryCharge=order.calculateDeliveryCharge();

        return order.getAmount()-discount+deliveryCharge;
    }
    public void displayBill(FoodOrder order)
    {
        Discountable discountable = (Discountable) order;

        double amount= order.getAmount();
        double discount= discountable.applyDiscount();
        double delivery=order.calculateDeliveryCharge();
        double finalAmount=amount-discount+delivery;

        System.out.println("----------------------------");
        order.displayBasicDetails();

        System.out.println("Bill Amount     :Rs."+amount);
        System.out.println("Discount        :Rs"+discount);
        System.out.println("Delivery Charge :Rs"+delivery);
        System.out.println("Final Payable.  :Rs"+finalAmount);
        System.out.println("----------------------------------------");
    }

}
