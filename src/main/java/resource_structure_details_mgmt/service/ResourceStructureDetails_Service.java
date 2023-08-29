package resource_structure_details_mgmt.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import resource_structure_details_mgmt.model.dto.ResourceStructureDetail_DTO;
import resource_structure_details_mgmt.model.master.ResourceStructureDetail;
import resource_structure_details_mgmt.model.master.ResourceStructureDetailPK;
import resource_structure_details_mgmt.model.repo.ResourceStructureDetails_Repo;

@Service("resourceStructureDetailServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceStructureDetails_Service implements I_ResourceStructureDetails_Service 
{

	@Autowired
	private ResourceStructureDetails_Repo ResourceStructureDetailsRepo;

	public ResourceStructureDetail_DTO newResourceStructureDetail(ResourceStructureDetail_DTO lStructure) 
	{
		ResourceStructureDetail_DTO ResourceStructureDetailDTO = null;
		ResourceStructureDetailPK ResourceStructureDetailPK = new ResourceStructureDetailPK();
		ResourceStructureDetailPK.setParResourceClassSeqNo(lStructure.getParResourceClassSeqNo());
		ResourceStructureDetailPK.setResourceClassSeqNo(lStructure.getResourceClassSeqNo());
		ResourceStructureDetailPK.setParResourceSeqNo(lStructure.getParResourceSeqNo());
		ResourceStructureDetailPK.setResourceSeqNo(lStructure.getResourceSeqNo());
		
		if (!ResourceStructureDetailsRepo.existsById(ResourceStructureDetailPK)) 
		{			
			ResourceStructureDetailDTO = getResourceStructureDetail_DTO(
			ResourceStructureDetailsRepo.save(this.setResourceStructureDetail(lStructure)));
		}
		return ResourceStructureDetailDTO;
	}
	
	public void updResourceStructureDetail(ResourceStructureDetail_DTO lStructure) 
	{
		ResourceStructureDetailPK ResourceStructureDetailPK = new ResourceStructureDetailPK();
		ResourceStructureDetailPK.setParResourceClassSeqNo(lStructure.getParResourceClassSeqNo());
		ResourceStructureDetailPK.setResourceClassSeqNo(lStructure.getResourceClassSeqNo());
		ResourceStructureDetailPK.setParResourceSeqNo(lStructure.getParResourceSeqNo());
		ResourceStructureDetailPK.setResourceSeqNo(lStructure.getResourceSeqNo());

		if (ResourceStructureDetailsRepo.existsById(ResourceStructureDetailPK)) 
		{
			ResourceStructureDetailsRepo.save(this.setResourceStructureDetail(lStructure));
		}
		return;
	}

	public ArrayList<ResourceStructureDetail_DTO> getAllResourceStructureDetails()
    {
		ArrayList<ResourceStructureDetail> lDetails = (ArrayList<ResourceStructureDetail>) ResourceStructureDetailsRepo.findAll();
		ArrayList<ResourceStructureDetail_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceStructureDetail_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}

	
	public ArrayList<ResourceStructureDetail_DTO> getSelectResourceStructureDetails(ArrayList<ResourceStructureDetailPK> ids)
    {
		ArrayList<ResourceStructureDetail> lDetails = (ArrayList<ResourceStructureDetail>) ResourceStructureDetailsRepo.findAllById(ids);
		ArrayList<ResourceStructureDetail_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceStructureDetail_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}
	
	public ArrayList<ResourceStructureDetail_DTO> getSelectResourceStructureDetailsByResources(ArrayList<Long> ids, ArrayList<Long> cids)
    {
		ArrayList<ResourceStructureDetail> lDetails = ResourceStructureDetailsRepo.getSelectResourceStructureDetailsByResources(ids, cids);
		ArrayList<ResourceStructureDetail_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceStructureDetail_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}
	
	public ArrayList<ResourceStructureDetail_DTO> getSelectResourceStructureDetailsByParents(ArrayList<Long> ids)
    {
		ArrayList<ResourceStructureDetail> lDetails = ResourceStructureDetailsRepo.getSelectResourceClassesByParents(ids);
		ArrayList<ResourceStructureDetail_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceStructureDetail_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}
	
	public void delAllResourceStructureDetails() {
		ResourceStructureDetailsRepo.deleteAll();
	}

	public void delSelectResourceStructureDetails(ArrayList<ResourceStructureDetailPK> ids) 
	{
		if (ids != null) 
		{
			ResourceStructureDetailsRepo.deleteAllById(ids);
		}
	}
	
	
	public void delSelectResourceStructureDetailsByResources(ArrayList<Long> ids, ArrayList<Long> cids) 
	{
		if (ids != null)
		{
			ResourceStructureDetailsRepo.delSelectResourceStructureDetailsByResources(ids, cids);
		}
	}
	
	public void delSelectResourceStructureDetailsByParents(ArrayList<Long> pids) 
	{
		if (pids != null)
		{
			ResourceStructureDetailsRepo.delSelectResourceStructureDetailsByParents(pids);
		}
	}
	
	
	private ArrayList<ResourceStructureDetail_DTO> getResourceStructureDetail_DTOs(
			ArrayList<ResourceStructureDetail> lStructures) {
		ResourceStructureDetail_DTO lDTO = null;
		ArrayList<ResourceStructureDetail_DTO> lStructureDTOs = new ArrayList<ResourceStructureDetail_DTO>();
		for (int i = 0; i < lStructures.size(); i++) {
			lDTO = getResourceStructureDetail_DTO(lStructures.get(i));
			lStructureDTOs.add(lDTO);
		}
		return lStructureDTOs;
	}

	private ResourceStructureDetail_DTO getResourceStructureDetail_DTO(ResourceStructureDetail lStructure) {
		ResourceStructureDetail_DTO lDTO = new ResourceStructureDetail_DTO();
		lDTO.setParResourceClassSeqNo(lStructure.getId().getParResourceClassSeqNo());
		lDTO.setResourceClassSeqNo(lStructure.getId().getResourceClassSeqNo());
		lDTO.setParResourceSeqNo(lStructure.getId().getParResourceSeqNo());
		lDTO.setResourceSeqNo(lStructure.getId().getResourceSeqNo());
		return lDTO;
	}

	private ResourceStructureDetail setResourceStructureDetail(ResourceStructureDetail_DTO lDTO) 
	{
		ResourceStructureDetail lStructure = new ResourceStructureDetail();
		ResourceStructureDetailPK ResourceStructureDetailPK = new ResourceStructureDetailPK();
		ResourceStructureDetailPK.setParResourceClassSeqNo(lDTO.getParResourceClassSeqNo());
		ResourceStructureDetailPK.setResourceClassSeqNo(lDTO.getResourceClassSeqNo());
		ResourceStructureDetailPK.setParResourceSeqNo(lDTO.getParResourceSeqNo());
		ResourceStructureDetailPK.setResourceSeqNo(lDTO.getResourceSeqNo());
		lStructure.setId(ResourceStructureDetailPK);
		return lStructure;
	}
}