package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import com.worldline.interview.engine.InternalCombustionEngine;
import com.worldline.interview.engine.SteamEngine;

public class WidgetMachine extends Widget {

    public WidgetMachine(FuelType fuelType, int fuelLevel) {
        super(fuelType, fuelLevel);
    }

    Engine engine;

    @Override
    Engine createEngine(FuelType fuelType) {
        switch (fuelType) {
            case DIESEL:
            case PETROL:
                engine = new InternalCombustionEngine(fuelType);
                break;
            case COAL:
            case WOOD:
                engine = new SteamEngine(fuelType);
                break;
        }
        return engine;
    }
}
