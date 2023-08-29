package resource_class_details_mgmt.service;

import java.util.ArrayList;

import resource_class_details_mgmt.model.dto.ResourceClassDetail_DTO;
import resource_class_details_mgmt.model.master.ResourceClassDetailPK;

public interface I_ResourceClassDetails_Service
{
    abstract public ResourceClassDetail_DTO newResourceClassDetail(ResourceClassDetail_DTO resourceClassDetailsDTO);
    abstract public ArrayList<ResourceClassDetail_DTO> getAllResourceClassDetails();
    abstract public ArrayList<ResourceClassDetail_DTO> getSelectResourceClassDetails(ArrayList<ResourceClassDetailPK> ids);
    abstract public ArrayList<ResourceClassDetail_DTO> getSelectResourcesForClasses(ArrayList<Long> ids);
    abstract public void updResourceClassDetail(ResourceClassDetail_DTO resourceClassDetailsDTO);
    abstract public void delAllResourceClassDetails();
    abstract public void delSelectResourceClassDetails(ArrayList<ResourceClassDetailPK> ids);
    abstract public void delSelectResourcesForClasses(ArrayList<Long> ids);    
}