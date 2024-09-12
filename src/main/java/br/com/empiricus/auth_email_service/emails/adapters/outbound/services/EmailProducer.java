package br.com.empiricus.auth_email_service.emails.adapters.outbound.services;

import br.com.empiricus.auth_email_service.emails.core.domain.Email;
import br.com.empiricus.auth_email_service.emails.core.dtos.SendEmailDTO;
import br.com.empiricus.auth_email_service.emails.core.exceptions.SendEmailException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailProducer {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.email}")
    private String sender;

    public void sendMessage(Email changedEmail, List<SendEmailDTO> emails, String action) throws SendEmailException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setFrom(sender);
            for(SendEmailDTO bcc : emails)
                mimeMessageHelper.addTo(bcc.getEmail());
            mimeMessageHelper.setSubject("O email " + changedEmail.getEmail()
                        + " foi " + action
                        + " para o usuário de CPF " + changedEmail.getCpf());
            mimeMessageHelper.setText("");
            mailSender.send(message);
        }  catch (Exception e) {
            throw new SendEmailException(e.getLocalizedMessage());
        }
    }
}
