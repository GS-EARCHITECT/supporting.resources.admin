package resource_structure_details_mgmt.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resource_structure_details_mgmt.model.dto.ResourceStructureDetail_DTO;
import resource_structure_details_mgmt.model.master.ResourceStructureDetailPK;
import resource_structure_details_mgmt.service.I_ResourceStructureDetails_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceStructureDetailsManagement")
public class ResourceStructureDetails_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ResourceStructureDetail_Controller.class);

	@Autowired
	private I_ResourceStructureDetails_Service resourceStructureDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<ResourceStructureDetail_DTO> newResourceClass(@RequestBody ResourceStructureDetail_DTO resourceClassDTO) {
		ResourceStructureDetail_DTO resourceClassDTO2 = resourceStructureDetailsServ.newResourceStructureDetail(resourceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllResourceStructureDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceStructureDetail_DTO>> getAllResourceStructureDetails() {
		ArrayList<ResourceStructureDetail_DTO> resourceClassDTOs = resourceStructureDetailsServ.getAllResourceStructureDetails();
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourceStructureDetails", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceStructureDetail_DTO>> getSelectResourceStructureDetails(@RequestBody ArrayList<ResourceStructureDetailPK> ids) 
	{
		ArrayList<ResourceStructureDetail_DTO> resourceClassDTOs = resourceStructureDetailsServ.getSelectResourceStructureDetails(ids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResourceStructureDetailsByParents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceStructureDetail_DTO>> getSelectResourceStructureDetailsByParents(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceStructureDetail_DTO> resourceClassDTOs = resourceStructureDetailsServ.getSelectResourceStructureDetailsByParents(ids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResourceStructureDetailsByResources", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceStructureDetail_DTO>> getSelectResourceStructureDetailsByResources(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> cids) 
	{
		ArrayList<ResourceStructureDetail_DTO> resourceClassDTOs = resourceStructureDetailsServ.getSelectResourceStructureDetailsByResources(ids, cids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updResourceStructureDetail")
	public void updateResourceStructureDetail(@RequestBody ResourceStructureDetail_DTO resourceStructureDetailDTO) 
	{
		resourceStructureDetailsServ.updResourceStructureDetail(resourceStructureDetailDTO);	
		return;
	}
	
	@DeleteMapping("/delSelectResourceStructureDetails")
	public void deleteSelectresourceStructureDetails(@RequestBody ArrayList<ResourceStructureDetailPK> ids)
	{
		resourceStructureDetailsServ.delSelectResourceStructureDetails(ids);
		return;
	}
	
	@DeleteMapping("/delSelectResourceStructureDetailsByResources")
	public void deleteSelectresourceStructureDetailsByResources(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		resourceStructureDetailsServ.delSelectResourceStructureDetailsByResources(ids, pids);
		return;
	}
	
	@DeleteMapping("/delSelectResourceStructureDetailsByParents")
	public void deleteSelectresourceStructureDetailsByParents(@RequestBody ArrayList<Long> ids)
	{
		resourceStructureDetailsServ.delSelectResourceStructureDetailsByParents(ids);
		return;
	}

	@DeleteMapping("/delAllresourceClass")
	public void deleteAllresourceClasss() {
		resourceStructureDetailsServ.delAllResourceStructureDetails();;
		return;
	}
	}