package com.shifair.androidgsonparser;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.shifair.androidgsonparser.model.SOResponse;


import java.io.IOException;
import java.io.Reader;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
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
        bt_search = (Button) findViewById(R.id.bt_search);
        et_search = (EditText) findViewById(R.id.et_search);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
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
                final okhttp3.Call call = client.newCall(req);

                final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                pd.setCancelable(true);
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        call.cancel();
                    }
                });
                pd.setIndeterminate(true);
                pd.show();
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(okhttp3.Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(okhttp3.Call call, Response response) throws IOException {
                        if (!response.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "" + response.code(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        ResponseBody body = response.body();
                        Reader reader = body.charStream();
                        Gson gson = new Gson();
                        final SOResponse resp = gson.fromJson(reader, SOResponse.class);
                        pd.dismiss();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                parseData(resp);
                            }
                        });
                        Log.i(TAG, "onResponse: ");
                    }

                });
            }
        });
//        requestJsonObject();
    }

    private void parseData(SOResponse response) {
        adapter = new RecyclerViewAdapter(this, response.getItems());
        recyclerView.setAdapter(adapter);
    }

}
