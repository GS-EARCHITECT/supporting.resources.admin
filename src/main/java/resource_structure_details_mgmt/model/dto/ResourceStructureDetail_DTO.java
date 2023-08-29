package resource_structure_details_mgmt.model.dto;

import java.io.Serializable;

public class ResourceStructureDetail_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2163646907561652459L;
	private Long resourceClassSeqNo;
	private Long resourceSeqNo;
	private Long parResourceClassSeqNo;
	private Long parResourceSeqNo;

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

	public Long getParResourceClassSeqNo() {
		return parResourceClassSeqNo;
	}

	public void setParResourceClassSeqNo(Long parResourceClassSeqNo) {
		this.parResourceClassSeqNo = parResourceClassSeqNo;
	}

	public Long getParResourceSeqNo() {
		return parResourceSeqNo;
	}

	public void setParResourceSeqNo(Long parResourceSeqNo) {
		this.parResourceSeqNo = parResourceSeqNo;
	}

	public ResourceStructureDetail_DTO(Long resourceClassSeqNo, Long resourceSeqNo, Long parResourceClassSeqNo,
			Long parResourceSeqNo) {
		super();
		this.resourceClassSeqNo = resourceClassSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.parResourceClassSeqNo = parResourceClassSeqNo;
		this.parResourceSeqNo = parResourceSeqNo;
	}

	public ResourceStructureDetail_DTO() {
		super();
	}

}