package com.example.administrador.pvsegalmex.controller;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrador.pvsegalmex.R;

import static android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_SWIPE;
import static android.support.v7.widget.helper.ItemTouchHelper.Callback;
import static android.support.v7.widget.helper.ItemTouchHelper.LEFT;
import static android.support.v7.widget.helper.ItemTouchHelper.RIGHT;

enum ButtonsState2{
    GONE,LEFT_VISIBLE,RIGHT_VISIBLE
}

public class SwipeControllerRV extends Callback {
    private boolean swipeBack=false;
    private ButtonsState buttonState=ButtonsState.GONE;
    private static final float buttonWidth=150;
    private  RectF buttonInstance;
    private RecyclerView.ViewHolder currentItemViewHolder = null;
    private SwipeControllerActions buttonsActions = null;

    public SwipeControllerRV(SwipeControllerActions buttonsActions) {
        this.buttonsActions = buttonsActions;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, LEFT | RIGHT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        if (swipeBack) {
            swipeBack = buttonState != ButtonsState.GONE;
            return 0;
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        if (actionState == ACTION_STATE_SWIPE) {
            if (buttonState != ButtonsState.GONE) {
                if (buttonState == ButtonsState.LEFT_VISIBLE) dX = Math.max(dX, buttonWidth);
                if (buttonState == ButtonsState.RIGHT_VISIBLE) dX = Math.min(dX, -buttonWidth);
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
            else {
                setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        }

        if (buttonState == ButtonsState.GONE) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
        currentItemViewHolder = viewHolder;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setTouchListener(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY,
                                  int actionState, boolean isCurrentlyActive) {

        recyclerView.setOnTouchListener((v, event) -> {
            swipeBack = event.getAction() == MotionEvent.ACTION_CANCEL || event.getAction() == MotionEvent.ACTION_UP;
            if (swipeBack) {
                if (dX < -buttonWidth) buttonState = ButtonsState.RIGHT_VISIBLE;
                else if (dX > buttonWidth) buttonState  = ButtonsState.LEFT_VISIBLE;
                if (buttonState != ButtonsState.GONE) {
                    setTouchDownListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                    setItemsClickable(recyclerView, false);
                }
            }
            return false;
        });
    }
    @SuppressLint("ClickableViewAccessibility")
    private void setTouchDownListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder,
                                      final float dX, final float dY, final int actionState, final boolean isCurrentlyActive)
    {
        recyclerView.setOnTouchListener((v,event)->{
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                setTouchUpListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
            return false;
        });
    }
    @SuppressLint("ClickableViewAccessibility")
    private void setTouchUpListener(final Canvas c, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder,
                                    final float dX, final float dY, final int actionState, final boolean isCurrentlyActive)
    {
        recyclerView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                SwipeControllerRV.super.onChildDraw(c, recyclerView, viewHolder, 0F, dY, actionState, isCurrentlyActive);
                recyclerView.setOnTouchListener((v1, event1) -> false);
                setItemsClickable(recyclerView,true);
                swipeBack = false;
                if(buttonsActions!=null && buttonInstance!=null &&buttonInstance.contains(event.getX(),event.getY())){
                    if(buttonState==ButtonsState.LEFT_VISIBLE)
                        buttonsActions.onLeftClicked(viewHolder.getAdapterPosition());
                    else if(buttonState==ButtonsState.RIGHT_VISIBLE)
                        buttonsActions.onRightClicked(viewHolder.getAdapterPosition());
                }
                buttonState = ButtonsState.GONE;
                currentItemViewHolder=null;
            }
            return false;
        });
    }

    private void setItemsClickable(RecyclerView recyclerView,boolean isClickable) {
        for (int i = 0; i < recyclerView.getChildCount(); ++i) {
            recyclerView.getChildAt(i).setClickable(isClickable);
        }
    }

    private void drawButtons(Canvas c, RecyclerView.ViewHolder viewHolder){
        float buttonWidthWithoutPadding = buttonWidth -10;
        float corners = 16;
        View itemView = viewHolder.itemView;
        Paint paint=new Paint();
        Bitmap iconL,iconR;

        iconL= BitmapFactory.decodeResource(itemView.getResources(), R.drawable.delete);
        iconR=BitmapFactory.decodeResource(itemView.getResources(),R.drawable.edit);

        paint.setColor(Color.parseColor("#D35656"));

        RectF leftButton = new RectF(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + buttonWidthWithoutPadding, itemView.getBottom());
        RectF leftButtonIcon = new RectF(itemView.getLeft()+30, itemView.getTop()+30, itemView.getLeft() + buttonWidthWithoutPadding-30, itemView.getBottom()-30);
        c.drawRoundRect(leftButton,corners,corners,paint);
        drawText("Eliminar",c,leftButton,paint);
        // c.drawBitmap(iconL,null,leftButtonIcon,paint);

        paint.setColor(Color.parseColor("#D35656"));
        RectF rightButton = new RectF(itemView.getRight() - buttonWidthWithoutPadding, itemView.getTop(), itemView.getRight(), itemView.getBottom());
        RectF rightButtonIcon = new RectF(itemView.getRight() - buttonWidthWithoutPadding+30, itemView.getTop()+30, itemView.getRight()-30, itemView.getBottom()-30);
        c.drawRoundRect(rightButton, corners, corners, paint);
        drawText("Eliminar",c,rightButton,paint);
        //c.drawBitmap(iconR,null,rightButtonIcon,paint);

        buttonInstance = null;
        if(buttonState==ButtonsState.LEFT_VISIBLE){
            buttonInstance=leftButton;
        }
        else if (buttonState== ButtonsState.RIGHT_VISIBLE) {
            buttonInstance = rightButton;
        }

    }
    public void onDraw(Canvas c) {
        if (currentItemViewHolder != null) {
            drawButtons(c, currentItemViewHolder);
        }
    }

    private void drawText(String text, Canvas c, RectF button, Paint p) {
        float textSize =20;
        p.setColor(Color.WHITE);
        p.setAntiAlias(true);
        p.setTextSize(textSize);

        float textWidth = p.measureText(text);
        c.drawText(text, button.centerX()-(textWidth/2), button.centerY()+(textSize/2), p);
    }



}
