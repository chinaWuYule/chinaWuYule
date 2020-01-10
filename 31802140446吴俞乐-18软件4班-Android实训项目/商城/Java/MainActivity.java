package com.example.administrator.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ListView mListView;
    private String[] titles={"桌子","苹果","蛋糕","线衣","猕猴桃","围巾","西瓜","电视","洗衣机","冰箱","狗"};
    private String[] prices={"100元","10元/kg","80元","150元","10元/kg","20元","5元/kg","2699元","1499元","3888元","500元/只"};
    private int[] icons={R.drawable.table,R.drawable.apple,R.drawable.cake,R.drawable.wireclothes,
            R.drawable.kiwifruit,R.drawable.scarf,R.drawable.xigua,R.drawable.dianshi,R.drawable.xiyiji,
            R.drawable.bingxiang,R.drawable.gou};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
    }
    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return  titles.length;
        }
        @Override
        public Object getItem(int position){
            return titles[position];
        }
        @Override
        public long getItemId (int position){
            return position;
        }
        @Override
        public View getView(int position, View converView, ViewGroup parent){
            ViewHolder holder = null;
            if(converView == null){
                converView = View.inflate(MainActivity.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.title = (TextView)converView.findViewById(R.id.title);
                holder.price = (TextView)converView.findViewById(R.id.price);
                holder.iv = (ImageView) converView.findViewById(R.id.iv);
                converView.setTag(holder);
            }else{
                holder = (ViewHolder) converView.getTag();
            }
            holder.title.setText(titles[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return converView;
        }
    }

}
