package by.tc.task01.entity;

import by.tc.task01.dao.impl.Characteristics;

import java.io.Serializable;
import java.util.Map;

public class Speakers extends Appliance implements Serializable {
    private double powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private double cordLength;

    private enum SpeakersParams {
        POWER_CONSUMPTION {
            @Override
            public void setParameter(Speakers instance, String parameter) {
                double powerConsumption = Double.parseDouble(parameter);
                instance.setPowerConsumption(powerConsumption);
            }
        },
        NUMBER_OF_SPEAKERS {
            @Override
            public void setParameter(Speakers instance, String parameter) {
                double numberOfSpeakers = Double.parseDouble(parameter);
                instance.setNumberOfSpeakers((int) numberOfSpeakers);
            }
        },
        FREQUENCY_RANGE {
            @Override
            public void setParameter(Speakers instance, String parameter) {
                instance.setFrequencyRange(parameter);
            }
        },
        CORD_LENGTH {
            @Override
            public void setParameter(Speakers instance, String parameter) {
                double cordLength = Double.parseDouble(parameter);
                instance.setCordLength(cordLength);
            }
        };

        public abstract void setParameter(Speakers instance, String parameter);
    }

    public Speakers() {
    }

    public Speakers(Characteristics characteristics) {
        super("Speakers");
        Map<String, String> params = characteristics.getCharacteristics();
        for (String parameter : params.keySet()) {
            String paramValue = params.get(parameter);
            setParameter(parameter, paramValue);
        }
    }

    @Override
    public void setParameter(String parameter, String value) {
        for (SpeakersParams speakersParameter : SpeakersParams.values()) {
            if (speakersParameter.name().equals(parameter)) {
                speakersParameter.setParameter(this, value);
            }
        }
    }

    @Override
    public String toString() {
        return "Speakers {" +
                "power consumption: " + powerConsumption +
                ", number of speakers: " + numberOfSpeakers +
                ", frequency range: " + frequencyRange +
                ", cord length: " + cordLength +
                '}';
    }

    public void setPowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public void setNumberOfSpeakers(int numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public void setFrequencyRange(String frequencyRange) {
        this.frequencyRange = frequencyRange;
    }

    public void setCordLength(double cordLength) {
        this.cordLength = cordLength;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }

    public int getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public String getFrequencyRange() {
        return frequencyRange;
    }

    public double getCordLength() {
        return cordLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Speakers speakers = (Speakers) o;

        if (Double.compare(speakers.powerConsumption, powerConsumption) != 0) return false;
        if (numberOfSpeakers != speakers.numberOfSpeakers) return false;
        if (Double.compare(speakers.cordLength, cordLength) != 0) return false;
        return frequencyRange.equals(speakers.frequencyRange);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(powerConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numberOfSpeakers;
        result = 31 * result + frequencyRange.hashCode();
        temp = Double.doubleToLongBits(cordLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
