package com.slakra.common.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.koin.standalone.KoinComponent

abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity(), KoinComponent {

    private lateinit var mViewDataBinding: T
    private var mViewModel: V? = null

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    /**
     * Function to get ViewDataBinding
     * @return [T] ViewDataBinding
     * @author sumitlakra
     * @date 06/01/2020
     */
    fun getViewDataBinding(): T = mViewDataBinding

    /**
     * Function to execute ViewDataBinding
     * @author Sumit Lakra
     * @date 12/07/19
     */
    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }
}