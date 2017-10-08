package by.tc.task01.entity;

import by.tc.task01.dao.impl.Characteristics;

import java.io.Serializable;
import java.util.Map;

public class Oven extends Appliance implements Serializable {

    private double powerConsumption;
    private double weight;
    private double capacity;
    private double depth;
    private double height;
    private double width;

    private enum OvenParams {
        POWER_CONSUMPTION {
            @Override
            public void setParameter(Oven instance, String parameter) {
                double powerConsumption = Double.parseDouble(parameter);
                instance.setPowerConsumption(powerConsumption);
            }
        },
        WEIGHT {
            @Override
            public void setParameter(Oven instance, String parameter) {
                double weight = Double.parseDouble(parameter);
                instance.setWeight(weight);
            }
        },
        CAPACITY {
            @Override
            public void setParameter(Oven instance, String parameter) {
                double capacity = Double.parseDouble(parameter);
                instance.setCapacity(capacity);
            }
        },
        DEPTH {
            @Override
            public void setParameter(Oven instance, String parameter) {
                double depth = Double.parseDouble(parameter);
                instance.setDepth(depth);
            }
        },
        HEIGHT {
            @Override
            public void setParameter(Oven instance, String parameter) {
                double height = Double.parseDouble(parameter);
                instance.setHeight(height);
            }
        },
        WIDTH {
            @Override
            public void setParameter(Oven instance, String parameter) {
                double width = Double.parseDouble(parameter);
                instance.setWidth(width);
            }
        };

        public abstract void setParameter(Oven instance, String parameter);
    }

    public Oven() {
    }

    public Oven(Characteristics characteristics) {
        super("Oven");
        Map<String, String> params = characteristics.getCharacteristics();
        for (String parameter : params.keySet()) {
            String paramValue = params.get(parameter);
            setParameter(parameter, paramValue);
        }
    }

    @Override
    public void setParameter(String parameter, String value) {
        for (OvenParams ovenParameter : OvenParams.values()) {
            if (ovenParameter.name().equals(parameter)) {
                ovenParameter.setParameter(this, value);
            }
        }
    }

    @Override
    public String toString() {
        return "Oven {" +
                "power consumption: " + powerConsumption +
                ", weight: " + weight +
                ", capacity: " + capacity +
                ", depth: " + depth +
                ", height: " + height +
                ", width: " + width +
                '}';
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public double getWeight() {
        return weight;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getDepth() {
        return depth;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Oven oven = (Oven) o;

        if (Double.compare(oven.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(oven.weight, weight) != 0) return false;
        if (capacity != oven.capacity) return false;
        if (Double.compare(oven.depth, depth) != 0) return false;
        if (Double.compare(oven.height, height) != 0) return false;
        return Double.compare(oven.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long longBits;
        longBits = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(capacity);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(height);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(width);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        return result;
    }
}
