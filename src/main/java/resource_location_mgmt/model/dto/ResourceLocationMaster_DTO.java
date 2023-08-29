package resource_location_mgmt.model.dto;

import java.io.Serializable;

public class ResourceLocationMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8139503852002964204L;
	private Long resourceSeqNo;
	private Long locationSeqNo;
	private Long partySeqNo;
	private Float qty;
	private Long qtySeqNo;

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public Long getQtySeqNo() {
		return qtySeqNo;
	}

	public void setQtySeqNo(Long qtySeqNo) {
		this.qtySeqNo = qtySeqNo;
	}

	public ResourceLocationMaster_DTO(Long resourceSeqNo, Long locationSeqNo, Long partySeqNo, Float qty,
			Long qtySeqNo) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.partySeqNo = partySeqNo;
		this.qty = qty;
		this.qtySeqNo = qtySeqNo;
	}

	public ResourceLocationMaster_DTO() {
		super();
	}

}