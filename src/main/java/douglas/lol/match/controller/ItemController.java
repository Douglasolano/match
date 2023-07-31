package douglas.lol.match.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.server.ResponseStatusException;

import douglas.lol.match.entity.Item;
import douglas.lol.match.repository.ItemRepository;

@RestController
@RequestMapping(value = "/matchAPI/item")
public class ItemController {
	
	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping
	public List<Item> getItems() {
		return itemRepo.findAll();
	}
	
	@GetMapping(value = "/{name}")
	public ResponseEntity getItemByName(@PathVariable("name") String name) {
		
		Item item = itemRepo.findByName(name);
		
		if(item != null) {
			return ResponseEntity.ok(item);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping(value = "/newItem")
	@ResponseStatus(HttpStatus.CREATED)
	public Item saveItem(@RequestBody Item item) {
		return itemRepo.save(item);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteItem(@PathVariable Integer id) {
		
		itemRepo.findById(id)
		.map(i -> {itemRepo.delete(i); return Void.class;})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Item not found in database."));
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateItem(@RequestBody Item item,
						   @PathVariable Integer id) {
		
		itemRepo.findById(id)
		.map(i -> {item.setId(i.getId()); itemRepo.save(item); return i;})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Item not found in database."));
	}
}
