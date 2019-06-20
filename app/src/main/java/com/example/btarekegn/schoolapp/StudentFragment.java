package com.example.btarekegn.schoolapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.btarekegn.schoolapp.dummy.DummyContent;
import com.example.btarekegn.schoolapp.dummy.DummyContent.DummyItem;
import com.example.btarekegn.schoolapp.entity.User;
import com.example.btarekegn.schoolapp.repository.SchoolAppContract;
import com.example.btarekegn.schoolapp.repository.SchoolAppDbHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class StudentFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    private List<User> users = new ArrayList<>();

    SchoolAppDbHelper dbHelper;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StudentFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static StudentFragment newInstance(int columnCount) {
        StudentFragment fragment = new StudentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        dbHelper = new SchoolAppDbHelper(getActivity());
//
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        if (getArguments() != null) {
//            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
//        }
//
//        String[] projection = {
//                BaseColumns._ID,
//                SchoolAppContract.UserEntry.COLUMN_FULL_NAME,
//                SchoolAppContract.UserEntry.COLUMN_GENDER
//        };
//        String selection = SchoolAppContract.UserEntry.COLUMN_ROLE + " = ?";
//        String[] selectionArgs = { "Student" };
//        String sortOrder =
//                SchoolAppContract.UserEntry.COLUMN_FULL_NAME + " ASC";
//
//        Cursor cursor = db.query(
//                SchoolAppContract.UserEntry.TABLE_NAME,   // The table to query
//                null,             // The array of columns to return (pass null to get all)
//                selection,              // The columns for the WHERE clause
//                selectionArgs,          // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                sortOrder               // The sort order
//        );
//
//
//        while(cursor.moveToNext()) {
//
//            users.add(new User(
//                    cursor.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID)),
//                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolAppContract.UserEntry.COLUMN_FULL_NAME)),
//                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolAppContract.UserEntry.COLUMN_EMAIL)),
//                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolAppContract.UserEntry.COLUMN_ROLE)),
//                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolAppContract.UserEntry.COLUMN_PASSWORD)),
//                    cursor.getString(cursor.getColumnIndexOrThrow(SchoolAppContract.UserEntry.COLUMN_GENDER))
//
//            ));
//            long itemId = cursor.getLong(
//                    cursor.getColumnIndexOrThrow(BaseColumns._ID));
//
//        }
//        cursor.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyStudentRecyclerViewAdapter(users, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(User item);
    }
}
