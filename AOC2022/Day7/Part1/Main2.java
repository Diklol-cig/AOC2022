import java.util.List;

public class Main2{

    public static String input;

    public static String part1() {
        List<String> in = FileUtils.readLines("input.txt");

        String[] tomb = in.toArray(new String[0]);

        input = String.join("\n",tomb);
        

        DirectoryTreeNode root = new DirectoryTreeNode("/");
        DirectoryTreeNode cur = root;


        for(String s : input.split("\n")) {
            //dirs are irrelevant - we'll add them when (if) they're cd'd into
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
            //only other possibility is file within current directory - add its size to total
            } else {
                cur.filesTotal += Long.parseLong(words[0]);
            }
        }
        //recursively calculate sum of all smaller than given size
        return Long.toString(sizeGreaterThanTotal(root));
    }

    public static long sizeTotal(DirectoryTreeNode n) {
        long total = 0;
        for(DirectoryTreeNode o : n.children)
            total += sizeTotal(o);
        total += n.filesTotal;
        return total;
    }

    public static long sizeGreaterThanTotal(DirectoryTreeNode n) {
        long total = 0;
        for(DirectoryTreeNode o : n.children)
            total += sizeGreaterThanTotal(o);
        if(sizeTotal(n) < 100001)
            total += sizeTotal(n);
        return total;
    }

    public long smallestAbove(DirectoryTreeNode n, long required) {
        long smallest = Long.MAX_VALUE;
        for(DirectoryTreeNode o : n.children)
            smallest = Math.min(smallest,smallestAbove(o,required));
        if(sizeTotal(n) > required)
            smallest = Math.min(smallest,sizeTotal(n));
        return smallest;
    }

    public static void main(String[] args){
        System.out.println(part1());
    }
}