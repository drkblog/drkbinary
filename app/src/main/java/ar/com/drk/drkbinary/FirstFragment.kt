package ar.com.drk.drkbinary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import ar.com.drk.drkbinary.databinding.PlayfieldBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: PlayfieldBinding? = null

    private val gameService : GameService = GameService()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PlayfieldBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }


    private fun setup() {
        val setup = gameService.play()
        binding.firstNumber.text = setup.first.toString(2)
        binding.secondNumber.text = setup.second.toString(2)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}