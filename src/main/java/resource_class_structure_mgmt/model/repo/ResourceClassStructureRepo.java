package resource_class_structure_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource_class_structure_mgmt.model.master.ResourceClassStructure;
import resource_class_structure_mgmt.model.master.ResourceClassStructurePK;

@Repository("resourceClassStructureRepo")
public interface ResourceClassStructureRepo extends CrudRepository<ResourceClassStructure, ResourceClassStructurePK> 
{
	@Query(value = "SELECT * FROM RESOURCE_CLASS_STRUCTURE a WHERE (a.resource_class_seq_no in :ids and a.par_resource_class_seq_no in :pids) order by resource_class_seq_no", nativeQuery = true)
	ArrayList<ResourceClassStructure> getSelectResourceClassStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM RESOURCE_CLASS_STRUCTURE a WHERE a.party_seq_no in :ids order by resource_class_seq_no", nativeQuery = true)
	ArrayList<ResourceClassStructure> getSelectResourceClassStructuresByParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM RESOURCE_CLASS_STRUCTURE a WHERE a.par_resource_class_seq_no in :ids order by resource_class_seq_no", nativeQuery = true)
	ArrayList<ResourceClassStructure> getSelectResourceClassesByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM RESOURCE_CLASS_STRUCTURE WHERE (a.resource_class_seq_no in :ids and a.par_resource_class_seq_no in :pids)", nativeQuery = true)
	void delSelectResourceClassStructures(@Param("ids") ArrayList<Long> ids, @Param("pids") ArrayList<Long> pids);

	@Query(value = "SELECT * FROM RESOURCE_CLASS_STRUCTURE a WHERE a.par_resource_class_seq_no in :ids", nativeQuery = true)
	void delSelectResourceClassStructuresByParents(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM RESOURCE_CLASS_STRUCTURE a WHERE a.party_seq_no in :ids", nativeQuery = true)
	void delSelectResourceClassStructuresByParties(@Param("ids") ArrayList<Long> ids);
}
