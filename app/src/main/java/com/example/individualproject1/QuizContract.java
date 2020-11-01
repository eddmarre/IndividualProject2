package com.example.individualproject1;

import android.provider.BaseColumns;

public final class QuizContract {
    //make sure the class isn't used as an object
    private QuizContract(){ }
    //create table for sqlite saving
    public static class QuestionsTable implements BaseColumns {
        public static final String TABLE_NAME="quiz_questions";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWER_NR="answer_nr";
    }
}
