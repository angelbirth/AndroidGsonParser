package com.shifair.androidgsonparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private RecyclerViewAdapter adapter;

    String URL_bef = "https://api.stackexchange.com/2.2/search";
    String doneSearch;
    String noWhiteSpace;
    String URL_aft;
//    String URL_aft = URL_bef + "?order=desc&sort=activity&intitle=" + noWhiteSpace + "&filter=default&site=stackoverflow&run=true";

    EditText et_search;
    Button bt_search;
    TextView bro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);




        requestJsonObject();
    }

    private void requestJsonObject(){

        bt_search = (Button) findViewById(R.id.bt_search);
        et_search = (EditText) findViewById(R.id.et_search);
//        bro = (TextView) findViewById(R.id.bro);

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doneSearch = et_search.getText().toString();
                noWhiteSpace = doneSearch.replaceAll(" ", "%20");
                URL_aft = URL_bef + "?order=desc&sort=activity&intitle=" + noWhiteSpace + "&filter=default&site=stackoverflow&run=true";

            }
        });

        final RequestQueue queue = Volley.newRequestQueue(this);
//        String url ="http://toscanyacademy.com/blog/mp.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_aft, new Response.Listener<String>() {
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
