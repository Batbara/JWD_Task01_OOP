package by.tc.task01.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypesValidator {

    private enum StringTypes {
        OS, WAND_TYPE, COLOR, FILTER_TYPE, BAG_TYPE
    }

    private enum NumberTypes {
        POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH, BATTERY_CAPACITY,
        MEMORY_ROM, CPU, DISPLAY_INCHES, FREEZER_CAPACITY, OVERALL_CAPACITY, MOTOR_SPEED_REGULATION,
        CLEANING_WIDTH, FLASH_MEMORY_CAPACITY, NUMBER_OF_SPEAKERS, CORD_LENGTH

    }
    private enum RangeTypes {
        FREQUENCY_RANGE
    }
    private static String RANGE_TYPE_PATTERN_EXPRESSION = "\\d+([.])?\\d*[-]\\d+([.])?\\d*";
    private static Pattern rangeTypePattern = Pattern.compile(RANGE_TYPE_PATTERN_EXPRESSION);

    public static <E> boolean isRangeCriteria(E criteria){
        String criteriaName = criteria.toString();
        for (RangeTypes rangeType : RangeTypes.values()){
            if(rangeType.name().equals(criteriaName))
                return true;
        }
        return false;
    }

    public static boolean isRangeType(String expression) {
        Matcher matcher = rangeTypePattern.matcher(expression);
        return matcher.matches();
    }

    public static <E> Class getCorrectType(E criteria) throws ClassNotFoundException {
        String criteriaName = criteria.toString();

        for (StringTypes stringType : StringTypes.values()){
            if(stringType.name().equals(criteriaName))
                return Class.forName("java.lang.String");
        }

        for (NumberTypes numberType : NumberTypes.values()){
            if(numberType.name().equals(criteriaName))
                return Class.forName("java.lang.Number");
        }

        return null;
    }
}
