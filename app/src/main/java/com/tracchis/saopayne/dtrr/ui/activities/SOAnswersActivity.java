package com.tracchis.saopayne.dtrr.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.tracchis.saopayne.dtrr.R;
import com.tracchis.saopayne.dtrr.data.adapter.AnswersAdapter;
import com.tracchis.saopayne.dtrr.data.model.Item;
import com.tracchis.saopayne.dtrr.data.model.SOAnswersResponse;
import com.tracchis.saopayne.dtrr.data.remote.service.SOService;
import com.tracchis.saopayne.dtrr.data.remote.utils.ApiUtils;
import com.tracchis.saopayne.dtrr.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SOAnswersActivity extends BaseActivity {

    private AnswersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_soanswers);
        mService = ApiUtils.getSOService();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_answers);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(SOAnswersActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
//        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<List<SOAnswersResponse>>() {

            @Override
            public void onResponse(Response<List<SOAnswersResponse>> response) {
                if (response.isSuccess()) {
                    mAdapter.updateAnswers(response.body().get(0).getItems());
                    Log.d("MainActivity", "posts loaded from API");
                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("error", t.toString());
                Log.d("SOAnswersActivity", "error loading from API");
            }

        });
    }

}
