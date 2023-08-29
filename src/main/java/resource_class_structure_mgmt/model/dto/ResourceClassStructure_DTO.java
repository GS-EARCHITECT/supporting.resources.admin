package resource_class_structure_mgmt.model.dto;

import java.io.Serializable;

public class ResourceClassStructure_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6245151590523064L;
	private Long partySeqNo;
	private Long resourceClassSeqNo;
	private Long parResourceClassSeqNo;

	public Long getResourceClassSeqNo() {
		return resourceClassSeqNo;
	}

	public void setResourceClassSeqNo(Long resourceClassSeqNo) {
		this.resourceClassSeqNo = resourceClassSeqNo;
	}

	public Long getParResourceClassSeqNo() {
		return parResourceClassSeqNo;
	}

	public void setParResourceClassSeqNo(Long parResourceClassSeqNo) {
		this.parResourceClassSeqNo = parResourceClassSeqNo;
	}

	public ResourceClassStructure_DTO(Long partySeqNo, Long resourceClassSeqNo, Long parResourceClassSeqNo) {
		super();
		this.partySeqNo = partySeqNo;
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.parResourceClassSeqNo = parResourceClassSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public ResourceClassStructure_DTO() {
		super();
	}

}