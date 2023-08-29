package resource_location_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RESOURCE_LOCATION_MASTER database table.
 * 
 */
@Embeddable
public class ResourceLocationMasterPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
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
		ResourceLocationMasterPK other = (ResourceLocationMasterPK) obj;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
			return false;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		return true;
	}

	public ResourceLocationMasterPK(Long resourceSeqNo, Long locationSeqNo, Long partySeqNo) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.partySeqNo = partySeqNo;
	}

	public ResourceLocationMasterPK() {
		super();
	}

}