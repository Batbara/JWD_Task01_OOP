package by.tc.task01.entity;

import by.tc.task01.dao.impl.Characteristics;

import java.io.Serializable;
import java.util.Map;

public class Refrigerator extends Appliance implements Serializable {

    private double powerConsumption;
    private double weight;
    private double freezerCapacity;
    private double overallCapacity;
    private double height;
    private double width;

    private enum RefrigeratorParams {
        POWER_CONSUMPTION {
            @Override
            public void setParameter(Refrigerator instance, String parameter) {
                double powerConsumption = Double.parseDouble(parameter);
                instance.setPowerConsumption(powerConsumption);
            }
        },
        WEIGHT {
            @Override
            public void setParameter(Refrigerator instance, String parameter) {
                double weight = Double.parseDouble(parameter);
                instance.setWeight(weight);
            }
        },
        FREEZER_CAPACITY {
            @Override
            public void setParameter(Refrigerator instance, String parameter) {
                double freezerCapacity = Double.parseDouble(parameter);
                instance.setFreezerCapacity(freezerCapacity);
            }
        },
        OVERALL_CAPACITY {
            @Override
            public void setParameter(Refrigerator instance, String parameter) {
                double overallCapacity = Double.parseDouble(parameter);
                instance.setOverallCapacity(overallCapacity);
            }
        },
        HEIGHT {
            @Override
            public void setParameter(Refrigerator instance, String parameter) {
                double height = Double.parseDouble(parameter);
                instance.setHeight(height);
            }
        },
        WIDTH {
            @Override
            public void setParameter(Refrigerator instance, String parameter) {
                double width = Double.parseDouble(parameter);
                instance.setWidth(width);
            }
        };

        public abstract void setParameter(Refrigerator instance, String parameter);
    }

    public Refrigerator() {
    }

    public Refrigerator(Characteristics characteristics) {
        super("Refrigerator");
        Map<String, String> params = characteristics.getCharacteristics();
        for (String parameter : params.keySet()) {
            String paramValue = params.get(parameter);
            setParameter(parameter, paramValue);
        }
    }

    @Override
    public void setParameter(String parameter, String value) {
        for (RefrigeratorParams fridgeParameter : RefrigeratorParams.values()) {
            if (fridgeParameter.name().equals(parameter)) {
                fridgeParameter.setParameter(this, value);
            }
        }
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFreezerCapacity(double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public void setOverallCapacity(double overallCapacity) {
        this.overallCapacity = overallCapacity;
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

    public double getFreezerCapacity() {
        return freezerCapacity;
    }

    public double getOverallCapacity() {
        return overallCapacity;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Refrigerator {" +
                "power consumption: " + powerConsumption +
                ", weight: " + weight +
                ", freezer capacity: " + freezerCapacity +
                ", overall capacity: " + overallCapacity +
                ", height: " + height +
                ", width: " + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Refrigerator that = (Refrigerator) o;

        if (Double.compare(that.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.freezerCapacity, freezerCapacity) != 0) return false;
        if (Double.compare(that.overallCapacity, overallCapacity) != 0) return false;
        if (Double.compare(that.height, height) != 0) return false;
        return Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long longBits;
        longBits = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(freezerCapacity);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(overallCapacity);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(height);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(width);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        return result;
    }
}
