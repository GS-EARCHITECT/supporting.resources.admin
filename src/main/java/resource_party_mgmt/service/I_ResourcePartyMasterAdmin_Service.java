package resource_party_mgmt.service;

import java.util.ArrayList;
import resource_party_mgmt.model.dto.ResourcePartyMaster_DTO;

public interface I_ResourcePartyMasterAdmin_Service
{
    public ResourcePartyMaster_DTO newResourcePartyMaster(ResourcePartyMaster_DTO resourceCategoryMasterDTO);
    public void updResourcePartyMaster(ResourcePartyMaster_DTO ResourcePartyMaster_DTO);
    public ArrayList<ResourcePartyMaster_DTO> getAllResourcePartyMasters();   
    public ArrayList<ResourcePartyMaster_DTO> getSelectResources(ArrayList<Long> ids);
    public ArrayList<ResourcePartyMaster_DTO> getSelectResourcesByResourceIds( ArrayList<String> ids);
    public ArrayList<ResourcePartyMaster_DTO> getSelectResourcesByOEMs( ArrayList<Long> ids);
	public ArrayList<ResourcePartyMaster_DTO> getSelectResourceByParties( ArrayList<Long> ids);
	public ArrayList<ResourcePartyMaster_DTO> getSelectResourcesByPriceRange( Float fr, Float to);    
    public void delAllResourcePartyMasters();    
    public void delSelectResources(ArrayList<Long> ids);
    public void delSelectResourceByParties( ArrayList<Long> ids);
    public void delSelectResourcesByOEMs( ArrayList<Long> ids);    
    public void delSelectResourcesByPriceRange( Float fr, Float to);
}