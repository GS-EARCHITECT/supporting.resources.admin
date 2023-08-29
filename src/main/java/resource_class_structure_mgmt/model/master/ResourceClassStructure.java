package resource_class_structure_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the RESOURCE_CLASS_STRUCTURE database table.
 * 
 */
@Entity
@Table(name = "RESOURCE_CLASS_STRUCTURE")
public class ResourceClassStructure implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResourceClassStructurePK id;

	public ResourceClassStructure() {
	}

	public ResourceClassStructurePK getId() {
		return this.id;
	}

	public void setId(ResourceClassStructurePK id) {
		this.id = id;
	}

	public ResourceClassStructure(ResourceClassStructurePK id) {
		super();
		this.id = id;
	}

}