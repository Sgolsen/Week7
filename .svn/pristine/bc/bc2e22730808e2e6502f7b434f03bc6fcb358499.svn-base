package com.golsen.week7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.golsen.week7.R;
import com.golsen.week7.model.Album;
import com.golsen.week7.model.Albumse;
import com.rock.teachlibrary.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/24 0024.
 */
public class RecommentLvAdapter extends BaseExpandableListAdapter {

    private List<Albumse> data;
    private LayoutInflater inflater;

    public RecommentLvAdapter(Context context, List<Albumse> data) {
        inflater = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        if (data!=null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
    }

    //组的个数
    @Override
    public int getGroupCount() {
        return data!=null?data.size():0;
    }

    /**
     * 根据groupPosition返回对应的组的数据
     * @param groupPosition
     * @return
     */
    @Override
    public Albumse getGroup(int groupPosition) {
        return data.get(groupPosition);
    }
    /**
     * position对应的组中有多个 child
     * @param groupPosition
     * @return
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return getGroup(groupPosition).getList()!=null?getGroup(groupPosition).getList().size()/3:0;
    }



    /**
     * 根据组的位置和子的位置去返回 child数据
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public Album getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).getList().get(childPosition);
    }

    /**
     * 返回组的id
     * @param groupPosition
     * @return
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * 返回 child 的id
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    /**
     * 是否拥有固定的id
     * @return   false 和 true 没有实际影响
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 获取组的View
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.recomment_group_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = ((ViewHolder) convertView.getTag());
        }
        TextView title = (TextView) holder.getView(R.id.recommend_group_item_title);
        title.setText(getGroup(groupPosition).getTitle());

        return convertView;
    }

    /**
     * 获取子的View
     * @param groupPosition
     * @param childPosition
     * @param isLastChild
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView ==null) {
            convertView = inflater.inflate(R.layout.recomment_child_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
        ImageView imgOne = (ImageView) holder.getView(R.id.recommend_child_item_img_one);
        ImageView imgTwo = (ImageView) holder.getView(R.id.recommend_child_item_img_two);
        ImageView imgThree = (ImageView) holder.getView(R.id.recommend_child_item_img_three);
        TextView titleOne = (TextView) holder.getView(R.id.recommend_child_item_title_one);
        TextView titleTwo = (TextView) holder.getView(R.id.recommend_child_item_title_two);
        TextView titleThree = (TextView) holder.getView(R.id.recommend_child_item_title_three);
        TextView nickOne = (TextView) holder.getView(R.id.recommend_child_item_nick_one);
        TextView nickTwo = (TextView) holder.getView(R.id.recommend_child_item_nick_two);
        TextView nickThree = (TextView) holder.getView(R.id.recommend_child_item_nick_three);

        titleOne.setText(getChild(groupPosition,childPosition).getTrackTitle());
        titleTwo.setText(getChild(groupPosition,childPosition+1).getTrackTitle());
        titleThree.setText(getChild(groupPosition,childPosition+2).getTrackTitle());
        nickOne.setText(getChild(groupPosition,childPosition).getTitle());
        nickTwo.setText(getChild(groupPosition,childPosition+1).getTitle());
        nickThree.setText(getChild(groupPosition,childPosition+2).getTitle());
        ImageLoader.display(imgOne,getChild(groupPosition,childPosition).getCoverMiddle());
        ImageLoader.display(imgTwo,getChild(groupPosition,childPosition+1).getCoverMiddle());
        ImageLoader.display(imgThree,getChild(groupPosition,childPosition+2).getCoverMiddle());

        return convertView;
    }

    /**
     * child 是否可以被选择
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private static class ViewHolder{

        private View convertView;
        private Map<Integer,View> mCacheViews;

        public ViewHolder(View convertView){
            this.convertView = convertView;
            mCacheViews = new HashMap<>();
        }

        public View getView(int resId){
            View view = null;
            if (mCacheViews.containsKey(resId)) {
                view = mCacheViews.get(resId);
            }else{
                view = convertView.findViewById(resId);
                mCacheViews.put(resId,view);
            }
            return view;
        }
    }
}
