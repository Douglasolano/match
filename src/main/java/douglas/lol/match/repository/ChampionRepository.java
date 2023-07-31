package douglas.lol.match.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import douglas.lol.match.entity.Champion;

public interface ChampionRepository extends JpaRepository<Champion, Integer>{
	
	public Champion findByName(String name);
}
