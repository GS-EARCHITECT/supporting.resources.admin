package resource_party_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource_party_mgmt.model.master.ResourcePartyMaster;

@Repository("resourcePartyMasterAdminRepo")
public interface ResourcePartyMasterAdmin_Repo extends JpaRepository<ResourcePartyMaster, Long> 
{
	@Query(value = "SELECT * FROM RESOURCE_DETAILS a WHERE upper(trim(a.resource_id)) in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourcePartyMaster> getSelectResourcesByResourceIds(@Param("ids") ArrayList<String> ids);

	@Query(value = "SELECT * FROM RESOURCE_DETAILS a WHERE a.oem_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourcePartyMaster> getSelectResourcesByOEMs(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM RESOURCE_PARTY_MASTER a WHERE a.party_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourcePartyMaster> getSelectResourceeByParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM RESOURCE_DETAILS a WHERE a.unit_price>=:fr and a.unit_price<=:to order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourcePartyMaster> getSelectResourcesByPriceRange(@Param("fr") Float fr, @Param("to") Float to);
	
	@Query(value = "DELETE FROM RESOURCE_DETAILS WHERE a.resource_type_seq_no in :ids", nativeQuery = true)
	void delSelectResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM RESOURCE_PARTY_MASTER a WHERE a.party_seq_no in :ids", nativeQuery = true)
	void delSelectResourceByParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "deleet FROM RESOURCE_DETAILS a WHERE a.oem_seq_no in :ids", nativeQuery = true)
	void delSelectResourcesByOEMs(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM RESOURCE_DETAILS a WHERE a.unit_price>=:fr and a.unit_price<=:to ", nativeQuery = true)
	void delSelectResourcesByPriceRange(@Param("fr") Float fr, @Param("to") Float to);

}
