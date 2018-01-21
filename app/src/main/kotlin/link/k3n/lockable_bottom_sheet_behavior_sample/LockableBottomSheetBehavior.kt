package link.k3n.lockable_bottom_sheet_behavior_sample

import android.content.Context
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * タッチ・ドラッグ操作を無効化可能なBottomSheetBehavior
 */
class LockableBottomSheetBehavior<V: View>(context: Context, attrs: AttributeSet): BottomSheetBehavior<V>(context, attrs) {

    /**
     * タッチ・ドラッグ操作を無効化するならtrue
     */
    var locked = false

    override fun onInterceptTouchEvent(parent: CoordinatorLayout?, child: V, event: MotionEvent?): Boolean {
        return if (locked) false
        else return super.onInterceptTouchEvent(parent, child, event)
    }

    override fun onTouchEvent(parent: CoordinatorLayout?, child: V, event: MotionEvent?): Boolean {
        return if (locked) false
        else return super.onTouchEvent(parent, child, event)
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return if (locked) false
        else return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onNestedPreScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        if (!locked) super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: V, target: View, type: Int) {
        if (!locked) super.onStopNestedScroll(coordinatorLayout, child, target, type)
    }

    override fun onNestedPreFling(coordinatorLayout: CoordinatorLayout, child: V, target: View, velocityX: Float, velocityY: Float): Boolean {
        return if (locked) false
        else return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
    }
}