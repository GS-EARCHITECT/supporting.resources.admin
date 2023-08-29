package resource_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_CLASS_STRUCTURE database table.
 * 
 */
@Embeddable
public class ResourceClassStructurePK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6939353313120038940L;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "RESOURCE_CLASS_SEQ_NO")
	private Long resourceClassSeqNo;

	@Column(name = "PAR_RESOURCE_CLASS_SEQ_NO")
	private Long parResourceClassSeqNo;

	public ResourceClassStructurePK() {
	}

	public Long getResourceClassSeqNo() {
		return this.resourceClassSeqNo;
	}

	public void setResourceClassSeqNo(Long resourceClassSeqNo) {
		this.resourceClassSeqNo = resourceClassSeqNo;
	}

	public Long getParResourceClassSeqNo() {
		return this.parResourceClassSeqNo;
	}

	public void setParResourceClassSeqNo(Long parResourceClassSeqNo) {
		this.parResourceClassSeqNo = parResourceClassSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parResourceClassSeqNo == null) ? 0 : parResourceClassSeqNo.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((resourceClassSeqNo == null) ? 0 : resourceClassSeqNo.hashCode());
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
		ResourceClassStructurePK other = (ResourceClassStructurePK) obj;
		if (parResourceClassSeqNo == null) {
			if (other.parResourceClassSeqNo != null)
				return false;
		} else if (!parResourceClassSeqNo.equals(other.parResourceClassSeqNo))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (resourceClassSeqNo == null) {
			if (other.resourceClassSeqNo != null)
				return false;
		} else if (!resourceClassSeqNo.equals(other.resourceClassSeqNo))
			return false;
		return true;
	}

	public ResourceClassStructurePK(Long partySeqNo, Long resourceClassSeqNo, Long parResourceClassSeqNo) {
		super();
		this.partySeqNo = partySeqNo;
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.parResourceClassSeqNo = parResourceClassSeqNo;
	}

}