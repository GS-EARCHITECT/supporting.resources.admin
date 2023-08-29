package resource_structure_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_STRUCTURE_DETAILS database table.
 * 
 */
@Embeddable
public class ResourceStructureDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "RESOURCE_CLASS_SEQ_NO")
	private Long resourceClassSeqNo;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "PAR_RESOURCE_CLASS_SEQ_NO")
	private Long parResourceClassSeqNo;

	@Column(name = "PAR_RESOURCE_SEQ_NO")
	private Long parResourceSeqNo;

	public ResourceStructureDetailPK() {
	}

	public Long getResourceClassSeqNo() {
		return this.resourceClassSeqNo;
	}

	public void setResourceClassSeqNo(Long resourceClassSeqNo) {
		this.resourceClassSeqNo = resourceClassSeqNo;
	}

	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getParResourceClassSeqNo() {
		return this.parResourceClassSeqNo;
	}

	public void setParResourceClassSeqNo(Long parResourceClassSeqNo) {
		this.parResourceClassSeqNo = parResourceClassSeqNo;
	}

	public Long getParResourceSeqNo() {
		return this.parResourceSeqNo;
	}

	public void setParResourceSeqNo(Long parResourceSeqNo) {
		this.parResourceSeqNo = parResourceSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ResourceStructureDetailPK)) {
			return false;
		}
		ResourceStructureDetailPK castOther = (ResourceStructureDetailPK) other;
		return (this.resourceClassSeqNo == castOther.resourceClassSeqNo)
				&& (this.resourceSeqNo == castOther.resourceSeqNo)
				&& (this.parResourceClassSeqNo == castOther.parResourceClassSeqNo)
				&& (this.parResourceSeqNo == castOther.parResourceSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.resourceClassSeqNo ^ (this.resourceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.resourceSeqNo ^ (this.resourceSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parResourceClassSeqNo ^ (this.parResourceClassSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.parResourceSeqNo ^ (this.parResourceSeqNo >>> 32)));
		return hash;

	}

	public ResourceStructureDetailPK(Long resourceClassSeqNo, Long resourceSeqNo, Long parResourceClassSeqNo,
			Long parResourceSeqNo) {
		super();
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.parResourceClassSeqNo = parResourceClassSeqNo;
		this.parResourceSeqNo = parResourceSeqNo;
	}
}