package com.example.individualproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.individualproject1.QuizContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    //set data base name and version
    private static final String DATABASE_NAME="Quiz.db";
    private  static final int DATABASE_VERSION=1;

    private SQLiteDatabase db;

    public QuizDbHelper(@Nullable Context context) {
        //create database by passing in name and version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    this.db=db;
//create the database
    final String SQL_CREATE_QUESTIONS_TABLE ="CREATE TABLE "+
            QuestionsTable.TABLE_NAME + " ( " +
            QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
            QuestionsTable.COLUMN_ANSWER_NR + " INTEGER" +
            ")";
    db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
    fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS "+QuestionsTable.TABLE_NAME);
    onCreate(db);
    }

    private  void fillQuestionsTable()
    {
        Question q1=new Question("What color are Bananas?","Red","Orange","Purple","Yellow",4);
        addQuestions(q1);
        Question q2=new Question("Who was the first president?","George Washington","Abraham Lincoln","Benjamin Franklin","Thomas Jefferson",1);
        addQuestions(q2);
        Question q3=new Question("Where is the Eiffel Tower?","Germany","France","USA","Canada",2);
        addQuestions(q3);
        Question q4=new Question("What shape best describes the Earth","Cube","Pyramid","Sphere","Rectangle",3);
        addQuestions(q4);
        Question q5=new Question("What year was Tesla founded","2011","1994","2018","2003",4);
        addQuestions(q5);
    }
    private void addQuestions(Question question)
    {
        ContentValues cv=new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1,question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2,question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3,question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4,question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR,question.getAnswerNr());
        db.insert(QuestionsTable.TABLE_NAME, null,cv);
    }

    public ArrayList<Question> getAllQuestions()
    {
        ArrayList<Question> questionList=new ArrayList<>();
        db=getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME,null);
        if(c.moveToFirst()) {
            do {
                Question question =new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                questionList.add(question);
            }while(c.moveToNext());
        }

        c.close();
        return questionList;
    }
}
