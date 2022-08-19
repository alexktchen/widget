package com.worldline.interview.engine;

import com.worldline.interview.FuelType;

import static java.lang.String.format;

public class SteamEngine extends Engine {

    //we could have done via via param
    private static final int STEAM_ENGINE_BATCH_SIZE = 2;

    public SteamEngine(final FuelType fuelType) {
        super(fuelType, STEAM_ENGINE_BATCH_SIZE);

        if (!fuelType.equals(FuelType.WOOD) && !fuelType.equals(FuelType.COAL)) {
            throw new IllegalStateException(format("This engine doesn't support %s fuel.", fuelType.toString()));
        }
    }

    @Override
    public double getFuelTypeValue() {
        switch (super.getFuelType()) {
            case WOOD:
                return 4.35;
            case COAL:
                return 5.65;
        }
        return 0;
    }
}
