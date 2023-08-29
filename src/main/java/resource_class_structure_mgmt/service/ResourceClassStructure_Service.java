package resource_class_structure_mgmt.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import resource_class_details_mgmt.model.dto.ResourceClassDetail_DTO;
import resource_class_details_mgmt.model.master.ResourceClassDetail;
import resource_class_structure_mgmt.model.dto.ResourceClassStructure_DTO;
import resource_class_structure_mgmt.model.master.ResourceClassStructure;
import resource_class_structure_mgmt.model.master.ResourceClassStructurePK;
import resource_class_structure_mgmt.model.repo.ResourceClassStructureRepo;

@Service("resourceClassStructureServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourceClassStructure_Service implements I_ResourceClassStructure_Service 
{

	@Autowired
	private ResourceClassStructureRepo resourceClassStructureRepo;

	public ResourceClassStructure_DTO newResourceClassStructure(ResourceClassStructure_DTO lStructure) 
	{
		ResourceClassStructure_DTO resourceClassStructureDTO = null;
		ResourceClassStructurePK resourceClassStructurePK = new ResourceClassStructurePK();
		resourceClassStructurePK.setParResourceClassSeqNo(lStructure.getParResourceClassSeqNo());
		resourceClassStructurePK.setResourceClassSeqNo(lStructure.getResourceClassSeqNo());
		resourceClassStructurePK.setPartySeqNo(lStructure.getPartySeqNo());
		
		if (!resourceClassStructureRepo.existsById(resourceClassStructurePK)) 
		{			
			resourceClassStructureDTO = getResourceClassStructure_DTO(
			resourceClassStructureRepo.save(this.setResourceClassStructure(lStructure)));
		}
		return resourceClassStructureDTO;
	}
	
	public void updResourceClassStructure(ResourceClassStructure_DTO lStructure) 
	{
		ResourceClassStructurePK resourceClassStructurePK = new ResourceClassStructurePK();
		resourceClassStructurePK.setParResourceClassSeqNo(lStructure.getParResourceClassSeqNo());
		resourceClassStructurePK.setResourceClassSeqNo(lStructure.getResourceClassSeqNo());
		resourceClassStructurePK.setPartySeqNo(lStructure.getPartySeqNo());

		if (resourceClassStructureRepo.existsById(resourceClassStructurePK)) 
		{
			resourceClassStructureRepo.save(this.setResourceClassStructure(lStructure));
		}
		return;
	}

	public ArrayList<ResourceClassStructure_DTO> getSelectResourceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids)
    {
		ArrayList<ResourceClassStructure> lDetails = resourceClassStructureRepo.getSelectResourceClassStructures(ids, pids);
		ArrayList<ResourceClassStructure_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceClassStructure_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}
	
	public ArrayList<ResourceClassStructure_DTO> getAllResourceClassStructures()
    {
		ArrayList<ResourceClassStructure> lDetails = (ArrayList<ResourceClassStructure>) resourceClassStructureRepo.findAll();
		ArrayList<ResourceClassStructure_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceClassStructure_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}

	
	public ArrayList<ResourceClassStructure_DTO> getSelectResourceClassStructuresByParties( ArrayList<Long> ids)
    {
		ArrayList<ResourceClassStructure> lDetails = resourceClassStructureRepo.getSelectResourceClassStructuresByParties(ids);
		ArrayList<ResourceClassStructure_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceClassStructure_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}
	
	public ArrayList<ResourceClassStructure_DTO> getSelectResourceClassStructuresByParents(ArrayList<Long> ids)
    {
		ArrayList<ResourceClassStructure> lDetails = resourceClassStructureRepo.getSelectResourceClassStructuresByParents(ids);
		ArrayList<ResourceClassStructure_DTO> resourceClassDetailsDTOs = lDetails != null ? this.getResourceClassStructure_DTOs(lDetails) : null;
		return resourceClassDetailsDTOs;
	}
	
	public void delAllResourceClassStructures() {
		resourceClassStructureRepo.deleteAll();
	}

	public void delSelectResourceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids) 
	{
		if (ids != null && pids != null) {
			resourceClassStructureRepo.delSelectResourceClassStructures(ids, pids);
		}
	}
	
	public void delSelectResourceClassStructuresByParties(ArrayList<Long> ids) 
	{
		if (ids != null)
		{
			resourceClassStructureRepo.delSelectResourceClassStructuresByParties(ids);
		}
	}
	
	public void delSelectResourceClassStructuresByParents(ArrayList<Long> ids) 
	{
		if (ids != null)
		{
			resourceClassStructureRepo.delSelectResourceClassStructuresByParents(ids);
		}
	}

	private ArrayList<ResourceClassStructure_DTO> getResourceClassStructure_DTOs(
			ArrayList<ResourceClassStructure> lStructures) {
		ResourceClassStructure_DTO lDTO = null;
		ArrayList<ResourceClassStructure_DTO> lStructureDTOs = new ArrayList<ResourceClassStructure_DTO>();
		for (int i = 0; i < lStructures.size(); i++) {
			lDTO = getResourceClassStructure_DTO(lStructures.get(i));
			lStructureDTOs.add(lDTO);
		}
		return lStructureDTOs;
	}

	private ResourceClassStructure_DTO getResourceClassStructure_DTO(ResourceClassStructure lStructure) {
		ResourceClassStructure_DTO lDTO = new ResourceClassStructure_DTO();
		lDTO.setParResourceClassSeqNo(lStructure.getId().getParResourceClassSeqNo());
		lDTO.setResourceClassSeqNo(lStructure.getId().getResourceClassSeqNo());
		lDTO.setPartySeqNo(lStructure.getId().getPartySeqNo());
		return lDTO;
	}

	private ResourceClassStructure setResourceClassStructure(ResourceClassStructure_DTO lDTO) {
		ResourceClassStructure lStructure = new ResourceClassStructure();
		ResourceClassStructurePK resourceClassStructurePK = new ResourceClassStructurePK();
		resourceClassStructurePK.setParResourceClassSeqNo(lDTO.getParResourceClassSeqNo());
		resourceClassStructurePK.setResourceClassSeqNo(lDTO.getResourceClassSeqNo());
		resourceClassStructurePK.setPartySeqNo(lDTO.getPartySeqNo());
		lStructure.setId(resourceClassStructurePK);
		return lStructure;
	}
}