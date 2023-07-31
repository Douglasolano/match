package douglas.lol.match.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "build_item")
public class BuildItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "build_id")
	private Build buildId;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item itemId;
	
	public BuildItems() {
		super();
	}
	
	public BuildItems(Integer id, Build buildId, Item itemId) {
		super();
		this.id = id;
		this.buildId = buildId;
		this.itemId = itemId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Build getBuildId() {
		return buildId;
	}

	public void setBuildId(Build buildId) {
		this.buildId = buildId;
	}

	public Item getItemId() {
		return itemId;
	}

	public void setItemId(Item itemId) {
		this.itemId = itemId;
	}
	
	@Override
	public String toString() {
		return "BuildItems [id=" + id + ", buildId=" + buildId + ", itemId=" + itemId + "]";
	}
}
