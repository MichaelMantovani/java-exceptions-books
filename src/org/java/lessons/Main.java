package org.java.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * Book book = new Book("Titolo", 400, "Autore", "Editore");
		 * System.out.println(book);
		 */

		Scanner in = new Scanner(System.in);
		System.out.println("Quanti libri vuoi aggiungere?");
		int totalBooks = Integer.parseInt(in.nextLine());

		int booksIndex = 0;
		Book[] books = new Book[totalBooks];

		while (booksIndex < totalBooks) {
			System.out.println("Libro " + (booksIndex + 1));

			System.out.println("Qual è il titolo ?");
			String titolo = in.nextLine();

			System.out.println("Quante pagine ha in totale ?");
			int totalPages = Integer.parseInt(in.nextLine());

			System.out.println("Chi è l'autore ?");
			String author = in.nextLine();

			System.out.println("Chi è l'editore ?");
			String editor = in.nextLine();

			try {

				books[booksIndex] = new Book(titolo, totalPages, author, editor);

				booksIndex++;

			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}

		}

		in.close();

		final File myFile = new File ("myBooks.txt");
		FileWriter myBooks = null;
		try {
			myBooks = new FileWriter(myFile);
			
			for (int x = 0; x < totalBooks; x++) {
				Book book = books[x];
				myBooks.write(book.toString());
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println("Errore: " + e.getMessage());
		} finally {
			if(myBooks != null)
				try {
					myBooks.close();
				} catch (IOException e) {
					System.err.println("Errore: " + e.getMessage());
				}
		}
		
		Scanner reader = null;
	
		try {
			reader = new Scanner(myFile);
			
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (reader != null) 
				reader.close();
		}
		
		

	}
}
