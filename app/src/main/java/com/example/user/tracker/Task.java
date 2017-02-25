package com.example.user.tracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Task extends AppCompatActivity {

    List<ForumModel> forumModelList=new ArrayList<>();
    private RecyclerView recyclerView;
    private ForumAdapter mAdapter;
    ForumModel model;
    Button button,complain;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        button=(Button)findViewById(R.id.complain);

        mAdapter = new ForumAdapter(forumModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        getData();


        /*if(getIntent()!=null){
            model= (ForumModel) getIntent().getSerializableExtra("rumi");
            Log.e("TAG", "onCreate: "+model.getName() );
            forumModelList.add(model);
            mAdapter.notifyDataSetChanged();
        }*/




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Task.this,FormActivity.class);

                startActivityForResult(intent,5);
            }
        });



    }






    public void getData(){
        model=new ForumModel();
        model.setName("Rumi");
        model.setSubject("Complain about Balkumari Road");
        model.setEmail("rumirajbhandari");
        model.setBody("It has been almost 3 years since the beginning of the construciton of balkumari road. The construction company has not delaying the construction due to various reason. So I want to attract the authorized person for this.");
        forumModelList.add(model);

        model=new ForumModel();
        model.setName("Sushma");
        model.setSubject("Sinamangal Road construction delay.");
        model.setEmail("abc");
        model.setBody("The construction delay of sinamangal road is causing lots of traffic in Sinamangal.");
        forumModelList.add(model);

        model=new ForumModel();
        model.setName("Anjana");
        model.setSubject("Lots of pollution");
        model.setEmail("abc");
        model.setBody("Because of delaying of constuction of khanepani my family is suffering of respiratory disease. Not only my family but lots of local is suffering form respiratory disease as well. So I want to grab the attention of concerned authority.");
        forumModelList.add(model);

        model=new ForumModel();
        model.setName("Priyanka");
        model.setSubject("Difficulty in car parking.");
        model.setEmail("xyz");
        model.setBody("Due to prolonged construction of road, we local community of koteshwor are facing problem during car parking");
        forumModelList.add(model);



    }


}
