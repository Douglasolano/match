package douglas.lol.match.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import douglas.lol.match.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	public Item findByName(String name);
}
