package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {

    public static void print(Appliance appliance) {
        try {
            System.out.println(appliance.toString());
        } catch (NullPointerException e) {
            System.out.println("Nothing found");
        }

    }

}
