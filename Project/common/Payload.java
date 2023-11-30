package Project.common;

import java.io.Serializable;

public class Payload implements Serializable {
    // read https://www.baeldung.com/java-serial-version-uid
    private static final long serialVersionUID = 1L;// change this if the class changes

    /**
     * Determines how to process the data on the receiver's side
     */
    private PayloadType payloadType;

    public PayloadType getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    /**
     * Who the payload is from
     */
    private String clientName;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private long clientId;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    /**
     * Generic text based message
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
// rr268, 11/08/2023
    private int score;

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    private String answer;

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }

    private String question;
    private String category;
    private String options;

    public void setQuestion(String quesiton){
        this.question = quesiton;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setOptions(String options){
        this.options = options;
    }

    public String getQuestion(){
        return question;
    }

    public String getCategory(){
        return category;
    }

    public String getOptions(){
        return options;
    }

    private int time;

    public void setTime(int time){
        this.time = time;
    }

    public int getTime(){
        return time;
    }

//
    @Override
    public String toString() {
        return String.format("Type[%s],ClientId[%s,] ClientName[%s], Message[%s]", getPayloadType().toString(),
                getClientId(), getClientName(),
                getMessage());
    }
}