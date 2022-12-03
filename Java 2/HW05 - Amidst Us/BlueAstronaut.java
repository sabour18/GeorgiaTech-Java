import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate{

    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }
    
    public BlueAstronaut(String name) {
        super(name, 15);
        numTasks = 6;
        taskSpeed = 10;
    }

    @Override
    public void emergencyMeeting() {
        if(this.isFrozen()){
            return;
        }

        //get list of all Players
        Player[] allPlayers = getPlayers();
        Arrays.sort(allPlayers);

        Player mostSus = null;

        for(int i = allPlayers.length-1; i> 0; i--){
            if(i>0 && !(allPlayers[i].isFrozen())){
                for(int j = i-1; j >= 0; j--){
                    if(allPlayers[j].compareTo(allPlayers[i]) == 0 && !(allPlayers[j].isFrozen())){
                        return;
                    }
                }
                mostSus = allPlayers[i];
                break;
            }
        }
        mostSus.setFrozen(true);
        gameOver();
    }

    @Override
    public void completeTask() {
        if(this.isFrozen()){
            return;
        }

        if(numTasks > 0){
            if(taskSpeed > 20){
                numTasks -= 2;
            }else{
                numTasks--;
            }

            if(numTasks < 0 || numTasks == 0){
                numTasks = 0;
                System.out.println("I have completed all my tasks");
                this.setSusLevel((int) this.getSusLevel()/2);
            }
        }
    }//completeTask
  
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            if(super.equals(o) && numTasks == player.getNumTasks() && taskSpeed == player.getTaskSpeed());
            return true;
        }else{
            return false;
        }
    }//equals

    public int getNumTasks(){
        return numTasks;
    }

    public int getTaskSpeed(){
        return taskSpeed;
    }

    public String toString(){
        String s = super.toString();
        s+= " I have " + numTasks + " left over";

        if(this.getSusLevel() > 15){
            return(s.toUpperCase());
        }
        return s;
    }//toString
}
