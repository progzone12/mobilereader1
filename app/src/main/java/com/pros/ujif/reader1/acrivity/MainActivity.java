package com.pros.ujif.reader1.acrivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pros.ujif.reader1.R;
import com.pros.ujif.reader1.adapters.BookListAdapter;
import com.pros.ujif.reader1.data.pojo.BookItem;

import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.pros.ujif.reader1.MESSAGE";
    private RecyclerView booksRecyclerView;
    private BookListAdapter bookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();

        bookListAdapter = new BookListAdapter();
        booksRecyclerView.setAdapter(bookListAdapter);

        loadBooks();
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActiviry.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        if (!message.isEmpty()) {
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Fill the field", Toast.LENGTH_SHORT).show();
        }
    }


    private void loadBooks() {
        Collection<BookItem> books = getBooks();
        bookListAdapter.setItems(books);
    }

    private Collection<BookItem> getBooks() {
        return Arrays.asList(
                new BookItem(
                        "Идиот",
                        "Достоевский Ф.М."),
                new BookItem(
                        "Война и мир",
                        "Толстой Л.Н."),
                new BookItem(
                        "На дне",
                        "Горький Максим"),
                new BookItem(
                        "Вий",
                        "Гоголь Н.В.")
        );
    }

    private void initRecyclerView() {
        booksRecyclerView = (RecyclerView) findViewById(R.id.books_recycler_view);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
