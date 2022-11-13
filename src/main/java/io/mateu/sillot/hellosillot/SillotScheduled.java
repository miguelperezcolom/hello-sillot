package io.mateu.sillot.hellosillot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SillotScheduled {

    @Autowired
    private SillotService sillotService;
    @Autowired
    private EmailService emailService;

    @Scheduled(fixedDelay = 300000, initialDelay = 300000) // Tiempo en milisegundos-> fixedDelay = 12h. initialDelay = 5min.
    public void checkNotification() {
        boolean notify = sillotService.checkNotification();

        if (notify && sillotService.isNotificationsActive())
        {
            emailService.notifySillotAlertas();
            sillotService.setNotificationsActive(false);
        }
    }
}
