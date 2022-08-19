package com.worldline.interview;

import com.worldline.interview.engine.Engine;

public abstract class Widget {

    private final FuelType fuelType;

    private final int fuelLevel;

    public Widget(FuelType fuelType, int fuelLevel) {

        this.fuelLevel = fuelLevel;
        this.fuelType = fuelType;
    }


    abstract Engine createEngine(FuelType petrol);


    public double produceWidgets(final int quantity) {

        Engine engine = createEngine(this.fuelType);
        engine.fill(this.fuelLevel);
        engine.start();

        double cost = 0.0;

        if (engine.isRunning()) {
            cost = engine.produce(quantity);
        }

        engine.stop();

        return cost;
    }

}
