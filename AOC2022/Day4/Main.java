import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main{
    public static void main(String args[]){
        String input = "input.txt";

        List<String> lines = FileUtils.readLines(input);
        int sum = 0;

        for(String line : lines){
            System.out.println(line);
            String[] sorok = line.split(",");
            String[] szo1 = sorok[0].split("-");
            String[] szo2 = sorok[1].split("-");

            List<Integer> list1 = range(Integer.parseInt(szo1[0]), Integer.parseInt(szo1[1]));
            List<Integer> list2 = range(Integer.parseInt(szo2[0]), Integer.parseInt(szo2[1]));

           /*  System.out.println(list1);
            System.out.println(list2);
 */
            if(!containsList2(list1, list2)){
                sum += 1;
            }
        }

        System.out.println(sum);
    }

    private static List<Integer> range (int n, int m){
        List<Integer> list = new ArrayList<>();
        for(int i = n; i <= m; i++){
            list.add(i);
        }
        
        return list;
    }

    private static boolean containsList(List<Integer> list1, List<Integer> list2){
        if(list1.size()>list2.size()){
            list1.retainAll(list2);
                if(list1.size() == list2.size()){
                    return true;
                }
        }
        else{
            list2.retainAll(list1);
                if(list2.size()==list1.size()){
                    return true;
                }
        }
        return false;
    }
    private static boolean containsList2(List<Integer> list1, List<Integer> list2){
        if(list1.size()>list2.size()){
            list1.retainAll(list2);
                if(list1.size() == 0){
                    return true;
                }
        }
        else{
            list2.retainAll(list1);
                if(list2.size()== 0){
                    return true;
                }
        }
        return false;
    }
}
