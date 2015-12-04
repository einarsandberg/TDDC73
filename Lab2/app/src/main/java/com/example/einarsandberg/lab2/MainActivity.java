package com.example.einarsandberg.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.EditText;
import android.text.TextWatcher;
import android.graphics.Color;
import android.util.Log;
public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity"; // log tag
    List<String> titles;
    HashMap<String, List<String>> children;
    ExpandableListAdapter listAdapter;
    ExpandableListView listView;
    EditText searchField;
    int prevExpandedPosition = -1;
    int prevSelectedChild = -1;
    int prevSelectedGroup = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchField = (EditText) findViewById(R.id.search);

        listView = (ExpandableListView) findViewById(R.id.expandableListView);
        initList();

        listView.setSelector(R.drawable.item_selector);

        listAdapter = new ExpandableListAdapter(this, titles, children);

        listView.setAdapter(listAdapter);
        listView.setFocusableInTouchMode(true);
        listView.setItemsCanFocus(true);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                searchField.setText("/" + titles.get(groupPosition) + "/" + listAdapter.getChild(groupPosition, childPosition));
                return true;
            }
        });

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition)
            {

                prevExpandedPosition = groupPosition;
                listView.clearChoices();
            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener()
        {
            public void onGroupCollapse(int groupPosition)
            {
                listView.clearChoices();
            }

        });

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                // only do this if string is not empty
                if (!(s.toString().equals("")) && s.charAt(0) == '/')
                {
                    String groupName = getGroupName(s.toString());
                    String childName = getChildName(s.toString());
                    int groupPosition = getGroupPosition(groupName);
                    int childPosition = -1;

                    // if group matches or can match
                    if (groupPosition != -1)
                    {
                        listView.expandGroup(groupPosition);
                        searchField.setBackgroundColor(Color.parseColor("#ffffff"));
                        // if there is text after second "/"
                        if (!childName.equals("NO_POSSIBLE_CHILD"))
                        {
                            // try getting position
                            childPosition = getChildPosition(groupName, childName);
                            // child matches or can match one of the children
                            if (childPosition != -1)
                            {
                                int i = listView.getFlatListPosition(
                                        ExpandableListView.getPackedPositionForChild(groupPosition, childPosition));
                                listView.setItemChecked(i, true);
                                searchField.setBackgroundColor(Color.parseColor("#ffffff"));
                                prevSelectedGroup = groupPosition;
                                prevSelectedChild = childPosition;
                            }
                            // child does not match and can not match any of the children
                            else // childPosition == -1
                            {
                                try
                                {
                                    int i = listView.getFlatListPosition(
                                            ExpandableListView.getPackedPositionForChild(prevSelectedGroup, prevSelectedChild));
                                    listView.setItemChecked(i, false);
                                }
                                catch (Exception e)
                                {
                                    e.printStackTrace();
                                }
                                // only mark if the user has written something after second "/"
                                if (!childName.equals(""))
                                {
                                    searchField.setBackgroundColor(Color.RED);
                                    listView.collapseGroup(prevExpandedPosition);
                                }

                            }

                        }
                        // there is no text after second "/" or there is no "/"
                        else
                        {

                            int i = listView.getFlatListPosition(
                                    ExpandableListView.getPackedPositionForChild(groupPosition, 0));
                            listView.setItemChecked(i, true);
                            searchField.setBackgroundColor(Color.parseColor("#ffffff"));
                        }

                    }
                    // group doesn't exist and can not possibly exist
                    else if (groupPosition == -1)
                    {
                        listView.collapseGroup(prevExpandedPosition);
                        // if there is text
                        if (!groupName.equals(""))
                        {
                            searchField.setBackgroundColor(Color.RED);
                        }
                    }

                }

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }



    private void initList()
    {
        titles = new ArrayList<String>();
        children = new HashMap<String, List<String>>();

        // add some titles
        titles.add("Kebab");
        titles.add("Pizza");
        titles.add("Falafel");
        titles.add("Hamburgare");

        List <String> kebabChildren = new ArrayList<String>();
        List <String> pizzaChildren = new ArrayList<String>();
        List <String> falafelChildren = new ArrayList<String>();
        List <String> hamburgerChildren = new ArrayList<String>();

        //add some children
        kebabChildren.add("Kebabrulle");
        kebabChildren.add("Kebabtallrik");
        pizzaChildren.add("Margarita");
        pizzaChildren.add("Vesuvio");
        pizzaChildren.add("Hawaii");
        pizzaChildren.add("Ciao Ciao");
        falafelChildren.add("Falafelrulle");
        falafelChildren.add("Falafeltallrik");
        hamburgerChildren.add("Baconburgare");
        hamburgerChildren.add("Cheeseburgare");

        children.put(titles.get(0), kebabChildren);
        children.put(titles.get(1), pizzaChildren);
        children.put(titles.get(2), falafelChildren);
        children.put(titles.get(3), hamburgerChildren);

    }

    private String getGroupName(String s)
    {

        if (s.charAt(0) == '/') {
            //remove first '/'
            s = s.substring(1, s.length());

            if (s.contains("/")) {
                int i = s.indexOf("/");
                s = s.substring(0, i);

            }
        }
        return s;
    }

    private String getChildName(String s)
    {
        if (s.charAt(0) == '/')
        {
            s = s.substring(1, s.length());

            if (s.contains("/")) {
                int i = s.indexOf("/");
                s = s.substring(i+1, s.length());
                // if there is a second "/" but no child
                if (s.equals(""))
                {
                    return "NO_POSSIBLE_CHILD";
                }
            }
            // no child
            else
            {
                return "NO_POSSIBLE_CHILD";
            }
        }
        return s;
    }

    private int getGroupPosition(String group)
    {
        int groupPosition = -1;
        if (!group.equals(""))
        {
            for (int i = 0; i < titles.size(); i++)
            {
                if (titles.get(i).startsWith(group))
                {
                    groupPosition = i;
                    break;
                }
            }
        }
        return groupPosition;
    }

    private int getChildPosition(String group, String child)
    {
        int childPosition = -1;
        // check if there is a child in the text field, and get its position if so
        if (!child.equals(""))
        {
            if (children.get(group) != null)
            {
                for (int i = 0; i < children.get(group).size(); i++)
                {
                    if (children.get(group).get(i).startsWith(child))
                    {
                        childPosition = i;
                        break;
                    }
                }
            }
        }
        return childPosition;
    }
}
