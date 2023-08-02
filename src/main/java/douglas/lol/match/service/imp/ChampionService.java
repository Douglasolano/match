package douglas.lol.match.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import douglas.lol.match.entity.Champion;
import douglas.lol.match.entity.Item;
import douglas.lol.match.exception.BussinesRuleException;
import douglas.lol.match.repository.ChampionRepository;

@Service
public class ChampionService {

	@Autowired
	private ChampionRepository champRepo;
	
	public void saveItemsStatics(Item item, Integer idChamp) {
		
		Champion champion = champRepo.findById(idChamp)
									 .orElseThrow(() -> new BussinesRuleException("Champion not found: " + idChamp));
		
		if(!(item.getArmor() == null)) {
			champion.setArmor(champion.getArmor() + item.getArmor());
		}
		if(!(item.getAttackSpeed()== null)) {
			champion.setAttackSpeed(champion.getAttackSpeed() + item.getAttackSpeed());
		}
		if(!(item.getCritic()== null)) {
			champion.setCritic(champion.getCritic() + item.getCritic());
		}
		if(!(item.getHabilitPower()== null)) {
			champion.setHabilitPower(champion.getHabilitPower() + item.getHabilitPower());
		}
		if(!(item.getLife()== null)) {
			champion.setLife(champion.getLife() + item.getLife());
		}
		if(!(item.getLifeSteal()== null)) {
			champion.setLifeSteal(champion.getLifeSteal() + item.getLifeSteal());
		}
		if(!(item.getMagicResist()== null)) {
			champion.setMagicResist(champion.getMagicResist() + item.getMagicResist());
		}
		if(!(item.getMana()== null)) {
			champion.setMana(champion.getMana() + item.getMana());
		}
		if(!(item.getPhysicalDamage()== null)) {
			champion.setPhysicalDamage(champion.getPhysicalDamage() + item.getPhysicalDamage());
		}
		
		champRepo.save(champion);
		
	}
	
}
