    import java.util.*;
    
    public class problem_09 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
    
            String inputData = scan.nextLine();
    
            Map<String, Map<String, Integer>> usersData = new TreeMap<>();
            while (!inputData.equals("end")){
                String[] history = inputData.split("\\s+");
    
                String ip = history[0].split("=")[1];
                String name = history[2].split("=")[1];
    
                usersData.putIfAbsent(name, new LinkedHashMap<>());
                Map<String, Integer> messagesCount = usersData.get(name);
                messagesCount.putIfAbsent(ip, 0);
                messagesCount.put(ip, messagesCount.get(ip) + 1);
    
    
                inputData = scan.nextLine();
            }
            usersData.entrySet()
                    .forEach(u -> {
                        System.out.println(u.getKey() + ":");
                        String values = String.join(", ", u.getValue().toString());
                        values = values.replace("{", "");
                        values = values.replace("=", " => ");
    
                        values = values.replace("}", ".");
                        System.out.println(values);
    
                    });
        }
    }
