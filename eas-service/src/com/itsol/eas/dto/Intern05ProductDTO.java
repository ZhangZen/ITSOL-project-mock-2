package com.itsol.eas.dto;

import com.itsol.eas.bo.Intern05ProductBO;
import com.viettel.service.base.dto.BaseFWDTOImpl;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "INTERN05_PRODUCTBO")
public class Intern05ProductDTO extends BaseFWDTOImpl<Intern05ProductBO> {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private java.lang.Long prId;
private java.lang.String prName;
private java.lang.Float price;
private java.lang.String prUnit;
private java.lang.Long quantity;
private java.lang.Float discountRate;
private java.lang.String prDescription;
private java.lang.String prDigitalproduct;
private java.lang.Long productCategoryId;

    @Override
    public Intern05ProductBO toModel() {
        Intern05ProductBO intern05ProductBO = new Intern05ProductBO();
        intern05ProductBO.setPrId(this.prId);
        intern05ProductBO.setPrName(this.prName);
        intern05ProductBO.setPrice(this.price);
        intern05ProductBO.setPrUnit(this.prUnit);
        intern05ProductBO.setQuantity(this.quantity);
        intern05ProductBO.setDiscountRate(this.discountRate);
        intern05ProductBO.setPrDescription(this.prDescription);
        intern05ProductBO.setPrDigitalproduct(this.prDigitalproduct);
        intern05ProductBO.setProductCategoryId(this.productCategoryId);
        return intern05ProductBO;
    }

    @Override
     public Long getFWModelId() {
        return prId;
    }
   
    @Override
    public String catchName() {
        return getPrId().toString();
    }
    public java.lang.Long getPrId(){
    return prId;
    }
    public void setPrId(java.lang.Long prId)
    {
    this.prId = prId;
    }
    
    public java.lang.String getPrName(){
    return prName;
    }
    public void setPrName(java.lang.String prName)
    {
    this.prName = prName;
    }
    
    public java.lang.Float getPrice(){
    return price;
    }
    public void setPrice(java.lang.Float price)
    {
    this.price = price;
    }
    
    public java.lang.String getPrUnit(){
    return prUnit;
    }
    public void setPrUnit(java.lang.String prUnit)
    {
    this.prUnit = prUnit;
    }
    
    public java.lang.Long getQuantity(){
    return quantity;
    }
    public void setQuantity(java.lang.Long quantity)
    {
    this.quantity = quantity;
    }
    
    public java.lang.Float getDiscountRate(){
    return discountRate;
    }
    public void setDiscountRate(java.lang.Float discountRate)
    {
    this.discountRate = discountRate;
    }
    
    public java.lang.String getPrDescription(){
    return prDescription;
    }
    public void setPrDescription(java.lang.String prDescription)
    {
    this.prDescription = prDescription;
    }
    
    public java.lang.String getPrDigitalproduct(){
    return prDigitalproduct;
    }
    public void setPrDigitalproduct(java.lang.String prDigitalproduct)
    {
    this.prDigitalproduct = prDigitalproduct;
    }
    
    public java.lang.Long getProductCategoryId(){
    return productCategoryId;
    }
    public void setProductCategoryId(java.lang.Long productCategoryId)
    {
    this.productCategoryId = productCategoryId;
    }
    
   
}
