package com.example.foodlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.foodlist.databinding.FragmentSettingBinding

class SettingFragment : Fragment(R.layout.fragment_setting) {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingBinding.bind(view)
        var sharedPref=MySharedPref(requireContext())

        binding.apply {
            save.setOnClickListener {
                if(s.isChecked)
                    sharedPref.saveSize("16")
                if(m.isChecked)
                    sharedPref.saveSize("34")
                if(l.isChecked)
                    sharedPref.saveSize("50")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}