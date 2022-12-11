/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

/**
 *
 * @author Zahra Maryam
 */
public class IssueBook {
    private String Name,Book,Date,ReturnDate;
    public IssueBook(String Name, String Book, String Date, String ReturnDate){
        this.Name  = Name;
        this.Book = Book;
        this.Date = Date;
        this.ReturnDate = ReturnDate;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setAuthor(String Book){
        this.Book = Book;
    }
    public void setCategory(String Date){
        this.Date = Date;
    }
    public void setEdition(String ReturnDate){
        this.ReturnDate = ReturnDate;
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
    public String getReturnDate(){
        return this.ReturnDate;
    }
}
