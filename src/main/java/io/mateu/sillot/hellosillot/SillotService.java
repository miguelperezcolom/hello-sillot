package io.mateu.sillot.hellosillot;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SillotService {

    private LocalDateTime lastTime;

    public LocalDateTime getLastTime()
    {
        return lastTime;
    }

    public void setLastTime()
    {
        lastTime = LocalDateTime.now();
    }
}
