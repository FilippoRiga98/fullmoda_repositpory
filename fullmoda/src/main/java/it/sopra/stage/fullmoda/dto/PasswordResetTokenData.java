package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;

@Data
public class PasswordResetTokenData implements Serializable
{
	private static final long serialVersionUID = 2577051965704026887L;
	
	private Long id;
   private String token;
   private UserData user;
   private Date expiryDate;
   
   public void setExpiryDate(Date expiryDate){
      this.expiryDate = expiryDate;
   }
   
   public void setExpiryDate(int minutes){
      Calendar now = Calendar.getInstance();
      now.add(Calendar.MINUTE, minutes);
      this.expiryDate = now.getTime();
   }
   
   public boolean isExpired() {
      return new Date().after(this.expiryDate);
   }

}
