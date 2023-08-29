package resource_location_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_LOCATION_MASTER database table.
 * 
 */
@Entity
@Table(name="RESOURCE_LOCATION_MASTER")
public class ResourceLocationMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceLocationMasterPK id;

	@Column(name="QTY")
	private Float qty;

	@Column(name="QTY_SEQ_NO")
	private Long qtySeqNo;

	public ResourceLocationMasterPK getId() {
		return id;
	}

	public void setId(ResourceLocationMasterPK id) {
		this.id = id;
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

	public ResourceLocationMaster(ResourceLocationMasterPK id, Float qty, Long qtySeqNo) {
		super();
		this.id = id;
		this.qty = qty;
		this.qtySeqNo = qtySeqNo;
	}

	public ResourceLocationMaster() {
		super();
	}
		
}