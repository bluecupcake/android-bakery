package com.bluecupcake.androidbakary.presentation.version

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.bluecupcake.androidbakary.R
import com.bluecupcake.androidbakary.ui.adapter.VersionListAdapter
import com.bluecupcake.androidbakary.databinding.FragmentVersionListBinding
import com.bluecupcake.androidbakary.domain.usecases.GetVersionsUseCase
import com.bluecupcake.androidbakary.mapper.view.VersionOnViewMapper
import com.bluecupcake.androidbakary.presentation.application.ApplicationViewModel


class VersionListFragment : Fragment(R.layout.fragment_version_list) {

    private var _binding: FragmentVersionListBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: ApplicationViewModel by activityViewModels()
    private var mapper = VersionOnViewMapper()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVersionListBinding.inflate(inflater, container, false)

        sharedViewModel.changeActionBarTitle("All Versions")

        return binding.root    //return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getVersions = GetVersionsUseCase(requireContext()).invoke().map { mapper(it) }

        initRecyclerView(view, getVersions)
    }

    private fun initRecyclerView(view: View, versionsList: List<VersionOnView>) {
        val versionRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        val adapter = VersionListAdapter(
            versionsList
        ) { version ->
            val versionDetailsFragment = VersionDetailsFragment(version)
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, versionDetailsFragment)
                commit()
            }
        }

        versionRecyclerView.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}