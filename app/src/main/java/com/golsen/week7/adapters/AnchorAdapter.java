package com.golsen.week7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.golsen.week7.R;
import com.golsen.week7.model.Anchor;
import com.golsen.week7.model.Anchors;
import com.rock.teachlibrary.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class AnchorAdapter extends BaseExpandableListAdapter{
    private List<Anchors> data;
    private LayoutInflater inflater;
    public AnchorAdapter(Context context,List<Anchors> data){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (data!=null) {

            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
    }

    public void addRes(List<Anchors> data){
        if (data!=null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void updateRes(List<Anchors> data){
        if (data!=null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getGroupCount() {
        return data!=null?data.size():0;
    }

    @Override
    public Anchors getGroup(int groupPosition) {
        return data.get(groupPosition);
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return getGroup(groupPosition).getList()!=null?getGroup(groupPosition).getList().size()/3:0;
    }



    @Override
    public Anchor getChild(int groupPosition, int childPosition) {
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
            convertView = inflater.inflate(R.layout.fragment_anchor_group,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        TextView title = (TextView) holder.getView(R.id.anchor_group_item_title);
        title.setText(getGroup(groupPosition).getTitle());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fragment_anchor_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        ImageView imgOne = (ImageView) holder.getView(R.id.anchor_img_one);
        ImageView imgTwo = (ImageView) holder.getView(R.id.anchor_img_two);
        ImageView imgThree = (ImageView) holder.getView(R.id.anchor_img_three);

        TextView nickNameOne = (TextView) holder.getView(R.id.anchor_text_title_one);
        TextView nickNameTwo = (TextView) holder.getView(R.id.anchor_text_title_two);
        TextView nickNameThree = (TextView) holder.getView(R.id.anchor_text_title_three);

        nickNameOne.setText(getChild(groupPosition,childPosition).getNickname());
        nickNameTwo.setText(getChild(groupPosition,childPosition+1).getNickname());
        nickNameThree.setText(getChild(groupPosition,childPosition+2).getNickname());

        ImageLoader.display(imgOne,getChild(groupPosition,childPosition).getSmallLogo(),R.mipmap.no_content);
        ImageLoader.display(imgTwo,getChild(groupPosition,childPosition+1).getSmallLogo(),R.mipmap.no_content);
        ImageLoader.display(imgThree,getChild(groupPosition,childPosition+2).getSmallLogo(),R.mipmap.no_content);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    private static class ViewHolder{
        private View convertView;
        private Map<Integer,View> mcacheView;
        public ViewHolder(View convertView){
            this.convertView = convertView;
            mcacheView = new HashMap<>();
        }
        public View getView(int resId){
            View view=null;
            if (mcacheView.containsKey(resId)) {
                view = mcacheView.get(resId);
            }else{
                view = convertView.findViewById(resId);
                mcacheView.put(resId,view);
            }
            return view;
        }
    }
}
