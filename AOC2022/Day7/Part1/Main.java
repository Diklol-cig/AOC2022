import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Main{


    public static void main(String args[]){
        String fname = "test.txt";

        List<String> lines = FileUtils.readLines(fname);
        long count = 0;
        long sum = 0;

        Dir currentDir = new Dir("/",0);

        List<Dir> dirs = new ArrayList<Dir>() { currentDir };

        for(String line : lines){
            //System.out.println(line);
            if(line.startsWith("$")){
                //cmd
                if(line.startsWith("$ cd")){
                    String[] parts = line.split(" ");
                    String newFolder = parts[-1];
                    if(newFolder == "/"){
                        currentDir = directories.First(o -> o.Path == "/");
                    }else if(newFolder == ".."){
                        var split = currentDir.path.split('/');

                        String newPath = "/" + String.join('/', split.);
}
}
            /* count = line.chars().filter(x -> x == '.').count();
            
            String[] reszek = line.split(" "); 

            if(count == 0 && line.contains("cd")){
                dirs.put(reszek[0], Long.parseLong(reszek[1]));
            }
            if(count == 1){
                //System.out.println(reszek[0]);
                //System.err.println(reszek[1]);
                sizes.put(reszek[1], Integer.parseInt(reszek[0]));
                sum += Integer.parseInt(reszek[0]);
            } */
        }

        long sum2 = 0;
        for(int x : sizes.values()){
            //System.out.println(x);
            if(x < 100000)
            sum2 += x;
        }
        System.out.println(sum);
        System.out.println(sum2);
    }

    
}

