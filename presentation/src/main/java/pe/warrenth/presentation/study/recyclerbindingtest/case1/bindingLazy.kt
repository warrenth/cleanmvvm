package pe.warrenth.presentation.study.recyclerbindingtest.case1

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

inline fun <reified T : ViewDataBinding> bindings(view: View): Lazy<T> =
        lazy {
            requireNotNull(DataBindingUtil.bind<T>(view)) { "cannot find the matched view to layout." }
        }