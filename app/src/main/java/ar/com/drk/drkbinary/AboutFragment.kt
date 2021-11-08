package ar.com.drk.drkbinary

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.com.drk.drkbinary.databinding.AboutFragmentBinding
import ar.com.drk.drkbinary.databinding.PlayfieldFragmentBinding

class AboutFragment : Fragment() {

    private var _binding: AboutFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = AboutFragmentBinding.inflate(inflater, container, false)
        binding.drkUrl.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.drk_url))))
        }
        return binding.root
    }
}