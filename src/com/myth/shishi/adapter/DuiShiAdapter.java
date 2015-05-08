package com.myth.shishi.adapter;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myth.shishi.MyApplication;
import com.myth.shishi.R;
import com.myth.shishi.entity.Author;
import com.myth.shishi.listener.MyListener;
import com.myth.shishi.wiget.StoneView;

public class DuiShiAdapter extends RecyclerView.Adapter<DuiShiAdapter.ViewHolder>
{

    private List<String> list;

    private ViewHolder holder;

    private MyListener myListener;

    public void setList(List<String> list)
    {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener
    {
        private MyListener myListener;

        public ViewHolder(View arg0)
        {
            super(arg0);
            name = (TextView) arg0.findViewById(R.id.name);
            arg0.setOnClickListener(this);
        }

        TextView name;

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

    public DuiShiAdapter()
    {
    }

    @Override
    public DuiShiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_duishi, parent, false);

        holder = new ViewHolder(convertView);
        holder.myListener = myListener;
        holder.name.setTypeface(MyApplication.typeface);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {

        holder.name.setText(list.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount()
    {
        return list == null ? 0 : list.size();
    }

    public void setMyListener(MyListener myListener)
    {
        this.myListener = myListener;
    }

}
