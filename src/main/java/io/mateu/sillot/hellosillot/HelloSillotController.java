package io.mateu.sillot.hellosillot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloSillotController {

    @Autowired
    private SillotService sillotService;

    @RequestMapping("/raspberry/alive")
    public String registerCall()
    {
        sillotService.setLastTime();
        sillotService.setNotificationsActive(true);
        String result = sillotService.getLastTime().toString();
        return result;
    }

    @RequestMapping("/raspberry/lastTime")
    public String GetLastTime()
    {
        String result ="";
        LocalDateTime time = sillotService.getLastTime();
        if (time!=null)
            result = sillotService.getLastTime().toString();
        else
            result = "null";
        return result;
    }

}
