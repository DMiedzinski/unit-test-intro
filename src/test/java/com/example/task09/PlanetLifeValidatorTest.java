package com.example.task09;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import javax.xml.bind.Validator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.example.universum.Distance;
import com.example.universum.Planet;
import com.example.universum.RotationDirection;
import com.example.universum.SiderealYear;
import com.example.universum.Speed;

public class PlanetLifeValidatorTest {

    @Test
    public void shouldThrowExceptionWhenAvgOrbitalSpeedIsGreaterThanLightSpeed() {
        // given
        PlanetLifeValidator validator = new PlanetLifeValidator();
        Planet planet = examplePlanet();
        planet.setAvgOrbitalSpeed(Speed.createKmPerSecond("31000000")); // Greater Than 299 792 458 m/s

        try {
            // when
            validator.canBeLife(planet);
            // then
            fail("It should throw Exception, because planet orbital speed can't be greater than light speed");
        } catch (InvalidPlanetSpeed e) {
            assertTrue(true);
        }
    }

        @Test
        public void exeptionTest(){
        	
        	 PlanetLifeValidator validator = new PlanetLifeValidator();
             Planet planet = examplePlanet();
             planet.setAvgOrbitalSpeed(Speed.createKmPerSecond("310000"));
             
    Assertions.assertThatThrownBy(() -> validator.canBeLife(planet))
    	.isInstanceOf(InvalidPlanetSpeed.class)
    	.hasMessage("Speed ist greater than light speed");
    
        }

    private Planet examplePlanet() {
        return new Planet("Very Speed Planet", RotationDirection.LEFT,
                Distance.createFromMeter(new BigDecimal("4879400")),
                new SiderealYear(new BigDecimal("87.96935")));
    }
}
