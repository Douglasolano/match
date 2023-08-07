package douglas.lol.match.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "champion")
public class Champion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	@NotEmpty(message = "Empty name is not allowed.")
	private String name;
	
	@Column(name = "life")
	@NotEmpty(message = "Empty life is not allowed.")
	private Integer life;   
	
	@Column(name = "mana")
	@JsonInclude(Include. NON_NULL)
	private Integer mana;
	
	@Column(name = "physical_damage")
	@NotEmpty(message = "Empty physicalDamage is not allowed.")
	private Integer physicalDamage;
	
	@Column(name = "habilit_power")
	@NotEmpty(message = "Empty habilitPower is not allowed.")
	@JsonInclude(Include. NON_NULL)
	private Integer habilitPower;
	
	@Column(name = "armor")
	@NotEmpty(message = "Empty armor is not allowed.")
	private Integer armor;
	
	@Column(name = "magic_resist")
	@NotEmpty(message = "Empty magicResist is not allowed.")
	private Integer magicResist;
	
	@Column(name = "life_steal")
	@JsonInclude(Include. NON_NULL)
	private Integer lifeSteal;
	
	@Column(name = "critic")
	@JsonInclude(Include. NON_NULL)
	private Integer critic;
	
	@Column(name = "attack_speed")
	@NotEmpty(message = "Empty attackSpeed is not allowed.")
	private Double attackSpeed;

	public Champion() {
		super();
	}

	public Champion(Integer id, String name, Integer life, Integer mana, Integer physicalDamage, Integer habilitPower,
			Integer armor, Integer magicResist, Integer lifeSteal, Integer critic, Double attackSpeed) {
		super();
		this.id = id;
		this.name = name;
		this.life = life;
		this.mana = mana;
		this.physicalDamage = physicalDamage;
		this.habilitPower = habilitPower;
		this.armor = armor;
		this.magicResist = magicResist;
		this.lifeSteal = lifeSteal;
		this.critic = critic;
		this.attackSpeed = attackSpeed;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLife() {
		return life;
	}

	public void setLife(Integer life) {
		this.life = life;
	}

	public Integer getMana() {
		return mana;
	}

	public void setMana(Integer mana) {
		this.mana = mana;
	}

	public Integer getPhysicalDamage() {
		return physicalDamage;
	}

	public void setPhysicalDamage(Integer physicalDamage) {
		this.physicalDamage = physicalDamage;
	}

	public Integer getHabilitPower() {
		return habilitPower;
	}

	public void setHabilitPower(Integer habilitPower) {
		this.habilitPower = habilitPower;
	}

	public Integer getArmor() {
		return armor;
	}

	public void setArmor(Integer armor) {
		this.armor = armor;
	}

	public Integer getMagicResist() {
		return magicResist;
	}

	public void setMagicResist(Integer magicResist) {
		this.magicResist = magicResist;
	}

	public Integer getLifeSteal() {
		return lifeSteal;
	}

	public void setLifeSteal(Integer lifeSteal) {
		this.lifeSteal = lifeSteal;
	}

	public Integer getCritic() {
		return critic;
	}

	public void setCritic(Integer critic) {
		this.critic = critic;
	}

	public Double getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(Double attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	@Override
	public String toString() {
		return "Champion [id=" + id + ", life=" + life + ", mana=" + mana + ", physicalDamage=" + physicalDamage + ", habilitPower="
				+ habilitPower + ", armor=" + armor + ", magicResist=" + magicResist + ", lifeSteal=" + lifeSteal
				+ ", critic=" + critic + ", attackSpeed=" + attackSpeed + "]";
	}
}
