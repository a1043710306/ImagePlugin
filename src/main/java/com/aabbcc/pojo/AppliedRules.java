/**
  * Copyright 2022 json.cn 
  */
package com.aabbcc.pojo;
import java.util.Date;

/**
 * Auto-generated: 2022-06-22 15:12:45
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class AppliedRules {

    private String id;
    private Date endDate;
    private DiscountSetting discountSetting;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setEndDate(Date endDate) {
         this.endDate = endDate;
     }
     public Date getEndDate() {
         return endDate;
     }

    public void setDiscountSetting(DiscountSetting discountSetting) {
         this.discountSetting = discountSetting;
     }
     public DiscountSetting getDiscountSetting() {
         return discountSetting;
     }

}