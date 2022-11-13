package io.mateu.sillot.hellosillot;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SillotService {

    private LocalDateTime lastTime;
    private boolean notificationsActive = true;



    public LocalDateTime getLastTime()
    {
        return lastTime;
    }

    public void setLastTime()
    {
        lastTime = LocalDateTime.now();
    }

    public void setLastTime( LocalDateTime time)
    {
        lastTime = time;
    }

    public boolean checkNotification()
    {
        boolean notify = false;
        LocalDateTime lastTime= getLastTime();
        LocalDateTime hace5Minutos = LocalDateTime.now().minusMinutes(5);
        if (lastTime==null) notify = true;
        else if (lastTime.isBefore(hace5Minutos))  notify=true;
        return notify;
    }

    public boolean isNotificationsActive() {
        return notificationsActive;
    }

    public void setNotificationsActive(boolean notificationsActive) {
        this.notificationsActive = notificationsActive;
    }
}
