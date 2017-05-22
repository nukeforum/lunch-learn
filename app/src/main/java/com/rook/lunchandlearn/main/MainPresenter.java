package com.rook.lunchandlearn.main;

import com.rook.lunchandlearn.Presenter;
import com.rook.lunchandlearn.entities.Topic;

import java.util.ArrayList;

/**
 * Created by Rook on 5/21/2017.
 */

public class MainPresenter extends Presenter<IMain> {
    ArrayList<Topic> topics = new ArrayList<>();

    @Override
    protected void onBind() {
        topics.add(new Topic("One"));
        topics.add(new Topic("Two"));
        topics.add(new Topic("Three"));

        displayTopics();
    }

    @Override
    protected void onUnbind() {
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    private void displayTopics() {
        view().showTopics(topics);
    }
}
