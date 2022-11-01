package com.example.telegram

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegram.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        createHeader()
        createDrawer()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder().withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Azat Sabirov")
                    .withEmail("azat240510@gmail.com")
            )
            .build()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder().withActivity(this)
            .withToolbar(mToolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(mHeader)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName("Создать группу")
                    .withIcon(R.drawable.ic_baseline_group_24)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(101)
                    .withIconTintingEnabled(true)
                    .withName("Создать секретный чат")
                    .withIcon(R.drawable.ic_baseline_lock_24)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(102)
                    .withIconTintingEnabled(true)
                    .withName("Создать канал")
                    .withIcon(R.drawable.ic_speaker_svgrepo_com)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(103)
                    .withIconTintingEnabled(true)
                    .withName("Контакты")
                    .withIcon(R.drawable.ic_baseline_person_24)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(104)
                    .withIconTintingEnabled(true)
                    .withName("Звонки")
                    .withIcon(R.drawable.ic_baseline_call_24)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(105)
                    .withIconTintingEnabled(true)
                    .withName("Избранное")
                    .withIcon(R.drawable.ic_favorite)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(106)
                    .withIconTintingEnabled(true)
                    .withName("Настройки")
                    .withIcon(R.drawable.ic_baseline_settings_24)
                    .withSelectable(false),

                DividerDrawerItem(),

                PrimaryDrawerItem().withIdentifier(107)
                    .withIconTintingEnabled(true)
                    .withName("Пригласить друзей")
                    .withIcon(R.drawable.ic_baseline_person_add_24)
                    .withSelectable(false),

                PrimaryDrawerItem().withIdentifier(108)
                    .withIconTintingEnabled(true)
                    .withName("Возможности Telegram")
                    .withIcon(R.drawable.ic_question)
                    .withSelectable(false)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                    Toast.makeText(this@MainActivity, "$position", Toast.LENGTH_SHORT).show()
                    return false
                }
            })
            .build()
    }
}