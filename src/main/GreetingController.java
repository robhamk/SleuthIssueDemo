package greeting;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AutoConfigurationPackage
@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String welcome() {
        return "Hello World";
    }

}
