package com.liangfeng.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        //获取控件
        recyclerView = (RecyclerView) findViewById(R.id.rl_demo1);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            strings.add("item" + i);
        }
        //设置布局管理器
        //瀑布流
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //设置适配器
        recyclerView.setAdapter(new MyAdapter(strings));
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        //数据集合
        private List<String> datas;
        private List<Integer> heights;

        //构造方法
        public MyAdapter(List<String> datas) {
            this.datas = datas;
            heights= new ArrayList<Integer>();
            //随机获取一个mHeight值
            for (int i = 0; i < datas.size(); i++) {
                heights.add((int) (100+Math.random() * 300));
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(DemoActivity2.this).inflate(R.layout.item0, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflate);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(datas.get(position));
            //设置每个item的高度
            ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
            lp.height = heights.get(position);
            holder.itemView.setLayoutParams(lp);
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            //ViewHolder中的子控件
            public TextView mTextView;
            //构造方法
            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.tv_data);
            }
        }
    }
}
