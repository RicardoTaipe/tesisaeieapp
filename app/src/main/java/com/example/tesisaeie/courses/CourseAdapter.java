package com.example.tesisaeie.courses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tesisaeie.R;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder> {
    private List<Course> courses;
    private Context context;

    public CourseAdapter(List<Course> courses, Context context) {
        this.courses = courses;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.course_item, viewGroup,false);
        return new CourseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder courseHolder, int i) {
        courseHolder.name.setText(courses.get(i).getName());
        courseHolder.date.setText(courses.get(i).getFormatedDate());
        courseHolder.semester.setText(courses.get(i).getSemester().getName());
        courseHolder.price.setText("$"+courses.get(i).getPrice().toString());
        courseHolder.places.setText("Cupos: "+courses.get(i).getPlaces().toString());
    }

    @Override
    public int getItemCount() {
        if(courses.size() != 0){
            return courses.size();
        }
        return 0;
    }

    public class CourseHolder extends RecyclerView.ViewHolder {
        TextView name,description, price, places, semester, date;
        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            price= itemView.findViewById(R.id.price);
            description=itemView.findViewById(R.id.description);
            places = itemView.findViewById(R.id.places);
            semester= itemView.findViewById(R.id.semester);
            date = itemView.findViewById(R.id.date);
        }
    }
}
