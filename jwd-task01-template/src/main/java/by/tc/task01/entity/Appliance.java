package by.tc.task01.entity;

import java.io.Serializable;

public abstract class Appliance implements Serializable {

    private String applianceType;

    public Appliance() {
    }

    public Appliance(String applianceType) {
        this.applianceType = applianceType;
    }

    public abstract void setParameter(String parameter, String value);

    @Override
    public String toString() {
        return "Appliance {" +
                "appliance type: '" + applianceType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appliance appliance = (Appliance) o;

        return applianceType.equals(appliance.applianceType);
    }

    @Override
    public int hashCode() {
        return applianceType.hashCode();
    }
}
