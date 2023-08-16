package com.example.customdrawerlayout.with_recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.customdrawerlayout.databinding.ViewItemMenuBinding

class RecyclerMenuAdapter(
    val menuList: List<MenuItemModel>,
    val menuClickListener: MenuClickListener
) : Adapter<RecyclerMenuAdapter.RecyclerMenuHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecyclerMenuHolder(
            ViewItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(holder: RecyclerMenuHolder, position: Int) {
        holder.apply {
            bind(menuList[position])
            binding.root.setOnClickListener {
                menuClickListener.menuItemSelected(menuList[position])
            }
        }
    }


    class RecyclerMenuHolder(val binding: ViewItemMenuBinding) : ViewHolder(binding.root) {
        fun bind(menuItemModel: MenuItemModel) {
            binding.apply {
                ivIcon.setImageResource(menuItemModel.icon)
                tvTitle.text = menuItemModel.title
            }
        }
    }

    interface MenuClickListener {
        fun menuItemSelected(menuItemModel: MenuItemModel)
    }
}