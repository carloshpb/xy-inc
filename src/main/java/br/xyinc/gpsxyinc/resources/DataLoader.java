package br.xyinc.gpsxyinc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.xyinc.gpsxyinc.domain.Coordinate;
import br.xyinc.gpsxyinc.domain.CoordinateRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private CoordinateRepository repository;

    @Autowired
    public DataLoader(CoordinateRepository repository) {
        this.repository = repository;
    }

    public void run(ApplicationArguments args) {
		repository.save(new Coordinate(27, 12, "Lanchonete"));
		repository.save(new Coordinate(31, 18, "Posto"));
		repository.save(new Coordinate(15, 12, "Joalheria"));
		repository.save(new Coordinate(19, 21, "Floricultura"));
		repository.save(new Coordinate(12, 8, "Pub"));
		repository.save(new Coordinate(23, 6, "Supermercado"));
		repository.save(new Coordinate(28, 2, "Churrascaria"));
    }
}
