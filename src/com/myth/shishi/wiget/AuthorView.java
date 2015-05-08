package com.myth.shishi.wiget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myth.shishi.R;
import com.myth.shishi.MyApplication;
import com.myth.shishi.activity.PoetryActivity;
import com.myth.shishi.activity.AuthorListActivity;
import com.myth.shishi.activity.PoetrySearchActivity;
import com.myth.shishi.activity.WebviewActivity;
import com.myth.shishi.entity.Author;
import com.myth.shishi.entity.ColorEntity;
import com.myth.shishi.util.DisplayUtil;

public class AuthorView extends RelativeLayout
{

    private Context mContext;

    private Author author;

    public AuthorView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public AuthorView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public AuthorView(Context context)
    {
        super(context);
        mContext = context;
        initView();
    }

    public AuthorView(Context context, Author author)
    {
        super(context);
        this.author = author;
        mContext = context;
        initView();
    }

    private void initView()
    {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.layout_author, null);

        LinearLayout topView = (LinearLayout) root.findViewById(R.id.right);
        LayoutParams param = new LayoutParams(DisplayUtil.dip2px(mContext, 80), DisplayUtil.dip2px(mContext, 120));
        CircleImageView dirView = new CircleImageView(mContext,author.getColor(),R.drawable.director);
        topView.addView(dirView, 1, param);
        
        dirView.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(mContext, PoetrySearchActivity.class);
                intent.putExtra("author", author);
                mContext.startActivity(intent);
            }
        });
        
        root.findViewById(R.id.baike).setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(mContext, WebviewActivity.class);
                intent.putExtra("string", author.getAuthor());
                mContext.startActivity(intent);
            }
        });

        TextView content = (TextView) root.findViewById(R.id.content);

        content.setTypeface(MyApplication.typeface);

        content.setText(author.getIntro());

        TextView title = (TextView) root.findViewById(R.id.title);

        title.setTypeface(MyApplication.typeface);

        title.setText(author.getAuthor());

        addView(root, new LayoutParams(-1, -1));
    }

}
