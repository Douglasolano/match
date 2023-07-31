package douglas.lol.match.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "build")
public class Build {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "build_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "champion_id")
	private Champion champion;
	
	@OneToMany
	@JoinColumn(name = "item_id")
	@JsonInclude(Include.NON_NULL)
	private List<Item> Items;

	public Build() {
		
	}

	public Build(Integer id, String name, Champion champion, List<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.champion = champion;
		Items = items;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Champion getChampion() {
		return champion;
	}

	public void setChampion(Champion champion) {
		this.champion = champion;
	}

	public List<Item> getItems() {
		return Items;
	}

	public void setItems(List<Item> items) {
		Items = items;
	}

	@Override
	public String toString() {
		return "Build [id=" + id + ", name=" + name + ", champion=" + champion + ", Items=" + Items + "]";
	}
}
