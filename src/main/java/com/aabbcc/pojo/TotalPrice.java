/**
  * Copyright 2022 json.cn 
  */
package com.aabbcc.pojo;

/**
 * Auto-generated: 2022-06-22 15:12:45
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class TotalPrice {

    private int discountPrice;
    private int originalPrice;
    private int voucherDiscount;
    private int discount;
    private String currencyCode;
    private CurrencyInfo currencyInfo;
    private FmtPrice fmtPrice;
    public void setDiscountPrice(int discountPrice) {
         this.discountPrice = discountPrice;
     }
     public int getDiscountPrice() {
         return discountPrice;
     }

    public void setOriginalPrice(int originalPrice) {
         this.originalPrice = originalPrice;
     }
     public int getOriginalPrice() {
         return originalPrice;
     }

    public void setVoucherDiscount(int voucherDiscount) {
         this.voucherDiscount = voucherDiscount;
     }
     public int getVoucherDiscount() {
         return voucherDiscount;
     }

    public void setDiscount(int discount) {
         this.discount = discount;
     }
     public int getDiscount() {
         return discount;
     }

    public void setCurrencyCode(String currencyCode) {
         this.currencyCode = currencyCode;
     }
     public String getCurrencyCode() {
         return currencyCode;
     }

    public void setCurrencyInfo(CurrencyInfo currencyInfo) {
         this.currencyInfo = currencyInfo;
     }
     public CurrencyInfo getCurrencyInfo() {
         return currencyInfo;
     }

    public void setFmtPrice(FmtPrice fmtPrice) {
         this.fmtPrice = fmtPrice;
     }
     public FmtPrice getFmtPrice() {
         return fmtPrice;
     }

}