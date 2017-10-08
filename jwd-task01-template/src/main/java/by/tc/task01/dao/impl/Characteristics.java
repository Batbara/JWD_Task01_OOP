package by.tc.task01.dao.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Characteristics implements Serializable{
    private Map<String, String> characteristics;
    public Characteristics(){
        characteristics = new HashMap<>();
    }

    public Characteristics(Map<String, String> characteristics){
        this.characteristics = characteristics;
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Characteristics that = (Characteristics) o;

        return characteristics.equals(that.characteristics);
    }

    @Override
    public int hashCode() {
        return characteristics.hashCode();
    }

    @Override
    public String toString() {
        return "Characteristics {" +
                "characteristics:" + characteristics +
                '}';
    }
}
