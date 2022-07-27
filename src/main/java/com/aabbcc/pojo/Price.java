/**
  * Copyright 2022 json.cn 
  */
package com.aabbcc.pojo;
import java.util.List;

/**
 * Auto-generated: 2022-06-22 15:12:45
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Price {

    private TotalPrice totalPrice;
    private List<LineOffers> lineOffers;
    public void setTotalPrice(TotalPrice totalPrice) {
         this.totalPrice = totalPrice;
     }
     public TotalPrice getTotalPrice() {
         return totalPrice;
     }

    public void setLineOffers(List<LineOffers> lineOffers) {
         this.lineOffers = lineOffers;
     }
     public List<LineOffers> getLineOffers() {
         return lineOffers;
     }

}