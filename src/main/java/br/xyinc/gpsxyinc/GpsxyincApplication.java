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
	
}
