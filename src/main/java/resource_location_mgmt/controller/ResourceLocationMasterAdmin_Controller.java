package resource_location_mgmt.controller;

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

import resource_location_mgmt.model.dto.ResourceLocationMaster_DTO;
import resource_location_mgmt.model.master.ResourceLocationMasterPK;
import resource_location_mgmt.services.I_ResourceLocationMasterAdmin_Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceLocationMasterAdminManagement")
public class ResourceLocationMasterAdmin_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(ResourceLocationMaster_Controller.class);

	@Autowired
	private I_ResourceLocationMasterAdmin_Service resourceLocationMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<ResourceLocationMaster_DTO> newResourc(@RequestBody ResourceLocationMaster_DTO resourceDTO) {
		ResourceLocationMaster_DTO resourceDTO2 = resourceLocationMasterAdminServ.newPartyLocationResource(resourceDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping("/updPartyLocationResource")
	public void updPartyLocationResource(@RequestBody ResourceLocationMaster_DTO resourceLocationMaster_DTO) {
		resourceLocationMasterAdminServ.updPartyLocationResource(resourceLocationMaster_DTO);
		return;
	}

	@GetMapping(value = "/getAllPartyLocationResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceLocationMaster_DTO>> getAllPartyLocationResources() {
		ArrayList<ResourceLocationMaster_DTO> resourceDTOs = resourceLocationMasterAdminServ
				.getAllPartyLocationResources();
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourcesPartyLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceLocationMaster_DTO>> getSelectResourcesPartyLocations(
			@RequestBody ArrayList<ResourceLocationMasterPK> lids) {
		ArrayList<ResourceLocationMaster_DTO> resourceDTOs = resourceLocationMasterAdminServ
				.getSelectResourcesPartyLocations(lids);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourcesByLocations", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByLocations(
			@RequestBody ArrayList<Long> llids) {
		ArrayList<ResourceLocationMaster_DTO> resourceDTOs = resourceLocationMasterAdminServ
				.getSelectResourcesByLocations(llids);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResourcesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceLocationMaster_DTO>> getSelectResourcesByParties(
			@RequestBody ArrayList<Long> pids) {
		ArrayList<ResourceLocationMaster_DTO> resourceDTOs = resourceLocationMasterAdminServ
				.getSelectResourcesByParties(pids);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceLocationMaster_DTO>> getSelectResources(@RequestBody ArrayList<Long> rids) {
		ArrayList<ResourceLocationMaster_DTO> resourceDTOs = resourceLocationMasterAdminServ.getSelectResources(rids);
		return new ResponseEntity<>(resourceDTOs, HttpStatus.OK);
	}

	@DeleteMapping("/delSelectResourcesByLocations")
	public void delSelectResourcesByLocations(@RequestBody ArrayList<Long> lids) {
		resourceLocationMasterAdminServ.delSelectResourcesByLocations(lids);
	}

	@DeleteMapping("/delSelectResourcesByParties")
	public void delSelectResourcesByParties(@RequestBody ArrayList<Long> pids) {
		resourceLocationMasterAdminServ.delSelectResourcesByParties(pids);
	}

	@DeleteMapping("/delSelectResources")
	public void delSelectResources(@RequestBody ArrayList<Long> rids) {
		resourceLocationMasterAdminServ.delSelectResources(rids);
	}

	@DeleteMapping("/delAllresource")
	public void deleteAllresources() {
		resourceLocationMasterAdminServ.delAllPartyLocationResource();
		return;
	}
}