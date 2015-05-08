package com.myth.shishi.adapter;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myth.shishi.MyApplication;
import com.myth.shishi.R;
import com.myth.shishi.entity.Poetry;
import com.myth.shishi.listener.MyListener;
import com.myth.shishi.wiget.StoneView;

public class PoetryAdapter extends RecyclerView.Adapter<PoetryAdapter.ViewHolder>
{

    private List<Poetry> list;

    private ViewHolder holder;

    private MyListener myListener;

    public void setList(List<Poetry> list)
    {
        this.list = list;
    }

    // Provide a reference to the type of views that you are using
    // (custom viewholder)
    public static class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener
    {
        private MyListener myListener;

        public ViewHolder(View arg0)
        {
            super(arg0);
            name = (TextView) arg0.findViewById(R.id.name);
            tag = (TextView) arg0.findViewById(R.id.tag);
            arg0.setOnClickListener(this);
        }

        TextView name;

        TextView tag;

        /**
         * 点击监听
         */
        @Override
        public void onClick(View v)
        {
            if (myListener != null)
            {
                myListener.onItemClick(getPosition());
            }
        }

        public void setMyListener(MyListener myListener)
        {
            this.myListener = myListener;
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PoetryAdapter()
    {
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PoetryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // create a new view
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_cipai, parent, false);
        // set the view's size, margins, paddings and layout parameters

        holder = new ViewHolder(convertView);
        holder.myListener = myListener;
        holder.name.setTypeface(MyApplication.typeface);
        holder.tag.setTypeface(MyApplication.typeface);
        
        holder.tag.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.name.setText(list.get(position).getTitle());
        holder.tag.setText(list.get(position).getPoetry());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public void setMyListener(MyListener myListener)
    {
        this.myListener = myListener;
    }

}
