package com.worldline.interview.engine;

import com.worldline.interview.FuelType;

import static java.lang.String.format;

public class InternalCombustionEngine extends Engine {

    private static final int BATCH_SIZE = 8;

    public InternalCombustionEngine(final FuelType fuelType) {
        super(fuelType, BATCH_SIZE);
        if (!fuelType.equals(FuelType.DIESEL) && !fuelType.equals(FuelType.PETROL)) {
            throw new IllegalStateException(format("This engine doesn't support %s fuel.", fuelType.toString()));
        }
    }

    @Override
    public double getFuelTypeValue() {
        switch (super.getFuelType()) {
            case DIESEL:
                return 12.00;
            case PETROL:
                return 9.00;
        }
        return 0;
    }
}
