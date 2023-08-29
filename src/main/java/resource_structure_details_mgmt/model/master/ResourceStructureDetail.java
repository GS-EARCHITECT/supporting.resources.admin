package resource_structure_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_STRUCTURE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_STRUCTURE_DETAILS")
public class ResourceStructureDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceStructureDetailPK id;

	public ResourceStructureDetail() {
	}

	public ResourceStructureDetailPK getId() {
		return this.id;
	}

	public void setId(ResourceStructureDetailPK id) {
		this.id = id;
	}

	public ResourceStructureDetail(ResourceStructureDetailPK id) {
		super();
		this.id = id;
	}

}