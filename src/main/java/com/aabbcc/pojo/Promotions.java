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
public class Promotions {

    private List<PromotionalOffers> promotionalOffers;
    private List<String> upcomingPromotionalOffers;
    public void setPromotionalOffers(List<PromotionalOffers> promotionalOffers) {
         this.promotionalOffers = promotionalOffers;
     }
     public List<PromotionalOffers> getPromotionalOffers() {
         return promotionalOffers;
     }

    public void setUpcomingPromotionalOffers(List<String> upcomingPromotionalOffers) {
         this.upcomingPromotionalOffers = upcomingPromotionalOffers;
     }
     public List<String> getUpcomingPromotionalOffers() {
         return upcomingPromotionalOffers;
     }

}