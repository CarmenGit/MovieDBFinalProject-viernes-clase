package es.cice.moviedbfinalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import es.cice.moviedbfinalproject.model.CreditsLists;
import es.cice.moviedbfinalproject.model.MovieTitleAndImage;

import static es.cice.moviedbfinalproject.MainActivity.API_KEY;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String IMAGEN_EXTRA = "image";
    public static final String TITULO_EXTRA = "titulo";
    public static final String CREDITOS_EXTRA = "creditos";
    public static final String VALORACIONES_EXTRA = "valoraciones";
    public static final String OVERVIEW_EXTRA = "overview";
    public static final String ID_MOVIE_EXTRA = "idmovie";
    private static final String URL_CREDITS_MOVIE="https://api.themoviedb.org/3/movie/";
    private TextView movieCredits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        //el segundo parámetro de geinextra es en caso de que no exista el extra
        String image =intent.getStringExtra(IMAGEN_EXTRA);
        //int imageResource =intent.getIntExtra(IMAGEN_EXTRA, 0);
        String titulo = intent.getStringExtra(TITULO_EXTRA);
        String creditos = intent.getStringExtra(CREDITOS_EXTRA);
        String valoraciones = intent.getStringExtra(VALORACIONES_EXTRA);
        String overview = intent.getStringExtra(OVERVIEW_EXTRA);


        TheMovieDBCreditsAsynTask at = new TheMovieDBCreditsAsynTask();
        at.execute(URL_CREDITS_MOVIE+ intent.getStringExtra(ID_MOVIE_EXTRA)+ "/credits?api_key=" + API_KEY);

        ImageView movieImage = (ImageView) findViewById(R.id.movieImage);
        TextView movieTitulo = (TextView) findViewById((R.id.movieTitulo));
        movieCredits = (TextView) findViewById((R.id.movieCredits));
        TextView movieOverview = (TextView) findViewById((R.id.movieOverview));

        //if (imageResource != 0)
        //    movieImage.setImageResource(imageResource);
        Picasso
                .with(this)
                .load(Uri.parse(image))
                //.resize(500, 500)
                //.centerInside()
                .into(movieImage);

        movieTitulo.setText(titulo);
        movieCredits.setText(creditos);

        movieOverview.setText(overview);
    }

    public class TheMovieDBCreditsAsynTask  extends AsyncTask<String, Void, CreditsLists> {





        @Override
        protected CreditsLists doInBackground(String... urls) {
            BufferedReader in = null;

            List<MovieTitleAndImage> movieList = new ArrayList<>();

            //Retrofit evita tener que gestionar la conexion http
            //Retrofit no está disponible en android, hay que añadirla
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer data = new StringBuffer();
                //Insertar los datos obtenidos con in en el StringBuffer
                String line = null;
                while ((line = in.readLine()) != null) {
                    data.append(line);
                }
                Gson gson = new Gson();
                String json = data.toString();
                CreditsLists cl = gson.fromJson(json, CreditsLists.class);
                return cl;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;

        }

        @Override
        protected void onPostExecute(CreditsLists creditsLists) {
            super.onPostExecute(creditsLists);
            movieCredits.setText(creditsLists.getCast().get(0).getCharacter());
        }
    }

    }

