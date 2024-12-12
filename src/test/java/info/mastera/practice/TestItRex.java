package info.mastera.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class TestItRex {


    @Test
    void runningTest() {
        Map<String, List<String>> personPhones = new HashMap<>();

        personPhones.put("John", Arrays.asList("555-1123", "555-3389"));
        personPhones.put("Mary", Arrays.asList("555-2243", "555-5264"));
        personPhones.put("Steve", Arrays.asList("555-6654", "555-3242", "555-2243"));

        List<String> phones = personPhones.values()
                .stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println(phones);

        Map<String, Set<String>> phoneToPeople = new HashMap<>();

        personPhones.forEach((key, value) -> value.forEach(phone -> {
            if (phoneToPeople.containsKey(phone)) {
                var people = phoneToPeople.get(phone);
                people.add(key);
            } else {
                phoneToPeople.put(phone, new HashSet<>(Set.of(key)));
            }
        }));
        System.out.println(phoneToPeople);
        Assertions.assertNotNull(phoneToPeople);
    }
}
