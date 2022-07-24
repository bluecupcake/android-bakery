package com.bluecupcake.androidbakary.presentation.version

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.bluecupcake.androidbakary.R
import com.bluecupcake.androidbakary.domain.model.Version
import com.bluecupcake.androidbakary.presentation.application.ApplicationViewModel
import com.bluecupcake.androidbakary.databinding.FragmentVersionDetailsBinding
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel

class VersionDetailsFragment(currentVersion: VersionOnView) : Fragment(R.layout.fragment_version_details) {

    private val currVersion = currentVersion

    private var _binding: FragmentVersionDetailsBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: ApplicationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVersionDetailsBinding.inflate(inflater, container, false)

        sharedViewModel.changeActionBarTitle(currVersion.codename)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addChart(view)
        bindVersion()
    }

    private fun bindVersion() {
        binding.apply {
            editVersion.text = currVersion.versionNumber
            editSdk.text = currVersion.sdk
            editApiLevel.text = currVersion.apiLevel
            editVersionCode.text = currVersion.versionCodes
            editYear.text = currVersion.year

            btnBack.setOnClickListener { backToList() }
        }
    }

    private fun backToList() {
        val versionListFragment = VersionListFragment()
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, versionListFragment)
            commit()
        }
    }

    private fun addChart(view: View) {
        val chart = view.findViewById<PieChart>(R.id.chart)

        //Toast.makeText(context, currVersion.usage.toString(), Toast.LENGTH_SHORT).show()
        when (currVersion.usage) {
            null -> {
                chart.addPieSlice(
                    PieModel("lol", 100.0f, Color.parseColor("#fafffa"))
                )
            }
            else -> {
                val usage = currVersion.usage
                val complement = 100.0f - usage!!

                val versionUsage = PieModel("lol", usage, Color.parseColor("#A4C639"))
                val to100 = PieModel("lol", complement, Color.parseColor("#fafffa"))
                chart.addPieSlice(versionUsage)
                chart.addPieSlice(to100)

                chart.startAnimation()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}