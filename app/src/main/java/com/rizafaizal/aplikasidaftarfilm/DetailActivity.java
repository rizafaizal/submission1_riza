package com.rizafaizal.aplikasidaftarfilm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private TextView txtJudul, txtGenre, txtScore, txtDesc;
    private ImageView imgPhoto;

    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtJudul = findViewById(R.id.txt_judul_detail);
        txtGenre = findViewById(R.id.txt_genre_detail);
        txtScore = findViewById(R.id.txt_score_detail);
        txtDesc = findViewById(R.id.txt_isiDesc_detail);
        imgPhoto = findViewById(R.id.img_photo_detail);

        Films film = getIntent().getParcelableExtra(EXTRA_FILM);
        txtJudul.setText(film.getJudul());
        txtGenre.setText(getString(R.string.genre_template, film.getGenre()));
        txtScore.setText(getString(R.string.score_template, film.getScore()));
        txtDesc.setText(film.getDesc());
        imgPhoto.setImageResource(film.getPhoto());

        //Nama Bar
        ActionBar ab = getSupportActionBar();
        ab.setTitle(getString(R.string.name_bar_detail));
        ab.setSubtitle(film.getJudul());

    }
}
