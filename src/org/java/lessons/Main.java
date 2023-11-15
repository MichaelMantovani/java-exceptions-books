package org.java.lessons;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Book book = new Book("Titolo", 400, "Autore", "Editore");
		System.out.println(book);

		Scanner in = new Scanner(System.in);
		System.out.println("Quanti libri vuoi aggiungere?");
		int totalBooks = in.nextInt();

		int booksIndex = 0;
		Book[] books = new Book[totalBooks];

		while (booksIndex < totalBooks) {

			System.out.println("Libro " + (booksIndex + 1));

			System.out.println("Qual è il titolo ?");
			String titolo = in.next();

			System.out.println("Quante pagine ha in totale ?");
			int totalPages = in.nextInt();

			System.out.println("Chi è l'autore ?");
			String author = in.next();

			System.out.println("Chi è l'editore ?");
			String editor = in.next();

			books[booksIndex] = new Book(titolo, totalPages, author, editor);

			booksIndex++;
		}
		
		System.out.println(Arrays.asList(books));

	}
}
