package com.golsen.week7.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.golsen.week7.R;
import com.golsen.week7.model.Radios;
import com.rock.teachlibrary.ImageLoader;
import com.rock.teachlibrary.adapters.TeachBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class LocalRadioAdapter extends TeachBaseAdapter<Radios> {
    public LocalRadioAdapter(Context context, List<Radios> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, Radios item) {
        ImageView img = (ImageView) holder.getView(R.id.local_img);
        TextView title = (TextView) holder.getView(R.id.local_title);
        TextView childTitle = (TextView) holder.getView(R.id.local_child_title);
        TextView count = (TextView) holder.getView(R.id.local_count);
        ImageLoader.display(img,item.getRadioCoverSmall(),R.mipmap.image_default_202);
        title.setText(item.getRname());
        childTitle.setText(item.getProgramName());
        count.setText(item.getRadioPlayCount()+"");
    }
}
