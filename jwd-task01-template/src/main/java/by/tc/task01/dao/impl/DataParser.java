package by.tc.task01.dao.impl;

import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    private static String FILE_PATH = "jwd-task01-template/src/main/resources/appliances_db.txt";
    private static File dataBase = new File(FILE_PATH);


    private static <E> boolean meetsCriteria(String line, Criteria<E> criteria) {

        for (E key : criteria.keySet()) {

            String criteriaValue = criteria.get(key).toString();
            String parsableValue;
            if (isNumeric(criteriaValue)) {
                parsableValue = getParsableString(criteriaValue);
            } else {
                parsableValue = criteriaValue;
            }

            String regExpForCriteria = "\\s(" + key.toString() + ")[=](?i)(" + parsableValue + ")([,]|[;])";

            Pattern pattern = Pattern.compile(regExpForCriteria);
            Matcher matcher = pattern.matcher(line);

            if (!matcher.find())
                return false;
        }
        return true;
    }

    private static String getParsableString(String criteriaValue) {
        Integer valueAsInt;
        Double valueAsDouble;
        if (isFractional(criteriaValue)) {

            valueAsDouble = Double.parseDouble(criteriaValue);
            valueAsInt = valueAsDouble.intValue();

            if (valueAsDouble - valueAsInt != 0)
                return valueAsDouble.toString();

        } else {
            valueAsInt = Integer.parseInt(criteriaValue);
            valueAsDouble = valueAsInt.doubleValue();
        }
        return valueAsDouble.toString() + "|" + valueAsInt.toString();
    }

    public static boolean isNumeric(String stringToCheck) {
        return stringToCheck.matches("\\d+(\\.\\d+)?");
    }

    public static boolean isFractional(String stringToCheck) {
        return stringToCheck.matches("\\d+(\\.\\d+)+");
    }

    public static Characteristics getCharacteristics(String lineToParse) {

        Map<String, String> applianceCharacteristics = new HashMap<>();
        String characteristics = lineToParse.replaceAll("[:]\\s", "");

        for (String characteristic : characteristics.split("[,]\\s")) {
            List<String> values = Arrays.asList(characteristic.split("="));

            String parameterName = values.get(0);
            String parameterValue = values.get(1).replaceAll(";\\r\\n", "");

            applianceCharacteristics.put(parameterName, parameterValue);
        }
        return new Characteristics(applianceCharacteristics);
    }

    public static <E> String parseData(Criteria<E> criteria) throws FileNotFoundException {

        Scanner scanner = new Scanner(dataBase);
        String applianceType = criteria.getApplianceType();
        scanner.useDelimiter(applianceType + " ");
        while (scanner.hasNext()) {
            String line = scanner.next();
            if (!line.startsWith(":")) {
                continue;
            }
            if (meetsCriteria(line, criteria)) {
                return line;
            }
        }
        return null;
    }

}
