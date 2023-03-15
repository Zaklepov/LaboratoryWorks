package main;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
    HashMap<String, String> mapOfAddresses;

    public AddressBook() {
        this.mapOfAddresses = new HashMap<>();
    }

    public void add(String name, String address) {
        mapOfAddresses.put(name, address);
    }

    public void remove(String name) {
        mapOfAddresses.remove(name);
    }

    public void replaceAddress(String name, String replaceAddress) {
        mapOfAddresses.replace(name, replaceAddress);
    }

    public String getAddress(String name) {
        return (mapOfAddresses.get(name));
    }

    public Set<String> getPeopleOnAddress(String address) {
        Set<String> people = new HashSet<>();
        for (Map.Entry<String, String> entry : mapOfAddresses.entrySet()) {
            Pattern addressNeeded = Pattern.compile(address);
            Matcher addressFromMap = addressNeeded.matcher(entry.getValue());
            if (addressFromMap.find()) {
                people.add(entry.getKey());
            }
        }
        return (people);
    }
}
