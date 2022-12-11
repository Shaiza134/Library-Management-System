/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author Zahra Maryam
 */
public class Books {
    private String Name,Author,Category,Edition;
    public Books(String Name, String Author, String Category, String Edition){
        this.Name  = Name;
        this.Author = Author;
        this.Category = Category;
        this.Edition = Edition;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setAuthor(String Author){
        this.Author = Author;
    }
    public void setCategory(String Category){
        this.Category = Category;
    }
    public void setEdition(String Edition){
        this.Edition = Edition;
    }
    public String getName(){
        return this.Name;
    }
    public String getAuthor(){
        return this.Author;
    }
    public String getCategory(){
        return this.Category;
    }
    public String getEdition(){
        return this.Edition;
    }
    
}
