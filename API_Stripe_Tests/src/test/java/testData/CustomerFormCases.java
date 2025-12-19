package testData;

import providers.FakerProvider;

import java.util.HashMap;
import java.util.Map;

public class CustomerFormCases {

    public static Map<String, Object> emailOnly() {
        return Map.of("email", FakerProvider.faker().internet().emailAddress());
    }

    public static Map<String, Object> emailAndName() {
        Map<String, Object> formDataMap = new HashMap<>();
        formDataMap.put("email", FakerProvider.faker().internet().emailAddress());
        formDataMap.put("name", FakerProvider.faker().name().fullName());
        return formDataMap;
    }

    public static Map<String, Object> full() {
        Map<String, Object> formDataMap = emailAndName();
        formDataMap.put("description", FakerProvider.faker().lorem().sentence(3));
        return formDataMap;
    }
}

