package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class ThreeGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World Three";
    }
}
