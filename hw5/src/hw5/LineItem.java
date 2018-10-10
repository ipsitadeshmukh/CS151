package hw5;
/**
   A line item in an invoice.
*/
public interface LineItem
{
   /**
      Gets the price of this line item.
      @return the price
   */
   double getPrice();
   /**
      Gets the description of this line item.
      @return the description
   */   
   String toString();
   /**
    * Returns the quantity of this line item.
    * @return the quantity
    */
   int getQty();
   /**
    * Increments quantity by 1
    */
   void setQty();
}
