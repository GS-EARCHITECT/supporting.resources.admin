package resource_party_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_PARTY_MASTER database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_PARTY_MASTER")
public class ResourcePartyMaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESOURCE_SEQUENCE")
	@SequenceGenerator(name = "RESOURCE_SEQUENCE", sequenceName = "RESOURCE_SEQUENCE", allocationSize = 1)
	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "DISC_PER")
	private Float discPer;

	@Column(name = "DISC_SEQ_NO")
	private Long discSeqNo;

	@Column(name = "DISC_VAL")
	private Float discVal;

	@Column(name = "MASTER_RESOURCE_SEQ_NO")
	private Long masterResourceSeqNo;

	@Column(name = "MAX_QTY")
	private Float maxQty;

	@Column(name = "OEM_SEQ_NO")
	private Long oemSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "QOH")
	private Float qoh;

	@Column(name = "QTY_CODE_SEQ_NO")
	private Long qtyCodeSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "REORDER_LEVEL")
	private Float reorderLevel;

	@Column(name = "REORDER_QTY")
	private Float reorderQty;

	@Column(name = "RESOURCE_ID")
	private String resourceId;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specificationSeqNo;

	@Column(name = "TAX_PER")
	private Float taxPer;

	@Column(name = "TAX_SEQ_NO")
	private Long taxSeqNo;

	@Column(name = "TAX_VAL")
	private Float taxVal;

	@Column(name = "UNIT_PRICE")
	private Long unitPrice;

	@Column(name = "UNIT_PRICE_SEQ_NO")
	private Long unitPriceSeqNo;

	public ResourcePartyMaster() {
	}

	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Float getDiscPer() {
		return this.discPer;
	}

	public void setDiscPer(Float discPer) {
		this.discPer = discPer;
	}

	public Long getDiscSeqNo() {
		return this.discSeqNo;
	}

	public void setDiscSeqNo(Long discSeqNo) {
		this.discSeqNo = discSeqNo;
	}

	public Float getDiscVal() {
		return this.discVal;
	}

	public void setDiscVal(Float discVal) {
		this.discVal = discVal;
	}

	public Long getMasterResourceSeqNo() {
		return this.masterResourceSeqNo;
	}

	public void setMasterResourceSeqNo(Long masterResourceSeqNo) {
		this.masterResourceSeqNo = masterResourceSeqNo;
	}

	public Float getMaxQty() {
		return this.maxQty;
	}

	public void setMaxQty(Float maxQty) {
		this.maxQty = maxQty;
	}

	public Long getOemSeqNo() {
		return this.oemSeqNo;
	}

	public void setOemSeqNo(Long oemSeqNo) {
		this.oemSeqNo = oemSeqNo;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Float getQoh() {
		return this.qoh;
	}

	public void setQoh(Float qoh) {
		this.qoh = qoh;
	}

	public Long getQtyCodeSeqNo() {
		return this.qtyCodeSeqNo;
	}

	public void setQtyCodeSeqNo(Long qtyCodeSeqNo) {
		this.qtyCodeSeqNo = qtyCodeSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Float getReorderLevel() {
		return this.reorderLevel;
	}

	public void setReorderLevel(Float reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Float getReorderQty() {
		return this.reorderQty;
	}

	public void setReorderQty(Float reorderQty) {
		this.reorderQty = reorderQty;
	}

	public String getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public Long getSpecificationSeqNo() {
		return this.specificationSeqNo;
	}

	public void setSpecificationSeqNo(Long specificationSeqNo) {
		this.specificationSeqNo = specificationSeqNo;
	}

	public Float getTaxPer() {
		return this.taxPer;
	}

	public void setTaxPer(Float taxPer) {
		this.taxPer = taxPer;
	}

	public Long getTaxSeqNo() {
		return this.taxSeqNo;
	}

	public void setTaxSeqNo(Long taxSeqNo) {
		this.taxSeqNo = taxSeqNo;
	}

	public Float getTaxVal() {
		return this.taxVal;
	}

	public void setTaxVal(Float taxVal) {
		this.taxVal = taxVal;
	}

	public Long getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Long getUnitPriceSeqNo() {
		return this.unitPriceSeqNo;
	}

	public void setUnitPriceSeqNo(Long unitPriceSeqNo) {
		this.unitPriceSeqNo = unitPriceSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((masterResourceSeqNo == null) ? 0 : masterResourceSeqNo.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResourcePartyMaster other = (ResourcePartyMaster) obj;
		if (masterResourceSeqNo == null) {
			if (other.masterResourceSeqNo != null)
				return false;
		} else if (!masterResourceSeqNo.equals(other.masterResourceSeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		return true;
	}

	public ResourcePartyMaster(Long resourceSeqNo, Float discPer, Long discSeqNo, Float discVal,
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

}