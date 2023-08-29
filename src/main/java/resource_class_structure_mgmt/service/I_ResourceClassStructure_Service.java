package resource_class_structure_mgmt.service;

import java.util.ArrayList;
import resource_class_structure_mgmt.model.dto.ResourceClassStructure_DTO;

public interface I_ResourceClassStructure_Service
{
    public ResourceClassStructure_DTO newResourceClassStructure(ResourceClassStructure_DTO resourceClassStructureDTO);
    public ArrayList<ResourceClassStructure_DTO> getAllResourceClassStructures();    
    public ArrayList<ResourceClassStructure_DTO> getSelectResourceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);
    public ArrayList<ResourceClassStructure_DTO> getSelectResourceClassStructuresByParties( ArrayList<Long> ids);
    public ArrayList<ResourceClassStructure_DTO> getSelectResourceClassStructuresByParents(ArrayList<Long> ids);
	public void updResourceClassStructure(ResourceClassStructure_DTO resourceClassStructureDTO);
    public void delAllResourceClassStructures();
    public void delSelectResourceClassStructures(ArrayList<Long> ids, ArrayList<Long> pids);    
    public void delSelectResourceClassStructuresByParents(ArrayList<Long> ids);
    public void delSelectResourceClassStructuresByParties( ArrayList<Long> ids);
}