package by.tc.task01.entity;

import by.tc.task01.dao.impl.Characteristics;

import java.io.Serializable;
import java.util.Map;

public class VacuumCleaner extends Appliance implements Serializable{
    private double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private double motorSpeedRegulation;
    private double cleaningWidth;

    private enum VacuumCleanerParams{
        POWER_CONSUMPTION{
            @Override
            public void setParameter(VacuumCleaner instance, String parameter) {
                double powerConsumption = Double.parseDouble(parameter);
                instance.setPowerConsumption(powerConsumption);
            }
        },
        FILTER_TYPE{
            @Override
            public void setParameter(VacuumCleaner instance, String parameter) {
                instance.setFilterType(parameter);
            }
        },
        BAG_TYPE{
            @Override
            public void setParameter(VacuumCleaner instance, String parameter) {
                instance.setBagType(parameter);
            }
        },
        WAND_TYPE{
            @Override
            public void setParameter(VacuumCleaner instance, String parameter) {
                instance.setWandType(parameter);
            }
        },
        MOTOR_SPEED_REGULATION{
            @Override
            public void setParameter(VacuumCleaner instance, String parameter) {
                double speed = Double.parseDouble(parameter);
                instance.setMotorSpeedRegulation(speed);
            }
        },
        CLEANING_WIDTH{
            @Override
            public void setParameter(VacuumCleaner instance, String parameter) {
                double width = Double.parseDouble(parameter);
                instance.setCleaningWidth(width);
            }
        };

        public abstract void setParameter(VacuumCleaner instance, String parameter);
    }
    public VacuumCleaner(){}
    public VacuumCleaner(Characteristics characteristics){
        super("VacuumCleaner");
        Map<String, String> params = characteristics.getCharacteristics();
        for (String parameter : params.keySet()) {
            String paramValue = params.get(parameter);
            setParameter(parameter, paramValue);
        }
    }
    @Override
    public void setParameter(String parameter, String value) {
        for (VacuumCleanerParams vacuumCleanerParameter : VacuumCleanerParams.values()) {
            if (vacuumCleanerParameter.name().equals(parameter)) {
                vacuumCleanerParameter.setParameter(this, value);
            }
        }
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public void setMotorSpeedRegulation(double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public void setCleaningWidth(double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public double getCleaningWidth() {
        return cleaningWidth;
    }

    @Override
    public String toString() {
        return "VacuumCleaner {" +
                "power consumption: " + powerConsumption +
                ", filter type: '" + filterType + '\'' +
                ", bag type: '" + bagType + '\'' +
                ", wand type: '" + wandType + '\'' +
                ", motor speed regulation: " + motorSpeedRegulation +
                ", cleaning width: " + cleaningWidth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (Double.compare(that.powerConsumption, powerConsumption) != 0) return false;
        if (Double.compare(that.motorSpeedRegulation, motorSpeedRegulation) != 0) return false;
        if (Double.compare(that.cleaningWidth, cleaningWidth) != 0) return false;
        if (!filterType.equalsIgnoreCase(that.filterType)) return false;
        if (!bagType.equalsIgnoreCase(that.bagType)) return false;
        return wandType.equalsIgnoreCase(that.wandType);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long longBits;
        longBits = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        result = 31 * result + filterType.hashCode();
        result = 31 * result + bagType.hashCode();
        result = 31 * result + wandType.hashCode();
        longBits = Double.doubleToLongBits(motorSpeedRegulation);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        longBits = Double.doubleToLongBits(cleaningWidth);
        result = 31 * result + (int) (longBits ^ (longBits >>> 32));
        return result;
    }
}
