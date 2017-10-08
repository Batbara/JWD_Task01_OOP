package by.tc.task01.entity;

import by.tc.task01.dao.impl.Characteristics;

import java.io.Serializable;
import java.util.Map;

public class TabletPC extends Appliance implements Serializable {

    private double batteryCapacity;
    private double displayInches;
    private double memoryROM;
    private String color;
    private double flashMemoryCapacity;

    private enum TabletPCParams {
        BATTERY_CAPACITY {
            @Override
            public void setParameter(TabletPC instance, String parameter) {
                double batteryCapacity = Double.parseDouble(parameter);
                instance.setBatteryCapacity(batteryCapacity);
            }
        },
        DISPLAY_INCHES {
            @Override
            public void setParameter(TabletPC instance, String parameter) {
                double displayInches = Double.parseDouble(parameter);
                instance.setDisplayInches(displayInches);
            }
        },
        MEMORY_ROM {
            @Override
            public void setParameter(TabletPC instance, String parameter) {
                double memoryROM = Double.parseDouble(parameter);
                instance.setMemoryROM(memoryROM);
            }
        },
        FLASH_MEMORY_CAPACITY {
            @Override
            public void setParameter(TabletPC instance, String parameter) {
                double flashMemCapacity = Double.parseDouble(parameter);
                instance.setFlashMemoryCapacity(flashMemCapacity);
            }
        },
        COLOR {
            @Override
            public void setParameter(TabletPC instance, String parameter) {
                instance.setColor(parameter);
            }
        };

        public abstract void setParameter(TabletPC instance, String parameter);
    }

    public TabletPC() {
    }

    public TabletPC(Characteristics characteristics) {
        super("TabletPC");
        Map<String, String> params = characteristics.getCharacteristics();
        for (String parameter : params.keySet()) {
            String paramValue = params.get(parameter);
            setParameter(parameter, paramValue);
        }
    }

    @Override
    public void setParameter(String parameter, String value) {
        for (TabletPCParams tabletParameter : TabletPCParams.values()) {
            if (tabletParameter.name().equals(parameter)) {
                tabletParameter.setParameter(this, value);
            }
        }
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFlashMemoryCapacity(double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public String getColor() {
        return color;
    }

    public double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    @Override
    public String toString() {
        return "TabletPC {" +
                "battery capacity: " + batteryCapacity +
                ", display inches: " + displayInches +
                ", memory ROM: " + memoryROM +
                ", color: '" + color + '\'' +
                ", flash memory capacity: " + flashMemoryCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TabletPC tabletPC = (TabletPC) o;

        if (Double.compare(tabletPC.batteryCapacity, batteryCapacity) != 0) return false;
        if (Double.compare(tabletPC.displayInches, displayInches) != 0) return false;
        if (Double.compare(tabletPC.memoryROM, memoryROM) != 0) return false;
        if (Double.compare(tabletPC.flashMemoryCapacity, flashMemoryCapacity) != 0) return false;
        return color.equalsIgnoreCase(tabletPC.color);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long longBits;
        longBits = Double.doubleToLongBits(batteryCapacity);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(memoryROM);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        result = 31 * result + color.hashCode();
        longBits = Double.doubleToLongBits(flashMemoryCapacity);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        return result;
    }
}
