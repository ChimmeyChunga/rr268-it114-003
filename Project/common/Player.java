package Project.common;

public class Player {

    private boolean isReady = false;
    private boolean hasAnswered = false;
    private boolean isAway = false;

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public boolean isReady() {
        return this.isReady;
    }
//
    public void setAnswer(boolean hasAnswered){
        this.hasAnswered = hasAnswered;
    }

    public boolean hasAnswered(){
        return this.hasAnswered;
    }

    private int score;

    public void setScore(int score){
        this.score += score;
    }

    public int getScore(){
        return score;
    }
    public void setAway(boolean isAway) {
        this.isAway = isAway;
    }

    public boolean isAway() {
        return this.isAway;
    }

    //
}