package douglas.lol.match.service;

import douglas.lol.match.entity.Build;
import douglas.lol.match.entityDTO.BuildDTO;

public interface BuildService {
	Build saveBuild(BuildDTO dto);
}
