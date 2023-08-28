package resource_party_mgmt.model.dto;

import java.io.Serializable;

public class ResourcePartyMaster_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5075272297929901314L;
	private Long resourceSeqNo;
	private Float discPer;
	private Long discSeqNo;
	private Float discVal;
	private Long masterResourceSeqNo;
	private Float maxQty;
	private Long oemSeqNo;
	private Long partySeqNo;
	private Float qoh;
	private Long qtyCodeSeqNo;
	private String remark;
	private Float reorderLevel;
	private Float reorderQty;
	private String resourceId;
	private Long specificationSeqNo;
	private Float taxPer;
	private Long taxSeqNo;
	private Float taxVal;
	private Long unitPrice;
	private Long unitPriceSeqNo;

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(Float discPer) {
		this.discPer = discPer;
	}

	public Long getDiscSeqNo() {
		return discSeqNo;
	}

	public void setDiscSeqNo(Long discSeqNo) {
		this.discSeqNo = discSeqNo;
	}

	public Float getDiscVal() {
		return discVal;
	}

	public void setDiscVal(Float discVal) {
		this.discVal = discVal;
	}

	public Long getMasterResourceSeqNo() {
		return masterResourceSeqNo;
	}

	public void setMasterResourceSeqNo(Long masterResourceSeqNo) {
		this.masterResourceSeqNo = masterResourceSeqNo;
	}

	public Float getMaxQty() {
		return maxQty;
	}

	public void setMaxQty(Float maxQty) {
		this.maxQty = maxQty;
	}

	public Long getOemSeqNo() {
		return oemSeqNo;
	}

	public void setOemSeqNo(Long oemSeqNo) {
		this.oemSeqNo = oemSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Float getQoh() {
		return qoh;
	}

	public void setQoh(Float qoh) {
		this.qoh = qoh;
	}

	public Long getQtyCodeSeqNo() {
		return qtyCodeSeqNo;
	}

	public void setQtyCodeSeqNo(Long qtyCodeSeqNo) {
		this.qtyCodeSeqNo = qtyCodeSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Float getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Float reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Float getReorderQty() {
		return reorderQty;
	}

	public void setReorderQty(Float reorderQty) {
		this.reorderQty = reorderQty;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Long getSpecificationSeqNo() {
		return specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public Float getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(Float taxPer) {
		this.taxPer = taxPer;
	}

	public Long getTaxSeqNo() {
		return taxSeqNo;
	}

	public void setTaxSeqNo(Long taxSeqNo) {
		this.taxSeqNo = taxSeqNo;
	}

	public Float getTaxVal() {
		return taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getUnitPriceSeqNo() {
		return unitPriceSeqNo;
	}

	public void setUnitPriceSeqNo(Long unitPriceSeqNo) {
		this.unitPriceSeqNo = unitPriceSeqNo;
	}

	public ResourcePartyMaster_DTO(Long resourceSeqNo, Float discPer, Long discSeqNo, Float discVal,
			Long masterResourceSeqNo, Float maxQty, Long oemSeqNo, Long partySeqNo, Float qoh, Long qtyCodeSeqNo,
			String remark, Float reorderLevel, Float reorderQty, String resourceId, Long specificationSeqNo,
			Float taxPer, Long taxSeqNo, Float taxVal, Long unitPrice, Long unitPriceSeqNo) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.discPer = discPer;
		this.discSeqNo = discSeqNo;
		this.discVal = discVal;
		this.masterResourceSeqNo = masterResourceSeqNo;
		this.maxQty = maxQty;
		this.oemSeqNo = oemSeqNo;
		this.partySeqNo = partySeqNo;
		this.qoh = qoh;
		this.qtyCodeSeqNo = qtyCodeSeqNo;
		this.remark = remark;
		this.reorderLevel = reorderLevel;
		this.reorderQty = reorderQty;
		this.resourceId = resourceId;
		this.specificationSeqNo = specificationSeqNo;
		this.taxPer = taxPer;
		this.taxSeqNo = taxSeqNo;
		this.taxVal = taxVal;
		this.unitPrice = unitPrice;
		this.unitPriceSeqNo = unitPriceSeqNo;
	}

	public ResourcePartyMaster_DTO() {
		super();
	}

}