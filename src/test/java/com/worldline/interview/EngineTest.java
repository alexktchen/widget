package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.engine.InternalCombustionEngine;
import com.worldline.interview.engine.SteamEngine;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class EngineTest {
    private Engine engine;

    @Test
    public void testPetrolValidValues() {

        //when
        engine = createEngine(FuelType.PETROL);

        //then
        assertThat(engine.getFuelType()).isEqualTo(FuelType.PETROL);
        assertThat(engine.isEmpty()).isTrue();
        assertThat(engine.getBatchSize()).isEqualTo(8);
        assertThat(engine.getFuelTypeValue()).isEqualTo(9.0);
        assertThat(engine.isRunning()).isFalse();

    }

    @Test
    public void testDieselValidValues() {

        //when
        engine = createEngine(FuelType.DIESEL);

        //then
        assertThat(engine.getFuelType()).isEqualTo(FuelType.DIESEL);
        assertThat(engine.isEmpty()).isTrue();
        assertThat(engine.getBatchSize()).isEqualTo(8);
        assertThat(engine.getFuelTypeValue()).isEqualTo(12.0);
        assertThat(engine.isRunning()).isFalse();

    }

    @Test(expected = IllegalStateException.class)
    public void itShouldThrowExpectedExceptionGivenInvalidFuelType() {
        engine = new InternalCombustionEngine(FuelType.COAL);
    }

    @Test
    public void testEngineWhenIsEmpty() {

        //given
        Engine engine = createEngine(FuelType.DIESEL);

        //when
        engine.fill(50);

        //then
        assertThat(engine.getFuelLevel()).isEqualTo(50);

    }

    @Test
    public void testDepositWhenIsFull() {

        //given
        Engine engine = createEngine(FuelType.DIESEL);

        //when
        engine.fill(150);

        //then
        assertThat(engine.getFuelLevel()).isEqualTo(100);

    }

    @Test
    public void testNegativeFilling() {
        engine = createEngine(FuelType.PETROL);
        engine.fill(-1);
        assertThat(engine.getFuelLevel()).isEqualTo(0);

        engine = createEngine(FuelType.COAL);
        engine.fill(-1);
        assertThat(engine.getFuelLevel()).isEqualTo(0);
    }

    @Test(expected = IllegalStateException.class)
    public void testStartTheEngineWhenIsEmpty() {

        Engine petrolEngine = createEngine(FuelType.PETROL);
        petrolEngine.start();
        fail("it shouldn't reach here");
    }

    @Test
    public void testEngineWhenIsNotEmpty() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);
        petrolEngine.fill(25);

        //when
        petrolEngine.start();

        assertThat(petrolEngine.isRunning()).isTrue();

    }

    @Test
    public void testEngineWhenIsRunning() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);
        petrolEngine.fill(25);
        petrolEngine.start();

        //when
        petrolEngine.stop();

        assertThat(petrolEngine.isRunning()).isFalse();

    }

    @Test(expected = IllegalStateException.class)
    public void testEngineWhenIsNotRunning() {

        //given
        Engine petrolEngine = createEngine(FuelType.PETROL);

        //when
        petrolEngine.stop();

        fail("it shouldn't reach here");

    }

    //private test helpers
    private Engine createEngine(final FuelType fuelType) {
        switch (fuelType) {
            case DIESEL:
            case PETROL:
            default:
                return new InternalCombustionEngine(fuelType);
            case COAL:
            case WOOD:
                return new SteamEngine(fuelType);
        }
    }
}
