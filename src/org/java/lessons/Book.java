package org.java.lessons;

public class Book {
	private String title;
	private int totalPages;
	private String author;
	private String editor;

	public Book(String title, int totalPages, String author, String editor) throws Exception {
		setTitle(title);
		setTotalPages(totalPages);
		setAuthor(author);
		setEditor(editor);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) throws Exception {
		if(totalPages <= 0) 
			throw new Exception("Total pages must be more than zero.");
		this.totalPages = totalPages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Override
	public String toString() {

		return "Titolo: " + getTitle() + "\n" + "Numero di pagine totali: " + getTotalPages() + "\n" + "Autore: "
				+ getAuthor() + "\n" + "Editore: " + getEditor();
	}

}
