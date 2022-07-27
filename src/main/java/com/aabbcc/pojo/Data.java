/**
  * Copyright 2022 json.cn 
  */
package com.aabbcc.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Auto-generated: 2022-06-22 15:12:45
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Data {

    @JSONField(name = "Catalog")
    private Catalogs Catalog;

    public void setCatalog(Catalogs Catalog) {
         this.Catalog = Catalog;
     }
     public Catalogs getCatalog() {
         return Catalog;
     }

}