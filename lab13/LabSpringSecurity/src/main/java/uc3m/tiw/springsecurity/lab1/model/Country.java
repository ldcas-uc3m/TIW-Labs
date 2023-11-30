package uc3m.tiw.springsecurity.lab1.model;

public class Country {

	private Long id;

	private String name;

	private Integer population;
	
	private String continent;

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Country() {
		super();
	}

	public Country(Long id, String name, Integer population, String continent) {
		
		super();
		this.id = id;
		this.name = name;
		this.continent=continent;
		this.population = population;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getPopulation() {
		return population;
	}

}
