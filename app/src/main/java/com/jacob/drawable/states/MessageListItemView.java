package com.jacob.drawable.states;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jacob.drawable.R;

/**
 * Package : com.jacob.drawable.states
 * Author : jacob
 * Date : 15-4-11
 * Description : 这个类是用来xxx
 */
public class MessageListItemView extends RelativeLayout {
    private static final int[] STATE_MESSAGE_UNREAD = {R.attr.state_message_unread};
    private TextView mTextViewMessage;
    private boolean messageUnread;

    public MessageListItemView(Context context) {
        this(context, null);
    }

    public MessageListItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MessageListItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViews();
    }

    private void initViews() {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        layoutInflater.inflate(R.layout.message_item, this, true);
        int paddingFive = dpToPx(5);
        int itemHeight = dpToPx(50);
        setPadding(paddingFive, paddingFive, paddingFive, paddingFive);

        setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, itemHeight));

        setBackgroundResource(R.drawable.message_list_item_background);

        mTextViewMessage = (TextView) findViewById(R.id.text_view);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        // If the message is unread then we merge our custom message unread state into
        // the existing drawable state before returning it.
        if (messageUnread) {
            final int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
            mergeDrawableStates(drawableState, STATE_MESSAGE_UNREAD);
            return drawableState;
        }
        return super.onCreateDrawableState(extraSpace);
    }

    public void setMessage(Message message) {
        mTextViewMessage.setText(message.getMessage());
        boolean isUnRead = message.isUnRead();
        if (messageUnread != isUnRead) {
            this.messageUnread = isUnRead;
            refreshDrawableState();
        }
    }


    private int dpToPx(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
