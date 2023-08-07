package douglas.lol.match.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import douglas.lol.match.entity.Build;
import douglas.lol.match.entity.Champion;
import douglas.lol.match.entity.Item;
import douglas.lol.match.entityDTO.BuildDTO;
import douglas.lol.match.entityDTO.BuildItemsDTO;
import douglas.lol.match.entityDTO.ItemDTO;
import douglas.lol.match.exception.BussinesRuleException;
import douglas.lol.match.repository.BuildRepository;
import douglas.lol.match.repository.ChampionRepository;
import douglas.lol.match.repository.ItemRepository;
import douglas.lol.match.service.BuildItemsService;
import douglas.lol.match.service.BuildService;
import jakarta.transaction.Transactional;

@Service
public class BuildServiceImp implements BuildService{

	@Autowired
	private BuildRepository buildRepo;
	
	@Autowired 
	private ChampionRepository champRepo;
	
	@Autowired 
	private ItemRepository itemRepo;
	
	@Autowired
	private BuildItemsService buildItemsService;
	
	@Autowired 
	private ChampionService championService;
	
	@Override
	@Transactional
	public void saveBuild(BuildDTO buildDTO) {
		
		Champion champ = champRepo
				.findById(buildDTO.getChampion())
				.orElseThrow(() -> new BussinesRuleException("Champion not found: " + buildDTO.getChampion()));
		
		Build build = new Build();
		build.setName(buildDTO.getName());
		build.setChampion(champ);
		
		List<Item> items = itemsConvert(build, buildDTO.getItems());
		build.setItems(items);
		Build savedBuild = buildRepo.save(build);
		
		buildItemsService.saveBuildItems(new BuildItemsDTO(savedBuild.getId(),buildDTO.getItems()));
		
		for (Item item : items) {
			championService.saveItemsStatics(item,buildDTO.getChampion());
		}
	}

	private List<Item> itemsConvert(Build build, List<ItemDTO> items) {
		
		if(items.isEmpty()) {
			throw new BussinesRuleException("Need one item.");
		}
		
		return items
				.stream()
				.map(dto -> {
					Integer itemId = dto.getItemID();
					Item item = itemRepo.findById(itemId)
							.orElseThrow(() -> new BussinesRuleException("Invalid item code: " + itemId));
					
				return item;
		}).collect(Collectors.toList());
	}

	@Override
	public void deleteBuild(Integer id) {
		
		Optional<Build> optionalBuild = buildRepo.findById(id);
		
		if(!optionalBuild.isPresent()) {
			throw new BussinesRuleException("Build id not found in database: " + id);
		}
		
		buildItemsService.deleteBuildItems(id);
		buildRepo.deleteById(id);
	}
}
