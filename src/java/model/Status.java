/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Status implements Serializable {

    private static final long serialVersionUID = -9130603850117689481L;

    private String status;
    private String message;
    
    public Status() {} // needed for JAXB
    
    public Status(String status, String message) {
        this.status = status;
        this.message = message;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
