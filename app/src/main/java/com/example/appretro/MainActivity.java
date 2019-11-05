package com.example.appretro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appretro.interfaces.JsonPlaceHolderApi;
import com.example.appretro.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView myJsonTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myJsonTextview = (TextView) findViewById(R.id.json_text);
        getPosts();
    }

    private void getPosts(){
        //objeto de retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    myJsonTextview.setText("COdigo:"+ response.code());
                    return;
                }

                List<Post> postList = response.body();
                for(Post post: postList){


                    String contenido = "";
                    contenido += "userId: " + post.getUserId() +"\n";
                    contenido += "id: " + post.getId() +"\n";
                    contenido += "title: " + post.getTitle() +"\n";
                    contenido += "body: " + post.getBody() +"\n\n";


                    myJsonTextview.append(contenido);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                myJsonTextview.setText(t.getMessage());
            }
        });
    }
}
