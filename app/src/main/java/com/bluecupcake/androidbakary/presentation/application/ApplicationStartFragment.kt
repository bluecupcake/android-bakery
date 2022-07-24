package com.bluecupcake.androidbakary.presentation.application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bluecupcake.androidbakary.R
import com.bluecupcake.androidbakary.databinding.FragmentApplicationStartBinding
import com.bluecupcake.androidbakary.presentation.version.VersionListFragment

class ApplicationStartFragment : Fragment() {

    // View Binding
    private var _binding: FragmentApplicationStartBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: ApplicationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentApplicationStartBinding.inflate(inflater, container, false)

        sharedViewModel.changeActionBarTitle(null)

        binding.rlStart.setOnClickListener {
            val versionsListFragment = VersionListFragment()

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, versionsListFragment)
                commit()
            }
        }

        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}