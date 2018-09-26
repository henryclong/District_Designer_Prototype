package fuel.prototype;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class URLMappingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public fuel.prototype.Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new fuel.prototype.Greeting(counter.incrementAndGet(),
                String.format(template, "world"));
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "templates/index.html";
    }
}