package resource_class_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RESOURCE_CLASS_DETAILS database table.
 * 
 */
@Entity
@Table(name="RESOURCE_CLASS_DETAILS")
public class ResourceClassDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceClassDetailPK id;

	public ResourceClassDetail() {
	}

	public ResourceClassDetailPK getId() {
		return this.id;
	}

	public void setId(ResourceClassDetailPK id) {
		this.id = id;
	}

}