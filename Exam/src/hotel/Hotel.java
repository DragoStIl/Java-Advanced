package hotel;

import java.util.LinkedHashMap;
import java.util.Map;

public class Hotel {

    private String name;
    private int capacity;
    private Map<String, Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new LinkedHashMap<>();
    }

    public void add(Person person) {
        if (this.capacity > roster.size()) {
            this.roster.putIfAbsent(person.getName(), person);
        }
    }

    public boolean remove(String name) {
        if (this.roster.containsKey(name)) {
            this.roster.remove(name);
            return true;
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        if (roster.containsKey(name)) {
            if (this.roster.get(name).getHometown().equals(hometown)) {
                return roster.get(name);
            }
        }
        return null;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder hotelGuestsInfo = new StringBuilder();
        hotelGuestsInfo.append(
        String.format("The people in the hotel %s are:", this.name))
                .append(System.lineSeparator());

        for (Person person : roster.values()) {
            hotelGuestsInfo.append(person).append(System.lineSeparator());
        }

        return hotelGuestsInfo.toString().trim();
    }
}
