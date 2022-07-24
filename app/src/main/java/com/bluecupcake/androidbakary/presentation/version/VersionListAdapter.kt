package com.bluecupcake.androidbakary.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bluecupcake.androidbakary.R
import com.bluecupcake.androidbakary.domain.model.Version
import com.bluecupcake.androidbakary.domain.usecases.GetVersionsUseCase
import com.bluecupcake.androidbakary.presentation.version.VersionOnView


class VersionListAdapter(
    private val versionsList: List<VersionOnView>,
    private val clickListener: (VersionOnView) -> Unit
) : RecyclerView.Adapter<VersionViewHolder>() {

    // create new views
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VersionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.list_view_item, parent, false)
        return VersionViewHolder(layoutInflater, clickListener)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: VersionViewHolder, position: Int) {
        holder.bind(versionsList[position])
    }

    // return the number of the items in the list
    // versionList.count()
    override fun getItemCount(): Int = versionsList.size
}

class VersionViewHolder(
    itemView: View,
    private val onClick: (VersionOnView) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    var codename = itemView.findViewById<TextView>(R.id.tv_versionCodename)

    fun bind(version: VersionOnView) {
        codename.text = version.codename

        itemView.setOnClickListener {
            onClick(version)
        }
    }
}