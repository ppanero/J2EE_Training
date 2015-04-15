package Client_Server_App;

import java.io.Serializable;

public class Message implements Serializable{

    private String body;

    public Message(String body){
        this.body = body;
    }

    public String getBody() {
        return body;
    }

}
