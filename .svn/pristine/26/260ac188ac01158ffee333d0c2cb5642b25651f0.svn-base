package com.golsen.week7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.golsen.week7.R;
import com.golsen.week7.model.Programme;
import com.golsen.week7.model.Programmes;
import com.rock.teachlibrary.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class TopListLvAdapter extends BaseExpandableListAdapter{

    private List<Programmes> data;
    private LayoutInflater inflater;
    public TopListLvAdapter(Context context,List<Programmes> data){
        inflater=((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        if (data!=null) {
            this.data  = data;

        }else{
            data = new ArrayList<>();
        }
    }

    @Override
    public int getGroupCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Programmes getGroup(int groupPosition) {
        return data.get(groupPosition);
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).getList()!=null?data.get(groupPosition).getList().size():0;
    }

    @Override
    public Programme getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_toplist_group_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        View divider = holder.getView(R.id.toplist_group_divider);
        if (groupPosition==0) {
            divider.setVisibility(View.GONE);

        }else{
            divider.setVisibility(View.VISIBLE);
        }

        TextView title = (TextView) holder.getView(R.id.toplist_group_item_title);
        title.setText(getGroup(groupPosition).getTitle());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_toplist_child_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        ImageView img = (ImageView) holder.getView(R.id.toplist_child_img);
        TextView title = (TextView) holder.getView(R.id.toplist_child_title);
        TextView titleOne = (TextView) holder.getView(R.id.toplist_child_child_title_one);
        TextView titleTwo = (TextView) holder.getView(R.id.toplist_child_child_title_two);

        title.setText(getChild(groupPosition,childPosition).getTitle());
        titleOne.setText(getChild(groupPosition,childPosition).getFirstKResults().get(0).getTitle());
        titleTwo.setText(getChild(groupPosition,childPosition).getFirstKResults().get(1).getTitle());
        ImageLoader.display(img,getChild(groupPosition,childPosition).getCoverPath(),R.mipmap.image_default_202);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class ViewHolder{
        private View convertView;
        private Map<Integer,View> mCacheView;
        public ViewHolder(View convertView){
            this.convertView = convertView;
            mCacheView = new HashMap<>();
        }

        public View getView(int resId){
            View view=null;
            if (mCacheView.containsKey(resId)) {
                view = mCacheView.get(resId);
            }else{
                view = convertView.findViewById(resId);
                mCacheView.put(resId,view);
            }
            return  view;
        }


    }
}
