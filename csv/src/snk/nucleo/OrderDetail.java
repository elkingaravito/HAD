package snk.nucleo;;


/**
 */
public class OrderDetail {
   
   String itemNumber = null;
   String description = null;
   Double price = 0.0;
   int quantity = 0;
   
   /**
    * Method getItemNumber.
    * @return String
    */
   public String getItemNumber() {
       return itemNumber;
   }
   /**
    * Method setItemNumber.
    * @param itemNumber String
    */
   public void setItemNumber(String itemNumber) {
       this.itemNumber = itemNumber;
   }
   /**
    * Method getDescription.
    * @return String
    */
   public String getDescription() {
       return description;
   }
   /**
    * Method setDescription.
    * @param description String
    */
   public void setDescription(String description) {
       this.description = description;
   }
   /**
    * Method getPrice.
    * @return Double
    */
   public Double getPrice() {
       return price;
   }
   /**
    * Method setPrice.
    * @param price Double
    */
   public void setPrice(Double price) {
       this.price = price;
   }
   /**
    * Method getQuantity.
    * @return int
    */
   public int getQuantity() {
       return quantity;
   }
   /**
    * Method setQuantity.
    * @param quantity int
    */
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }

}