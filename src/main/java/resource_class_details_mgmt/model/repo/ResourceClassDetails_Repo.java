package resource_class_details_mgmt.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resource_class_details_mgmt.model.master.ResourceClassDetail;
import resource_class_details_mgmt.model.master.ResourceClassDetailPK;

@Repository("resourceClassDetailsRepo")
public interface ResourceClassDetails_Repo extends CrudRepository<ResourceClassDetail, ResourceClassDetailPK> 
{
	@Query(value = "SELECT * FROM RESOURCE_CLASS_DETAILS a WHERE (a.resource_class_seq_no in :ids) order by resource_seq_no", nativeQuery = true)
	ArrayList<ResourceClassDetail> getSelectResourcesForClasses(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "DELETE FROM RESOURCE_CLASS_DETAILS a WHERE (a.resource_class_seq_no in :ids)", nativeQuery = true)
	void delSelectResourcesForClasses(@Param("ids") ArrayList<Long> ids);

}
