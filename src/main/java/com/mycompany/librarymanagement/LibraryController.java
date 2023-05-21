package com.mycompany.librarymanagement;

import javax.swing.JOptionPane;

/**
 *bx
 * @author 5hayzi
 */
public class LibraryController {
//    private DbHandler data;
    private int mCurrentIndex;
    
    public void addbook(String bName, int bId, int bCopies, String bGenre){
//        data.addbook(new Book(bName, bId, bCopies, bGenre));
            JOptionPane.showMessageDialog(null, bName + bId);
    }
    public void addUser(String uName, String userID, String uPass, String confirmPass, String gender){
//        data.addbook(new User(uName, userID, uPass, confirmPass, gender));
    }
    public void updateBook(String bookId, String newName, String newCopy){
//        data.addbook(new book(bookId, newName, newCopy));       
    }
}
