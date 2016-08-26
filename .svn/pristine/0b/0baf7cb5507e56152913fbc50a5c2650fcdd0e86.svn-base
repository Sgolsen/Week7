package com.golsen.week7.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.golsen.week7.R;
import com.golsen.week7.model.RecommendRadio;
import com.golsen.week7.model.TopRadio;
import com.rock.teachlibrary.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23 0023.
 */
public class BroadcastAdapter extends BaseAdapter {

    private static final int HEADER = 0;
    private static final int NORMAL = 1;
    private List<RecommendRadio> RecommendData;
    private List<TopRadio> TopData;
    private LayoutInflater inflater;
    public BroadcastAdapter(Context context, List<RecommendRadio> RecommendData, List<TopRadio> TopData){
        inflater = LayoutInflater.from(context);
        if (RecommendData!=null) {
            this.RecommendData = RecommendData;
        }else{
            this.RecommendData = new ArrayList<>();
        }
        if (TopData!=null) {
            this.TopData = TopData;
        }else{
            this.TopData = new ArrayList<>();
        }

    }

    public void updateRes(List<RecommendRadio> RecommendData, List<TopRadio> TopData){
        if (RecommendData!=null &&TopData!=null) {
            this.RecommendData.clear();
            this.TopData.clear();
            this.RecommendData.addAll(RecommendData);
            this.TopData.addAll(TopData);
            notifyDataSetChanged();
        }
    }
    @Override
    public int getItemViewType(int position) {
        if (position==0) {
            return HEADER;
        }else{
            return NORMAL;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return RecommendData!=null&&TopData!=null?TopData.size()+1:0;
    }

    @Override
    public Object getItem(int position) {
        if(position==0){
            return RecommendData;
        }else{
            return TopData.get(position-1);
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder headerHolder = null;
        NormalViewHolder normalHolder = null;
        if (convertView==null) {
            //控件初始化
            switch (getItemViewType(position)) {
                case HEADER:
                        convertView = inflater.inflate(R.layout.broadcast_recommend_item, parent, false);
                        headerHolder = new HeaderViewHolder();
                        headerHolder.headerImageOne = ((ImageView) convertView.findViewById(R.id.broadcast_recommend_item_img_one));
                        headerHolder.headerImageTwo = ((ImageView) convertView.findViewById(R.id.broadcast_recommend_item_img_two));
                        headerHolder.headerImageThree = ((ImageView) convertView.findViewById(R.id.broadcast_recommend_item_img_three));
                        headerHolder.headerNameOne = ((TextView) convertView.findViewById(R.id.broadcast_recommend_item_text_one));
                        headerHolder.headerNameTwo = ((TextView) convertView.findViewById(R.id.broadcast_recommend_item_text_two));
                        headerHolder.headerNameThree = ((TextView) convertView.findViewById(R.id.broadcast_recommend_item_text_three));
                    convertView.setTag(headerHolder);
                        break;

                case NORMAL:
                        convertView = inflater.inflate(R.layout.broadcast_row_item, parent, false);
                        normalHolder = new NormalViewHolder();
                        normalHolder.normalImage = ((ImageView) convertView.findViewById(R.id.broadcast_row_item_img));
                        normalHolder.normalName = ((TextView) convertView.findViewById(R.id.broadcast_row_item_name));
                        normalHolder.normalProgram = ((TextView) convertView.findViewById(R.id.broadcast_row_item_program));
                        normalHolder.normalCount = ((TextView) convertView.findViewById(R.id.broadcast_row_item_num));
                        normalHolder.nornalDivider = ((RelativeLayout) convertView.findViewById(R.id.row_item_divider));
                        convertView.setTag(normalHolder);
                    break;
            }
        }else{
            if (getItemViewType(position)==HEADER) {
                headerHolder = ((HeaderViewHolder) convertView.getTag());
            }else{
                normalHolder = ((NormalViewHolder) convertView.getTag());
            }


        }

        //设置数据
        switch (getItemViewType(position)) {
            case HEADER:
                if (getCount()!=1) {
                    headerHolder.headerNameOne.setText(RecommendData.get(position).getRname());
                    headerHolder.headerNameTwo.setText(RecommendData.get(position + 1).getRname());
                    headerHolder.headerNameThree.setText(RecommendData.get(position + 2).getRname());
                    ImageLoader.display(headerHolder.headerImageOne, RecommendData.get(position).getPicPath());
                    ImageLoader.display(headerHolder.headerImageTwo, RecommendData.get(position + 1).getPicPath());
                    ImageLoader.display(headerHolder.headerImageThree, RecommendData.get(position + 2).getPicPath());
                }
                break;
            case NORMAL:
                //分割线的显示和隐藏
                if (position==1){
                    normalHolder.nornalDivider.setVisibility(View.VISIBLE);
                }else{
                    normalHolder.nornalDivider.setVisibility(View.GONE);
                }

                normalHolder.normalName.setText(TopData.get(position-1).getRname());
                normalHolder.normalProgram.setText(TopData.get(position-1).getProgramName());
                normalHolder.normalCount.setText(TopData.get(position-1).getRadioPlayCount());
                ImageLoader.display(normalHolder.normalImage,TopData.get(position-1).getRadioCoverSmall());
                break;
        }



        return convertView;
    }


    public class HeaderViewHolder{
        ImageView headerImageOne;
        ImageView headerImageTwo;
        ImageView headerImageThree;
        TextView headerNameOne;
        TextView headerNameTwo;
        TextView headerNameThree;

    }
    public class NormalViewHolder{
        ImageView normalImage;
        TextView normalName;
        TextView normalProgram;
        TextView normalCount;
        RelativeLayout nornalDivider;
    }
}
