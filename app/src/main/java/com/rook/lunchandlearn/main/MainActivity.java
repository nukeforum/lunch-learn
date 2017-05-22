package com.rook.lunchandlearn.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.rook.lunchandlearn.R;
import com.rook.lunchandlearn.entities.Topic;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMain {
    RecyclerView topicList;
    FloatingActionButton addTopicButton;

    MainPresenter presenter = new MainPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUi();

        presenter.takeView(this);
    }

    private void initializeUi() {
        topicList = (RecyclerView) findViewById(R.id.topics);
        addTopicButton = (FloatingActionButton) findViewById(R.id.add_topic);
    }

    @Override
    public void showTopics(ArrayList<Topic> topics) {
        topicList.setAdapter(new TopicAdapter(topics));
    }
}
