package resource_class_details_mgmt.service;

import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import resource_class_details_mgmt.model.dto.ResourceClassDetail_DTO;
import resource_class_details_mgmt.model.master.ResourceClassDetail;
import resource_class_details_mgmt.model.master.ResourceClassDetailPK;
import resource_class_details_mgmt.model.repo.ResourceClassDetails_Repo;

@Service("resourceClassDetailsServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceClassDetail_Service implements I_ResourceClassDetails_Service 
{

	@Autowired
	private ResourceClassDetails_Repo resourceClassDetailsRepo;

	public ResourceClassDetail_DTO newResourceClassDetail(ResourceClassDetail_DTO lDetails) 
	{
		Optional<ResourceClassDetail> resourceClassDetails = null;
		ResourceClassDetail_DTO resourceClassDetailsDTO = null;
		ResourceClassDetailPK resourceClassDetailsPK = new ResourceClassDetailPK();
		resourceClassDetailsPK.setResourceSeqNo(lDetails.getResourceSeqNo());
		resourceClassDetailsPK.setResourceClassSeqNo(lDetails.getResourceClassSeqNo());
		resourceClassDetails = resourceClassDetailsRepo.findById(resourceClassDetailsPK);
		
		if(!resourceClassDetails.isPresent())
		{
		resourceClassDetails.get().setId(resourceClassDetailsPK);	
		resourceClassDetailsDTO = 	getResourceClassDetail_DTO(resourceClassDetailsRepo.save(resourceClassDetails.get()));
		}
		return resourceClassDetailsDTO;
	}

	public ArrayList<ResourceClassDetail_DTO> getAllResourceClassDetails() {
		ArrayList<ResourceClassDetail> resourceList = (ArrayList<ResourceClassDetail>) resourceClassDetailsRepo.findAll();
		ArrayList<ResourceClassDetail_DTO> lDetails = new ArrayList<ResourceClassDetail_DTO>();
		lDetails = resourceList != null ? this.getResourceClassDetail_DTOs(resourceList) : null;
		return lDetails;
	}

    
	public ArrayList<ResourceClassDetail_DTO> getSelectResourcesForClasses(ArrayList<Long> ids)
    {
		ArrayList<ResourceClassDetail> lDetails = resourceClassDetailsRepo.getSelectResourcesForClasses(ids);
		ArrayList<ResourceClassDetail_DTO> resourceClassDetailsDTOs = null;
		resourceClassDetailsDTOs = lDetails != null ? this.getResourceClassDetail_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}

	public ArrayList<ResourceClassDetail_DTO> getSelectResourceClassDetails(ArrayList<ResourceClassDetailPK> ids)
    {
		ArrayList<ResourceClassDetail> lDetails = (ArrayList<ResourceClassDetail>) resourceClassDetailsRepo.findAllById(ids);
		ArrayList<ResourceClassDetail_DTO> resourceClassDetailsDTOs = null;
		resourceClassDetailsDTOs = lDetails != null ? this.getResourceClassDetail_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}
		
	public void updResourceClassDetail(ResourceClassDetail_DTO lDetails) 
	{
		ResourceClassDetailPK resourceClassDetailsPK = new ResourceClassDetailPK();
		resourceClassDetailsPK.setResourceSeqNo(lDetails.getResourceSeqNo());
		resourceClassDetailsPK.setResourceClassSeqNo(lDetails.getResourceClassSeqNo());	
		
		if (resourceClassDetailsRepo.existsById(resourceClassDetailsPK)) 
			{			
			resourceClassDetailsRepo.save(this.setResourceClassDetail(lDetails));			
		}
		return;
	}

	
	public void delAllResourceClassDetails() {
		resourceClassDetailsRepo.deleteAll();
	}

	public void delSelectResourceClassDetails(ArrayList<ResourceClassDetailPK> ids) 
	{
		if (ids != null) 
		{
			resourceClassDetailsRepo.deleteAllById(ids);
		}
	}
	
	public void delSelectResourcesForClasses(ArrayList<Long> ids) 
	{
		if (ids != null) 
		{
			resourceClassDetailsRepo.delSelectResourcesForClasses(ids);
		}
	}

	private ArrayList<ResourceClassDetail_DTO> getResourceClassDetail_DTOs(ArrayList<ResourceClassDetail> lDetails) {
		ResourceClassDetail_DTO lDTO = null;
		ArrayList<ResourceClassDetail_DTO> lDetailsDTOs = new ArrayList<ResourceClassDetail_DTO>();		
		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getResourceClassDetail_DTO(lDetails.get(i));			
			lDetailsDTOs.add(lDTO);
		}
		return lDetailsDTOs;
	}

	private ResourceClassDetail_DTO getResourceClassDetail_DTO(ResourceClassDetail lDetails) 
	{		
		ResourceClassDetail_DTO lDTO = new ResourceClassDetail_DTO();		
		lDTO.setResourceSeqNo(lDetails.getId().getResourceSeqNo());
		lDTO.setResourceClassSeqNo(lDetails.getId().getResourceClassSeqNo());
		return lDTO;
	}

	private ResourceClassDetail setResourceClassDetail(ResourceClassDetail_DTO lDTO) 
	{
		ResourceClassDetail lDetails = new ResourceClassDetail();
		ResourceClassDetailPK resourceClassDetailsPK = new ResourceClassDetailPK();
		resourceClassDetailsPK.setResourceSeqNo(lDTO.getResourceSeqNo());
		resourceClassDetailsPK.setResourceClassSeqNo(lDTO.getResourceClassSeqNo());
		lDetails.setId(resourceClassDetailsPK);
		return lDetails;
	}
}