import java.util.*;
import java.util.stream.Collectors;

public class problem_12 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Shadowmourne – requires 250 Shards;
        // Valanyr – requires 250 Fragments;
        // Dragonwrath – requires 250 Motes;

        // map for the key mats
        // map for the others

        List<String> mats = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        Map<String, Integer> needed = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        needed.put("shards", 0);
        needed.put("fragments", 0);
        needed.put("motes", 0);
        boolean enough = false;
        String item = "";
        while (!enough) {
            while (!mats.isEmpty()) {
                int quantity = Integer.parseInt(mats.remove(0));
                String mat = mats.remove(0).toLowerCase();

                if (needed.containsKey(mat)) {
                    needed.put(mat, needed.get(mat) + quantity);
                } else {
                    junk.putIfAbsent(mat, 0);
                    junk.put(mat, junk.get(mat) + quantity);
                }
                for (String key : needed.keySet()) {
                    if (needed.get(key) >= 250) {
                        enough = true;
                        needed.put(key, needed.get(key) - 250);
                        switch (key) {
                            case "shards":
                                item = "Shadowmourne";
                                break;
                            case "fragments":
                                item = "Valanyr";
                                break;
                            case "motes":
                                item = "Dragonwrath";
                                break;

                        }
                        System.out.println(item + " obtained!");
                        needed.entrySet().stream().sorted((m1, m2) -> m2.getValue().compareTo(m1.getValue()))
                                .forEach(m -> System.out.println(m.getKey() + ": " + m.getValue()));

                        junk.forEach((key1, value) -> System.out.println(key1 + ": " + value));
                        return;
                    }
                }
            }
            mats = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        }
    }
}
