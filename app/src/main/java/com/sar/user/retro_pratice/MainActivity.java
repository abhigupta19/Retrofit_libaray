package com.sar.user.retro_pratice;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.text);
        Myweb myweb=Myweb.retrofit.create(Myweb.class);
        Call<List<Model>> call=myweb.getModel();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(response.isSuccessful())
                {
                    for (Model model:response.body())
                    {
                        showmodel(model);
                    }
                }
            }

            private void showmodel(Model model) {
                textView.append(model.getTitle());
                textView.append(model.getBody());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {

            }
        });

    }
}
