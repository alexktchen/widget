package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.engine.InternalCombustionEngine;
import org.junit.Test;

import static org.junit.Assert.fail;

public class InternalCombustionEngineTest {
    private Engine engine;

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToCreateACombustionEngineWithInvalidFuelTypeWood() {

        engine = createEngine(FuelType.WOOD);

        fail("it shouldn't reach here");
    }

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToCreateACombustionEngineWithInvalidFuelTypeCoal() {

        engine = createEngine(FuelType.COAL);

        fail("it shouldn't reach here");

    }

    private Engine createEngine(FuelType fuelType) {
        return new InternalCombustionEngine(fuelType);
    }
}
