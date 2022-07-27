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
public class SearchStore {

    private List<Elements> elements;
    private Paging paging;
    public void setElements(List<Elements> elements) {
         this.elements = elements;
     }
     public List<Elements> getElements() {
         return elements;
     }

    public void setPaging(Paging paging) {
         this.paging = paging;
     }
     public Paging getPaging() {
         return paging;
     }

}