package douglas.lol.match.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import douglas.lol.match.entity.Build;
import douglas.lol.match.entityDTO.BuildDTO;
import douglas.lol.match.exception.BussinesRuleException;
import douglas.lol.match.repository.BuildRepository;
import douglas.lol.match.repository.ChampionRepository;
import douglas.lol.match.service.BuildItemsService;
import douglas.lol.match.service.BuildService;

@RestController
@RequestMapping(value = "/matchAPI/build")
public class BuildController {
	
	@Autowired 
	private BuildRepository buildRepo;
	
	@Autowired 
	private ChampionRepository championRepo;
	
	@Autowired
	private BuildService service;
	
	@Autowired
	private BuildItemsService buildItemsService;
	
	@GetMapping
	public List<Build> getBuilds() {
		return buildRepo.findAll();
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity getBuildByName(@PathVariable("name") String name) {
		
		Build build = buildRepo.findByName(name);
		
		if(build != null) {
			return ResponseEntity.ok(build);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(value = "/newBuild")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveBuild(@RequestBody BuildDTO buildDTO) {
		service.saveBuild(buildDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBuild(@PathVariable Integer id) {
		
		buildRepo.findById(id)
		.map(b -> {buildRepo.delete(b); return Void.class;})
		.orElseThrow(() -> new BussinesRuleException("Champion not found in database."));
	}
}
