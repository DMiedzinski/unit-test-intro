package com.example.task07;

import java.math.BigDecimal;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import com.example.universum.Distance;
import com.example.universum.Gas;
import com.example.universum.Planet;
import com.example.universum.RotationDirection;

public class PlanetAssert extends AbstractAssert<PlanetAssert, Planet> {
	
	private PlanetAssert(Planet actual) {
		super(actual, PlanetAssert.class);
	}

	public static PlanetAssert assertThat(Planet actual){
		Assertions.assertThat(actual).isNotNull();
		return new PlanetAssert(actual);
	}
	
	public PlanetAssert hasName(String expectedName){
		Assertions.assertThat(actual.getName()).isEqualTo(expectedName);
		return this;
	}

	public PlanetAssert hasRotation (RotationDirection expectedRotation){
		Assertions.assertThat(actual.getRotationDirection()).isEqualTo(expectedRotation);
		return this;
	}
	
	public PlanetAssert hasDiameter (String expectedDistanceInMeter){
		Assertions.assertThat(actual.getDiameter().getMeter()).isEqualTo(new BigDecimal(expectedDistanceInMeter));
		return this;
	}
	
	public PlanetAssert hasGases(Gas ... expectedGases){
		Assertions.assertThat(actual.getAtmosphereGases()).containsOnly(expectedGases);
		return this;

	}
}
