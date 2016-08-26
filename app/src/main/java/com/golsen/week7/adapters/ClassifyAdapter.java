package com.golsen.week7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.golsen.week7.R;
import com.golsen.week7.model.Classify;
import com.rock.teachlibrary.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/22 0022.
 */
public class ClassifyAdapter extends BaseAdapter implements View.OnClickListener {

    private static final String TAG = ClassifyAdapter.class.getSimpleName();
    private ColumnCilckLisener columnCilckLisener;
    private List<Classify> data;
    private LayoutInflater inflater;

    public void setColumnCilckLisener(ColumnCilckLisener columnCilckLisener){
        this.columnCilckLisener = columnCilckLisener;
    }
    public ClassifyAdapter(Context context,List<Classify> data){
        //实例化布局导入器
        inflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        //传递数据源
        if (data!=null) {
            this.data = data;
        }else{
            this.data=new ArrayList<>();
        }
    }

    public void updataRes(List<Classify> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    

    @Override
    public int getCount() {
        int count = 0;
        if (data!=null) {
            count =(data.size()-1)/2;
        }
        return count;
    }

    @Override
    public Classify getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null) {
            // 导入布局
            convertView = inflater.inflate(R.layout.classify_item,parent,false);
            holder = new ViewHolder();
            holder.itemImage01 = ((ImageView) convertView.findViewById(R.id.classify_item_image01));
            holder.itemImage02 = ((ImageView) convertView.findViewById(R.id.classify_item_image02));
            holder.itemText01 = ((TextView) convertView.findViewById(R.id.classify_item_text01));
            holder.itemText02 = ((TextView) convertView.findViewById(R.id.classify_item_text02));
            holder.topDivider = convertView.findViewById(R.id.classify_item_divider);
            holder.left =  convertView.findViewById(R.id.classify_item_one);
            holder.right = convertView.findViewById(R.id.classify_item_two);
            convertView.setTag(holder);
        }else{
            holder = ((ViewHolder) convertView.getTag());
        }
        //根据条件判断是否显示分割线
        if (position%3 ==0) {
            holder.topDivider.setVisibility(View.VISIBLE);
        }else{
            holder.topDivider.setVisibility(View.GONE);
        }

        //加载数据
        holder.itemText01.setText(getItem(position*2+1).getTitle());
        holder.itemText02.setText(getItem(position*2+2).getTitle());


        //加载图片
        ImageLoader.display(holder.itemImage01,getItem(position*2+1).getCoverPath(),R.mipmap.ic_launcher);
        ImageLoader.display(holder.itemImage02,getItem(position*2+2).getCoverPath(),R.mipmap.ic_launcher);
        //记录位置
        holder.left.setOnClickListener(this);
        holder.right.setOnClickListener(this);
        holder.left.setTag(position*2+1);
        holder.right.setTag(position*1+2);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        Integer position = (Integer) v.getTag();
        if (columnCilckLisener!=null) {
            columnCilckLisener.getColumnClicLisener(position);
        }
    }


    private static class ViewHolder{
        //左边的图片
        ImageView itemImage01;
        //右边的图片
        ImageView itemImage02;
        //左边的文字
        TextView itemText01;
        //右边的文字
        TextView itemText02;
        //分割线
        View topDivider;
        //item
        View left;
        View right;
    }


    public interface ColumnCilckLisener{
        void getColumnClicLisener(int position);
    }
}