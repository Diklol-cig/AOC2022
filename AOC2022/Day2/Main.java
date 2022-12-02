import java.util.List;

class Main{
    public static void main(String args[]){
        String fname = "input.txt";

        List<String> sorok = FileUtils.readLines(fname);

        String enemy;
        String me;
        int score = 0;
        
        for (String s : sorok){
            
            String[] line = s.split(" ");
            me = line[1];
            enemy = line[0];

            //System.out.println("me: -" + me + "- enemy: -" + enemy + "-");
            /* if(enemy.equals("A") && me.equals("Y")  || enemy.equals("B") && me.equals("Z") || enemy.equals("C") && me.equals("X")){
                System.out.println("------------EN NYEREK------------");
                if(me.equals("X")){
                    score += 1 +6;  
                }else if(me.equals("Y")){
                    score += 2 +6;
                }else if(me.equals("Z")){
                    score += 3 +6;
                }

            }else if(enemy.equals("A") && me.equals("X") || enemy.equals("B") && me.equals("Y") || enemy.equals("C") && me.equals("Z")){
                if(me.equals("X")){
                    score += 1 +3;
                }else if(me.equals("Y")){
                    score += 2 +3;
                }else if(me.equals("Z")){
                    score += 3 +3;
                }
            }else{
                if(me.equals("X")){
                    score += 1;
                }else if(me.equals("Y")){
                    score += 2;
                }else if(me.equals("Z")){
                    score += 3;
                }
            }
        } */
        //X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
        
        if(me.equals("X")){ //lose 0 pont
            if(enemy.equals("A")){
                score += 3 +0; //Z
            }
            if(enemy.equals("B")){
                score += 1 +0; //X
            }
            if(enemy.equals("C")){
                score += 2 +0; //Y
            }
        }else if(me.equals("Y")){
            
            if(enemy.equals("A")){
                score += 1 +3; 
            }
            if(enemy.equals("B")){
                score += 2 +3;
            }
            if(enemy.equals("C")){
                score += 3 +3;
            }
        }else{
            if(enemy.equals("A")){
                score += 2 +6;  //Y
            }
            if(enemy.equals("B")){
                score += 3 +6; //Z
            }
            if(enemy.equals("C")){
                score += 1 +6; //X
            }
        }
        
    }
    System.out.println("asd");
    System.out.println(score);
}}
