package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Set;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {

        Set<E> keys = criteria.keySet();
        for (E criteriaKey : keys) {
            Object criteriaValue = criteria.get(criteriaKey);

            if (TypesValidator.isRangeCriteria(criteriaKey)) {
                if (!validateRangeType(criteriaValue)) {
                    return false;
                }
                continue;
            }

            Class valueClass;
            try {
                valueClass = TypesValidator.getCorrectType(criteriaKey);
            } catch (ClassNotFoundException e) {
                return false;
            }

            if (valueClass == null || !valueClass.isInstance(criteriaValue)) {
                return false;
            }

        }
        return true;
    }

    private static boolean validateRangeType(Object criteriaValue) {

        return criteriaValue instanceof String && TypesValidator.isRangeType((String) criteriaValue);

    }

}
