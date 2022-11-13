package io.mateu.sillot.hellosillot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SillotServiceTest {

    @Autowired
    private SillotService sillotService;


    @Test
    public void comprovacioInici()
    {
        assertTrue(sillotService.checkNotification());
    }

    @Test
    public void comprovacioOK()
    {
        sillotService.setLastTime();
        assertFalse(sillotService.checkNotification());
    }

    @Test
    public void comprovacioError()
    {
        LocalDateTime time = LocalDateTime.now().minusMinutes(10);
        sillotService.setLastTime(time);
        assertTrue(sillotService.checkNotification());
    }
}
