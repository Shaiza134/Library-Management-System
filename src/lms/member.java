/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author Zahra Maryam
 */
public class member {
    private String Name,Address,Phone;
    public member(String Name, String Address, String Phone){
        this.Name  = Name;
        this.Address = Address;
        this.Phone = Phone;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public void setPhone(String Phone){
        this.Phone = Phone;
    }
    public String getName(){
        return this.Name;
    }
    public String getAddress(){
        return this.Address;
    }
    public String getPhone(){
        return this.Phone;
    }
    
}
