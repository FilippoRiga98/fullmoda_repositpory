package it.sopra.stage.fullmoda.dto;

import java.util.Map;

import lombok.Data;

@Data
public class MailData
{
	private String from;
   private String to;
   private String subject;
   private Map<String, Object> model;
   
   public MailData() {
   	
   }

}
