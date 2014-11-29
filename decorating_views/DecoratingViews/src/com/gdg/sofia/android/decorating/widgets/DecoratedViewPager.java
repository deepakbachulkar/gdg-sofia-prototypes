package com.gdg.sofia.android.decorating.widgets;

import java.util.ArrayList;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.IntToString;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowId;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LayoutAnimationController;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public class DecoratedViewPager extends ViewPager {
    private ViewPager viewPager;

    public DecoratedViewPager(Context context) {
        super(context);
    }

    public DecoratedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    @Override
    public void addFocusables(ArrayList<View> arg0, int arg1, int arg2) {
        if (viewPager != null) {
            viewPager.addFocusables(arg0, arg1, arg2);
        } else {
            super.addFocusables(arg0, arg1, arg2);
        }
    }

    @Override
    public void addTouchables(ArrayList<View> arg0) {
        if (viewPager != null) {
            viewPager.addTouchables(arg0);
        } else {
            super.addTouchables(arg0);
        }
    }

    @Override
    public void addView(View child, int index, android.view.ViewGroup.LayoutParams params) {
        if (viewPager != null) {
            viewPager.addView(child, index, params);
        } else {
            super.addView(child, index, params);
        }
    }

    @Override
    public boolean arrowScroll(int arg0) {
        return (viewPager != null) ? viewPager.arrowScroll(arg0) : super.arrowScroll(arg0);
    }

    @Override
    public boolean beginFakeDrag() {
        return (viewPager != null) ? viewPager.beginFakeDrag() : super.beginFakeDrag();
    }

    @Override
    public boolean canScrollHorizontally(int direction) {
        return (viewPager != null) ? viewPager.canScrollHorizontally(direction) : super
                .canScrollHorizontally(direction);
    }

    @Override
    public void computeScroll() {
        if (viewPager != null) {
            viewPager.computeScroll();
        } else {
            super.computeScroll();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return (viewPager != null) ? viewPager.dispatchKeyEvent(event) : super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent arg0) {
        return (viewPager != null) ? viewPager.dispatchPopulateAccessibilityEvent(arg0) : super
                .dispatchPopulateAccessibilityEvent(arg0);
    }

    @Override
    public void draw(Canvas arg0) {
        if (viewPager != null) {
            viewPager.draw(arg0);
        } else {
            super.draw(arg0);
        }
    }

    @Override
    public void endFakeDrag() {
        if (viewPager != null) {
            viewPager.endFakeDrag();
        } else {
            super.endFakeDrag();
        }
    }

    @Override
    public boolean executeKeyEvent(KeyEvent event) {
        return (viewPager != null) ? viewPager.executeKeyEvent(event) : super.executeKeyEvent(event);
    }

    @Override
    public void fakeDragBy(float xOffset) {
        if (viewPager != null) {
            viewPager.fakeDragBy(xOffset);
        } else {
            super.fakeDragBy(xOffset);
        }
    }

    @Override
    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return (viewPager != null) ? viewPager.generateLayoutParams(attrs) : super.generateLayoutParams(attrs);
    }

    @Override
    public PagerAdapter getAdapter() {
        return (viewPager != null) ? viewPager.getAdapter() : super.getAdapter();
    }

    @Override
    public int getCurrentItem() {
        return (viewPager != null) ? viewPager.getCurrentItem() : super.getCurrentItem();
    }

    @Override
    public int getOffscreenPageLimit() {
        return (viewPager != null) ? viewPager.getOffscreenPageLimit() : super.getOffscreenPageLimit();
    }

    @Override
    public int getPageMargin() {
        return (viewPager != null) ? viewPager.getPageMargin() : super.getPageMargin();
    }

    @Override
    public boolean isFakeDragging() {
        return (viewPager != null) ? viewPager.isFakeDragging() : super.isFakeDragging();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return (viewPager != null) ? viewPager.onInterceptTouchEvent(arg0) : super.onInterceptTouchEvent(arg0);
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        if (viewPager != null) {
            viewPager.onRestoreInstanceState(state);
        } else {
            super.onRestoreInstanceState(state);
        }
    }

    @Override
    public Parcelable onSaveInstanceState() {
        return (viewPager != null) ? viewPager.onSaveInstanceState() : super.onSaveInstanceState();
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return (viewPager != null) ? viewPager.onTouchEvent(arg0) : super.onTouchEvent(arg0);
    }

    @Override
    public void removeView(View view) {
        if (viewPager != null) {
            viewPager.removeView(view);
        } else {
            super.removeView(view);
        }
    }

    @Override
    public void setAdapter(PagerAdapter arg0) {
        if (viewPager != null) {
            viewPager.setAdapter(arg0);
        } else {
            super.setAdapter(arg0);
        }
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        if (viewPager != null) {
            viewPager.setCurrentItem(item, smoothScroll);
        } else {
            super.setCurrentItem(item, smoothScroll);
        }
    }

    @Override
    public void setCurrentItem(int item) {
        if (viewPager != null) {
            viewPager.setCurrentItem(item);
        } else {
            super.setCurrentItem(item);
        }
    }

    @Override
    public void setOffscreenPageLimit(int limit) {
        if (viewPager != null) {
            viewPager.setOffscreenPageLimit(limit);
        } else {
            super.setOffscreenPageLimit(limit);
        }
    }

    @Override
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(listener);
        } else {
            super.setOnPageChangeListener(listener);
        }
    }

    @Override
    public void setPageMargin(int marginPixels) {
        if (viewPager != null) {
            viewPager.setPageMargin(marginPixels);
        } else {
            super.setPageMargin(marginPixels);
        }
    }

    @Override
    public void setPageMarginDrawable(Drawable d) {
        if (viewPager != null) {
            viewPager.setPageMarginDrawable(d);
        } else {
            super.setPageMarginDrawable(d);
        }
    }

    @Override
    public void setPageMarginDrawable(int resId) {
        if (viewPager != null) {
            viewPager.setPageMarginDrawable(resId);
        } else {
            super.setPageMarginDrawable(resId);
        }
    }

    @Override
    public void setPageTransformer(boolean arg0, PageTransformer arg1) {
        if (viewPager != null) {
            viewPager.setPageTransformer(arg0, arg1);
        } else {
            super.setPageTransformer(arg0, arg1);
        }
    }

    @Override
    @ExportedProperty(category = "focus", mapping = { @IntToString(from = 131072, to = "FOCUS_BEFORE_DESCENDANTS"),
            @IntToString(from = 262144, to = "FOCUS_AFTER_DESCENDANTS"),
            @IntToString(from = 393216, to = "FOCUS_BLOCK_DESCENDANTS") })
    public int getDescendantFocusability() {
        return (viewPager != null) ? viewPager.getDescendantFocusability() : super.getDescendantFocusability();
    }

    @Override
    public void setDescendantFocusability(int focusability) {
        if (viewPager != null) {
            viewPager.setDescendantFocusability(focusability);
        } else {
            super.setDescendantFocusability(focusability);
        }
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        if (viewPager != null) {
            viewPager.requestChildFocus(child, focused);
        } else {
            super.requestChildFocus(child, focused);
        }
    }

    @Override
    public void focusableViewAvailable(View v) {
        if (viewPager != null) {
            viewPager.focusableViewAvailable(v);
        } else {
            super.focusableViewAvailable(v);
        }
    }

    @Override
    public boolean showContextMenuForChild(View originalView) {
        return (viewPager != null) ? viewPager.showContextMenuForChild(originalView) : super
                .showContextMenuForChild(originalView);
    }

    @Override
    public ActionMode startActionModeForChild(View originalView, Callback callback) {
        return (viewPager != null) ? viewPager.startActionModeForChild(originalView, callback) : super
                .startActionModeForChild(originalView, callback);
    }

    @Override
    public View focusSearch(View focused, int direction) {
        return (viewPager != null) ? viewPager.focusSearch(focused, direction) : super.focusSearch(focused, direction);
    }

    @Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        return (viewPager != null) ? viewPager.requestChildRectangleOnScreen(child, rectangle, immediate) : super
                .requestChildRectangleOnScreen(child, rectangle, immediate);
    }

    @Override
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        return (viewPager != null) ? viewPager.requestSendAccessibilityEvent(child, event) : super
                .requestSendAccessibilityEvent(child, event);
    }

    @Override
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        return (viewPager != null) ? viewPager.onRequestSendAccessibilityEvent(child, event) : super
                .onRequestSendAccessibilityEvent(child, event);
    }

    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        return (viewPager != null) ? viewPager.dispatchUnhandledMove(focused, direction) : super.dispatchUnhandledMove(
                focused, direction);
    }

    @Override
    public void clearChildFocus(View child) {
        if (viewPager != null) {
            viewPager.clearChildFocus(child);
        } else {
            super.clearChildFocus(child);
        }
    }

    @Override
    public void clearFocus() {
        if (viewPager != null) {
            viewPager.clearFocus();
        } else {
            super.clearFocus();
        }
    }

    @Override
    public View getFocusedChild() {
        return (viewPager != null) ? viewPager.getFocusedChild() : super.getFocusedChild();
    }

    @Override
    public boolean hasFocus() {
        return (viewPager != null) ? viewPager.hasFocus() : super.hasFocus();
    }

    @Override
    public View findFocus() {
        return (viewPager != null) ? viewPager.findFocus() : super.findFocus();
    }

    @Override
    public boolean hasFocusable() {
        return (viewPager != null) ? viewPager.hasFocusable() : super.hasFocusable();
    }

    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        if (viewPager != null) {
            viewPager.findViewsWithText(outViews, text, flags);
        } else {
            super.findViewsWithText(outViews, text, flags);
        }
    }

    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        if (viewPager != null) {
            viewPager.dispatchWindowFocusChanged(hasFocus);
        } else {
            super.dispatchWindowFocusChanged(hasFocus);
        }
    }

    @Override
    public void dispatchDisplayHint(int hint) {
        if (viewPager != null) {
            viewPager.dispatchDisplayHint(hint);
        } else {
            super.dispatchDisplayHint(hint);
        }
    }

    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        if (viewPager != null) {
            viewPager.dispatchWindowVisibilityChanged(visibility);
        } else {
            super.dispatchWindowVisibilityChanged(visibility);
        }
    }

    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        if (viewPager != null) {
            viewPager.dispatchConfigurationChanged(newConfig);
        } else {
            super.dispatchConfigurationChanged(newConfig);
        }
    }

    @Override
    public void recomputeViewAttributes(View child) {
        if (viewPager != null) {
            viewPager.recomputeViewAttributes(child);
        } else {
            super.recomputeViewAttributes(child);
        }
    }

    @Override
    public void bringChildToFront(View child) {
        if (viewPager != null) {
            viewPager.bringChildToFront(child);
        } else {
            super.bringChildToFront(child);
        }
    }

    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        return (viewPager != null) ? viewPager.dispatchDragEvent(event) : super.dispatchDragEvent(event);
    }

    @Override
    public void dispatchWindowSystemUiVisiblityChanged(int visible) {
        if (viewPager != null) {
            viewPager.dispatchWindowSystemUiVisiblityChanged(visible);
        } else {
            super.dispatchWindowSystemUiVisiblityChanged(visible);
        }
    }

    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        if (viewPager != null) {
            viewPager.dispatchSystemUiVisibilityChanged(visible);
        } else {
            super.dispatchSystemUiVisibilityChanged(visible);
        }
    }

    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        return (viewPager != null) ? viewPager.dispatchKeyEventPreIme(event) : super.dispatchKeyEventPreIme(event);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        return (viewPager != null) ? viewPager.dispatchKeyShortcutEvent(event) : super.dispatchKeyShortcutEvent(event);
    }

    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        return (viewPager != null) ? viewPager.dispatchTrackballEvent(event) : super.dispatchTrackballEvent(event);
    }

    @Override
    public void addChildrenForAccessibility(ArrayList<View> childrenForAccessibility) {
        if (viewPager != null) {
            viewPager.addChildrenForAccessibility(childrenForAccessibility);
        } else {
            super.addChildrenForAccessibility(childrenForAccessibility);
        }
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        return (viewPager != null) ? viewPager.onInterceptHoverEvent(event) : super.onInterceptHoverEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return (viewPager != null) ? viewPager.dispatchTouchEvent(ev) : super.dispatchTouchEvent(ev);
    }

    @Override
    public void setMotionEventSplittingEnabled(boolean split) {
        if (viewPager != null) {
            viewPager.setMotionEventSplittingEnabled(split);
        } else {
            super.setMotionEventSplittingEnabled(split);
        }
    }

    @Override
    public boolean isMotionEventSplittingEnabled() {
        return (viewPager != null) ? viewPager.isMotionEventSplittingEnabled() : super.isMotionEventSplittingEnabled();
    }

    @Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (viewPager != null) {
            viewPager.requestDisallowInterceptTouchEvent(disallowIntercept);
        } else {
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        return (viewPager != null) ? viewPager.requestFocus(direction, previouslyFocusedRect) : super.requestFocus(
                direction, previouslyFocusedRect);
    }

    @Override
    public ViewGroupOverlay getOverlay() {
        return (viewPager != null) ? viewPager.getOverlay() : super.getOverlay();
    }

    @Override
    public boolean getClipChildren() {
        return (viewPager != null) ? viewPager.getClipChildren() : super.getClipChildren();
    }

    @Override
    public void setClipChildren(boolean clipChildren) {
        if (viewPager != null) {
            viewPager.setClipChildren(clipChildren);
        } else {
            super.setClipChildren(clipChildren);
        }
    }

    @Override
    public void setClipToPadding(boolean clipToPadding) {
        if (viewPager != null) {
            viewPager.setClipToPadding(clipToPadding);
        } else {
            super.setClipToPadding(clipToPadding);
        }
    }

    @Override
    public void dispatchSetSelected(boolean selected) {
        if (viewPager != null) {
            viewPager.dispatchSetSelected(selected);
        } else {
            super.dispatchSetSelected(selected);
        }
    }

    @Override
    public void dispatchSetActivated(boolean activated) {
        if (viewPager != null) {
            viewPager.dispatchSetActivated(activated);
        } else {
            super.dispatchSetActivated(activated);
        }
    }

    @Override
    public void addView(View child) {
        if (viewPager != null) {
            viewPager.addView(child);
        } else {
            super.addView(child);
        }
    }

    @Override
    public void addView(View child, int index) {
        if (viewPager != null) {
            viewPager.addView(child, index);
        } else {
            super.addView(child, index);
        }
    }

    @Override
    public void addView(View child, int width, int height) {
        if (viewPager != null) {
            viewPager.addView(child, width, height);
        } else {
            super.addView(child, width, height);
        }
    }

    @Override
    public void addView(View child, android.view.ViewGroup.LayoutParams params) {
        if (viewPager != null) {
            viewPager.addView(child, params);
        } else {
            super.addView(child, params);
        }
    }

    @Override
    public void updateViewLayout(View view, android.view.ViewGroup.LayoutParams params) {
        if (viewPager != null) {
            viewPager.updateViewLayout(view, params);
        } else {
            super.updateViewLayout(view, params);
        }
    }

    @Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        if (viewPager != null) {
            viewPager.setOnHierarchyChangeListener(listener);
        } else {
            super.setOnHierarchyChangeListener(listener);
        }
    }

    @Override
    public void removeViewInLayout(View view) {
        if (viewPager != null) {
            viewPager.removeViewInLayout(view);
        } else {
            super.removeViewInLayout(view);
        }
    }

    @Override
    public void removeViewsInLayout(int start, int count) {
        if (viewPager != null) {
            viewPager.removeViewsInLayout(start, count);
        } else {
            super.removeViewsInLayout(start, count);
        }
    }

    @Override
    public void removeViewAt(int index) {
        if (viewPager != null) {
            viewPager.removeViewAt(index);
        } else {
            super.removeViewAt(index);
        }
    }

    @Override
    public void removeViews(int start, int count) {
        if (viewPager != null) {
            viewPager.removeViews(start, count);
        } else {
            super.removeViews(start, count);
        }
    }

    @Override
    public void setLayoutTransition(LayoutTransition transition) {
        if (viewPager != null) {
            viewPager.setLayoutTransition(transition);
        } else {
            super.setLayoutTransition(transition);
        }
    }

    @Override
    public LayoutTransition getLayoutTransition() {
        return (viewPager != null) ? viewPager.getLayoutTransition() : super.getLayoutTransition();
    }

    @Override
    public void removeAllViews() {
        if (viewPager != null) {
            viewPager.removeAllViews();
        } else {
            super.removeAllViews();
        }
    }

    @Override
    public void removeAllViewsInLayout() {
        if (viewPager != null) {
            viewPager.removeAllViewsInLayout();
        } else {
            super.removeAllViewsInLayout();
        }
    }

    @Override
    public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
        return (viewPager != null) ? viewPager.invalidateChildInParent(location, dirty) : super
                .invalidateChildInParent(location, dirty);
    }

    @Override
    public boolean getChildVisibleRect(View child, Rect r, Point offset) {
        return (viewPager != null) ? viewPager.getChildVisibleRect(child, r, offset) : super.getChildVisibleRect(child,
                r, offset);
    }

    @Override
    public void startLayoutAnimation() {
        if (viewPager != null) {
            viewPager.startLayoutAnimation();
        } else {
            super.startLayoutAnimation();
        }
    }

    @Override
    public void scheduleLayoutAnimation() {
        if (viewPager != null) {
            viewPager.scheduleLayoutAnimation();
        } else {
            super.scheduleLayoutAnimation();
        }
    }

    @Override
    public void setLayoutAnimation(LayoutAnimationController controller) {
        if (viewPager != null) {
            viewPager.setLayoutAnimation(controller);
        } else {
            super.setLayoutAnimation(controller);
        }
    }

    @Override
    public LayoutAnimationController getLayoutAnimation() {
        return (viewPager != null) ? viewPager.getLayoutAnimation() : super.getLayoutAnimation();
    }

    @Override
    @ExportedProperty
    public boolean isAnimationCacheEnabled() {
        return (viewPager != null) ? viewPager.isAnimationCacheEnabled() : super.isAnimationCacheEnabled();
    }

    @Override
    public void setAnimationCacheEnabled(boolean enabled) {
        if (viewPager != null) {
            viewPager.setAnimationCacheEnabled(enabled);
        } else {
            super.setAnimationCacheEnabled(enabled);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public boolean isAlwaysDrawnWithCacheEnabled() {
        return (viewPager != null) ? viewPager.isAlwaysDrawnWithCacheEnabled() : super.isAlwaysDrawnWithCacheEnabled();
    }

    @Override
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        if (viewPager != null) {
            viewPager.setAlwaysDrawnWithCacheEnabled(always);
        } else {
            super.setAlwaysDrawnWithCacheEnabled(always);
        }
    }

    @Override
    @ExportedProperty(category = "drawing", mapping = { @IntToString(from = 0, to = "NONE"),
            @IntToString(from = 1, to = "ANIMATION"), @IntToString(from = 2, to = "SCROLLING"),
            @IntToString(from = 3, to = "ALL") })
    public int getPersistentDrawingCache() {
        return (viewPager != null) ? viewPager.getPersistentDrawingCache() : super.getPersistentDrawingCache();
    }

    @Override
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        if (viewPager != null) {
            viewPager.setPersistentDrawingCache(drawingCacheToKeep);
        } else {
            super.setPersistentDrawingCache(drawingCacheToKeep);
        }
    }

    @Override
    public int getLayoutMode() {
        return (viewPager != null) ? viewPager.getLayoutMode() : super.getLayoutMode();
    }

    @Override
    public void setLayoutMode(int layoutMode) {
        if (viewPager != null) {
            viewPager.setLayoutMode(layoutMode);
        } else {
            super.setLayoutMode(layoutMode);
        }
    }

    @Override
    public int indexOfChild(View child) {
        return (viewPager != null) ? viewPager.indexOfChild(child) : super.indexOfChild(child);
    }

    @Override
    public int getChildCount() {
        return (viewPager != null) ? viewPager.getChildCount() : super.getChildCount();
    }

    @Override
    public View getChildAt(int index) {
        return (viewPager != null) ? viewPager.getChildAt(index) : super.getChildAt(index);
    }

    @Override
    public void clearDisappearingChildren() {
        if (viewPager != null) {
            viewPager.clearDisappearingChildren();
        } else {
            super.clearDisappearingChildren();
        }
    }

    @Override
    public void startViewTransition(View view) {
        if (viewPager != null) {
            viewPager.startViewTransition(view);
        } else {
            super.startViewTransition(view);
        }
    }

    @Override
    public void endViewTransition(View view) {
        if (viewPager != null) {
            viewPager.endViewTransition(view);
        } else {
            super.endViewTransition(view);
        }
    }

    @Override
    public boolean gatherTransparentRegion(Region region) {
        return (viewPager != null) ? viewPager.gatherTransparentRegion(region) : super.gatherTransparentRegion(region);
    }

    @Override
    public void requestTransparentRegion(View child) {
        if (viewPager != null) {
            viewPager.requestTransparentRegion(child);
        } else {
            super.requestTransparentRegion(child);
        }
    }

    @Override
    public AnimationListener getLayoutAnimationListener() {
        return (viewPager != null) ? viewPager.getLayoutAnimationListener() : super.getLayoutAnimationListener();
    }

    @Override
    public void jumpDrawablesToCurrentState() {
        if (viewPager != null) {
            viewPager.jumpDrawablesToCurrentState();
        } else {
            super.jumpDrawablesToCurrentState();
        }
    }

    @Override
    public void setAddStatesFromChildren(boolean addsStates) {
        if (viewPager != null) {
            viewPager.setAddStatesFromChildren(addsStates);
        } else {
            super.setAddStatesFromChildren(addsStates);
        }
    }

    @Override
    public boolean addStatesFromChildren() {
        return (viewPager != null) ? viewPager.addStatesFromChildren() : super.addStatesFromChildren();
    }

    @Override
    public void childDrawableStateChanged(View child) {
        if (viewPager != null) {
            viewPager.childDrawableStateChanged(child);
        } else {
            super.childDrawableStateChanged(child);
        }
    }

    @Override
    public void setLayoutAnimationListener(AnimationListener animationListener) {
        if (viewPager != null) {
            viewPager.setLayoutAnimationListener(animationListener);
        } else {
            super.setLayoutAnimationListener(animationListener);
        }
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return (viewPager != null) ? viewPager.shouldDelayChildPressedState() : super.shouldDelayChildPressedState();
    }

    @Override
    public String toString() {
        return (viewPager != null) ? viewPager.toString() : super.toString();
    }

    @Override
    public int getVerticalFadingEdgeLength() {
        return (viewPager != null) ? viewPager.getVerticalFadingEdgeLength() : super.getVerticalFadingEdgeLength();
    }

    @Override
    public void setFadingEdgeLength(int length) {
        if (viewPager != null) {
            viewPager.setFadingEdgeLength(length);
        } else {
            super.setFadingEdgeLength(length);
        }
    }

    @Override
    public int getHorizontalFadingEdgeLength() {
        return (viewPager != null) ? viewPager.getHorizontalFadingEdgeLength() : super.getHorizontalFadingEdgeLength();
    }

    @Override
    public int getVerticalScrollbarWidth() {
        return (viewPager != null) ? viewPager.getVerticalScrollbarWidth() : super.getVerticalScrollbarWidth();
    }

    @Override
    public void setVerticalScrollbarPosition(int position) {
        if (viewPager != null) {
            viewPager.setVerticalScrollbarPosition(position);
        } else {
            super.setVerticalScrollbarPosition(position);
        }
    }

    @Override
    public int getVerticalScrollbarPosition() {
        return (viewPager != null) ? viewPager.getVerticalScrollbarPosition() : super.getVerticalScrollbarPosition();
    }

    @Override
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        if (viewPager != null) {
            viewPager.setOnFocusChangeListener(l);
        } else {
            super.setOnFocusChangeListener(l);
        }
    }

    @Override
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        if (viewPager != null) {
            viewPager.addOnLayoutChangeListener(listener);
        } else {
            super.addOnLayoutChangeListener(listener);
        }
    }

    @Override
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        if (viewPager != null) {
            viewPager.removeOnLayoutChangeListener(listener);
        } else {
            super.removeOnLayoutChangeListener(listener);
        }
    }

    @Override
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        if (viewPager != null) {
            viewPager.addOnAttachStateChangeListener(listener);
        } else {
            super.addOnAttachStateChangeListener(listener);
        }
    }

    @Override
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        if (viewPager != null) {
            viewPager.removeOnAttachStateChangeListener(listener);
        } else {
            super.removeOnAttachStateChangeListener(listener);
        }
    }

    @Override
    public OnFocusChangeListener getOnFocusChangeListener() {
        return (viewPager != null) ? viewPager.getOnFocusChangeListener() : super.getOnFocusChangeListener();
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        if (viewPager != null) {
            viewPager.setOnClickListener(l);
        } else {
            super.setOnClickListener(l);
        }
    }

    @Override
    public boolean hasOnClickListeners() {
        return (viewPager != null) ? viewPager.hasOnClickListeners() : super.hasOnClickListeners();
    }

    @Override
    public void setOnLongClickListener(OnLongClickListener l) {
        if (viewPager != null) {
            viewPager.setOnLongClickListener(l);
        } else {
            super.setOnLongClickListener(l);
        }
    }

    @Override
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        if (viewPager != null) {
            viewPager.setOnCreateContextMenuListener(l);
        } else {
            super.setOnCreateContextMenuListener(l);
        }
    }

    @Override
    public boolean performClick() {
        return (viewPager != null) ? viewPager.performClick() : super.performClick();
    }

    @Override
    public boolean callOnClick() {
        return (viewPager != null) ? viewPager.callOnClick() : super.callOnClick();
    }

    @Override
    public boolean performLongClick() {
        return (viewPager != null) ? viewPager.performLongClick() : super.performLongClick();
    }

    @Override
    public boolean showContextMenu() {
        return (viewPager != null) ? viewPager.showContextMenu() : super.showContextMenu();
    }

    @Override
    public ActionMode startActionMode(Callback callback) {
        return (viewPager != null) ? viewPager.startActionMode(callback) : super.startActionMode(callback);
    }

    @Override
    public void setOnKeyListener(OnKeyListener l) {
        if (viewPager != null) {
            viewPager.setOnKeyListener(l);
        } else {
            super.setOnKeyListener(l);
        }
    }

    @Override
    public void setOnTouchListener(OnTouchListener l) {
        if (viewPager != null) {
            viewPager.setOnTouchListener(l);
        } else {
            super.setOnTouchListener(l);
        }
    }

    @Override
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        if (viewPager != null) {
            viewPager.setOnGenericMotionListener(l);
        } else {
            super.setOnGenericMotionListener(l);
        }
    }

    @Override
    public void setOnHoverListener(OnHoverListener l) {
        if (viewPager != null) {
            viewPager.setOnHoverListener(l);
        } else {
            super.setOnHoverListener(l);
        }
    }

    @Override
    public void setOnDragListener(OnDragListener l) {
        if (viewPager != null) {
            viewPager.setOnDragListener(l);
        } else {
            super.setOnDragListener(l);
        }
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle) {
        return (viewPager != null) ? viewPager.requestRectangleOnScreen(rectangle) : super
                .requestRectangleOnScreen(rectangle);
    }

    @Override
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        return (viewPager != null) ? viewPager.requestRectangleOnScreen(rectangle, immediate) : super
                .requestRectangleOnScreen(rectangle, immediate);
    }

    @Override
    public void sendAccessibilityEvent(int eventType) {
        if (viewPager != null) {
            viewPager.sendAccessibilityEvent(eventType);
        } else {
            super.sendAccessibilityEvent(eventType);
        }
    }

    @Override
    public void announceForAccessibility(CharSequence text) {
        if (viewPager != null) {
            viewPager.announceForAccessibility(text);
        } else {
            super.announceForAccessibility(text);
        }
    }

    @Override
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        if (viewPager != null) {
            viewPager.sendAccessibilityEventUnchecked(event);
        } else {
            super.sendAccessibilityEventUnchecked(event);
        }
    }

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        if (viewPager != null) {
            viewPager.onPopulateAccessibilityEvent(event);
        } else {
            super.onPopulateAccessibilityEvent(event);
        }
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        if (viewPager != null) {
            viewPager.onInitializeAccessibilityEvent(event);
        } else {
            super.onInitializeAccessibilityEvent(event);
        }
    }

    @Override
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        return (viewPager != null) ? viewPager.createAccessibilityNodeInfo() : super.createAccessibilityNodeInfo();
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        if (viewPager != null) {
            viewPager.onInitializeAccessibilityNodeInfo(info);
        } else {
            super.onInitializeAccessibilityNodeInfo(info);
        }
    }

    @Override
    public void setAccessibilityDelegate(AccessibilityDelegate delegate) {
        if (viewPager != null) {
            viewPager.setAccessibilityDelegate(delegate);
        } else {
            super.setAccessibilityDelegate(delegate);
        }
    }

    @Override
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        return (viewPager != null) ? viewPager.getAccessibilityNodeProvider() : super.getAccessibilityNodeProvider();
    }

    @Override
    @ExportedProperty(category = "accessibility")
    public CharSequence getContentDescription() {
        return (viewPager != null) ? viewPager.getContentDescription() : super.getContentDescription();
    }

    @Override
    public void setContentDescription(CharSequence contentDescription) {
        if (viewPager != null) {
            viewPager.setContentDescription(contentDescription);
        } else {
            super.setContentDescription(contentDescription);
        }
    }

    @Override
    @ExportedProperty(category = "accessibility")
    public int getLabelFor() {
        return (viewPager != null) ? viewPager.getLabelFor() : super.getLabelFor();
    }

    @Override
    public void setLabelFor(int id) {
        if (viewPager != null) {
            viewPager.setLabelFor(id);
        } else {
            super.setLabelFor(id);
        }
    }

    @Override
    @ExportedProperty(category = "focus")
    public boolean isFocused() {
        return (viewPager != null) ? viewPager.isFocused() : super.isFocused();
    }

    @Override
    public boolean isScrollContainer() {
        return (viewPager != null) ? viewPager.isScrollContainer() : super.isScrollContainer();
    }

    @Override
    public void setScrollContainer(boolean isScrollContainer) {
        if (viewPager != null) {
            viewPager.setScrollContainer(isScrollContainer);
        } else {
            super.setScrollContainer(isScrollContainer);
        }
    }

    @Override
    public int getDrawingCacheQuality() {
        return (viewPager != null) ? viewPager.getDrawingCacheQuality() : super.getDrawingCacheQuality();
    }

    @Override
    public void setDrawingCacheQuality(int quality) {
        if (viewPager != null) {
            viewPager.setDrawingCacheQuality(quality);
        } else {
            super.setDrawingCacheQuality(quality);
        }
    }

    @Override
    public boolean getKeepScreenOn() {
        return (viewPager != null) ? viewPager.getKeepScreenOn() : super.getKeepScreenOn();
    }

    @Override
    public void setKeepScreenOn(boolean keepScreenOn) {
        if (viewPager != null) {
            viewPager.setKeepScreenOn(keepScreenOn);
        } else {
            super.setKeepScreenOn(keepScreenOn);
        }
    }

    @Override
    public int getNextFocusLeftId() {
        return (viewPager != null) ? viewPager.getNextFocusLeftId() : super.getNextFocusLeftId();
    }

    @Override
    public void setNextFocusLeftId(int nextFocusLeftId) {
        if (viewPager != null) {
            viewPager.setNextFocusLeftId(nextFocusLeftId);
        } else {
            super.setNextFocusLeftId(nextFocusLeftId);
        }
    }

    @Override
    public int getNextFocusRightId() {
        return (viewPager != null) ? viewPager.getNextFocusRightId() : super.getNextFocusRightId();
    }

    @Override
    public void setNextFocusRightId(int nextFocusRightId) {
        if (viewPager != null) {
            viewPager.setNextFocusRightId(nextFocusRightId);
        } else {
            super.setNextFocusRightId(nextFocusRightId);
        }
    }

    @Override
    public int getNextFocusUpId() {
        return (viewPager != null) ? viewPager.getNextFocusUpId() : super.getNextFocusUpId();
    }

    @Override
    public void setNextFocusUpId(int nextFocusUpId) {
        if (viewPager != null) {
            viewPager.setNextFocusUpId(nextFocusUpId);
        } else {
            super.setNextFocusUpId(nextFocusUpId);
        }
    }

    @Override
    public int getNextFocusDownId() {
        return (viewPager != null) ? viewPager.getNextFocusDownId() : super.getNextFocusDownId();
    }

    @Override
    public void setNextFocusDownId(int nextFocusDownId) {
        if (viewPager != null) {
            viewPager.setNextFocusDownId(nextFocusDownId);
        } else {
            super.setNextFocusDownId(nextFocusDownId);
        }
    }

    @Override
    public int getNextFocusForwardId() {
        return (viewPager != null) ? viewPager.getNextFocusForwardId() : super.getNextFocusForwardId();
    }

    @Override
    public void setNextFocusForwardId(int nextFocusForwardId) {
        if (viewPager != null) {
            viewPager.setNextFocusForwardId(nextFocusForwardId);
        } else {
            super.setNextFocusForwardId(nextFocusForwardId);
        }
    }

    @Override
    public boolean isShown() {
        return (viewPager != null) ? viewPager.isShown() : super.isShown();
    }

    @Override
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        if (viewPager != null) {
            viewPager.setFitsSystemWindows(fitSystemWindows);
        } else {
            super.setFitsSystemWindows(fitSystemWindows);
        }
    }

    @Override
    public boolean getFitsSystemWindows() {
        return (viewPager != null) ? viewPager.getFitsSystemWindows() : super.getFitsSystemWindows();
    }

    @Override
    public void requestFitSystemWindows() {
        if (viewPager != null) {
            viewPager.requestFitSystemWindows();
        } else {
            super.requestFitSystemWindows();
        }
    }

    @Override
    @ExportedProperty(mapping = { @IntToString(from = 0, to = "VISIBLE"), @IntToString(from = 4, to = "INVISIBLE"),
            @IntToString(from = 8, to = "GONE") })
    public int getVisibility() {
        return (viewPager != null) ? viewPager.getVisibility() : super.getVisibility();
    }

    @Override
    public void setVisibility(int visibility) {
        if (viewPager != null) {
            viewPager.setVisibility(visibility);
        } else {
            super.setVisibility(visibility);
        }
    }

    @Override
    @ExportedProperty
    public boolean isEnabled() {
        return (viewPager != null) ? viewPager.isEnabled() : super.isEnabled();
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (viewPager != null) {
            viewPager.setEnabled(enabled);
        } else {
            super.setEnabled(enabled);
        }
    }

    @Override
    public void setFocusable(boolean focusable) {
        if (viewPager != null) {
            viewPager.setFocusable(focusable);
        } else {
            super.setFocusable(focusable);
        }
    }

    @Override
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        if (viewPager != null) {
            viewPager.setFocusableInTouchMode(focusableInTouchMode);
        } else {
            super.setFocusableInTouchMode(focusableInTouchMode);
        }
    }

    @Override
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        if (viewPager != null) {
            viewPager.setSoundEffectsEnabled(soundEffectsEnabled);
        } else {
            super.setSoundEffectsEnabled(soundEffectsEnabled);
        }
    }

    @Override
    @ExportedProperty
    public boolean isSoundEffectsEnabled() {
        return (viewPager != null) ? viewPager.isSoundEffectsEnabled() : super.isSoundEffectsEnabled();
    }

    @Override
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        if (viewPager != null) {
            viewPager.setHapticFeedbackEnabled(hapticFeedbackEnabled);
        } else {
            super.setHapticFeedbackEnabled(hapticFeedbackEnabled);
        }
    }

    @Override
    @ExportedProperty
    public boolean isHapticFeedbackEnabled() {
        return (viewPager != null) ? viewPager.isHapticFeedbackEnabled() : super.isHapticFeedbackEnabled();
    }

    @Override
    public void setLayoutDirection(int layoutDirection) {
        if (viewPager != null) {
            viewPager.setLayoutDirection(layoutDirection);
        } else {
            super.setLayoutDirection(layoutDirection);
        }
    }

    @Override
    @ExportedProperty(category = "layout", mapping = { @IntToString(from = 0, to = "RESOLVED_DIRECTION_LTR"),
            @IntToString(from = 1, to = "RESOLVED_DIRECTION_RTL") })
    public int getLayoutDirection() {
        return (viewPager != null) ? viewPager.getLayoutDirection() : super.getLayoutDirection();
    }

    @Override
    @ExportedProperty(category = "layout")
    public boolean hasTransientState() {
        return (viewPager != null) ? viewPager.hasTransientState() : super.hasTransientState();
    }

    @Override
    public void setHasTransientState(boolean hasTransientState) {
        if (viewPager != null) {
            viewPager.setHasTransientState(hasTransientState);
        } else {
            super.setHasTransientState(hasTransientState);
        }
    }

    @Override
    public void setWillNotDraw(boolean willNotDraw) {
        if (viewPager != null) {
            viewPager.setWillNotDraw(willNotDraw);
        } else {
            super.setWillNotDraw(willNotDraw);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public boolean willNotDraw() {
        return (viewPager != null) ? viewPager.willNotDraw() : super.willNotDraw();
    }

    @Override
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        if (viewPager != null) {
            viewPager.setWillNotCacheDrawing(willNotCacheDrawing);
        } else {
            super.setWillNotCacheDrawing(willNotCacheDrawing);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public boolean willNotCacheDrawing() {
        return (viewPager != null) ? viewPager.willNotCacheDrawing() : super.willNotCacheDrawing();
    }

    @Override
    @ExportedProperty
    public boolean isClickable() {
        return (viewPager != null) ? viewPager.isClickable() : super.isClickable();
    }

    @Override
    public void setClickable(boolean clickable) {
        if (viewPager != null) {
            viewPager.setClickable(clickable);
        } else {
            super.setClickable(clickable);
        }
    }

    @Override
    public boolean isLongClickable() {
        return (viewPager != null) ? viewPager.isLongClickable() : super.isLongClickable();
    }

    @Override
    public void setLongClickable(boolean longClickable) {
        if (viewPager != null) {
            viewPager.setLongClickable(longClickable);
        } else {
            super.setLongClickable(longClickable);
        }
    }

    @Override
    public void setPressed(boolean pressed) {
        if (viewPager != null) {
            viewPager.setPressed(pressed);
        } else {
            super.setPressed(pressed);
        }
    }

    @Override
    public boolean isPressed() {
        return (viewPager != null) ? viewPager.isPressed() : super.isPressed();
    }

    @Override
    public boolean isSaveEnabled() {
        return (viewPager != null) ? viewPager.isSaveEnabled() : super.isSaveEnabled();
    }

    @Override
    public void setSaveEnabled(boolean enabled) {
        if (viewPager != null) {
            viewPager.setSaveEnabled(enabled);
        } else {
            super.setSaveEnabled(enabled);
        }
    }

    @Override
    @ExportedProperty
    public boolean getFilterTouchesWhenObscured() {
        return (viewPager != null) ? viewPager.getFilterTouchesWhenObscured() : super.getFilterTouchesWhenObscured();
    }

    @Override
    public void setFilterTouchesWhenObscured(boolean enabled) {
        if (viewPager != null) {
            viewPager.setFilterTouchesWhenObscured(enabled);
        } else {
            super.setFilterTouchesWhenObscured(enabled);
        }
    }

    @Override
    public boolean isSaveFromParentEnabled() {
        return (viewPager != null) ? viewPager.isSaveFromParentEnabled() : super.isSaveFromParentEnabled();
    }

    @Override
    public void setSaveFromParentEnabled(boolean enabled) {
        if (viewPager != null) {
            viewPager.setSaveFromParentEnabled(enabled);
        } else {
            super.setSaveFromParentEnabled(enabled);
        }
    }

    @Override
    public View focusSearch(int direction) {
        return (viewPager != null) ? viewPager.focusSearch(direction) : super.focusSearch(direction);
    }

    @Override
    public ArrayList<View> getFocusables(int direction) {
        return (viewPager != null) ? viewPager.getFocusables(direction) : super.getFocusables(direction);
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        if (viewPager != null) {
            viewPager.addFocusables(views, direction);
        } else {
            super.addFocusables(views, direction);
        }
    }

    @Override
    public ArrayList<View> getTouchables() {
        return (viewPager != null) ? viewPager.getTouchables() : super.getTouchables();
    }

    @Override
    @ExportedProperty(category = "accessibility", mapping = { @IntToString(from = 0, to = "auto"),
            @IntToString(from = 1, to = "yes"), @IntToString(from = 2, to = "no") })
    public int getImportantForAccessibility() {
        return (viewPager != null) ? viewPager.getImportantForAccessibility() : super.getImportantForAccessibility();
    }

    @Override
    public void setImportantForAccessibility(int mode) {
        if (viewPager != null) {
            viewPager.setImportantForAccessibility(mode);
        } else {
            super.setImportantForAccessibility(mode);
        }
    }

    @Override
    public ViewParent getParentForAccessibility() {
        return (viewPager != null) ? viewPager.getParentForAccessibility() : super.getParentForAccessibility();
    }

    @Override
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        return (viewPager != null) ? viewPager.performAccessibilityAction(action, arguments) : super
                .performAccessibilityAction(action, arguments);
    }

    @Override
    public void onStartTemporaryDetach() {
        if (viewPager != null) {
            viewPager.onStartTemporaryDetach();
        } else {
            super.onStartTemporaryDetach();
        }
    }

    @Override
    public void onFinishTemporaryDetach() {
        if (viewPager != null) {
            viewPager.onFinishTemporaryDetach();
        } else {
            super.onFinishTemporaryDetach();
        }
    }

    @Override
    public DispatcherState getKeyDispatcherState() {
        return (viewPager != null) ? viewPager.getKeyDispatcherState() : super.getKeyDispatcherState();
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        return (viewPager != null) ? viewPager.onFilterTouchEventForSecurity(event) : super
                .onFilterTouchEventForSecurity(event);
    }

    @Override
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        return (viewPager != null) ? viewPager.dispatchGenericMotionEvent(event) : super
                .dispatchGenericMotionEvent(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (viewPager != null) {
            viewPager.onWindowFocusChanged(hasWindowFocus);
        } else {
            super.onWindowFocusChanged(hasWindowFocus);
        }
    }

    @Override
    public boolean hasWindowFocus() {
        return (viewPager != null) ? viewPager.hasWindowFocus() : super.hasWindowFocus();
    }

    @Override
    public int getWindowVisibility() {
        return (viewPager != null) ? viewPager.getWindowVisibility() : super.getWindowVisibility();
    }

    @Override
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        if (viewPager != null) {
            viewPager.getWindowVisibleDisplayFrame(outRect);
        } else {
            super.getWindowVisibleDisplayFrame(outRect);
        }
    }

    @Override
    @ExportedProperty
    public boolean isInTouchMode() {
        return (viewPager != null) ? viewPager.isInTouchMode() : super.isInTouchMode();
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        return (viewPager != null) ? viewPager.onKeyPreIme(keyCode, event) : super.onKeyPreIme(keyCode, event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return (viewPager != null) ? viewPager.onKeyDown(keyCode, event) : super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return (viewPager != null) ? viewPager.onKeyLongPress(keyCode, event) : super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return (viewPager != null) ? viewPager.onKeyUp(keyCode, event) : super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        return (viewPager != null) ? viewPager.onKeyMultiple(keyCode, repeatCount, event) : super.onKeyMultiple(
                keyCode, repeatCount, event);
    }

    @Override
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        return (viewPager != null) ? viewPager.onKeyShortcut(keyCode, event) : super.onKeyShortcut(keyCode, event);
    }

    @Override
    public boolean onCheckIsTextEditor() {
        return (viewPager != null) ? viewPager.onCheckIsTextEditor() : super.onCheckIsTextEditor();
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        return (viewPager != null) ? viewPager.onCreateInputConnection(outAttrs) : super
                .onCreateInputConnection(outAttrs);
    }

    @Override
    public boolean checkInputConnectionProxy(View view) {
        return (viewPager != null) ? viewPager.checkInputConnectionProxy(view) : super.checkInputConnectionProxy(view);
    }

    @Override
    public void createContextMenu(ContextMenu menu) {
        if (viewPager != null) {
            viewPager.createContextMenu(menu);
        } else {
            super.createContextMenu(menu);
        }
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        return (viewPager != null) ? viewPager.onTrackballEvent(event) : super.onTrackballEvent(event);
    }

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        return (viewPager != null) ? viewPager.onGenericMotionEvent(event) : super.onGenericMotionEvent(event);
    }

    @Override
    public boolean onHoverEvent(MotionEvent event) {
        return (viewPager != null) ? viewPager.onHoverEvent(event) : super.onHoverEvent(event);
    }

    @Override
    @ExportedProperty
    public boolean isHovered() {
        return (viewPager != null) ? viewPager.isHovered() : super.isHovered();
    }

    @Override
    public void setHovered(boolean hovered) {
        if (viewPager != null) {
            viewPager.setHovered(hovered);
        } else {
            super.setHovered(hovered);
        }
    }

    @Override
    public void onHoverChanged(boolean hovered) {
        if (viewPager != null) {
            viewPager.onHoverChanged(hovered);
        } else {
            super.onHoverChanged(hovered);
        }
    }

    @Override
    public void cancelLongPress() {
        if (viewPager != null) {
            viewPager.cancelLongPress();
        } else {
            super.cancelLongPress();
        }
    }

    @Override
    public void setTouchDelegate(TouchDelegate delegate) {
        if (viewPager != null) {
            viewPager.setTouchDelegate(delegate);
        } else {
            super.setTouchDelegate(delegate);
        }
    }

    @Override
    public TouchDelegate getTouchDelegate() {
        return (viewPager != null) ? viewPager.getTouchDelegate() : super.getTouchDelegate();
    }

    @Override
    public void bringToFront() {
        if (viewPager != null) {
            viewPager.bringToFront();
        } else {
            super.bringToFront();
        }
    }

    @Override
    public void setScrollX(int value) {
        if (viewPager != null) {
            viewPager.setScrollX(value);
        } else {
            super.setScrollX(value);
        }
    }

    @Override
    public void setScrollY(int value) {
        if (viewPager != null) {
            viewPager.setScrollY(value);
        } else {
            super.setScrollY(value);
        }
    }

    @Override
    public void getDrawingRect(Rect outRect) {
        if (viewPager != null) {
            viewPager.getDrawingRect(outRect);
        } else {
            super.getDrawingRect(outRect);
        }
    }

    @Override
    public Matrix getMatrix() {
        return (viewPager != null) ? viewPager.getMatrix() : super.getMatrix();
    }

    @Override
    public float getCameraDistance() {
        return (viewPager != null) ? viewPager.getCameraDistance() : super.getCameraDistance();
    }

    @Override
    public void setCameraDistance(float distance) {
        if (viewPager != null) {
            viewPager.setCameraDistance(distance);
        } else {
            super.setCameraDistance(distance);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getRotation() {
        return (viewPager != null) ? viewPager.getRotation() : super.getRotation();
    }

    @Override
    public void setRotation(float rotation) {
        if (viewPager != null) {
            viewPager.setRotation(rotation);
        } else {
            super.setRotation(rotation);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getRotationY() {
        return (viewPager != null) ? viewPager.getRotationY() : super.getRotationY();
    }

    @Override
    public void setRotationY(float rotationY) {
        if (viewPager != null) {
            viewPager.setRotationY(rotationY);
        } else {
            super.setRotationY(rotationY);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getRotationX() {
        return (viewPager != null) ? viewPager.getRotationX() : super.getRotationX();
    }

    @Override
    public void setRotationX(float rotationX) {
        if (viewPager != null) {
            viewPager.setRotationX(rotationX);
        } else {
            super.setRotationX(rotationX);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getScaleX() {
        return (viewPager != null) ? viewPager.getScaleX() : super.getScaleX();
    }

    @Override
    public void setScaleX(float scaleX) {
        if (viewPager != null) {
            viewPager.setScaleX(scaleX);
        } else {
            super.setScaleX(scaleX);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getScaleY() {
        return (viewPager != null) ? viewPager.getScaleY() : super.getScaleY();
    }

    @Override
    public void setScaleY(float scaleY) {
        if (viewPager != null) {
            viewPager.setScaleY(scaleY);
        } else {
            super.setScaleY(scaleY);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getPivotX() {
        return (viewPager != null) ? viewPager.getPivotX() : super.getPivotX();
    }

    @Override
    public void setPivotX(float pivotX) {
        if (viewPager != null) {
            viewPager.setPivotX(pivotX);
        } else {
            super.setPivotX(pivotX);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getPivotY() {
        return (viewPager != null) ? viewPager.getPivotY() : super.getPivotY();
    }

    @Override
    public void setPivotY(float pivotY) {
        if (viewPager != null) {
            viewPager.setPivotY(pivotY);
        } else {
            super.setPivotY(pivotY);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getAlpha() {
        return (viewPager != null) ? viewPager.getAlpha() : super.getAlpha();
    }

    @Override
    public boolean hasOverlappingRendering() {
        return (viewPager != null) ? viewPager.hasOverlappingRendering() : super.hasOverlappingRendering();
    }

    @Override
    public void setAlpha(float alpha) {
        if (viewPager != null) {
            viewPager.setAlpha(alpha);
        } else {
            super.setAlpha(alpha);
        }
    }

    @Override
    public boolean isDirty() {
        return (viewPager != null) ? viewPager.isDirty() : super.isDirty();
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getX() {
        return (viewPager != null) ? viewPager.getX() : super.getX();
    }

    @Override
    public void setX(float x) {
        if (viewPager != null) {
            viewPager.setX(x);
        } else {
            super.setX(x);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getY() {
        return (viewPager != null) ? viewPager.getY() : super.getY();
    }

    @Override
    public void setY(float y) {
        if (viewPager != null) {
            viewPager.setY(y);
        } else {
            super.setY(y);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getTranslationX() {
        return (viewPager != null) ? viewPager.getTranslationX() : super.getTranslationX();
    }

    @Override
    public void setTranslationX(float translationX) {
        if (viewPager != null) {
            viewPager.setTranslationX(translationX);
        } else {
            super.setTranslationX(translationX);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public float getTranslationY() {
        return (viewPager != null) ? viewPager.getTranslationY() : super.getTranslationY();
    }

    @Override
    public void setTranslationY(float translationY) {
        if (viewPager != null) {
            viewPager.setTranslationY(translationY);
        } else {
            super.setTranslationY(translationY);
        }
    }

    @Override
    public void getHitRect(Rect outRect) {
        if (viewPager != null) {
            viewPager.getHitRect(outRect);
        } else {
            super.getHitRect(outRect);
        }
    }

    @Override
    public void getFocusedRect(Rect r) {
        if (viewPager != null) {
            viewPager.getFocusedRect(r);
        } else {
            super.getFocusedRect(r);
        }
    }

    @Override
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        return (viewPager != null) ? viewPager.getGlobalVisibleRect(r, globalOffset) : super.getGlobalVisibleRect(r,
                globalOffset);
    }

    @Override
    public void offsetTopAndBottom(int offset) {
        if (viewPager != null) {
            viewPager.offsetTopAndBottom(offset);
        } else {
            super.offsetTopAndBottom(offset);
        }
    }

    @Override
    public void offsetLeftAndRight(int offset) {
        if (viewPager != null) {
            viewPager.offsetLeftAndRight(offset);
        } else {
            super.offsetLeftAndRight(offset);
        }
    }

    @Override
    @ExportedProperty(deepExport = true, prefix = "layout_")
    public android.view.ViewGroup.LayoutParams getLayoutParams() {
        return (viewPager != null) ? viewPager.getLayoutParams() : super.getLayoutParams();
    }

    @Override
    public void setLayoutParams(android.view.ViewGroup.LayoutParams params) {
        if (viewPager != null) {
            viewPager.setLayoutParams(params);
        } else {
            super.setLayoutParams(params);
        }
    }

    @Override
    public void scrollTo(int x, int y) {
        if (viewPager != null) {
            viewPager.scrollTo(x, y);
        } else {
            super.scrollTo(x, y);
        }
    }

    @Override
    public void scrollBy(int x, int y) {
        if (viewPager != null) {
            viewPager.scrollBy(x, y);
        } else {
            super.scrollBy(x, y);
        }
    }

    @Override
    public void invalidate(Rect dirty) {
        if (viewPager != null) {
            viewPager.invalidate(dirty);
        } else {
            super.invalidate(dirty);
        }
    }

    @Override
    public void invalidate(int l, int t, int r, int b) {
        if (viewPager != null) {
            viewPager.invalidate(l, t, r, b);
        } else {
            super.invalidate(l, t, r, b);
        }
    }

    @Override
    public void invalidate() {
        if (viewPager != null) {
            viewPager.invalidate();
        } else {
            super.invalidate();
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public boolean isOpaque() {
        return (viewPager != null) ? viewPager.isOpaque() : super.isOpaque();
    }

    @Override
    public Handler getHandler() {
        return (viewPager != null) ? viewPager.getHandler() : super.getHandler();
    }

    @Override
    public boolean post(Runnable action) {
        return (viewPager != null) ? viewPager.post(action) : super.post(action);
    }

    @Override
    public boolean postDelayed(Runnable action, long delayMillis) {
        return (viewPager != null) ? viewPager.postDelayed(action, delayMillis) : super
                .postDelayed(action, delayMillis);
    }

    @Override
    public void postOnAnimation(Runnable action) {
        if (viewPager != null) {
            viewPager.postOnAnimation(action);
        } else {
            super.postOnAnimation(action);
        }
    }

    @Override
    public void postOnAnimationDelayed(Runnable action, long delayMillis) {
        if (viewPager != null) {
            viewPager.postOnAnimationDelayed(action, delayMillis);
        } else {
            super.postOnAnimationDelayed(action, delayMillis);
        }
    }

    @Override
    public boolean removeCallbacks(Runnable action) {
        return (viewPager != null) ? viewPager.removeCallbacks(action) : super.removeCallbacks(action);
    }

    @Override
    public void postInvalidate() {
        if (viewPager != null) {
            viewPager.postInvalidate();
        } else {
            super.postInvalidate();
        }
    }

    @Override
    public void postInvalidate(int left, int top, int right, int bottom) {
        if (viewPager != null) {
            viewPager.postInvalidate(left, top, right, bottom);
        } else {
            super.postInvalidate(left, top, right, bottom);
        }
    }

    @Override
    public void postInvalidateDelayed(long delayMilliseconds) {
        if (viewPager != null) {
            viewPager.postInvalidateDelayed(delayMilliseconds);
        } else {
            super.postInvalidateDelayed(delayMilliseconds);
        }
    }

    @Override
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top, int right, int bottom) {
        if (viewPager != null) {
            viewPager.postInvalidateDelayed(delayMilliseconds, left, top, right, bottom);
        } else {
            super.postInvalidateDelayed(delayMilliseconds, left, top, right, bottom);
        }
    }

    @Override
    public void postInvalidateOnAnimation() {
        if (viewPager != null) {
            viewPager.postInvalidateOnAnimation();
        } else {
            super.postInvalidateOnAnimation();
        }
    }

    @Override
    public void postInvalidateOnAnimation(int left, int top, int right, int bottom) {
        if (viewPager != null) {
            viewPager.postInvalidateOnAnimation(left, top, right, bottom);
        } else {
            super.postInvalidateOnAnimation(left, top, right, bottom);
        }
    }

    @Override
    public boolean isHorizontalFadingEdgeEnabled() {
        return (viewPager != null) ? viewPager.isHorizontalFadingEdgeEnabled() : super.isHorizontalFadingEdgeEnabled();
    }

    @Override
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        if (viewPager != null) {
            viewPager.setHorizontalFadingEdgeEnabled(horizontalFadingEdgeEnabled);
        } else {
            super.setHorizontalFadingEdgeEnabled(horizontalFadingEdgeEnabled);
        }
    }

    @Override
    public boolean isVerticalFadingEdgeEnabled() {
        return (viewPager != null) ? viewPager.isVerticalFadingEdgeEnabled() : super.isVerticalFadingEdgeEnabled();
    }

    @Override
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        if (viewPager != null) {
            viewPager.setVerticalFadingEdgeEnabled(verticalFadingEdgeEnabled);
        } else {
            super.setVerticalFadingEdgeEnabled(verticalFadingEdgeEnabled);
        }
    }

    @Override
    public boolean isHorizontalScrollBarEnabled() {
        return (viewPager != null) ? viewPager.isHorizontalScrollBarEnabled() : super.isHorizontalScrollBarEnabled();
    }

    @Override
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        if (viewPager != null) {
            viewPager.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
        } else {
            super.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
        }
    }

    @Override
    public boolean isVerticalScrollBarEnabled() {
        return (viewPager != null) ? viewPager.isVerticalScrollBarEnabled() : super.isVerticalScrollBarEnabled();
    }

    @Override
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        if (viewPager != null) {
            viewPager.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
        } else {
            super.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
        }
    }

    @Override
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        if (viewPager != null) {
            viewPager.setScrollbarFadingEnabled(fadeScrollbars);
        } else {
            super.setScrollbarFadingEnabled(fadeScrollbars);
        }
    }

    @Override
    public boolean isScrollbarFadingEnabled() {
        return (viewPager != null) ? viewPager.isScrollbarFadingEnabled() : super.isScrollbarFadingEnabled();
    }

    @Override
    public int getScrollBarDefaultDelayBeforeFade() {
        return (viewPager != null) ? viewPager.getScrollBarDefaultDelayBeforeFade() : super
                .getScrollBarDefaultDelayBeforeFade();
    }

    @Override
    public void setScrollBarDefaultDelayBeforeFade(int scrollBarDefaultDelayBeforeFade) {
        if (viewPager != null) {
            viewPager.setScrollBarDefaultDelayBeforeFade(scrollBarDefaultDelayBeforeFade);
        } else {
            super.setScrollBarDefaultDelayBeforeFade(scrollBarDefaultDelayBeforeFade);
        }
    }

    @Override
    public int getScrollBarFadeDuration() {
        return (viewPager != null) ? viewPager.getScrollBarFadeDuration() : super.getScrollBarFadeDuration();
    }

    @Override
    public void setScrollBarFadeDuration(int scrollBarFadeDuration) {
        if (viewPager != null) {
            viewPager.setScrollBarFadeDuration(scrollBarFadeDuration);
        } else {
            super.setScrollBarFadeDuration(scrollBarFadeDuration);
        }
    }

    @Override
    public int getScrollBarSize() {
        return (viewPager != null) ? viewPager.getScrollBarSize() : super.getScrollBarSize();
    }

    @Override
    public void setScrollBarSize(int scrollBarSize) {
        if (viewPager != null) {
            viewPager.setScrollBarSize(scrollBarSize);
        } else {
            super.setScrollBarSize(scrollBarSize);
        }
    }

    @Override
    public void setScrollBarStyle(int style) {
        if (viewPager != null) {
            viewPager.setScrollBarStyle(style);
        } else {
            super.setScrollBarStyle(style);
        }
    }

    @Override
    @ExportedProperty(mapping = { @IntToString(from = 0, to = "INSIDE_OVERLAY"),
            @IntToString(from = 16777216, to = "INSIDE_INSET"), @IntToString(from = 33554432, to = "OUTSIDE_OVERLAY"),
            @IntToString(from = 50331648, to = "OUTSIDE_INSET") })
    public int getScrollBarStyle() {
        return (viewPager != null) ? viewPager.getScrollBarStyle() : super.getScrollBarStyle();
    }

    @Override
    public boolean canScrollVertically(int direction) {
        return (viewPager != null) ? viewPager.canScrollVertically(direction) : super.canScrollVertically(direction);
    }

    @Override
    public void onScreenStateChanged(int screenState) {
        if (viewPager != null) {
            viewPager.onScreenStateChanged(screenState);
        } else {
            super.onScreenStateChanged(screenState);
        }
    }

    @Override
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (viewPager != null) {
            viewPager.onRtlPropertiesChanged(layoutDirection);
        } else {
            super.onRtlPropertiesChanged(layoutDirection);
        }
    }

    @Override
    public IBinder getWindowToken() {
        return (viewPager != null) ? viewPager.getWindowToken() : super.getWindowToken();
    }

    @Override
    public WindowId getWindowId() {
        return (viewPager != null) ? viewPager.getWindowId() : super.getWindowId();
    }

    @Override
    public IBinder getApplicationWindowToken() {
        return (viewPager != null) ? viewPager.getApplicationWindowToken() : super.getApplicationWindowToken();
    }

    @Override
    public Display getDisplay() {
        return (viewPager != null) ? viewPager.getDisplay() : super.getDisplay();
    }

    @Override
    public void saveHierarchyState(SparseArray<Parcelable> container) {
        if (viewPager != null) {
            viewPager.saveHierarchyState(container);
        } else {
            super.saveHierarchyState(container);
        }
    }

    @Override
    public void restoreHierarchyState(SparseArray<Parcelable> container) {
        if (viewPager != null) {
            viewPager.restoreHierarchyState(container);
        } else {
            super.restoreHierarchyState(container);
        }
    }

    @Override
    public long getDrawingTime() {
        return (viewPager != null) ? viewPager.getDrawingTime() : super.getDrawingTime();
    }

    @Override
    public void setDuplicateParentStateEnabled(boolean enabled) {
        if (viewPager != null) {
            viewPager.setDuplicateParentStateEnabled(enabled);
        } else {
            super.setDuplicateParentStateEnabled(enabled);
        }
    }

    @Override
    public boolean isDuplicateParentStateEnabled() {
        return (viewPager != null) ? viewPager.isDuplicateParentStateEnabled() : super.isDuplicateParentStateEnabled();
    }

    @Override
    public void setLayerType(int layerType, Paint paint) {
        if (viewPager != null) {
            viewPager.setLayerType(layerType, paint);
        } else {
            super.setLayerType(layerType, paint);
        }
    }

    @Override
    public void setLayerPaint(Paint paint) {
        if (viewPager != null) {
            viewPager.setLayerPaint(paint);
        } else {
            super.setLayerPaint(paint);
        }
    }

    @Override
    public int getLayerType() {
        return (viewPager != null) ? viewPager.getLayerType() : super.getLayerType();
    }

    @Override
    public void buildLayer() {
        if (viewPager != null) {
            viewPager.buildLayer();
        } else {
            super.buildLayer();
        }
    }

    @Override
    public void setDrawingCacheEnabled(boolean enabled) {
        if (viewPager != null) {
            viewPager.setDrawingCacheEnabled(enabled);
        } else {
            super.setDrawingCacheEnabled(enabled);
        }
    }

    @Override
    @ExportedProperty(category = "drawing")
    public boolean isDrawingCacheEnabled() {
        return (viewPager != null) ? viewPager.isDrawingCacheEnabled() : super.isDrawingCacheEnabled();
    }

    @Override
    public Bitmap getDrawingCache() {
        return (viewPager != null) ? viewPager.getDrawingCache() : super.getDrawingCache();
    }

    @Override
    public Bitmap getDrawingCache(boolean autoScale) {
        return (viewPager != null) ? viewPager.getDrawingCache(autoScale) : super.getDrawingCache(autoScale);
    }

    @Override
    public void destroyDrawingCache() {
        if (viewPager != null) {
            viewPager.destroyDrawingCache();
        } else {
            super.destroyDrawingCache();
        }
    }

    @Override
    public void setDrawingCacheBackgroundColor(int color) {
        if (viewPager != null) {
            viewPager.setDrawingCacheBackgroundColor(color);
        } else {
            super.setDrawingCacheBackgroundColor(color);
        }
    }

    @Override
    public int getDrawingCacheBackgroundColor() {
        return (viewPager != null) ? viewPager.getDrawingCacheBackgroundColor() : super
                .getDrawingCacheBackgroundColor();
    }

    @Override
    public void buildDrawingCache() {
        if (viewPager != null) {
            viewPager.buildDrawingCache();
        } else {
            super.buildDrawingCache();
        }
    }

    @Override
    public void buildDrawingCache(boolean autoScale) {
        if (viewPager != null) {
            viewPager.buildDrawingCache(autoScale);
        } else {
            super.buildDrawingCache(autoScale);
        }
    }

    @Override
    public boolean isInEditMode() {
        return (viewPager != null) ? viewPager.isInEditMode() : super.isInEditMode();
    }

    @Override
    public boolean isHardwareAccelerated() {
        return (viewPager != null) ? viewPager.isHardwareAccelerated() : super.isHardwareAccelerated();
    }

    @Override
    public void setClipBounds(Rect clipBounds) {
        if (viewPager != null) {
            viewPager.setClipBounds(clipBounds);
        } else {
            super.setClipBounds(clipBounds);
        }
    }

    @Override
    public Rect getClipBounds() {
        return (viewPager != null) ? viewPager.getClipBounds() : super.getClipBounds();
    }

    @Override
    @ExportedProperty(category = "drawing")
    public int getSolidColor() {
        return (viewPager != null) ? viewPager.getSolidColor() : super.getSolidColor();
    }

    @Override
    public boolean isLayoutRequested() {
        return (viewPager != null) ? viewPager.isLayoutRequested() : super.isLayoutRequested();
    }

    @Override
    public Resources getResources() {
        return (viewPager != null) ? viewPager.getResources() : super.getResources();
    }

    @Override
    public void invalidateDrawable(Drawable drawable) {
        if (viewPager != null) {
            viewPager.invalidateDrawable(drawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (viewPager != null) {
            viewPager.scheduleDrawable(who, what, when);
        } else {
            super.scheduleDrawable(who, what, when);
        }
    }

    @Override
    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (viewPager != null) {
            viewPager.unscheduleDrawable(who, what);
        } else {
            super.unscheduleDrawable(who, what);
        }
    }

    @Override
    public void unscheduleDrawable(Drawable who) {
        if (viewPager != null) {
            viewPager.unscheduleDrawable(who);
        } else {
            super.unscheduleDrawable(who);
        }
    }

    @Override
    public void refreshDrawableState() {
        if (viewPager != null) {
            viewPager.refreshDrawableState();
        } else {
            super.refreshDrawableState();
        }
    }

    @Override
    public void setBackgroundColor(int color) {
        if (viewPager != null) {
            viewPager.setBackgroundColor(color);
        } else {
            super.setBackgroundColor(color);
        }
    }

    @Override
    public void setBackgroundResource(int resid) {
        if (viewPager != null) {
            viewPager.setBackgroundResource(resid);
        } else {
            super.setBackgroundResource(resid);
        }
    }

    @Override
    public void setBackground(Drawable background) {
        if (viewPager != null) {
            viewPager.setBackground(background);
        } else {
            super.setBackground(background);
        }
    }

    @Override
    @Deprecated
    public void setBackgroundDrawable(Drawable background) {
        if (viewPager != null) {
            viewPager.setBackgroundDrawable(background);
        } else {
            super.setBackgroundDrawable(background);
        }
    }

    @Override
    public Drawable getBackground() {
        return (viewPager != null) ? viewPager.getBackground() : super.getBackground();
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        if (viewPager != null) {
            viewPager.setPadding(left, top, right, bottom);
        } else {
            super.setPadding(left, top, right, bottom);
        }
    }

    @Override
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        if (viewPager != null) {
            viewPager.setPaddingRelative(start, top, end, bottom);
        } else {
            super.setPaddingRelative(start, top, end, bottom);
        }
    }

    @Override
    public int getPaddingTop() {
        return (viewPager != null) ? viewPager.getPaddingTop() : super.getPaddingTop();
    }

    @Override
    public int getPaddingBottom() {
        return (viewPager != null) ? viewPager.getPaddingBottom() : super.getPaddingBottom();
    }

    @Override
    public int getPaddingLeft() {
        return (viewPager != null) ? viewPager.getPaddingLeft() : super.getPaddingLeft();
    }

    @Override
    public int getPaddingStart() {
        return (viewPager != null) ? viewPager.getPaddingStart() : super.getPaddingStart();
    }

    @Override
    public int getPaddingRight() {
        return (viewPager != null) ? viewPager.getPaddingRight() : super.getPaddingRight();
    }

    @Override
    public int getPaddingEnd() {
        return (viewPager != null) ? viewPager.getPaddingEnd() : super.getPaddingEnd();
    }

    @Override
    public boolean isPaddingRelative() {
        return (viewPager != null) ? viewPager.isPaddingRelative() : super.isPaddingRelative();
    }

    @Override
    public void setSelected(boolean selected) {
        if (viewPager != null) {
            viewPager.setSelected(selected);
        } else {
            super.setSelected(selected);
        }
    }

    @Override
    @ExportedProperty
    public boolean isSelected() {
        return (viewPager != null) ? viewPager.isSelected() : super.isSelected();
    }

    @Override
    public void setActivated(boolean activated) {
        if (viewPager != null) {
            viewPager.setActivated(activated);
        } else {
            super.setActivated(activated);
        }
    }

    @Override
    @ExportedProperty
    public boolean isActivated() {
        return (viewPager != null) ? viewPager.isActivated() : super.isActivated();
    }

    @Override
    public ViewTreeObserver getViewTreeObserver() {
        return (viewPager != null) ? viewPager.getViewTreeObserver() : super.getViewTreeObserver();
    }

    @Override
    public View getRootView() {
        return (viewPager != null) ? viewPager.getRootView() : super.getRootView();
    }

    @Override
    public void getLocationOnScreen(int[] location) {
        if (viewPager != null) {
            viewPager.getLocationOnScreen(location);
        } else {
            super.getLocationOnScreen(location);
        }
    }

    @Override
    public void getLocationInWindow(int[] location) {
        if (viewPager != null) {
            viewPager.getLocationInWindow(location);
        } else {
            super.getLocationInWindow(location);
        }
    }

    @Override
    public void setId(int id) {
        if (viewPager != null) {
            viewPager.setId(id);
        } else {
            super.setId(id);
        }
    }

    @Override
    @CapturedViewProperty
    public int getId() {
        return (viewPager != null) ? viewPager.getId() : super.getId();
    }

    @Override
    @ExportedProperty
    public Object getTag() {
        return (viewPager != null) ? viewPager.getTag() : super.getTag();
    }

    @Override
    public void setTag(Object tag) {
        if (viewPager != null) {
            viewPager.setTag(tag);
        } else {
            super.setTag(tag);
        }
    }

    @Override
    public Object getTag(int key) {
        return (viewPager != null) ? viewPager.getTag(key) : super.getTag(key);
    }

    @Override
    public void setTag(int key, Object tag) {
        if (viewPager != null) {
            viewPager.setTag(key, tag);
        } else {
            super.setTag(key, tag);
        }
    }

    @Override
    @ExportedProperty(category = "layout")
    public int getBaseline() {
        return (viewPager != null) ? viewPager.getBaseline() : super.getBaseline();
    }

    @Override
    public boolean isInLayout() {
        return (viewPager != null) ? viewPager.isInLayout() : super.isInLayout();
    }

    @Override
    public void requestLayout() {
        if (viewPager != null) {
            viewPager.requestLayout();
        } else {
            super.requestLayout();
        }
    }

    @Override
    public void forceLayout() {
        if (viewPager != null) {
            viewPager.forceLayout();
        } else {
            super.forceLayout();
        }
    }

    @Override
    public int getMinimumHeight() {
        return (viewPager != null) ? viewPager.getMinimumHeight() : super.getMinimumHeight();
    }

    @Override
    public void setMinimumHeight(int minHeight) {
        if (viewPager != null) {
            viewPager.setMinimumHeight(minHeight);
        } else {
            super.setMinimumHeight(minHeight);
        }
    }

    @Override
    public int getMinimumWidth() {
        return (viewPager != null) ? viewPager.getMinimumWidth() : super.getMinimumWidth();
    }

    @Override
    public void setMinimumWidth(int minWidth) {
        if (viewPager != null) {
            viewPager.setMinimumWidth(minWidth);
        } else {
            super.setMinimumWidth(minWidth);
        }
    }

    @Override
    public Animation getAnimation() {
        return (viewPager != null) ? viewPager.getAnimation() : super.getAnimation();
    }

    @Override
    public void startAnimation(Animation animation) {
        if (viewPager != null) {
            viewPager.startAnimation(animation);
        } else {
            super.startAnimation(animation);
        }
    }

    @Override
    public void clearAnimation() {
        if (viewPager != null) {
            viewPager.clearAnimation();
        } else {
            super.clearAnimation();
        }
    }

    @Override
    public void setAnimation(Animation animation) {
        if (viewPager != null) {
            viewPager.setAnimation(animation);
        } else {
            super.setAnimation(animation);
        }
    }

    @Override
    public void playSoundEffect(int soundConstant) {
        if (viewPager != null) {
            viewPager.playSoundEffect(soundConstant);
        } else {
            super.playSoundEffect(soundConstant);
        }
    }

    @Override
    public boolean performHapticFeedback(int feedbackConstant) {
        return (viewPager != null) ? viewPager.performHapticFeedback(feedbackConstant) : super
                .performHapticFeedback(feedbackConstant);
    }

    @Override
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        return (viewPager != null) ? viewPager.performHapticFeedback(feedbackConstant, flags) : super
                .performHapticFeedback(feedbackConstant, flags);
    }

    @Override
    public void setSystemUiVisibility(int visibility) {
        if (viewPager != null) {
            viewPager.setSystemUiVisibility(visibility);
        } else {
            super.setSystemUiVisibility(visibility);
        }
    }

    @Override
    public int getSystemUiVisibility() {
        return (viewPager != null) ? viewPager.getSystemUiVisibility() : super.getSystemUiVisibility();
    }

    @Override
    public int getWindowSystemUiVisibility() {
        return (viewPager != null) ? viewPager.getWindowSystemUiVisibility() : super.getWindowSystemUiVisibility();
    }

    @Override
    public void onWindowSystemUiVisibilityChanged(int visible) {
        if (viewPager != null) {
            viewPager.onWindowSystemUiVisibilityChanged(visible);
        } else {
            super.onWindowSystemUiVisibilityChanged(visible);
        }
    }

    @Override
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l) {
        if (viewPager != null) {
            viewPager.setOnSystemUiVisibilityChangeListener(l);
        } else {
            super.setOnSystemUiVisibilityChangeListener(l);
        }
    }

    @Override
    public boolean onDragEvent(DragEvent event) {
        return (viewPager != null) ? viewPager.onDragEvent(event) : super.onDragEvent(event);
    }

    @Override
    public int getOverScrollMode() {
        return (viewPager != null) ? viewPager.getOverScrollMode() : super.getOverScrollMode();
    }

    @Override
    public void setOverScrollMode(int overScrollMode) {
        if (viewPager != null) {
            viewPager.setOverScrollMode(overScrollMode);
        } else {
            super.setOverScrollMode(overScrollMode);
        }
    }

    @Override
    public void setTextDirection(int textDirection) {
        if (viewPager != null) {
            viewPager.setTextDirection(textDirection);
        } else {
            super.setTextDirection(textDirection);
        }
    }

    @Override
    @ExportedProperty(category = "text", mapping = { @IntToString(from = 0, to = "INHERIT"),
            @IntToString(from = 1, to = "FIRST_STRONG"), @IntToString(from = 2, to = "ANY_RTL"),
            @IntToString(from = 3, to = "LTR"), @IntToString(from = 4, to = "RTL"),
            @IntToString(from = 5, to = "LOCALE") })
    public int getTextDirection() {
        return (viewPager != null) ? viewPager.getTextDirection() : super.getTextDirection();
    }

    @Override
    public void setTextAlignment(int textAlignment) {
        if (viewPager != null) {
            viewPager.setTextAlignment(textAlignment);
        } else {
            super.setTextAlignment(textAlignment);
        }
    }

    @Override
    @ExportedProperty(category = "text", mapping = { @IntToString(from = 0, to = "INHERIT"),
            @IntToString(from = 1, to = "GRAVITY"), @IntToString(from = 2, to = "TEXT_START"),
            @IntToString(from = 3, to = "TEXT_END"), @IntToString(from = 4, to = "CENTER"),
            @IntToString(from = 5, to = "VIEW_START"), @IntToString(from = 6, to = "VIEW_END") })
    public int getTextAlignment() {
        return (viewPager != null) ? viewPager.getTextAlignment() : super.getTextAlignment();
    }

    @Override
    public ViewPropertyAnimator animate() {
        return (viewPager != null) ? viewPager.animate() : super.animate();
    }

}
