package resource_party_mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource_party_mgmt.model.dto.ResourcePartyMaster_DTO;
import resource_party_mgmt.service.I_ResourcePartyMasterAdmin_Service;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourcePartyAdminManagement")
public class ResourcePartyMasterAdmin_Controller
{

//	private static final Logger logger = LoggerFactory.getLogger(ResourceMaster_Controller.class);

	@Autowired
	private I_ResourcePartyMasterAdmin_Service resourcePartyMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<ResourcePartyMaster_DTO> newPartyResource(@RequestBody ResourcePartyMaster_DTO resourcePartyMasterDTO) 
	{
		ResourcePartyMaster_DTO resourcePartyMaster_DTO2 = resourcePartyMasterAdminServ.newResourcePartyMaster(resourcePartyMasterDTO);
		HttpHeaders httpHeaders = new HttpHeaders();		
		return new ResponseEntity<>(resourcePartyMaster_DTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping("/updResourcePartyMaster")
	public void updResourcePartyMaster(@RequestBody ResourcePartyMaster_DTO resourceDTO) 
	{
			resourcePartyMasterAdminServ.updResourcePartyMaster(resourceDTO);;	
		return;
	}
	
	@GetMapping(value = "/getAllResourcePartyMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourcePartyMaster_DTO>> getAllResourceMasters() {
		ArrayList<ResourcePartyMaster_DTO> resourceDTOs = resourcePartyMasterAdminServ.getAllResourcePartyMasters();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResources", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourcePartyMaster_DTO>> getSelectResourceMasters(@RequestBody ArrayList<Long> resourceSeqNos) {
		ArrayList<ResourcePartyMaster_DTO> resourceDTOs = resourcePartyMasterAdminServ.getSelectResources(resourceSeqNos);		
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResourcesByResourceIds", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourcePartyMaster_DTO>> getSelectResourcesByResourceIds(@RequestBody ArrayList<String> ids) 
	{
		ArrayList<ResourcePartyMaster_DTO> resourceDTOs = resourcePartyMasterAdminServ.getSelectResourcesByResourceIds(ids);		
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResourcesByOEMs", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourcePartyMaster_DTO>> getSelectResourceMastersByOEMs(@RequestBody ArrayList<Long> cos) {
		ArrayList<ResourcePartyMaster_DTO> resourceDTOs = resourcePartyMasterAdminServ.getSelectResourcesByOEMs(cos);		
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourcesByParties", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourcePartyMaster_DTO>> getSelectResourceMastersByParties(@RequestBody ArrayList<Long> cos) {
		ArrayList<ResourcePartyMaster_DTO> resourceDTOs = resourcePartyMasterAdminServ.getSelectResourceByParties(cos);		
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourcesByPriceRange/{fr}/{to}", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourcePartyMaster_DTO>> getSelectResourceMastersByPriceRange(@PathVariable Float fr, @PathVariable Float to) {
		ArrayList<ResourcePartyMaster_DTO> resourceDTOs = resourcePartyMasterAdminServ.getSelectResourcesByPriceRange(fr, to);		
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}
	
	@DeleteMapping("/delAllResourcePartyMasters")
	public void deleteAlldelAllResourcePartyMasters() {
		resourcePartyMasterAdminServ.delAllResourcePartyMasters();
		return;
	}
	
	@DeleteMapping("/delSelectResources")
	public void delSelectResources(@RequestBody ArrayList<Long> resourceSeqNoList) {
		resourcePartyMasterAdminServ.delSelectResources(resourceSeqNoList);;
		return;
	}

	@DeleteMapping("/delSelectResourceByParties")
	public void delSelectResourceByParties(@RequestBody ArrayList<Long> resourceSeqNoList) {
		resourcePartyMasterAdminServ.delSelectResourceByParties(resourceSeqNoList);;
		return;
	}

	@DeleteMapping("/delSelectResourcesByOEMs")
	public void delSelectResourcesByOEMs(@RequestBody ArrayList<Long> resourceSeqNoList) {
		resourcePartyMasterAdminServ.delSelectResourcesByOEMs(resourceSeqNoList);;
		return;
	}
	
	@DeleteMapping("/deltSelectResourcesByPriceRange/{fr}/{to}")
	public void delSelectResourceMastersByPriceRange(@PathVariable Float fr, @PathVariable Float to) 
	{
		resourcePartyMasterAdminServ.delSelectResourcesByPriceRange(fr, to);
		return;
		
	}
	
}
	