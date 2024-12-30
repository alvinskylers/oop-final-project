package org.project.abstracts;

import java.util.ArrayList;
import java.util.List;

public abstract class Quiz {
    protected String title;
    protected String description;
    protected List<Question> questions;
    protected int score;

    public Quiz(String title, String description) {
        this.title = title;
        this.description = description;
        this.questions = new ArrayList<Question>();
    }


}
