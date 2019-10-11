package com.tktpl.contactsmvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.tktpl.contactsmvvm.R
import com.tktpl.contactsmvvm.data.db.ContactsEntry
import kotlinx.android.synthetic.main.contacts_ticket.view.*

class ContactAdapter : BaseAdapter {

    var context: Context? = null
    var contactList = ArrayList<ContactsEntry>()

    constructor(context: Context?, contactList: List<ContactsEntry>){
        this.context = context
        this.contactList = contactList as ArrayList<ContactsEntry>
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val contact = contactList[p0]
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val contactView = inflator.inflate(R.layout.contacts_ticket,null)

        contactView.name_detil.text = contact.name
        contactView.number_detil.text = "+62"+contact.number
        contactView.relation_detil.text = contact.relation

        return contactView
    }

    override fun getItem(p0: Int): Any {
        return contactList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return contactList.size
    }


}