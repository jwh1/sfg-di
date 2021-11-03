package guru.springframework.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {
    private String myName = "default";
    public PrototypeBean() {
        System.out.println("Creating a PrototypeBean!!!!!!!!!!!!!");
    }

    public String getMyScope() {
        return "I am a Prototype bean";
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}