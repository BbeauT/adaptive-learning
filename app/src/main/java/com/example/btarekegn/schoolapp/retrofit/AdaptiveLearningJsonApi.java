package com.example.btarekegn.schoolapp.retrofit;

import com.example.btarekegn.schoolapp.entity.Course;
import com.example.btarekegn.schoolapp.entity.Quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AdaptiveLearningJsonApi {

    @GET("courses/read.php")
    Call<List<Course>> getCourses();

    @GET("quizzes/read.php")
    Call<List<Quiz>> getQuizzes();
}
