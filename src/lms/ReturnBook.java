/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author Zahra Maryam
 */
public class ReturnBook {
    private String Name,Book,Date;
    public ReturnBook(String Name, String Book, String Date){
        this.Name  = Name;
        this.Book = Book;
        this.Date = Date;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setBook(String Book){
        this.Book = Book;
    }
    public void setDate(String Phone){
        this.Date = Date;
    }
    public String getName(){
        return this.Name;
    }
    public String getBook(){
        return this.Book;
    }
    public String getDate(){
        return this.Date;
    }
}
