import java.util.List;

class Main{
    public static void main(String args[]){
        System.out.println(part2());
    
    }

    public static String part2() {
        DirectoryTreeNode root = new DirectoryTreeNode("/");
        DirectoryTreeNode cur = root;
        
        
        List<String> in = FileUtils.readLines("input.txt");

        String[] tomb = in.toArray(new String[0]);

        String input = String.join("\n",tomb);


        for(String s : input.split("\n")) {
            //dirs are irrelevant - we'll add them once (if) they're cd'd into
            if(s.endsWith("/") || s.startsWith("dir"))
                continue;
            String[] words = s.split(" ");
            if(words[0].equals("$")) {
                if(words[1].equals("cd")) {
                    //move up level
                    if(words[2].equals("..")) {
                        cur = cur.parent;
                        //initialize subdirectory and move into it
                    } else {
                        DirectoryTreeNode next = new DirectoryTreeNode(words[2]);
                        cur.children.add(next);
                        next.parent = cur;
                        cur = next;
                    }
                }
                //only other possibility is file within directory - add its size to total
            } else {
                cur.filesTotal += Long.parseLong(words[0]);
            }
        }

        //calculate minimum size required to delete
        long required = 30000000 - (70000000 - sizeTotal(root));

        return Long.toString(smallestAbove(root,required));
    }

    public static long sizeTotal(DirectoryTreeNode n) {
        long total = 0;
        for(DirectoryTreeNode o : n.children)
            total += sizeTotal(o);
        total += n.filesTotal;
        return total;
    }

    public static long smallestAbove(DirectoryTreeNode n, long required) {
        long smallest = Long.MAX_VALUE;
        for(DirectoryTreeNode o : n.children)
            smallest = Math.min(smallest,smallestAbove(o,required));
        if(sizeTotal(n) > required)
            smallest = Math.min(smallest,sizeTotal(n));
        return smallest;
    }
}
