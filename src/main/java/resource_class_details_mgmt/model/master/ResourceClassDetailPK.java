package resource_class_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CLASS_DETAILS database table.
 * 
 */
@Embeddable
public class ResourceClassDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "RESOURCE_CLASS_SEQ_NO")
	private Long resourceClassSeqNo;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	public ResourceClassDetailPK() {
	}

	public Long getResourceClassSeqNo() {
		return resourceClassSeqNo;
	}

	public void setResourceClassSeqNo(Long resourceClassSeqNo) {
		this.resourceClassSeqNo = resourceClassSeqNo;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resourceClassSeqNo == null) ? 0 : resourceClassSeqNo.hashCode());
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
		ResourceClassDetailPK other = (ResourceClassDetailPK) obj;
		if (resourceClassSeqNo == null) {
			if (other.resourceClassSeqNo != null)
				return false;
		} else if (!resourceClassSeqNo.equals(other.resourceClassSeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		return true;
	}

	public ResourceClassDetailPK(Long resourceClassSeqNo, Long resourceSeqNo) {
		super();
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.resourceSeqNo = resourceSeqNo;
	}

}