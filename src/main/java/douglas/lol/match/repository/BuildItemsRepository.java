package douglas.lol.match.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import douglas.lol.match.entity.BuildItems;
import jakarta.transaction.Transactional;

public interface BuildItemsRepository extends JpaRepository<BuildItems, Integer>{
	
	@Query(value = "SELECT bd.build_id FROM build_item bd WHERE bd.build_id = :build_id", nativeQuery = true)
	public List<BuildItems> buildItens(@Param("build_id") Integer build_id);

	@Modifying
	@Transactional
	@Query(value = "delete from build_item where build_item.build_id = :integer", nativeQuery = true)
	public void deleteBuildItems(@Param("integer") Integer integer);
}
