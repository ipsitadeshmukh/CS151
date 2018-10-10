package hw5;
/**
   A product with a price and description.
*/
public class Product implements LineItem
{
   /**
      Constructs a product.
      @param description the description
      @param price the price
   */
   public Product(String description, double price)
   {
      this.description = description;
      this.price = price;
      qty = 1;
   }
   public int getQty() {return qty; }
   public void setQty() { qty++;} 
   public double getPrice() { return price; }
   public String toString() { return description; }
   private String description;
   private double price;
   private int 	  qty; 
}
