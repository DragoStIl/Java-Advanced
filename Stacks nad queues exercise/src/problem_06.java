import java.util.Scanner;

public class problem_06 {
    public static long [] memory;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int searchedFib = Integer.parseInt(scan.nextLine());
        memory = new long[searchedFib + 1];
        System.out.println(fib(searchedFib));
    // fib N == fib n-1 + fib n-2
        // if fib <= 1 ; return 1

            
    }

    public static long fib (int n) {
        if (n <= 1){
            return 1;
        }
        
        if(memory[n] != 0){
            return memory[n];
        }

        return memory[n] = fib(n - 1) + fib(n - 2);
    }
    
}
