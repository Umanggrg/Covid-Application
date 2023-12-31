package com.example.covidapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.covidapp.api.ApiClient;
import com.example.covidapp.api.ApiInterface;
import com.example.covidapp.models.Article;
import com.example.covidapp.models.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Worldnews extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    public static final String API_KEY = "199ce9156769464693e1c42839721895";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles =  new ArrayList<>();
    private Adapter adapter;
    private String TAG =  Worldnews.class.getSimpleName();
    private TextView topHeadLine;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rlog);

        swipeRefreshLayout=findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);


        recyclerView=findViewById(R.id.recyclerView);
        topHeadLine=findViewById(R.id.topHeadLine);
        layoutManager = new LinearLayoutManager(Worldnews.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

       onLoadingSwipeRefresh("");
    }
    public void LoadJson(final String keyword){

        topHeadLine.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(true);

        ApiInterface apiInterface = ApiClient.getAppClient().create(ApiInterface.class);

        String country = Utils.getCountry();
        String language = Utils.getLanguage();

        Call<News> call;
        if (keyword.length()>0){
            call = apiInterface.getNewsSearch(keyword,language,"publishedAt",API_KEY);
        }else {
            call  = apiInterface.getNews(country,API_KEY);
        }


        call.enqueue(new Callback<News>() {
        @Override
        public void onResponse(Call<News> call, Response<News> respone) {
            if (respone.isSuccessful() && respone.body().getArticle() != null) {

                if (!articles.isEmpty()){
                    articles.clear();
                }

                articles = respone.body().getArticle();
                adapter = new Adapter(articles, Worldnews.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                initListener();

                topHeadLine.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setRefreshing(false);


            } else {
                topHeadLine.setVisibility(View.INVISIBLE);

                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(Worldnews.this,"No Result", Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onFailure (Call<News> call,Throwable t){
            topHeadLine.setVisibility(View.INVISIBLE);
            swipeRefreshLayout.setRefreshing(false);
        }

    });

}
      private void initListener(){
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(Worldnews.this, NewsDetailActivity.class);

                Article  article =articles.get(position);
                intent.putExtra("url",article.getUrl());
                intent.putExtra("title",article.getTitle());
                intent.putExtra("img",article.getUrlToImage());
                intent.putExtra("date",article.getPublishedAt());
                intent.putExtra("source",article.getSource().getName());
                intent.putExtra("author",article.getAuthor());

                startActivity(intent);
            }
        });

      }


@Override
    public boolean onCreateOptionsMenu(Menu menu){
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main,menu);
    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    final SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
    MenuItem searchMenuItem = menu.findItem(R.id.action_search);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    searchView.setQueryHint("Search Latest News...");
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            if (query.length()>2){
                onLoadingSwipeRefresh(query);
            }
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            return false;
        }
    });

    searchMenuItem.getIcon().setVisible(false,false);

        return true;
}

    @Override
    public void onRefresh() {
        LoadJson("");
    }

    private void onLoadingSwipeRefresh(final String keyword){
        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        LoadJson(keyword);
                    }
                }

        );
    }
}
