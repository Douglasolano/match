package douglas.lol.match.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import douglas.lol.match.entity.Build;

public interface BuildRepository extends JpaRepository<Build, Integer>{
	
	public Build findByName(String name);
	
}
