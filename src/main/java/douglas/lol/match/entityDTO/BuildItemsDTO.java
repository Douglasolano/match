package douglas.lol.match.entityDTO;

import java.util.List;

public class BuildItemsDTO {

	private Integer buildId;
	private List<ItemDTO> itemId;
	
	public BuildItemsDTO(Integer buildId, List<ItemDTO> itemId) {
		super();
		this.buildId = buildId;
		this.itemId = itemId;
	}
	
	public BuildItemsDTO() {
		super();
	}
	
	public Integer getBuildId() {
		return buildId;
	}
	
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}
	
	public List<ItemDTO> getItemId() {
		return itemId;
	}
	
	public void setItemId(List<ItemDTO> itemId) {
		this.itemId = itemId;
	}
	
	@Override
	public String toString() {
		return "BuildItemsDTO [buildId=" + buildId + ", itemId=" + itemId + "]";
	}
}
