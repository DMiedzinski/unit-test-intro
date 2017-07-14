package com.example.task07;

import com.example.universum.Gas;
import com.example.universum.Planet;
import com.example.universum.RotationDirection;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SolarSystemFactoryTest {

    @Test
    public void shouldCreateInnersPlants() {
        // given
        SolarSystemFactory factory = new SolarSystemFactory();

        // when
        List<Planet> innerPlanets = factory.createInnerPlanets();

        // then
        Planet mercury = innerPlanets.get(0);
        assertEquals("Mercury", mercury.getName());
        assertEquals(RotationDirection.LEFT, mercury.getRotationDirection());
        assertEquals(new BigDecimal("4879400"), mercury.getDiameter().getMeter());
        assertEquals(new BigDecimal("87.96935"), mercury.getSiderealYear().inEarthDays());
        assertEquals(3.701, mercury.getAcceleration(), 0.01);
        Set<Gas> mercuryGases = Stream.of(Gas.OXYGEN, Gas.SODIUM, Gas.HYDROGEN).collect(Collectors.toSet());
        assertEquals(mercuryGases, mercury.getAtmosphereGases());

        Planet venus = innerPlanets.get(1);
        assertEquals("Venus", venus.getName());
        assertEquals(RotationDirection.RIGHT, venus.getRotationDirection());
        assertEquals(new BigDecimal("12103700"), venus.getDiameter().getMeter());
        assertEquals(new BigDecimal("224.70096"), venus.getSiderealYear().inEarthDays());
        assertEquals(8.87, venus.getAcceleration(), 0.01);
        Set<Gas> venusGases = Stream.of(Gas.CARBON_DIOXIDE, Gas.NITROGEN).collect(Collectors.toSet());
        assertEquals(venusGases, venus.getAtmosphereGases());

        Planet earth = innerPlanets.get(2);
        assertEquals("Earth", earth.getName());
        assertEquals(RotationDirection.LEFT, earth.getRotationDirection());
        assertEquals(new BigDecimal("12756273"), earth.getDiameter().getMeter());
        assertEquals(new BigDecimal("365.256363004"), earth.getSiderealYear().inEarthDays());
        assertEquals(9.806_65, earth.getAcceleration(), 0.01);
        Set<Gas> earthGases = Stream.of(Gas.NITROGEN, Gas.OXYGEN, Gas.CARBON_DIOXIDE, Gas.ARGON).collect(Collectors.toSet());
        assertEquals(earthGases, earth.getAtmosphereGases());

        Planet mars = innerPlanets.get(3);
        assertEquals("Mars", mars.getName());
        assertEquals(RotationDirection.LEFT, mars.getRotationDirection());
        assertEquals(new BigDecimal("6804900"), mars.getDiameter().getMeter());
        assertEquals(new BigDecimal("686.9601"), mars.getSiderealYear().inEarthDays());
        assertEquals(3.69, mars.getAcceleration(), 0.01);
        Set<Gas> marsGases = Stream.of(Gas.CARBON_DIOXIDE, Gas.NITROGEN).collect(Collectors.toSet());
        assertEquals(marsGases, mars.getAtmosphereGases());

    }
    
    @Test
    public void shouldCreateMercury() {
        // given
        SolarSystemFactory factory = new SolarSystemFactory();

        // when
        List<Planet> innerPlanets = factory.createInnerPlanets();
        Planet mercury = innerPlanets.get(0);

        // then
        assertThat(mercury.getName()).isEqualTo("Mercury");
        assertThat(mercury.getRotationDirection()).isEqualTo(RotationDirection.LEFT);
        assertThat(mercury.getDiameter().getMeter()).isEqualTo(new BigDecimal("4879400"));
        assertThat(mercury.getSiderealYear().inEarthDays()).isEqualTo(new BigDecimal("87.96935"));
        assertThat(mercury.getAcceleration()).isEqualTo(3.701);
        assertThat(mercury.getAtmosphereGases()).contains(Gas.OXYGEN, Gas.SODIUM, Gas.HYDROGEN);
}
    @Test
    public void shouldCreatePlanet() {
        // given
        SolarSystemFactory factory = new SolarSystemFactory();

        // when
        List<Planet> innerPlanets = factory.createInnerPlanets();

        // then
        Planet mercury = innerPlanets.get(0);
        PlanetAssert.assertThat(mercury).hasName("Mercury")
        .hasRotation(RotationDirection.LEFT);
}
}