package br.xyinc.gpsxyinc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coordinate")
public class Coordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCoordinate;
	
	@Column(name="x")
	private Integer x;
	
	@Column(name="y")
	private Integer y;
	
	@Column(name="name")
	private String name;
	
	public Coordinate() {}
	
	public Coordinate(Integer x, Integer y, String name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getIdCoordinate() {
		return idCoordinate;
	}
	public void setidCoordinate(Integer idCoordinate) {
		this.idCoordinate = idCoordinate;
	}
}
