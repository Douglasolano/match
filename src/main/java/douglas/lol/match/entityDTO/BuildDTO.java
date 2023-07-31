package douglas.lol.match.entityDTO;

import java.util.List;

public class BuildDTO {

	private String name;
	private Integer champion;
	private List<ItemDTO> items;
	
	public BuildDTO() {
		super();
	}

	public BuildDTO(String name, Integer champion, List<ItemDTO> items) {
		super();
		this.name = name;
		this.champion = champion;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getChampion() {
		return champion;
	}

	public void setChampion(Integer champion) {
		this.champion = champion;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "BuildDTO [name=" + name + ", champion=" + champion + ", items=" + items + "]";
	}
}
