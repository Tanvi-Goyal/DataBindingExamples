package com.example.android.databinding.basicsample.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout.VERTICAL
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.ItemViewModel
import com.example.android.databinding.basicsample.databinding.ActivityMainBinding
import com.example.android.databinding.basicsample.util.Item
import com.example.android.databinding.basicsample.util.ItemAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: com.example.android.databinding.basicsample.databinding.ActivityMainBinding

    companion object {
        const val myUserId = "id_123"
    }

    var list = listOf<Item>(
            Item(UUID.randomUUID().toString(), "Frank", "Overtrees", 1, "Team Gnome"),
            Item(UUID.randomUUID().toString(), "Kate", "Whitewalker", 2, "Team Gnome"),
            Item(UUID.randomUUID().toString(), "Edward", "Baker", 3, "Team KDE"),
            Item(myUserId, "Tony", "Ashenberg", 4, "Team xfce"),
            Item(UUID.randomUUID().toString(), "Roman", "Antysoman", 5, "Team xfce"),
            Item(UUID.randomUUID().toString(), "Mike", "The Shroom", 6, "Team Gnome"),
            Item(UUID.randomUUID().toString(), "Dolan", "Dolański", 7, "Team KDE")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setAdapter()
    }

    @SuppressLint("WrongConstant")
    private fun setAdapter() {
        binding.activityMainRecycler.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        val itemAdapter = ItemAdapter()
        binding.activityMainRecycler.adapter = itemAdapter

        val viewModelList = list.map {
            ItemViewModel(it.position.toString(), "${it.firstName} ${it.lastName}", it.teamName, it.id.contentEquals(myUserId))
        }

        itemAdapter.items = viewModelList
    }
}
