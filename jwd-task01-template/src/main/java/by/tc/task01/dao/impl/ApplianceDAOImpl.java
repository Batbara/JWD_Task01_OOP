package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.FileNotFoundException;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public <E> Appliance find(Criteria<E> criteria) {
        Appliance appliance;

        String searchData = getSearchData(criteria);

        if (searchData == null)
            return null;

        String applianceType = criteria.getApplianceType();
        Characteristics applianceParams = DataParser.getCharacteristics(searchData);

        appliance = createAppliance(applianceType, applianceParams);

        return appliance;
    }

    private <E> String getSearchData(Criteria<E> criteria) {
        String searchData;
        try {
            searchData = DataParser.parseData(criteria);
        } catch (FileNotFoundException e) {
            System.err.println("Can't open file!");
            return null;
        }
        return searchData;
    }

    private Appliance createAppliance(String applianceType, Characteristics applianceParams) {
        Appliance appliance;
        for (ApplianceFactory applianceFactory : ApplianceFactory.values()) {
            String factoryTypeName = applianceFactory.name();

            if (factoryTypeName.equals(applianceType)) {
                appliance = applianceFactory.getAppliance(applianceParams);
                return appliance;
            }
        }
        return null;
    }

}