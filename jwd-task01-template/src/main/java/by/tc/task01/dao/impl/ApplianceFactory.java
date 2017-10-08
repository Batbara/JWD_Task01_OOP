package by.tc.task01.dao.impl;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.VacuumCleaner;

public enum ApplianceFactory {
    Laptop {
        @Override
        public Laptop getAppliance(Characteristics characteristics) {
            return new Laptop(characteristics);
        }
    },
    Oven {
        @Override
        public Appliance getAppliance(Characteristics characteristics) {
            return new Oven(characteristics);
        }
    },
    Refrigerator {
        @Override
        public Appliance getAppliance(Characteristics characteristics) {
            return new Refrigerator(characteristics);
        }
    },
    Speakers {
        @Override
        public Appliance getAppliance(Characteristics characteristics) {
            return new Speakers(characteristics);
        }
    },
    TabletPC {
        @Override
        public Appliance getAppliance(Characteristics characteristics) {
            return new TabletPC(characteristics);
        }
    },
    VacuumCleaner {
        @Override
        public Appliance getAppliance(Characteristics characteristics) {
            return new VacuumCleaner(characteristics);
        }
    };

    public abstract Appliance getAppliance(Characteristics characteristics);
}
