package resource_location_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import resource_location_mgmt.model.master.ResourceLocationMaster;
import resource_location_mgmt.model.master.ResourceLocationMasterPK;

@Repository("resourceLocationMasterAdminRepo")
public interface ResourceLocationMasterAdmin_Repo extends JpaRepository<ResourceLocationMaster, ResourceLocationMasterPK> 
{		
	
	@Query(value = "select * FROM RESOURCE_LOCATION_MASTER a WHERE a.location_seq_no in :lids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceLocationMaster> getSelectResourcesByLocations(@Param("lids") ArrayList<Long> lidss);

	@Query(value = "select * FROM RESOURCE_LOCATION_MASTER a WHERE a.party_seq_no in :lids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceLocationMaster> getSelectResourcesByParties(@Param("pids") ArrayList<Long> pidss);
	
	@Query(value = "select * FROM RESOURCE_LOCATION_MASTER a WHERE a.resource_seq_no in :rids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceLocationMaster> getSelectResources(@Param("rids") ArrayList<Long> ridss);

	@Query(value = "delete FROM RESOURCE_LOCATION_MASTER a WHERE a.location_seq_no in :lids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceLocationMaster> delSelectResourcesByLocations(@Param("lids") ArrayList<Long> lidss);

	@Query(value = "delete FROM RESOURCE_LOCATION_MASTER a WHERE a.party_seq_no in :lids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceLocationMaster> delSelectResourcesByParties(@Param("pids") ArrayList<Long> pidss);
	
	@Query(value = "delete FROM RESOURCE_LOCATION_MASTER a WHERE a.resource_seq_no in :rids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceLocationMaster> delSelectResources(@Param("rids") ArrayList<Long> ridss);

}
