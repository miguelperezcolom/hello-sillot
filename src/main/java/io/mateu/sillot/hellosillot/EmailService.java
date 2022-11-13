package io.mateu.sillot.hellosillot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    private String[] to= {"miguelperezcolom@gmail.com", "antagalmes@gmail.com"};

    public void sendSimpleMessage(String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sillotalertas@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }

    public void notifySillotAlertas()
    {
        String subject = "Notificació des de S'Illot Alertas";
        String text = "És possible que se n'hagi anat el llum!!";
        sendSimpleMessage(subject,text);
    }
}
