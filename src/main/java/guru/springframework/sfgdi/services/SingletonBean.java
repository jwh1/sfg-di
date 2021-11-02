package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    private String myName = "default";
    public SingletonBean() {
        System.out.println("Creating a SingletonBean!!!!!!!!!!!!!");
    }

    public String getMyScope() {
        return "I am a Singleton bean";
    }
    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}
