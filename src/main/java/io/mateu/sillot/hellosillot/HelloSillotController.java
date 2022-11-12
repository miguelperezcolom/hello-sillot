package io.mateu.sillot.hellosillot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSillotController {

    @Autowired
    private SillotService sillotService;

    @RequestMapping("/raspberry/alive")
    public String registerCall()
    {
        sillotService.setLastTime();
        String result = sillotService.getLastTime().toString();
        return result;
    }

    @RequestMapping("/raspberry/lastTime")
    public String GetLastTime()
    {
        String result = sillotService.getLastTime().toString();
        return result;
    }

}
