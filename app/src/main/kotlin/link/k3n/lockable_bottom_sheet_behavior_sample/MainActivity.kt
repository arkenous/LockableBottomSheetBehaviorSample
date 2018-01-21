package link.k3n.lockable_bottom_sheet_behavior_sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import link.k3n.lockable_bottom_sheet_behavior_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // BottomSheetBehavior自体のドラッグ操作等によるExpand・Collapse操作を無効にする
        val behavior = BottomSheetBehavior.from(binding.bottomSheetBehaviorRootLayout) as LockableBottomSheetBehavior
        behavior.locked = true

        binding.bottomSheetBehaviorToggleButton.setOnClickListener {
            // ボタンクリックによって、Expand・Collapseを制御する
            when (behavior.state) {
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                    binding.bottomSheetBehaviorStatusText.text = "Expanded"
                }
                BottomSheetBehavior.STATE_EXPANDED -> {
                    behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    binding.bottomSheetBehaviorStatusText.text = "Collapsed"
                }
            }
        }

        binding.bottomSheetBehaviorClearButton.setOnClickListener {
            binding.bottomSheetBehaviorEditText.setText("")
        }
    }
}
