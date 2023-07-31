package douglas.lol.match.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import douglas.lol.match.entity.Build;
import douglas.lol.match.entity.BuildItems;
import douglas.lol.match.entity.Item;
import douglas.lol.match.entityDTO.BuildItemsDTO;
import douglas.lol.match.entityDTO.ItemDTO;
import douglas.lol.match.repository.BuildItemsRepository;
import douglas.lol.match.repository.BuildRepository;
import douglas.lol.match.repository.ItemRepository;
import douglas.lol.match.service.BuildItemsService;
import jakarta.transaction.Transactional;

@Service
public class BuildItemsServiceImp implements BuildItemsService{

	@Autowired
	private BuildRepository buildRepo;
	
	@Autowired 
	private ItemRepository itemRepo;
	
	@Autowired
	private BuildItemsRepository repository;
	
	
	@Override
	@Transactional
	public BuildItems saveBuildItems(BuildItemsDTO dto) {
		
		for ( ItemDTO bd : dto.getItemId() ) {
			
			BuildItems build = new BuildItems();
			
			Build realBuild = buildRepo
					.findById(dto.getBuildId())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
																   "Build not found: " + dto.getBuildId()));
			
			Item realItem = itemRepo
					.findById(bd.getItemID())
					.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
																   "Item not found: " + bd.getItemID()));
			
			build.setBuildId(realBuild);
			build.setItemId(realItem);
			repository.save(build);
		}
		
		return null; 
	}
}
