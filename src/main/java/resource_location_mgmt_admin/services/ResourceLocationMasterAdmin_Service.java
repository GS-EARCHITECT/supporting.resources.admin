package resource_location_mgmt_admin.services;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import resource_location_mgmt_admin.model.dto.ResourceLocationMaster_DTO;
import resource_location_mgmt_admin.model.master.ResourceLocationMaster;
import resource_location_mgmt_admin.model.master.ResourceLocationMasterPK;
import resource_location_mgmt_admin.model.repo.ResourceLocationMasterAdmin_Repo;

@Service("resourceLocationMasterServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceLocationMasterAdmin_Service implements I_ResourceLocationMasterAdmin_Service 
{

	@Autowired
	private ResourceLocationMasterAdmin_Repo resourceLocationMasterAdminRepo;

	public ResourceLocationMaster_DTO newPartyLocationResource(ResourceLocationMaster_DTO lMaster) 
	{
		ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
		resourceLocationMasterPK.setLocationSeqNo(lMaster.getLocationSeqNo());
		resourceLocationMasterPK.setResourceSeqNo(lMaster.getResourceSeqNo());
		resourceLocationMasterPK.setPartySeqNo(lMaster.getResourceSeqNo());
		Optional<ResourceLocationMaster> resOptional = resourceLocationMasterAdminRepo.findById(resourceLocationMasterPK);
		ResourceLocationMaster resourceLocationMaster = null;
		ResourceLocationMaster_DTO resourceLocationMasterDTO = null;
		
		if(!resOptional.isPresent())
		{
		resourceLocationMaster = this.setResourceLocationMaster(lMaster);
		resourceLocationMaster.setId(resourceLocationMasterPK);
		resourceLocationMasterDTO=getResourceLocationMaster_DTO(resourceLocationMasterAdminRepo.save(resourceLocationMaster));
		}	
		return resourceLocationMasterDTO;
	}

	public void updPartyLocationResource(ResourceLocationMaster_DTO lDTO) 
	{
		ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(lDTO.getLocationSeqNo());
 		resourceLocationMasterPK.setResourceSeqNo(lDTO.getResourceSeqNo());
 		resourceLocationMasterPK.setPartySeqNo(lDTO.getPartySeqNo());
 		 		
 		if(resourceLocationMasterAdminRepo.existsById(resourceLocationMasterPK))
 		{
 			resourceLocationMasterAdminRepo.save(this.setResourceLocationMaster(lDTO));	
 		}
 	
		return;
	}

	
	public ArrayList<ResourceLocationMaster_DTO> getAllPartyLocationResources() 
	{
		ArrayList<ResourceLocationMaster> resourceList = (ArrayList<ResourceLocationMaster>) resourceLocationMasterAdminRepo.findAll();
		ArrayList<ResourceLocationMaster_DTO> lMasters = new ArrayList<ResourceLocationMaster_DTO>();
		lMasters = resourceList != null ? this.getResourceLocationMaster_DTOs(resourceList) : null;
		return lMasters;
	}

	public ArrayList<ResourceLocationMaster_DTO> getSelectResourcesPartyLocations(ArrayList<ResourceLocationMasterPK> resourceLocationMasterPKs)
	{
		ArrayList<ResourceLocationMaster> lMasters = (ArrayList<ResourceLocationMaster>) resourceLocationMasterAdminRepo.findAllById(resourceLocationMasterPKs);
		ArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new ArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
	}
	
	
	public ArrayList<ResourceLocationMaster_DTO> getSelectResourcesByLocations( ArrayList<Long> lidss)
	{
		ArrayList<ResourceLocationMaster> lMasters = resourceLocationMasterAdminRepo.getSelectResourcesByLocations(lidss);
		ArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new ArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
	}

	public ArrayList<ResourceLocationMaster_DTO> getSelectResourcesByParties(ArrayList<Long> pids)
	{
		ArrayList<ResourceLocationMaster> lMasters = resourceLocationMasterAdminRepo.getSelectResourcesByParties(pids);
		ArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new ArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
	}

    public ArrayList<ResourceLocationMaster_DTO> getSelectResources(ArrayList<Long> rids)
	{
		ArrayList<ResourceLocationMaster> lMasters = resourceLocationMasterAdminRepo.getSelectResources(rids);
		ArrayList<ResourceLocationMaster_DTO> resourceLocationMaster_DTOs = new ArrayList<ResourceLocationMaster_DTO>();
		resourceLocationMaster_DTOs = resourceLocationMaster_DTOs != null ? this.getResourceLocationMaster_DTOs(lMasters) : null;
		return resourceLocationMaster_DTOs;
	}

    public void delSelectResourcesByLocations( ArrayList<Long> lids)
    {
    resourceLocationMasterAdminRepo.delSelectResourcesByLocations(lids);
    }
    
    public void delSelectResourcesByParties( ArrayList<Long> pidss)
    {
    resourceLocationMasterAdminRepo.delSelectResourcesByParties(pidss);
    }
    
    public void delSelectResources( ArrayList<Long> ridss)
    {
    resourceLocationMasterAdminRepo.delSelectResources(ridss);
    }
    
    public void delAllPartyLocationResource() 
	{
		resourceLocationMasterAdminRepo.deleteAll();
	}

	
	private synchronized ArrayList<ResourceLocationMaster_DTO> getResourceLocationMaster_DTOs(ArrayList<ResourceLocationMaster> lMaster) 
	{
		ResourceLocationMaster_DTO lDTO = null;
		ArrayList<ResourceLocationMaster_DTO> lMasterDTOs = new ArrayList<ResourceLocationMaster_DTO>();		
		for (int i = 0; i < lMaster.size(); i++) {
			lDTO = getResourceLocationMaster_DTO(lMaster.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized ResourceLocationMaster_DTO getResourceLocationMaster_DTO(ResourceLocationMaster lMaster) 
	{		
		ResourceLocationMaster_DTO lDTO = new ResourceLocationMaster_DTO();
		lDTO.setLocationSeqNo(lMaster.getId().getLocationSeqNo());		
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		lDTO.setPartySeqNo(lMaster.getId().getPartySeqNo());
		lDTO.setQtySeqNo(lMaster.getQtySeqNo());
		lDTO.setQty(lMaster.getQty());
		return lDTO;
	}
	
	private synchronized ResourceLocationMaster setResourceLocationMaster(ResourceLocationMaster_DTO lDTO) 
	{
		ResourceLocationMaster lMaster = new ResourceLocationMaster();
		ResourceLocationMasterPK resourceLocationMasterPK= new ResourceLocationMasterPK();
 		resourceLocationMasterPK.setLocationSeqNo(lDTO.getLocationSeqNo());
 		resourceLocationMasterPK.setResourceSeqNo(lDTO.getResourceSeqNo());
 		resourceLocationMasterPK.setPartySeqNo(lDTO.getPartySeqNo());
 		lMaster.setId(resourceLocationMasterPK);
		lMaster.setQty(lDTO.getQty());
		lMaster.setQtySeqNo(lDTO.getQtySeqNo());
		return lMaster;
	}

}