package Project.common;

public class Player {

    private boolean isReady = false;

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public boolean isReady() {
        return this.isReady;
    }

    //
    private int time;

    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return time;
    }

    private int score;

    public void setScore(int score){
        this.score += score;
    }

    public int getScore(){
        return score;
    }
    //
}