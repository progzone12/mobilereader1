package com.pros.ujif.reader1.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pros.ujif.reader1.R;
import com.pros.ujif.reader1.data.pojo.BookItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BooksViewHolder> {

    private String [] booksName = {"Книга 1","Книга 2","Книга 3","Книга 4","Книга 5"};
    private String [] booksAuthor = {"Автор 1","Автор 2","Автор 3","Автор 4","Автор 5"};

    private List<BookItem> bookList = new ArrayList<>();

    public void setItems(Collection<BookItem> books) {
        bookList.addAll(books);
        notifyDataSetChanged();
    }

    public void clearItems() {
        bookList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_book , parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.bind(bookList.get(position));

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder {
        // Ваш ViewHolder должен содержать переменные для всех
        // View-компонентов, которым вы хотите задавать какие-либо свойства
        // в процессе работы пользователя со списком
        private TextView bookNameTextView;
        private TextView authorNameTextView;

        // Мы также создали конструктор, который принимает на вход View-компонент строкИ
        // и ищет все дочерние компоненты
        public BooksViewHolder(View itemView) {
            super(itemView);
            bookNameTextView = itemView.findViewById(R.id.textView_bookname);
            authorNameTextView = itemView.findViewById(R.id.textView_authorname);
        }

        public void bind(BookItem bookItem) {
            bookNameTextView.setText(bookItem.getBookName());
            authorNameTextView.setText(bookItem.getAuthorName());
        }
    }


}
