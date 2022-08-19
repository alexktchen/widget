package com.worldline.interview;

import com.worldline.interview.engine.Engine;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class WidgetMachineUnitTest {

    @Test
    public void testPetrolFuel() {

        WidgetMachine widgetMachine = new WidgetMachine(FuelType.PETROL, 50);
        double totalCost = widgetMachine.produceWidgets(2);
        assertThat(totalCost).isEqualTo(9.0);
    }

    @Test
    public void testDieselFuel() {

        // 12
        WidgetMachine widgetMachine = new WidgetMachine(FuelType.DIESEL, 100);
        double totalCost = widgetMachine.produceWidgets(50);
        assertThat(totalCost).isEqualTo(84.0);
    }

    @Test
    public void testWoodFuel() {

        WidgetMachine widgetMachine = new WidgetMachine(FuelType.WOOD, 25);
        double totalCost = widgetMachine.produceWidgets(30);
        assertThat(totalCost).isEqualTo(65.25);
    }

    @Test
    public void testCoalFuel() {

        WidgetMachine widgetMachine = new WidgetMachine(FuelType.COAL, 75);
        double totalCost = widgetMachine.produceWidgets(80);
        assertThat(totalCost).isEqualTo(226.0);
    }
}