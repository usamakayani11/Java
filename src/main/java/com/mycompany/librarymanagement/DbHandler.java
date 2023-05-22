
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

package com.mycompany.librarymanagement;




public class DbHandler {
   private Connection conn;
    private Statement statement;

    public DbHandlernagementSystem() {
        String url = "jdbc:mysql://localhost/mydatabase";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "1234";

        try {
           
            Class.forName(driver);

           
            conn = DriverManager.getConnection(url, userName, password);

           
            statement = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addBook(String bookTitle, String author) {
        String addBookQuery = "INSERT INTO books (title, author) VALUES ('" + bookTitle + "', '" + author + "')";

        try {
            statement.executeUpdate(addBookQuery);
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String userName, String email) {
        String addUserQuery = "INSERT INTO users (name, email) VALUES ('" + userName + "', '" + email + "')";

        try {
            statement.executeUpdate(addUserQuery);
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showUsers() {
        String showUsersQuery = "SELECT * FROM users";

        try {
            ResultSet resultSet = statement.executeQuery(showUsersQuery);
            System.out.println("Users:");

            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("User ID: " + userId + ", Name: " + userName + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showBooks() {
        String showBooksQuery = "SELECT * FROM books";

        try {
            ResultSet resultSet = statement.executeQuery(showBooksQuery);
            System.out.println("Books:");

            while (resultSet.next()) {
                int bookId = resultSet.getInt("id");
                String bookTitle = resultSet.getString("title");
                String author = resultSet.getString("author");

                System.out.println("Book ID: " + bookId + ", Title: " + bookTitle + ", Author: " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(int bookId, String newTitle, String newAuthor) {
        String updateBookQuery = "UPDATE books SET title = '" + newTitle + "', author = '" + newAuthor + "' WHERE id = " + bookId;

        try {
            int rowsAffected = statement.executeUpdate(updateBookQuery);
            if (rowsAffected > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Book with ID " + bookId + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void issueBook(int bookId, int userId) {
        String issueBookQuery = "INSERT INTO issued_books (book_id, user_id) VALUES (" + bookId + ", " + userId + ")";

        try {
            statement.executeUpdate(issueBookQuery);
            System.out.println("Book issued successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void returnBook(int bookId, int userId) {
        String returnBookQuery = "DELETE FROM issued_books WHERE book_id = " + bookId + " AND user_id = " + userId;

        try {
            int rowsAffected = statement.executeUpdate(returnBookQuery);
            if (rowsAffected > 0) {
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book with ID " + bookId + " not issued to User ID " + userId + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showIssuedBooks() {
        String showIssuedBooksQuery = "SELECT b.title, u.name FROM issued_books ib " +
                "INNER JOIN books b ON ib.book_id = b.id " +
                "INNER JOIN users u ON ib.user_id = u.id";

        try {
            ResultSet resultSet = statement.executeQuery(showIssuedBooksQuery);
            System.out.println("Issued Books:");

            while (resultSet.next()) {
                String bookTitle = resultSet.getString("title");
                String userName = resultSet.getString("name");

                System.out.println("Book Title: " + bookTitle + ", User Name: " + userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DbHandler.library = new DbHandler();

        library.addBook("Software Construction ", "Sir. Qaiser");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addUser("Ali", "Ali@example.com");

        library.showBooks();
        library.showUsers();

        library.issueBook(1, 1);
        library.returnBook(1, 1);

        library.showIssuedBooks();

        library.updateBook(2, "To Kill a Mockingbird", "Harper Lee (Updated)");

        library.showBooks();

        library.closeConnection();
    }
}


       

  