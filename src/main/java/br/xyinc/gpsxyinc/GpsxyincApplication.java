package br.xyinc.gpsxyinc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.xyinc.gpsxyinc.domain.Coordinate;
import br.xyinc.gpsxyinc.domain.CoordinateRepository;

@SpringBootApplication
public class GpsxyincApplication {

	private static final Logger log = LoggerFactory.getLogger(GpsxyincApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GpsxyincApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner demo(CoordinateRepository repository) {
		return (args) -> {
			
			// -- Salvar coordenadas
			repository.save(new Coordinate(27, 12, "Lanchonete"));
			repository.save(new Coordinate(31, 18, "Posto"));
			repository.save(new Coordinate(15, 12, "Joalheria"));
			repository.save(new Coordinate(19, 21, "Floricultura"));
			repository.save(new Coordinate(12, 8, "Pub"));
			repository.save(new Coordinate(23, 6, "Supermercado"));
			repository.save(new Coordinate(28, 2, "Churrascaria"));
			
			// -- Pegar coordenadas
			log.info("Coordenadas encontradas com findAll():");
			log.info("--------------------------------------");
			for(Coordinate coordinate : repository.findAll()) {
				log.info(coordinate.toString());
			}
			log.info("");
			
			// -- Encontrar pelo ID
			Coordinate coordinate = repository.findOne(1);
			log.info("Coordenadas encontradas com findOne():");
			log.info("--------------------------------------");
			log.info(coordinate.toString());
			log.info("");
	*/		
//			// -- Encontrar pelas coordenadas
//			log.info("Coordenada encontrada pelas coordenadas (x,y) :");
//			log.info("-----------------------------------------------");
//			for(Coordinate coord : repository.findById(id)) {
//				log.info(coord.toString());
//			}
//			log.info("");
	//	};
	//}
}
