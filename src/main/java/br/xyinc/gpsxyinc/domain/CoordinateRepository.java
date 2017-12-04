package br.xyinc.gpsxyinc.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CoordinateRepository extends CrudRepository<Coordinate, Integer>{
	
	List<Coordinate> findByIdCoordinate(Integer id);
	
	@Query("select c from Coordinate c where (c.x between ?1 and ?2) and (c.y between ?3 and ?4)")
	List<Coordinate> findCoordinateByPointAndDistance(Integer xMin, Integer xMax, Integer yMin, Integer yMax);
	
}
