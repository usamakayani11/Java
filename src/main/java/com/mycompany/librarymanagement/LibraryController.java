package com.mycompany.librarymanagement;

import javax.swing.JOptionPane;

public class LibraryController {
    private DbHandler data;
    private int mCurrentIndex;
    
    public void addbook(String bName, int bId, int bCopies, String bGenre){
//        data.addbook(new Book(bName, bId, bCopies, bGenre));
            JOptionPane.showMessageDialog(null, bName + bId);
    }
    public void addUser(String uName, String userID, String uPass, String confirmPass, String gender){
//        data.addUser(new User(uName, userID, uPass, confirmPass, gender));
    }
    public void updateBook(String bookId, String newName, int newCopy){
//        data.updateBook(new book(bookId, newName, newCopy));       
    }
    public void issueBook(String StuName, String StuId, int returnDate, String bookId){
//        data.issueBook(new book(bookId, newName, newCopy));       
    }
    public void returnBook(String bookId, int issuedate, int returnDate){
//        data.returnBook(new book(bookId, newName, newCopy));       
    }
}
