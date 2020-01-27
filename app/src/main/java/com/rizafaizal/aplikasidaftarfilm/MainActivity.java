package com.rizafaizal.aplikasidaftarfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private FilmsAdapter adapter;
    private String[] dataJudul;
    private String[] dataGenre;
    private String[] dataScore;
    private String[] dataDesc;
    private TypedArray dataPhoto;
    private ArrayList<Films> films;

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_film);

        adapter = new FilmsAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, films.get(i).getJudul(), Toast.LENGTH_SHORT).show();

                Films film = films.get(i);

                Intent moveToDetail = new Intent(MainActivity.this, DetailActivity.class);
                moveToDetail.putExtra(DetailActivity.EXTRA_FILM, film);
                startActivity(moveToDetail);

            }
        });

    }

    private void prepare() {
        dataJudul = getResources().getStringArray(R.array.data_judul_film);
        dataGenre = getResources().getStringArray(R.array.data_genre_film);
        dataScore = getResources().getStringArray(R.array.data_score_film);
        dataDesc = getResources().getStringArray(R.array.data_deskripsi_film);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo_film);
    }

    private void addItem() {
        films = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Films film = new Films();
            film.setPhoto(dataPhoto.getResourceId(i, -1));
            film.setJudul(dataJudul[i]);
            film.setGenre(dataGenre[i]);
            film.setScore(dataScore[i]);
            film.setDesc(dataDesc[i]);
            films.add(film);
        }

        adapter.setFilms(films);

    }

}
