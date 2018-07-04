package com.shifair.androidgsonparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonStreamParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    final String BASE_URL = "https://api.stackexchange.com/2.2/search";
    //    String doneSearch;
//    String noWhiteSpace;
    EditText et_search;
    Button bt_search;
    TextView bro;
    String urlString;
    //    String urlString = BASE_URL + "?order=desc&sort=activity&intitle=" + noWhiteSpace + "&filter=default&site=stackoverflow&run=true";
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_search = findViewById(R.id.bt_search);
        et_search = findViewById(R.id.et_search);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String search = et_search.getText().toString();
//                noWhiteSpace = doneSearch.replaceAll(" ", "%20");
                 urlString = BASE_URL + "?order=desc&sort=activity&filter=default&site=stackoverflow&run=true";
                OkHttpClient client = new OkHttpClient();
                HttpUrl temp = HttpUrl.parse(urlString);
                okhttp3.HttpUrl url = temp.newBuilder()
                        .addQueryParameter("intitle", search)
                        .build();
                okhttp3.Request req = new okhttp3.Request.Builder()
                        .get()
                        .url(url)
                        .build();
                client.newCall(req).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, okhttp3.Response response) throws IOException {
                        if (!response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        ResponseBody body = response.body();
                        Reader reader = body.charStream();
                        Gson gson = new Gson();
                        Map<String,?> o = gson.fromJson(reader, new TypeToken<Map<String, ?>>() {
                        }.getType());

                        Log.i(TAG, "onResponse: ");
                    }
                });
            }
        });
//        requestJsonObject();
    }

    private void requestJsonObject() {

//        bro = (TextView) findViewById(R.id.bro);


        final RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="http://toscanyacademy.com/blog/mp.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlString, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response " + response);
                GsonBuilder builder = new GsonBuilder();
                Gson mGson = builder.create();

                List<ItemObject> posts = new ArrayList<ItemObject>();
                posts = Arrays.asList(mGson.fromJson(response, ItemObject[].class));

                adapter = new RecyclerViewAdapter(MainActivity.this, posts);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);

    }
}
