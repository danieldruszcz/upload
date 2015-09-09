/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.beans;

import javax.faces.bean.ManagedBean;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author DanielDruszcz
 */

@ManagedBean
public class BeanEmail {
    
    private static String host = "smtp.gmail.com";
    
    public void manda(){
        enviarEmail("danieldruszcz@gmail.com", "hehe", "danieldruszcz@hotmail.com", "husahushuauhsa");
    }
    
    
	public void enviarEmail(String remetente, String assunto, String destinatario, String corpo)
			 {
		
		try{
			SimpleEmail sm = new SimpleEmail();	
			sm.setHostName("smtp.gmail.com");
			sm.setSmtpPort(465);
			sm.setFrom(remetente);
			sm.setMsg(corpo);
			sm.setSubject(assunto);
			sm.addTo(destinatario);
			sm.setSSL(true);
                        sm.setAuthentication("email@hotmail.com", "senha");
                        System.out.println("enviado");
			sm.send();
		}
		catch (Exception e) {
                    e.printStackTrace();
		}

		
	}
    
}
