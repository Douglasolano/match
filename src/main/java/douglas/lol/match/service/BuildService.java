package douglas.lol.match.service;

import douglas.lol.match.entityDTO.BuildDTO;

public interface BuildService {
	void saveBuild(BuildDTO dto);

	void deleteBuild(Integer integer);
}
