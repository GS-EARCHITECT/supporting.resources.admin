package resource_structure_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource_structure_details_mgmt.model.master.ResourceStructureDetail;
import resource_structure_details_mgmt.model.master.ResourceStructureDetailPK;

@Repository("resourceStructureDetailsRepo")
public interface ResourceStructureDetails_Repo extends JpaRepository<ResourceStructureDetail, ResourceStructureDetailPK> 
{
	@Query(value = "SELECT * FROM RESOURCE_STRUCTURE_DETAILS a WHERE (a.resource_seq_no in :ids and a.resource_class_seq_no in :cids) order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceStructureDetail> getSelectResourceStructureDetailsByResources(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);

	@Query(value = "SELECT * FROM RESOURCE_STRUCTURE_DETAILS a WHERE a.par_resource_class_seq_no in :pids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceStructureDetail> getSelectResourceClassesByParents(@Param("pids") ArrayList<Long> pids);
	
	@Query(value = "delete FROM RESOURCE_STRUCTURE_DETAILS a WHERE (a.resource_seq_no in :ids and a.resource_class_seq_no in :cids)", nativeQuery = true)
	void delSelectResourceStructureDetailsByResources(@Param("ids") ArrayList<Long> ids, @Param("cids") ArrayList<Long> cids);

	@Query(value = "delete FROM RESOURCE_STRUCTURE_DETAILS a WHERE a.par_resource_class_seq_no in :pids", nativeQuery = true)
	void delSelectResourceStructureDetailsByParents(@Param("pids") ArrayList<Long> pids);
}
