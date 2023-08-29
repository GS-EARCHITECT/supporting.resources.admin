package resource_class_details_mgmt.model.dto;

import java.io.Serializable;

public class ResourceClassDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2551497695164125186L;
	private Long resourceClassSeqNo;
	private Long resourceSeqNo;
	
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

	public ResourceClassDetail_DTO(Long resourceClassSeqNo, Long resourceSeqNo)
	{
		super();
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.resourceSeqNo = resourceSeqNo;
	}

	public ResourceClassDetail_DTO() {
		super();
	}

}