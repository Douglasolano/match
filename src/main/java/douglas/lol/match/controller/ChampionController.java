package douglas.lol.match.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import douglas.lol.match.entity.Champion;
import douglas.lol.match.exception.BussinesRuleException;
import douglas.lol.match.repository.ChampionRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/matchAPI/champion")
public class ChampionController {

	@Autowired
	private ChampionRepository championRepo;
	
	@GetMapping
	public List<Champion> getChampions() {
		return championRepo.findAll();
	}
	
	@GetMapping(value = "/id/{id}")
	public Champion getChampionById(@PathVariable("id") Integer id) {
		
		return championRepo.findById(id)
						.map(b -> {return b;})
						.orElseThrow(() -> new BussinesRuleException("Champion id not found in database: " + id));
		
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity getChampionByName(@PathVariable("name") String name) {
		
		Champion champion = championRepo.findByName(name);
		
		if(champion != null) {
			return ResponseEntity.ok(champion);
		}	
		throw new BussinesRuleException("Champion name not found in database: " + name);
	}
	
	@PostMapping(value = "/newChamp")
	@ResponseStatus(HttpStatus.CREATED)
	public Champion saveChampion(@RequestBody @Valid Champion champion) {
		
		return championRepo.save(champion);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteChampion(@PathVariable Integer id) {
		
		championRepo.findById(id)
		.map(champion -> {championRepo.delete(champion);
						  return Void.class;})
						.orElseThrow(() -> new BussinesRuleException("Champion not found in database."));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateChampion(@PathVariable Integer id,
							   @RequestBody Champion champion) {
		
		championRepo.findById(id)
		.map( c -> {champion.setId(c.getId()); championRepo.save(champion); return c;})
		.orElseThrow(() -> new BussinesRuleException("Champion not found in database."));
	}
}
