import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class Main{
/*     public static void main(String args[]) throws FileNotFoundException{
        String fname = "input.txt";
        HashSet<Character> betuk = new HashSet<>();
        Scanner be = new Scanner(new File(fname));
        String y = be.next();
        char[] input = y.toCharArray();
        int hashsize = 0;
        int result = 0;

        for(int i = 0; i < input.length-3; i++){
            for(int j = 0; j < 4; j++){
                betuk.add(input[i+j]);
                hashsize++;
                if(hashsize > betuk.size()){
                    betuk.clear();
                    hashsize = 0;
                    break;
                }else if(betuk.size() == 4){
                    result = i+4;
                    break;
                }
            }
            if(result > 0){
                break;
            }
        }
        System.out.println(result);
    } */

    public static void main(String args[]) throws FileNotFoundException{
        String fname = "input.txt";
        HashSet<Character> betuk = new HashSet<>();
        Scanner be = new Scanner(new File(fname));
        String y = be.next();
        char[] input = y.toCharArray();
        int hashsize = 0;
        int result = 0;

        for(int i = 0; i < input.length-13; i++){
            for(int j = 0; j < 14; j++){
                betuk.add(input[i+j]);
                hashsize++;
                if(hashsize > betuk.size()){
                    betuk.clear();
                    hashsize = 0;
                    break;
                }else if(betuk.size() == 14){
                    result = i+14;
                    break;
                }
            }
            if(result > 0){
                break;
            }
        }
        System.out.println(result);
    }
}
