package com.jacob.drawable.states;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Package : com.jacob.drawable.states
 * Author : jacob
 * Date : 15-4-11
 * Description : 这个类是用来xxx
 */
public class MessageActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ExampleListAdapter());
    }

    private static class ExampleListAdapter extends BaseAdapter {

        private Message[] messages;

        private ExampleListAdapter() {
            messages = new Message[]{
                    new Message("Gas bill overdue", true),
                    new Message("Congratulations, you've won!", true),
                    new Message("I love you!", false),
                    new Message("Please reply!", false),
                    new Message("You ignoring me?", false),
                    new Message("Not heard from you", false),
                    new Message("Electricity bill", true),
                    new Message("Gas bill", true),
                    new Message("Holiday plans", false),
                    new Message("Marketing stuff", false),
            };
        }

        @Override
        public int getCount() {
            return messages.length;
        }

        @Override
        public Object getItem(int position) {
            return messages[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            MessageListItemView messageListItemView = (MessageListItemView) convertView;

            if (messageListItemView == null) {
                messageListItemView = new MessageListItemView(viewGroup.getContext());
            }

            Message message = (Message) getItem(position);
            messageListItemView.setMessage(message);
            return messageListItemView;
        }
    }
}
