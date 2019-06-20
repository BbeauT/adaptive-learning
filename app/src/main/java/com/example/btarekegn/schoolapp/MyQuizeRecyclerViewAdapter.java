package com.example.btarekegn.schoolapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.btarekegn.schoolapp.QuizeFragment.OnListFragmentInteractionListener;
import com.example.btarekegn.schoolapp.dummy.DummyContent.DummyItem;
import com.example.btarekegn.schoolapp.entity.Quiz;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyQuizeRecyclerViewAdapter extends RecyclerView.Adapter<MyQuizeRecyclerViewAdapter.ViewHolder> {

    private final List<Quiz> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyQuizeRecyclerViewAdapter(List<Quiz> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_quize, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getQuizName());
        holder.mCourse.setText(mValues.get(position).getQuizName());
        holder.mDate.setText(mValues.get(position).getDate());

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
        public final TextView mIdView;
        public final TextView mCourse;
        public final TextView mDate;
        public Quiz mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.quiz_id);
            mCourse = (TextView) view.findViewById(R.id.quiz_course_name_id);
            mDate = (TextView) view.findViewById(R.id.quiz_date_id);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mCourse.getText() + "'";
        }
    }
}
