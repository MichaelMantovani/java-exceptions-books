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

	public void setTitle(String title) throws Exception {
		if(title.isBlank() || title.length() < 3)
			throw new Exception( "There must be a title");
		this.title = title;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) throws Exception {
		if(totalPages <= 0 || totalPages < 25) 
			throw new Exception("Total pages must be more than zero.");
		this.totalPages = totalPages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) throws Exception {
		if(author.length() < 3 || author.isBlank() )
			throw new Exception( "There must be at least one author");
		this.author = author;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) throws Exception {
		if(editor.length() < 3 || editor.isBlank())
			throw new Exception( "There must be at least one editor");
		this.editor = editor;
	}

	@Override
	public String toString() {

		return "Titolo: " + getTitle() + "\n" + "Numero di pagine totali: " + getTotalPages() + "\n" + "Autore: "
				+ getAuthor() + "\n" + "Editore: " + getEditor();
	}

}
