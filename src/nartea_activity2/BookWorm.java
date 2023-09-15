/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nartea_activity2;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
class libro{
        String author;
        String title;
        String ISBN;
        libro next;
        
        public libro(String author,String title,String ISBN){
            this.author=author;
            this.title=title;
            this.ISBN=ISBN;
            this.next=null;
        }
    }
class libraryy{
    public libro head;
    
    public void addlibro(String author,String title,String ISBN){
        libro newlibro=new libro(author,title,ISBN);
        if(head==null){
            head=newlibro;
        }else{
            libro current=head;
            while(current.next !=null){
                current=current.next;
            }
            current.next=newlibro;
        }
    }
    public libro hanaplibro(String ISBN){
        libro current=head;
        while(current != null){
            if(current.ISBN.equals(ISBN)){
                return current;
            }
            current=current.next;
        }
        return null;
    }
    public void displaylibro(){
        libro current=head;
        while(current != null){
            System.out.println("Author " + current.author+ 
                    ", Title: " + current.title + ", ISBN: " + current.ISBN);
            current=current.next;
        }
    }
}
public class BookWorm {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        libraryy libraryy=new libraryy();
        
        libraryy.addlibro("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", "978-0-439-06486-3");
        libraryy.addlibro( "Suzanne Collins", "The Hunger Games", " 978-0-439-02348-1");
        libraryy.addlibro("James Dashner", "The Maze Runner", "978-0-385-73794-4");
        libraryy.addlibro("Eiichiro Oda", "One Piece Volume 1", "978-1-56931-901-3");
        
        while(true){
            System.out.println("");
        System.out.println("Add, Search,Display, or Quit?");
            System.out.print(":");
        String choose=s.nextLine();
        if(choose.equalsIgnoreCase("quit")){
            System.out.println("OK BYE!");
            break;
        }
        switch(choose){
            case "add" -> {
                while (true){
                    
                    System.out.println("type the author's name: ");
                    String Author=s.nextLine();
                    
                    System.out.println("");
                    System.out.println("name of the book: ");
                    String namebook=s.nextLine();
                    
                    System.out.println("");
                    System.out.println("the ISBN: ");
                    String Isbn=s.nextLine();
                    
                    libraryy.addlibro(Author, namebook, Isbn);
                    
                    System.out.println("re-add or no?: ");
                    System.out.println("");
                    
                    String condition=s.nextLine();
                    if(condition.equalsIgnoreCase("no")){
                        break;
                    }
                }       }
            case "search" -> {
                while(true){
                    
                    System.out.print("type the ISBN of the book: ");
                    String hanapinISBN=s.nextLine();
                    libro hanaplibro=libraryy.hanaplibro(hanapinISBN);
                    if(hanaplibro != null){
                        System.out.println("");
                        System.out.println("the book with ISBN of " + hanapinISBN +": ");
                        System.out.println("Author: " +hanaplibro.author+"title: " +hanaplibro.title +"ISBN: " +hanaplibro.ISBN );
                    }else{
                        System.out.println("the ISBN:" +hanapinISBN+ "is not found");
                    }break;
                }  }
            case "display" -> {
                System.out.println("library contents");
                libraryy.displaylibro();
                }
        }
            System.out.println("go back from the start? yer or no?: ");
            String G=s.nextLine();
            if(G.equalsIgnoreCase("no")){
                break;
            }
    }
    }
}
