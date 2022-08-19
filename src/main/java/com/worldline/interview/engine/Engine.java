package com.worldline.interview.engine;

import com.worldline.interview.FuelType;

public abstract class Engine {

    private final FuelType fuelType;
    private final int batchSize;
    private boolean running;
    private int fuelLevel;

    public abstract double getFuelTypeValue();

    public Engine(FuelType fuelType, int batchSize) {
        this.fuelType = fuelType;
        this.batchSize = batchSize;
    }

    public double produce(int quantity) {
        final int batchSize = this.getBatchSize();
        final double costPerBatch = getFuelTypeValue();

        int batch = 0;
        int batchCount = 0;

        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }

    public void start() {
        if (!isEmpty()) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }

    public void stop() {
        if (isRunning()) {
            running = false;
        } else {
            throw new IllegalStateException("Not able to stop engine.");
        }
    }

    public boolean isRunning() {
        return running;
    }


    public void fill(int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
        } else if (fuelLevel > 100) {
            this.fuelLevel = 100;
        } else {
            this.fuelLevel = 0;
        }
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public boolean isEmpty() {
        return fuelLevel == 0;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
}
