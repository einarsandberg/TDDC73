package com.example.einarsandberg.lab3;

import android.widget.BaseAdapter;

/**
 * Created by einarsandberg on 2015-11-26.
 */
import java.util.List;
import android.content.Context;
import android.view.*;
public class ItemAdapter extends BaseAdapter
{
    private List<String> items;
    Context context;
    public ItemAdapter(Context theContext, List<String> theItems)
    {
        context = theContext;
        items = theItems;
    }
    @Override
    public int getCount()
    {
        if (items == null) // will give an exception otherwise when deleting all text
            return 0;

        return items.size();
    }
    @Override
    public View getView(int i, View v, ViewGroup viewGroup)
    {
        return new ListItem(context, items.get(i));
    }
    @Override
    public long getItemId(int position)
    {
        return 0; // ?
    }
    @Override
    public Object getItem(int position)
    {
        return items.get(position);
    }


}
