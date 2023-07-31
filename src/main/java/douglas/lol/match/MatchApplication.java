package douglas.lol.match;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import douglas.lol.match.entity.Build;
import douglas.lol.match.entity.Champion;
import douglas.lol.match.entity.Item;
import douglas.lol.match.repository.BuildRepository;
import douglas.lol.match.repository.ChampionRepository;
import douglas.lol.match.repository.ItemRepository;

@SpringBootApplication
public class MatchApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MatchApplication.class, args);
	}

}
