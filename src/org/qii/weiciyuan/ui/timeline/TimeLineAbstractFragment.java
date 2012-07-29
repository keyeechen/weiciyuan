package org.qii.weiciyuan.ui.timeline;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.qii.weiciyuan.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qii
 * Date: 12-7-29
 * Time: 下午12:14
 * To change this template use File | Settings | File Templates.
 */
public abstract class TimeLineAbstractFragment extends Fragment {
    protected ListView listView;
    protected List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    protected TimeLineAdapter timeLineAdapter;

    protected class TimeLineAdapter extends BaseAdapter {
        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = getActivity().getLayoutInflater();

        Map<String, String> map;

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            if (convertView == null) {

                convertView = inflater.inflate(R.layout.mentionstimeline_item, parent, false);
                holder.screenName = (TextView) convertView.findViewById(R.id.username);
                holder.txt = (TextView) convertView.findViewById(R.id.content);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            map = list.get(position);

            holder.screenName.setText(map.get("screen_name"));

            holder.txt.setText(map.get("text"));

            return convertView;

        }
    }

    static class ViewHolder {
        TextView screenName;
        TextView txt;

    }
}
