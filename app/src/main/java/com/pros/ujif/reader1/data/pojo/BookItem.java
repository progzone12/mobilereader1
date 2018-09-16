package com.pros.ujif.reader1.data.pojo;

public class BookItem {
    private String bookName;
    private String authorName;

    public BookItem(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookItem book = (BookItem) o;

        if (!bookName.equals(book.bookName)) return false;
        return authorName != null ? authorName.equals(book.authorName) : book.authorName == null;
    }

    @Override
    public int hashCode() {
        int result = bookName.hashCode();
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        return result;
    }
}
