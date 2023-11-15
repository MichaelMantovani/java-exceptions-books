package org.java.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * Book book = new Book("Titolo", 400, "Autore", "Editore");
		 * System.out.println(book);
		 */

//		Chiedo quanti libri vuole aggiungerer all'utente
		Scanner in = new Scanner(System.in);
		System.out.println("Quanti libri vuoi aggiungere?");
		int totalBooks = Integer.parseInt(in.nextLine());

//		Dichiaro un indece e inizializzo l'array di tutti i libri
		int booksIndex = 0;
		Book[] books = new Book[totalBooks];

//		Creo libri finchè l'array non è pieno
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

//			Prima di creare delle istanze di Book controllo che i dati inseriti siano coerenti
			try {

				books[booksIndex] = new Book(titolo, totalPages, author, editor);

				booksIndex++;

			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}

		}

		in.close();

//		Creo un file di testo
		final File myFile = new File("myBooks.txt");
		FileWriter myBooks = null;

//		Scrivo al suo intero l'intero catalogo controllando eventuali errori
		try {
			myBooks = new FileWriter(myFile);

			for (int x = 0; x < totalBooks; x++) {
				Book book = books[x];
				myBooks.write(book.toString());
			}
		} catch (IOException e) {
			System.err.println("Errore: " + e.getMessage());
		} finally {
			if (myBooks != null)
				try {
					myBooks.close();
				} catch (IOException e) {
					System.err.println("Errore: " + e.getMessage());
				}
		}

//		Leggo il contenuto del file e lo stampo
		Scanner reader = null;

		try {
			reader = new Scanner(myFile);

			while (reader.hasNextLine()) {
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
