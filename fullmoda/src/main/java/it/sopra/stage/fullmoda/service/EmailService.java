package it.sopra.stage.fullmoda.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService
{
	/*@Autowired
   private JavaMailSender emailSender;

   @Autowired
   private SpringTemplateEngine templateEngine;

   public void sendEmail(MailData mail) {
       try {
           MimeMessage message = emailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(message,
                   MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                   StandardCharsets.UTF_8.name());

           Context context = new Context();
           context.setVariables(mail.getModel());
           String html = templateEngine.process("email/email-template", context);

           helper.setTo(mail.getTo());
           helper.setText(html, true);
           helper.setSubject(mail.getSubject());
           helper.setFrom(mail.getFrom());

           emailSender.send(message);
       } catch (Exception e){
           throw new RuntimeException(e);
       }
   }*/
}
