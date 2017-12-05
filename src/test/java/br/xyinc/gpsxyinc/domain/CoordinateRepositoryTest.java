package br.xyinc.gpsxyinc.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class CoordinateRepositoryTest {
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CoordinateRepository repository;
	
	
	@Test
	public void should_find_no_coordinate_if_repository_is_empty() {
		Iterable<Coordinate> coordinates = repository.findAll();
		
		coordinates.forEach(c -> assertNotNull(c));
		
	}
	
	@Test
	public void should_store_a_coordinate() {
		Coordinate coordinate = repository.save(new Coordinate(27, 12, "Lanchonete"));
		assertNotNull(coordinate.getIdCoordinate());
		
	}
	
	@Test
	public void should_find_all_coordinates() {
		Coordinate coordinate1 = new Coordinate(27, 12, "Lanchonete");
		entityManager.persist(coordinate1);
 
		Coordinate coordinate2 = new Coordinate(31, 18, "Posto");
		entityManager.persist(coordinate2);
 
		Coordinate coordinate3 = new Coordinate(15, 12, "Joalheria");
		entityManager.persist(coordinate3);
		
		Coordinate coordinate4 = new Coordinate(19, 21, "Floricultura");
		entityManager.persist(coordinate4);
		
		Coordinate coordinate5 = new Coordinate(12, 8, "Pub");
		entityManager.persist(coordinate5);
 
		Coordinate coordinate6 = new Coordinate(23, 6, "Supermercado");
		entityManager.persist(coordinate6);
		
		Coordinate coordinate7 = new Coordinate(28, 2, "Churrascaria");
		entityManager.persist(coordinate7);
		
		Iterable<Coordinate> coordinates = repository.findAll();
 
		assertThat(coordinates, CoreMatchers.hasItems(coordinate1, coordinate2, coordinate3, coordinate4, coordinate5, coordinate6, coordinate7));
	}
	
	@Test
	public void should_find_coordinate_by_id() {
		Coordinate coordinate1 = new Coordinate(10, 20, "Teste1");
		entityManager.persist(coordinate1);
		
		Coordinate coordinate2 = new Coordinate(15, 25, "Teste2");
		entityManager.persist(coordinate2);
		
		Coordinate foundCoordinate = repository.findOne(coordinate2.getIdCoordinate());
		
		assertEquals(foundCoordinate, coordinate2);
	}
	
	@Test
	public void should_find_coordinate_by_max_distance_of_N_meters() {
		Coordinate coordinate1 = new Coordinate(27, 12, "Lanchonete");
		entityManager.persist(coordinate1);
 
		Coordinate coordinate2 = new Coordinate(31, 18, "Posto");
		entityManager.persist(coordinate2);
 
		Coordinate coordinate3 = new Coordinate(15, 12, "Joalheria");
		entityManager.persist(coordinate3);
		
		Coordinate coordinate4 = new Coordinate(19, 21, "Floricultura");
		entityManager.persist(coordinate4);
		
		Coordinate coordinate5 = new Coordinate(12, 8, "Pub");
		entityManager.persist(coordinate5);
 
		Coordinate coordinate6 = new Coordinate(23, 6, "Supermercado");
		entityManager.persist(coordinate6);
		
		Coordinate coordinate7 = new Coordinate(28, 2, "Churrascaria");
		entityManager.persist(coordinate7);
		
		entityManager.flush();
		
		Integer basicX = 20;
		Integer basicY = 10;
		Integer max = 10;
		
		Iterable<Coordinate> coordinates = repository.findCoordinateByPointAndDistance(basicX-max, basicX+max, basicY-max, basicY+max);
		
		assertThat(coordinates, CoreMatchers.hasItems(coordinate1, coordinate3, coordinate5, coordinate6));
	}

}
