import java.util.List;

class Main{
    public static void main(String args[]){
        String fname = "input.txt";

        List<String> sorok = FileUtils.readLines(fname);

        int sum = 0;
        int mano_szama = 1;
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        for (String s : sorok){
            if(s.length()<=1){
                System.out.println("----------ÜRES SOR----------");
                sum = 0;
                mano_szama++;
            }
            else{
                sum += Integer.parseInt(s);
                mano_szama++;
            }

            if(sum>max1){
                max3 = max2;
                max2 = max1;
                max1 = sum;
            }else if(sum > max2 && sum != max1){
                max3 = max2;;
                max2 = sum;
            }else if(sum > max3 && sum != max2){
                max3 = sum;
            }
            System.out.println(sum);
        }
        System.out.println("-------------TOP3---------------");
        System.out.println(max1);
        System.out.println(max2);
        System.out.println(max3);
        int vege = max1+ max2 + max3;
        System.out.println(vege);
        
    }
}