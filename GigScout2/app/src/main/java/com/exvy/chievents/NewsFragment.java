package com.exvy.chievents;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.exvy.chievents.Events;
import com.exvy.chievents.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private ListView myListView;

    private List<Events> myEventsList;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView =  inflater.inflate(R.layout.fragment_news, container, false);
        myListView = (ListView) fragmentView.findViewById(R.id.MyListView);

        //Assignment ArrayList object which hold news to myEventsList variable
        myEventsList = new ArrayList<Events>();

        //Getting data from Parse
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Concerts");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> eventsParseList, ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + eventsParseList.size() + " scores");
                    for (ParseObject parseObject : eventsParseList) {
                        String title = (String) parseObject.get("title");
                        String link = (String) parseObject.get("link");
                        String imageLink = (String) parseObject.get("imageLink");
                        Events myEvents = new Events(title, link, imageLink);
                        myEventsList.add(myEvents);
                    }

                    //Create adapter and set adapter to the list
                    myListView.setAdapter(new MyAdapter());

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });

        //Open the Browser each time we click on the row
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Events events = myEventsList.get(position);
                String link = events.getLink();
                openBrowsser(link);
            }
        });

        return fragmentView;
    }

    public void openBrowsser(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myEventsList.size();
        }

        @Override
        public Object getItem(int position) {
            return myEventsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = getActivity().getLayoutInflater().inflate(R.layout.row,null);

            Events rowEvent = myEventsList.get(position);

            TextView textViewRow = (TextView) rowView.findViewById(R.id.textView);
            textViewRow.setText(rowEvent.getTitle());

            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewPicasso);
            Picasso.with(getActivity()).load(rowEvent.getImageLink()).into(imageView);

            return rowView;
        }
    }


}
