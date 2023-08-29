package resource_structure_details_mgmt.service;

import java.util.ArrayList;
import resource_structure_details_mgmt.model.dto.ResourceStructureDetail_DTO;
import resource_structure_details_mgmt.model.master.ResourceStructureDetailPK;

public interface I_ResourceStructureDetails_Service
{
    public ResourceStructureDetail_DTO newResourceStructureDetail(ResourceStructureDetail_DTO resourceStructureDetailDTO);
    public ArrayList<ResourceStructureDetail_DTO> getAllResourceStructureDetails();    
    public ArrayList<ResourceStructureDetail_DTO> getSelectResourceStructureDetails(ArrayList<ResourceStructureDetailPK> ids);
    public ArrayList<ResourceStructureDetail_DTO> getSelectResourceStructureDetailsByResources(ArrayList<Long> ids, ArrayList<Long> cids);
    public ArrayList<ResourceStructureDetail_DTO> getSelectResourceStructureDetailsByParents(ArrayList<Long> ids);
	public void updResourceStructureDetail(ResourceStructureDetail_DTO resourceStructureDetailDTO);
    public void delAllResourceStructureDetails();
    public void delSelectResourceStructureDetails(ArrayList<ResourceStructureDetailPK> ids);    
    public void delSelectResourceStructureDetailsByParents(ArrayList<Long> pids);    
    public void delSelectResourceStructureDetailsByResources(ArrayList<Long> ids, ArrayList<Long> cids);    
}