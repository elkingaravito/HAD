package snk.nucleo;;


public class OrderDetail {
   
   String itemNumber = null;
   String description = null;
   Double price = 0.0;
   int quantity = 0;
   
   public String getItemNumber() {
       return itemNumber;
   }
   public void setItemNumber(String itemNumber) {
       this.itemNumber = itemNumber;
   }
   public String getDescription() {
       return description;
   }
   public void setDescription(String description) {
       this.description = description;
   }
   public Double getPrice() {
       return price;
   }
   public void setPrice(Double price) {
       this.price = price;
   }
   public int getQuantity() {
       return quantity;
   }
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }

}