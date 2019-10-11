package com.tktpl.contactsmvvm.ui.insert

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.tktpl.contactsmvvm.R
import com.tktpl.contactsmvvm.ui.display.DataDisplayViewModel
import com.tktpl.contactsmvvm.ui.display.DataDisplayViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DataInsert : Fragment() {

    @Inject
    lateinit var viewModelFactory: DataInsertViewModelFactory

    private lateinit var viewModel: DataInsertViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.data_insert_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DataInsertViewModel::class.java)
    }

}
