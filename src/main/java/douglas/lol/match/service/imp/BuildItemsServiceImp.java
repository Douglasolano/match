package douglas.lol.match.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import douglas.lol.match.entity.Build;
import douglas.lol.match.entity.BuildItems;
import douglas.lol.match.entity.Item;
import douglas.lol.match.entityDTO.BuildItemsDTO;
import douglas.lol.match.entityDTO.ItemDTO;
import douglas.lol.match.exception.BussinesRuleException;
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
					.orElseThrow(() -> new BussinesRuleException("Build not found: " + dto.getBuildId()));
			
			Item realItem = itemRepo
					.findById(bd.getItemID())
					.orElseThrow(() -> new BussinesRuleException("Item not found: " + bd.getItemID()));
			
			build.setBuildId(realBuild);
			build.setItemId(realItem);
			repository.save(build);
		}
		
		return null; 
	}
	
	@Override
	@Transactional
	public void deleteBuildItems(Integer id) {
		
		BuildItems build = repository
				.findById(id)
				.orElseThrow(() -> new BussinesRuleException("Build not found: " + id));
		
		repository.deleteBuildItems(id);
	}
}
