package douglas.lol.match.service;

import douglas.lol.match.entity.BuildItems;
import douglas.lol.match.entityDTO.BuildItemsDTO;

public interface BuildItemsService {
	BuildItems saveBuildItems(BuildItemsDTO dto);
}
