package it.sopra.stage.fullmoda.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="password_reset_token")
@OnDelete(action = OnDeleteAction.NO_ACTION)
@Data
@NoArgsConstructor
public class PasswordResetToken implements Serializable
{
	private static final long serialVersionUID = -5579401717033965744L;

	@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
 
	@Column(nullable = false, unique = true)
   private String token;
 
   @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
   @JoinColumn(nullable = false, name = "user_id")
   private User user;
 
   @Column(name="expiry_date", nullable = false)
   private Date expiryDate;
   
}
