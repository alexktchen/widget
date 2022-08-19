package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.engine.SteamEngine;
import org.junit.Test;

import static org.junit.Assert.fail;

public class SteamEngineTest {
    private Engine engine;

    @Test(expected = IllegalStateException.class)
    public void testFuelTypePetrol() {

        engine = createEngine(FuelType.PETROL);

        fail("it shouldn't reach here");
    }

    @Test(expected = IllegalStateException.class)
    public void testFuelTypeDiesel() {

        engine = createEngine(FuelType.DIESEL);

        fail("it shouldn't reach here");

    }

    private Engine createEngine(FuelType fuelType) {
        return new SteamEngine(fuelType);
    }
}
