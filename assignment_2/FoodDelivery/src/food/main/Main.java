package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.service.OrderService;
import food.model.PremiumOrder;
import food.model.Discountable;
import food.utility.OrderUtility;


public class Main {
    public static void main(String[] args)
    {
        FoodOrder[] orders= new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Rahul", 500);
        orders[1] = new PremiumOrder(102, "Priya", 800);
        orders[2] = new RegularOrder(103, "Aman", 650);
        orders[3] = new PremiumOrder(104, "Simran", 1200);
        orders[4] = new RegularOrder(105, "Karan", 450);
        orders[5] = new PremiumOrder(106, "Neha", 1000);
        OrderService service = new OrderService();

        for(FoodOrder order: orders)
        {
            if(!OrderUtility.validateAmount(order.getAmount())){
                System.out.println("Invalid amount for Order ID:"+order.getOrderId());
                continue;
            }
            if(!OrderUtility.validateCustomerName(order.getCustomerName())){
                System.out.println("Invalid customer name for Order ID:"+order.getOrderId());
                continue;
            }

            service.displayBill(order);
        }
        FoodOrder.displayTotalOrders();
    }
}
