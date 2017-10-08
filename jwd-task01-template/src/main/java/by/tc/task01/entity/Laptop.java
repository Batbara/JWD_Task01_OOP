package by.tc.task01.entity;

import by.tc.task01.dao.impl.Characteristics;

import java.io.Serializable;
import java.util.Map;

public class Laptop extends Appliance implements Serializable {

    private double batteryCapacity;
    private String os;
    private double memoryROM;
    private double systemMemory;
    private double cpu;
    private double displayInches;

    private enum LaptopParams {
        BATTERY_CAPACITY {
            @Override
            public void setParameter(Laptop instance, String parameter) {
                double batteryCapacity = Double.parseDouble(parameter);
                instance.setBatteryCapacity(batteryCapacity);
            }
        },
        OS {
            @Override
            public void setParameter(Laptop instance, String parameter) {
                instance.setOs(parameter);
            }
        },
        MEMORY_ROM {
            @Override
            public void setParameter(Laptop instance, String parameter) {
                double memoryROM = Double.parseDouble(parameter);
                instance.setMemoryROM(memoryROM);
            }
        },
        SYSTEM_MEMORY {
            @Override
            public void setParameter(Laptop instance, String parameter) {
                double systemMemory = Double.parseDouble(parameter);
                instance.setSystemMemory(systemMemory);
            }
        },
        CPU {
            @Override
            public void setParameter(Laptop instance, String parameter) {
                double cpu = Double.parseDouble(parameter);
                instance.setCpu(cpu);
            }
        },
        DISPLAY_INCHES {
            @Override
            public void setParameter(Laptop instance, String parameter) {
                double displayInches = Double.parseDouble(parameter);
                instance.setDisplayInches(displayInches);
            }
        };

        public abstract void setParameter(Laptop instance, String parameter);
    }

    public Laptop() {
    }

    public Laptop(Characteristics characteristics) {
        super("Laptop");
        Map<String, String> params = characteristics.getCharacteristics();
        for (String parameter : params.keySet()) {
            String paramValue = params.get(parameter);
            setParameter(parameter, paramValue);
        }
    }

    public void setParameter(String parameter, String value) {
        for (LaptopParams laptopParameter : LaptopParams.values()) {
            if (laptopParameter.name().equals(parameter)) {
                laptopParameter.setParameter(this, value);
            }
        }
    }

    @Override
    public String toString() {
        return "Laptop {" +
                "battery capacity: " + batteryCapacity +
                ", OS: '" + os + '\'' +
                ", memory ROM: " + memoryROM +
                ", system memory: " + systemMemory +
                ", CPU: " + cpu +
                ", display inches: " + displayInches +
                '}';
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setMemoryROM(double memoryROM) {
        this.memoryROM = memoryROM;
    }

    public void setSystemMemory(double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public void setDisplayInches(double displayInches) {
        this.displayInches = displayInches;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public String getOs() {
        return os;
    }

    public double getMemoryROM() {
        return memoryROM;
    }

    public double getSystemMemory() {
        return systemMemory;
    }

    public double getCpu() {
        return cpu;
    }

    public double getDisplayInches() {
        return displayInches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Laptop laptop = (Laptop) o;

        if (batteryCapacity != laptop.batteryCapacity) return false;
        if (memoryROM != laptop.memoryROM) return false;
        if (systemMemory != laptop.systemMemory) return false;
        if (Double.compare(laptop.cpu, cpu) != 0) return false;
        if (displayInches != laptop.displayInches) return false;
        return os.equalsIgnoreCase(laptop.os);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long longBits;
        longBits = Double.doubleToLongBits(batteryCapacity);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        result = 31 * result + os.hashCode();
        longBits = Double.doubleToLongBits(memoryROM);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(systemMemory);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(cpu);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(displayInches);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        return result;
    }
}
