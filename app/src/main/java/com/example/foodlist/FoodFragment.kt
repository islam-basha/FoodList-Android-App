package com.example.foodlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.foodlist.databinding.FragmentFoodBinding

class FoodFragment : Fragment(R.layout.fragment_food) {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    private val foodList = mutableListOf(
        Food("Pizza (the queen)", R.drawable.baseline_local_pizza_24),
        Food("Burger", R.drawable.baseline_fastfood_24),
        Food("Mahshe (doulma)", R.drawable.baseline_heart_broken_24)
        )

    private var adapter = FoodAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)

        val sharedPref=MySharedPref(requireContext())
        adapter.size=sharedPref.getSize()!!
        binding.rvFoodList.adapter=adapter
        adapter.submitList(foodList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}