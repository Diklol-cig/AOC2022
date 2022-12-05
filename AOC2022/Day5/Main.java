import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Deque;

class Main{

            private static List<String> instructions;
        
            public static void main(String[] args) throws IOException {
                List<String> crates = createCratesAndInstructions();
                Deque<Character>[] Deques = createDeques(crates);
                performInstructions(Deques);
                printResult(Deques);
            }
        
            private static List<String> createCratesAndInstructions() throws FileNotFoundException {
                File file = new File("input.txt");
                List<String> crates = new ArrayList<>();
                instructions = new ArrayList<>();
                
                try(Scanner scanner = new Scanner(file)) {
                    String latest;
                    do {
                        latest = scanner.nextLine();
                        crates.add(latest);
                    } while(latest.indexOf(']') >= 0);
                    scanner.nextLine();
                    while(scanner.hasNext())
                        instructions.add(scanner.nextLine());
        
                }
                return crates;
            }
        
            public static Deque<Character>[] createDeques(List<String> crates) {
                String indexes = crates.remove(crates.size() - 1).trim();
                int largestIndex = Character.getNumericValue(indexes.charAt(indexes.length() - 1));
                Deque<Character>[] Deques = new ArrayDeque[largestIndex];
                
                for(int s = 0; s < Deques.length; s++)
                    Deques[s] = new ArrayDeque<>();
        
                for(int i = crates.size() - 1; i >= 0; i--) {
                    String c = crates.get(i);
                    //System.out.println(c);
                    for(int j = 1, s = 0; s < largestIndex && j < c.length(); j += 4, s++) {
                        char box = c.charAt(j);
                        if(box != ' ')
                            Deques[s].push(box);
                        
                    }
                }
                return Deques;
            }
        
            private static void performInstructions(Deque<Character>[] Deques) {
                for(String action : instructions) {
                    Scanner lineScanner = new Scanner(action);
                    lineScanner.next();
                    int pops = lineScanner.nextInt();
                    lineScanner.next();
                    int fromIndex = lineScanner.nextInt() - 1;
                    lineScanner.next();
                    int toIndex = lineScanner.nextInt() - 1;
                    List<Character> boxes = new ArrayList<>();
                    
                    for(int i = 0; i < pops; i++)
                        boxes.add(Deques[fromIndex].pop());
        
                    System.out.println(boxes);
                    boxes = reverseArrList(boxes);
                    System.out.println(boxes);
                    for(Character b : boxes)
                        
                        Deques[toIndex].push(b);
                    
                    System.out.println(boxes);
                    System.out.println("--------------------------------");

                    lineScanner.close();
                }
            }
        
            public static void printResult(Deque<Character>[] Deques) {
                for(Deque<Character> s : Deques)
                    System.out.print(s.peek());
        
                System.out.println();
            }

            public static List<Character> reverseArrList(List<Character> arr) {
                ArrayList<Character> revArrayList = new ArrayList<>();
                for (int i = arr.size() - 1; i >= 0; i--) {
                        revArrayList.add(arr.get(i));
                    }
                return revArrayList;
            }
}
