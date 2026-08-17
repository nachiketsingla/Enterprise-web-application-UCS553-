package food.model;
public abstract class FoodOrder{
    private int orderId;
    private String customerName;
    private double amount;

    protected static String restaurantName="Food Palace";

    private static int orderCounter=0;
    public FoodOrder(int orderId,String customerName,double amount)
    {
        this.orderId=orderId;
        this.customerName=customerName;
        this.amount=amount;
        orderCounter++;
    }
    public int getOrderId()
    {
        return orderId;
    }
    public void setOrderId(int orderId)
    {
        this.orderId=orderId;
    }
    public String getCustomerName()
    {
        return customerName;
    }
    public void setcustomerName(String customerName)
    {
        this.customerName=customerName;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount)
    {
        this.amount=amount;
    }
    public static void displayTotalOrders()
    {
        System.out.println("Total Orders Created:"+orderCounter);
    }
    public abstract double calculateDeliveryCharge();

    public void displayBasicDetails(){

        System.out.println("Restaurant:"+restaurantName);
        System.out.println("Order Id"+orderId);
        System.out.println("Customer:"+customerName);
        System.out.println("Amount: Rs."+amount);
    }
}