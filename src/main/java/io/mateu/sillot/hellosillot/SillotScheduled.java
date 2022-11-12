package io.mateu.sillot.hellosillot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SillotScheduled {

    @Autowired
    private SillotService sillotService;

    @Scheduled(fixedDelay = 300000, initialDelay = 300000) // Tiempo en milisegundos-> fixedDelay = 12h. initialDelay = 5min.
    public void checkNotification() {
        boolean notify = false;
       LocalDateTime lastTime= sillotService.getLastTime();
       LocalDateTime hace5Minutos = LocalDateTime.now().minusMinutes(5);
       if (lastTime==null) notify = true;
       else if (lastTime.isBefore(hace5Minutos)) {
           notify=true;
       }

    }
}
