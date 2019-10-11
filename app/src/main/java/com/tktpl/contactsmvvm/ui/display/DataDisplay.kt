package com.tktpl.contactsmvvm.ui.display

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.tktpl.contactsmvvm.R
import com.tktpl.contactsmvvm.ui.adapter.ContactAdapter
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.data_display_fragment.*
import javax.inject.Inject

class DataDisplay : Fragment() {

    private lateinit var viewModel: DataDisplayViewModel

    @Inject
    lateinit var viewModelFactory: DataDisplayViewModelFactory

    var adapter : ContactAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.data_display_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DataDisplayViewModel::class.java)
        viewModel.bindUI()

        viewModel.dataDisplayer.observe(this, Observer {value ->
            adapter = ContactAdapter(this@DataDisplay.context,value)
            gvContactsFragment.adapter = adapter
        })
    }

}
