package com.rook.lunchandlearn.entities;

/**
 * Created by Rook on 5/21/2017.
 */

public class Topic {
    private String name;
    private boolean completed;

    public Topic(String name, boolean completed) {
        this.name = name;
        this.completed = completed;
    }

    public Topic(String name) {
        this(name, false);
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return name + " " + String.valueOf(completed);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (!(obj instanceof Topic)) { return false; }

        Topic it = (Topic) obj;

        return it.name.equals(this.name) &&
                it.completed == this.completed;
    }


    @Override
    public int hashCode() {
        int result = 0;
        result += name.hashCode();
        if (completed) {
            result += 10;
        } else {
            result += 11;
        }
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Topic(name, completed);
    }
}
