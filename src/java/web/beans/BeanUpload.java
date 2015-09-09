package web.beans;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class BeanUpload {
    
    public void upload(FileUploadEvent event) throws FileNotFoundException, IOException {
        if(event != null) {
            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
             String imagemURL = "C:\\Users/DanielDruszcz/Documents/NetBeansProjects/TCC/tmp/" + 
                     event.getFile().getFileName();  
            try (FileOutputStream fos = new FileOutputStream(imagemURL)) {
                fos.write(event.getFile().getContents());
                fos.flush();
                fos.close();
                System.out.println("Sucesso");
            }  
        }
    }
     
//    public void upload(FileUploadEvent evt) throws FileNotFoundException, IOException {
//        setFile(((UploadedFile)evt.getFile()));
//        if(file != null) {
//            System.out.println("hue");
//            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//            String imagemURL = "./tmp/" + evt.getFile().getFileName();  
//            try (FileOutputStream fos = new FileOutputStream(imagemURL)) {
//                fos.write(evt.getFile().getContents());
//                fos.flush();
//                fos.close();
//                System.out.println("Sucesso");
//            }  
//        }
//    }
}