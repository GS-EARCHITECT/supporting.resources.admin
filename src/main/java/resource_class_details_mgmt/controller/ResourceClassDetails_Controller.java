package resource_class_details_mgmt.controller;

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
import resource_class_details_mgmt.model.dto.ResourceClassDetail_DTO;
import resource_class_details_mgmt.model.master.ResourceClassDetailPK;
import resource_class_details_mgmt.service.I_ResourceClassDetails_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceClassDetailsManagement")
public class ResourceClassDetails_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ResourceClassDetails_Controller.class);

	@Autowired
	private I_ResourceClassDetails_Service resourceClassDetailsServ;
	
	@PostMapping("/new")
	public ResponseEntity<ResourceClassDetail_DTO> newresourceClass(@RequestBody ResourceClassDetail_DTO resourceClassDTO) {
		ResourceClassDetail_DTO resourceClassDTO2 = resourceClassDetailsServ.newResourceClassDetail(resourceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllResourceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassDetail_DTO>> getAllResourceClassDetails() {
		ArrayList<ResourceClassDetail_DTO> resourceClassDTOs = resourceClassDetailsServ.getAllResourceClassDetails();
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourceClasses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassDetail_DTO>> getSelectResourceClassDetails(@RequestBody ArrayList<ResourceClassDetailPK> ids) 
	{
		ArrayList<ResourceClassDetail_DTO> resourceClassDTOs = resourceClassDetailsServ.getSelectResourceClassDetails(ids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResourcesForClasses", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassDetail_DTO>> getSelectResourcesForClasses(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceClassDetail_DTO> resourceClassDTOs = resourceClassDetailsServ.getSelectResourcesForClasses(ids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}	
	
	@PutMapping("/updResourceClassDetail")
	public void updateResourceClassDetail(@RequestBody ResourceClassDetail_DTO resourceClassDetailsDTO) 
	{
		resourceClassDetailsServ.updResourceClassDetail(resourceClassDetailsDTO);	
		return;
	}

	
	@DeleteMapping("/delSelectResourceClassDetails")
	public void deleteSelectresourceClassDetails(@RequestBody ArrayList<ResourceClassDetailPK> ids)
	{
		resourceClassDetailsServ.delSelectResourceClassDetails(ids);
		return;
	}
	
	@DeleteMapping("/delAllResourceClassDetails")
	public void deleteAllresourceClassDetails() {
		resourceClassDetailsServ.delAllResourceClassDetails();;
		return;
	}
	}