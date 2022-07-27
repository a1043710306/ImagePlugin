/**
  * Copyright 2022 json.cn 
  */
package com.aabbcc.pojo;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2022-06-22 15:12:45
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Elements {

    private String title;
    private String id;
    private String namespace;
    private String description;
    private Date effectiveDate;
    private String offerType;
    private String expiryDate;
    private String status;
    private boolean isCodeRedemptionOnly;
    private List<KeyImages> keyImages;
    private Seller seller;
    private String productSlug;
    private String urlSlug;
    private String url;
    private List<Items> items;
    private List<CustomAttributes> customAttributes;
    private List<Categories> categories;
    private List<Tags> tags;
    private CatalogNs catalogNs;
    private List<String> offerMappings;
    private Price price;
    private Promotions promotions;
    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setNamespace(String namespace) {
         this.namespace = namespace;
     }
     public String getNamespace() {
         return namespace;
     }

    public void setDescription(String description) {
         this.description = description;
     }
     public String getDescription() {
         return description;
     }

    public void setEffectiveDate(Date effectiveDate) {
         this.effectiveDate = effectiveDate;
     }
     public Date getEffectiveDate() {
         return effectiveDate;
     }

    public void setOfferType(String offerType) {
         this.offerType = offerType;
     }
     public String getOfferType() {
         return offerType;
     }

    public void setExpiryDate(String expiryDate) {
         this.expiryDate = expiryDate;
     }
     public String getExpiryDate() {
         return expiryDate;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setIsCodeRedemptionOnly(boolean isCodeRedemptionOnly) {
         this.isCodeRedemptionOnly = isCodeRedemptionOnly;
     }
     public boolean getIsCodeRedemptionOnly() {
         return isCodeRedemptionOnly;
     }

    public void setKeyImages(List<KeyImages> keyImages) {
         this.keyImages = keyImages;
     }
     public List<KeyImages> getKeyImages() {
         return keyImages;
     }

    public void setSeller(Seller seller) {
         this.seller = seller;
     }
     public Seller getSeller() {
         return seller;
     }

    public void setProductSlug(String productSlug) {
         this.productSlug = productSlug;
     }
     public String getProductSlug() {
         return productSlug;
     }

    public void setUrlSlug(String urlSlug) {
         this.urlSlug = urlSlug;
     }
     public String getUrlSlug() {
         return urlSlug;
     }

    public void setUrl(String url) {
         this.url = url;
     }
     public String getUrl() {
         return url;
     }

    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

    public void setCustomAttributes(List<CustomAttributes> customAttributes) {
         this.customAttributes = customAttributes;
     }
     public List<CustomAttributes> getCustomAttributes() {
         return customAttributes;
     }

    public void setCategories(List<Categories> categories) {
         this.categories = categories;
     }
     public List<Categories> getCategories() {
         return categories;
     }

    public void setTags(List<Tags> tags) {
         this.tags = tags;
     }
     public List<Tags> getTags() {
         return tags;
     }

    public void setCatalogNs(CatalogNs catalogNs) {
         this.catalogNs = catalogNs;
     }
     public CatalogNs getCatalogNs() {
         return catalogNs;
     }

    public void setOfferMappings(List<String> offerMappings) {
         this.offerMappings = offerMappings;
     }
     public List<String> getOfferMappings() {
         return offerMappings;
     }

    public void setPrice(Price price) {
         this.price = price;
     }
     public Price getPrice() {
         return price;
     }

    public void setPromotions(Promotions promotions) {
         this.promotions = promotions;
     }
     public Promotions getPromotions() {
         return promotions;
     }

}