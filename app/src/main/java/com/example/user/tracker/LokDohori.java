package com.example.user.tracker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;

public class LokDohori extends AppCompatActivity {
    private ArrayList<ManpowerItem> entityArray = new ArrayList<>();
    RecyclerView rv;
    private Context mContext;

    private RecyclerView.LayoutManager mLayoutManager;
    CustomAdapter adapter;
    String url = "https://raw.githubusercontent.com/sushmagiri/json/master/d.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_of_work);
        rv = (RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(mContext);
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());

//        rv.setAdapter(adapter);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        Gson gson=new Gson();
                       ArrayList<ManpowerItem> manpowerItemList=gson.fromJson(response.toString(),new TypeToken<ArrayList<ManpowerItem>>(){}.getType());
              adapter=new CustomAdapter(manpowerItemList,LokDohori.this);
                     rv.setAdapter(adapter);


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Adding request to request queue
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
//        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS * 2, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
////        jsonArrayRequest.setRetryPolicy(new DefaultRetryPolicy(
////                30000,
////                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
////                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
//        Volley.newRequestQueue(this).add(jsonArrayRequest);

    }
}

