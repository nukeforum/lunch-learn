package com.rook.lunchandlearn.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.rook.lunchandlearn.R;
import com.rook.lunchandlearn.entities.Topic;

import java.util.ArrayList;

/**
 * Created by Rook on 5/21/2017.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder> {
    private ArrayList<Topic> topics;

    public TopicAdapter(ArrayList<Topic> topics) {
        this.topics = topics;
    }

    private void toggleTopicCompleted(Topic topic) {
        notifyItemChanged(topics.indexOf(topic));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(parent.getContext(), R.layout.list_item_topic, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(topics.get(position));
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }

        void bind(final Topic topic) {
            ((TextView) itemView.findViewById(R.id.topic_name)).setText(topic.getName());
            ((CheckBox) itemView.findViewById(R.id.completed)).setChecked(topic.isCompleted());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleTopicCompleted(topic);
                }
            });
        }
    }
}
