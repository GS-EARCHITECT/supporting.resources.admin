package resource_party_mgmt.service;

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
import resource_party_mgmt.model.dto.ResourcePartyMaster_DTO;
import resource_party_mgmt.model.master.ResourcePartyMaster;
import resource_party_mgmt.model.repo.ResourcePartyMasterAdmin_Repo;

@Service("resourcePartyMasterAdminServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class ResourcePartyMasterAdmin_Service implements I_ResourcePartyMasterAdmin_Service 
{

	@Autowired
	private ResourcePartyMasterAdmin_Repo resourceMasterAdminRepo;

	public ResourcePartyMaster_DTO newResourcePartyMaster(ResourcePartyMaster_DTO lMaster)
	{
		ResourcePartyMaster ResourcePartyMaster = resourceMasterAdminRepo.save(this.setResourcePartyMaster(lMaster));
		lMaster = getResourcePartyMaster_DTO(ResourcePartyMaster);
		return lMaster;
	}
	
	public void updResourcePartyMaster(ResourcePartyMaster_DTO lMaster) 
	{
		ResourcePartyMaster resourceMaster = this.setResourcePartyMaster(lMaster);
		if (resourceMasterAdminRepo.existsById(lMaster.getResourceSeqNo())) 
				{		
			resourceMaster.setResourceSeqNo(lMaster.getResourceSeqNo());			
			resourceMasterAdminRepo.save(resourceMaster);			
		}
		return;
	}

	public ArrayList<ResourcePartyMaster_DTO> getAllResourcePartyMasters() 
	{
		ArrayList<ResourcePartyMaster> resourceList = (ArrayList<ResourcePartyMaster>) resourceMasterAdminRepo.findAll();
		ArrayList<ResourcePartyMaster_DTO> lMasterss = resourceList != null ? this.getResourcePartyMaster_DTOs(resourceList) : null;
		return lMasterss;
	}

	public ArrayList<ResourcePartyMaster_DTO> getSelectResources(ArrayList<Long> ids)
	{
		ArrayList<ResourcePartyMaster> lMasters = (ArrayList<ResourcePartyMaster>) resourceMasterAdminRepo.findAllById(ids);
		ArrayList<ResourcePartyMaster_DTO> lMasterss = lMasters != null ? this.getResourcePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
	
	public ArrayList<ResourcePartyMaster_DTO> getSelectResourcesByResourceIds( ArrayList<String> ids)
	{
		ArrayList<ResourcePartyMaster> lMasters = resourceMasterAdminRepo.getSelectResourcesByResourceIds(ids);
		ArrayList<ResourcePartyMaster_DTO> lMasterss = lMasters != null ? this.getResourcePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
   
	public ArrayList<ResourcePartyMaster_DTO> getSelectResourcesByOEMs( ArrayList<Long> ids)
	{
		ArrayList<ResourcePartyMaster> lMasters = resourceMasterAdminRepo.getSelectResourcesByOEMs(ids);
		ArrayList<ResourcePartyMaster_DTO> lMasterss = lMasters != null ? this.getResourcePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
	
	public ArrayList<ResourcePartyMaster_DTO> getSelectResourceByParties( ArrayList<Long> ids)
	{
		ArrayList<ResourcePartyMaster> lMasters = resourceMasterAdminRepo.getSelectResourceeByParties(ids);
		ArrayList<ResourcePartyMaster_DTO> lMasterss = lMasters != null ? this.getResourcePartyMaster_DTOs(lMasters) : null;
		return lMasterss;	
	}
	
	public ArrayList<ResourcePartyMaster_DTO> getSelectResourcesByPriceRange(Float fr, Float to)
	{
		ArrayList<ResourcePartyMaster> lMasters = resourceMasterAdminRepo.getSelectResourcesByPriceRange(fr, to);
		ArrayList<ResourcePartyMaster_DTO> lMasterss = lMasters != null ? this.getResourcePartyMaster_DTOs(lMasters) : null;
		return lMasterss;
	}

	public void delAllResourcePartyMasters() {
		resourceMasterAdminRepo.deleteAll();
	}

	public void delSelectResources(ArrayList<Long> resourceSeqNos) 
	{
		if (resourceSeqNos != null) {
			resourceMasterAdminRepo.delSelectResources(resourceSeqNos);
		}
	}

	public void delSelectResourceByParties(ArrayList<Long> resourceSeqNos) 
	{
		if (resourceSeqNos != null) {
			resourceMasterAdminRepo.delSelectResourceByParties(resourceSeqNos);
		}
	}
	
	public void delSelectResourcesByOEMs(ArrayList<Long> resourceSeqNos) 
	{
		if (resourceSeqNos != null) {
			resourceMasterAdminRepo.delSelectResourcesByOEMs(resourceSeqNos);
		}
	}
	
	public void delSelectResourcesByPriceRange( Float fr, Float to) 
	{
		resourceMasterAdminRepo.delSelectResourcesByPriceRange(fr, to);
	
	}
	
	private ArrayList<ResourcePartyMaster_DTO> getResourcePartyMaster_DTOs(ArrayList<ResourcePartyMaster> lMasters) {
		ResourcePartyMaster_DTO lDTO = null;
		ArrayList<ResourcePartyMaster_DTO> lMasterDTOs = new ArrayList<ResourcePartyMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getResourcePartyMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private ResourcePartyMaster_DTO getResourcePartyMaster_DTO(ResourcePartyMaster lMaster) 
	{		
		ResourcePartyMaster_DTO lDTO = new ResourcePartyMaster_DTO();
		lDTO.setRemark(lMaster.getRemark());		
		lDTO.setUnitPrice(lMaster.getUnitPrice());
		lDTO.setUnitPriceSeqNo(lMaster.getUnitPriceSeqNo());
		lDTO.setDiscSeqNo(lMaster.getDiscSeqNo());
		lDTO.setDiscPer(lMaster.getDiscPer());
		lDTO.setDiscVal(lMaster.getDiscVal());
		lDTO.setTaxSeqNo(lMaster.getTaxSeqNo());
		lDTO.setTaxPer(lMaster.getTaxPer());
		lDTO.setTaxVal(lMaster.getTaxVal());
		lDTO.setQoh(lMaster.getQoh());
		lDTO.setSpecificationSeqNo(lMaster.getSpecificationSeqNo());		
		lDTO.setResourceId(lMaster.getResourceId());
		lDTO.setQtyCodeSeqNo(lMaster.getQtyCodeSeqNo());
		lDTO.setPartySeqNo(lMaster.getPartySeqNo());
		lDTO.setReorderLevel(lMaster.getReorderLevel());
		lDTO.setReorderQty(lMaster.getReorderQty());
		lDTO.setMaxQty(lMaster.getMaxQty());
		lDTO.setMasterResourceSeqNo(lMaster.getMasterResourceSeqNo());
		lDTO.setResourceSeqNo(lMaster.getResourceSeqNo());
		return lDTO;
	}

	private ResourcePartyMaster setResourcePartyMaster(ResourcePartyMaster_DTO lDTO) 
	{
		ResourcePartyMaster lMaster = new ResourcePartyMaster();				
		lMaster.setRemark(lDTO.getRemark());		
		lMaster.setUnitPrice(lDTO.getUnitPrice());
		lMaster.setUnitPriceSeqNo(lDTO.getUnitPriceSeqNo());
		lMaster.setDiscSeqNo(lDTO.getDiscSeqNo());
		lMaster.setDiscPer(lDTO.getDiscPer());
		lMaster.setDiscVal(lDTO.getDiscVal());
		lMaster.setTaxSeqNo(lDTO.getTaxSeqNo());
		lMaster.setTaxPer(lDTO.getTaxPer());
		lMaster.setTaxVal(lDTO.getTaxVal());
		lMaster.setQoh(lDTO.getQoh());
		lMaster.setSpecificationSeqNo(lDTO.getSpecificationSeqNo());		
		lMaster.setResourceId(lDTO.getResourceId());
		lMaster.setQtyCodeSeqNo(lDTO.getQtyCodeSeqNo());
		lMaster.setPartySeqNo(lDTO.getPartySeqNo());
		lMaster.setReorderLevel(lDTO.getReorderLevel());
		lMaster.setReorderQty(lDTO.getReorderQty());
		lMaster.setMaxQty(lDTO.getMaxQty());
		lMaster.setMasterResourceSeqNo(lDTO.getMasterResourceSeqNo());
		return lMaster;
	}
}