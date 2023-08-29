package resource_location_mgmt.services;

import java.util.ArrayList;

import resource_location_mgmt.model.dto.ResourceLocationMaster_DTO;
import resource_location_mgmt.model.master.ResourceLocationMasterPK;

public interface I_ResourceLocationMasterAdmin_Service
{
	public ResourceLocationMaster_DTO newPartyLocationResource(ResourceLocationMaster_DTO resourceLocationMaster_DTO);
	public void updPartyLocationResource(ResourceLocationMaster_DTO resourceLocationMaster_DTO);
    public ArrayList<ResourceLocationMaster_DTO> getAllPartyLocationResources();        
    public ArrayList<ResourceLocationMaster_DTO> getSelectResourcesPartyLocations(ArrayList<ResourceLocationMasterPK> resourceLocationMasterPKs);
    public ArrayList<ResourceLocationMaster_DTO> getSelectResourcesByLocations( ArrayList<Long> lidss);
    public ArrayList<ResourceLocationMaster_DTO> getSelectResourcesByParties(ArrayList<Long> pids);
    public ArrayList<ResourceLocationMaster_DTO> getSelectResources(ArrayList<Long> ridss);
    public void delSelectResourcesByLocations( ArrayList<Long> lidss);
    public void delSelectResourcesByParties( ArrayList<Long> pidss);
    public void delSelectResources( ArrayList<Long> ridss);
    public void delAllPartyLocationResource();
}