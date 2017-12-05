package br.xyinc.gpsxyinc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.xyinc.gpsxyinc.domain.Coordinate;
import br.xyinc.gpsxyinc.domain.CoordinateRepository;

@RestController
@RequestMapping("/gps")
public class GPSRest {
	
	@Autowired
	CoordinateRepository coordinateRepository;
	
	@RequestMapping(method = RequestMethod.GET,
            value = "/cadastrarCoordenada/{nome}/{x}/{y}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Coordinate cadastrarCoordenada(
    								  @PathVariable ("x")    Integer x,
                                      @PathVariable ("y")    Integer y,
                                      @PathVariable ("nome") String nome){
		
		if((Math.signum(x) < 0) || (Math.signum(y) < 0)) {
			return null;
		}
		
		Coordinate c = new Coordinate();
		c.setX(x);
		c.setY(y);
		c.setName(nome);
		
		coordinateRepository.save(c);
		
        return c;
    }
	
	@RequestMapping(method = RequestMethod.GET,
            value = "/listarCoordenadas")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable<Coordinate> listarCoordenadas(){
		
		return coordinateRepository.findAll();
		
        
    }
	
	@RequestMapping(method = RequestMethod.GET,
            value = "/buscarPonto/{x}/{y}/{max}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Coordinate> buscarPonto(
    								  @PathVariable ("x")    Integer x,
                                      @PathVariable ("y")    Integer y,
                                      @PathVariable ("max")  Integer max){
		
		Integer xMin = (x-max) <= 0 ? 0 : (x-max);
		Integer yMin = (y-max) <= 0 ? 0 : (y-max);
				
		return coordinateRepository.findCoordinateByPointAndDistance(xMin,(x+max),yMin,(y+max));
		
       }
}
