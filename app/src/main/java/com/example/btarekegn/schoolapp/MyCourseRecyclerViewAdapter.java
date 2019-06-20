package com.example.btarekegn.schoolapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.btarekegn.schoolapp.CourseFragment.OnListFragmentInteractionListener;
import com.example.btarekegn.schoolapp.dummy.DummyContent.DummyItem;
import com.example.btarekegn.schoolapp.entity.Course;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCourseRecyclerViewAdapter extends RecyclerView.Adapter<MyCourseRecyclerViewAdapter.ViewHolder> {

    private final List<Course> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyCourseRecyclerViewAdapter(List<Course> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCourseCode.setText(mValues.get(position).getCode());
        holder.mCourseTitle.setText(mValues.get(position).getTitle());
        holder.mInstructor.setText(mValues.get(position).getInstructor());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mCourseCode;
        public final TextView mCourseTitle;
        public final TextView mInstructor;
        public Course mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mCourseCode = (TextView) view.findViewById(R.id.course_code_id);
            mCourseTitle = (TextView) view.findViewById(R.id.course_name_id);
            mInstructor = (TextView) view.findViewById(R.id.course_instructor_id);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mCourseTitle.getText() + " '" + mInstructor.getText() + " '" ;
        }
    }
}
