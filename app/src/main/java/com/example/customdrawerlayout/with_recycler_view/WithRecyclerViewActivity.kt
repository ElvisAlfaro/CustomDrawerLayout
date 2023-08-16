package com.example.customdrawerlayout.with_recycler_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.customdrawerlayout.CallFragment
import com.example.customdrawerlayout.R
import com.example.customdrawerlayout.databinding.ActivityWithMenuXmlBinding
import com.example.customdrawerlayout.databinding.ActivityWithRecyclerViewBinding
import com.google.android.material.snackbar.Snackbar

class WithRecyclerViewActivity : AppCompatActivity(), RecyclerMenuAdapter.MenuClickListener{
    private val binding: ActivityWithRecyclerViewBinding by lazy {
        ActivityWithRecyclerViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.layoutToolbarFragment.mtToolbar)

        val toggle = ActionBarDrawerToggle(this,
            binding.dlDrawer,
            binding.layoutToolbarFragment.mtToolbar,
            R.string.close_drawer,
            R.string.open_drawer
        )
        binding.dlDrawer.addDrawerListener(toggle)
        toggle.syncState()

        setUpMenuRecycler()

    }

    override fun onBackPressed() {
        binding.dlDrawer.run {
            if (isDrawerOpen(GravityCompat.START))
                closeDrawer(GravityCompat.START)
            else
                super.onBackPressed()
        }
    }

    private fun setUpMenuRecycler() {
        binding.rvMenuItems.adapter = RecyclerMenuAdapter(getMenuItems(), this)
    }

    private fun getMenuItems(): List<MenuItemModel> {
        return listOf(
            MenuItemModel(1, android.R.drawable.ic_menu_call, getString(R.string.menu_call)),
            MenuItemModel(2, android.R.drawable.ic_menu_camera, getString(R.string.menu_camera)),
            MenuItemModel(3, android.R.drawable.ic_menu_agenda, getString(R.string.menu_agenda)),
            MenuItemModel(4, android.R.drawable.ic_menu_gallery, getString(R.string.menu_gallery)),
            MenuItemModel(5, android.R.drawable.ic_menu_share, getString(R.string.menu_share)),
            MenuItemModel(6, android.R.drawable.ic_menu_send, getString(R.string.menu_send))
        )
    }

    override fun menuItemSelected(menuItemModel: MenuItemModel) {
        binding.dlDrawer.closeDrawer(GravityCompat.START)
        title = menuItemModel.title
        Snackbar.make(binding.root, menuItemModel.title, Snackbar.LENGTH_SHORT).show()
        when(menuItemModel.id) {
            1-> loadFragment(CallFragment.newInstance(android.R.color.holo_orange_light))
            2-> loadFragment(CallFragment.newInstance(android.R.color.holo_green_light))
            3-> loadFragment(CallFragment.newInstance(android.R.color.holo_red_light))
            4-> loadFragment(CallFragment.newInstance(android.R.color.holo_blue_light))
            5-> loadFragment(CallFragment.newInstance(android.R.color.darker_gray))
            6-> loadFragment(CallFragment.newInstance(R.color.accent_color))
        }
    }

    private fun loadFragment(fragment: Fragment?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment!!)
            //.addToBackStack("name")
            .commit()
    }
}