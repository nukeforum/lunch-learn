package com.rook.lunchandlearn.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        addTopicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_new_topic);
                final EditText nameField = ((EditText)dialog.findViewById(R.id.name_input));
                dialog.findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.addTopic(
                                new Topic(
                                        nameField.getText().toString()
                                ));

                        Snackbar.make(findViewById(R.id.main_root), "Added topic " + nameField.getText().toString(), Snackbar.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                });
                dialog.findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.create();
                dialog.show();
            }
        });
    }

    @Override
    public void showTopics(ArrayList<Topic> topics) {
        topicList.setAdapter(new TopicAdapter(topics));
    }
}
