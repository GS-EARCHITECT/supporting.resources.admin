package resource_class_structure_mgmt.controller;

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
import resource_class_structure_mgmt.model.dto.ResourceClassStructure_DTO;
import resource_class_structure_mgmt.service.I_ResourceClassStructure_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/resourceClassStructureManagement")
public class ResourceClassStructure_Controller 
{

//	private static final Logger logger = LoggerFactory.getLogger(ResourceClassStructure_Controller.class);

	@Autowired
	private I_ResourceClassStructure_Service resourceClassStructureServ;
	
	@PostMapping("/new")
	public ResponseEntity<ResourceClassStructure_DTO> newResourceClass(@RequestBody ResourceClassStructure_DTO resourceClassDTO) {
		ResourceClassStructure_DTO resourceClassDTO2 = resourceClassStructureServ.newResourceClassStructure(resourceClassDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(resourceClassDTO2, httpHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getAllResourceClassStructures", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassStructure_DTO>> getAllResourceClassStructures() {
		ArrayList<ResourceClassStructure_DTO> resourceClassDTOs = resourceClassStructureServ.getAllResourceClassStructures();
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectResourceClassStructures", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassStructure_DTO>> getSelectResourceClassStructures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids) 
	{
		ArrayList<ResourceClassStructure_DTO> resourceClassDTOs = resourceClassStructureServ.getSelectResourceClassStructures(ids, pids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResourceClassStructuresByParents", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassStructure_DTO>> getSelectResourceClassStructuresByParents(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceClassStructure_DTO> resourceClassDTOs = resourceClassStructureServ.getSelectResourceClassStructuresByParents(ids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}	
	
	@GetMapping(value = "/getSelectResourceClassStructuresByParties", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<ResourceClassStructure_DTO>> getSelectResourceClassStructuresByParties(@RequestBody ArrayList<Long> ids) 
	{
		ArrayList<ResourceClassStructure_DTO> resourceClassDTOs = resourceClassStructureServ.getSelectResourceClassStructuresByParties(ids);		
		return new ResponseEntity<>(resourceClassDTOs, HttpStatus.OK);
	}
	
	@PutMapping("/updResourceClassStructure")
	public void updateResourceClassStructure(@RequestBody ResourceClassStructure_DTO resourceClassStructureDTO) 
	{
		resourceClassStructureServ.updResourceClassStructure(resourceClassStructureDTO);	
		return;
	}

	
	@DeleteMapping("/delSelectResourceClassStrucures")
	public void deleteSelectresourceClassStrucures(@RequestBody ArrayList<Long> ids, @RequestBody ArrayList<Long> pids)
	{
		resourceClassStructureServ.delSelectResourceClassStructures(ids, pids);
		return;
	}
	
	@DeleteMapping("/delSelectResourceClassStrucuresByParties")
	public void deleteSelectresourceClassStrucuresByParties(@RequestBody ArrayList<Long> ids)
	{
		resourceClassStructureServ.delSelectResourceClassStructuresByParties(ids);
		return;
	}
	
	@DeleteMapping("/delSelectResourceClassStrucuresByParents")
	public void deleteSelectresourceClassStrucuresByParents(@RequestBody ArrayList<Long> ids)
	{
		resourceClassStructureServ.delSelectResourceClassStructuresByParents(ids);
		return;
	}

	@DeleteMapping("/delAllresourceClass")
	public void deleteAllresourceClasss() {
		resourceClassStructureServ.delAllResourceClassStructures();;
		return;
	}
	}