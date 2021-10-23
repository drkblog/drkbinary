package ar.com.drk.drkbinary

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import ar.com.drk.drkbinary.databinding.PlayfieldBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: PlayfieldBinding? = null

    private val gameService: GameService = GameService()

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
        binding.result.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.result.setSelection(0)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        binding.validate.setOnClickListener {
            validate()
        }
    }

    private fun validate() {
        try {
            if (gameService.validate(binaryStringToInt(binding.result.text.toString()))) {
                Toast.makeText(context,"Congratulations!", Toast.LENGTH_LONG).show()
                return
            }
        } catch (e: Exception) {
            // Ignore it
        } finally {
            binding.result.text.clear()
            setup()
        }
        Toast.makeText(context,"Wrong answer", Toast.LENGTH_LONG).show()
    }

    private fun setup() {
        val setup = gameService.play()
        binding.firstNumber.text = intToBinaryString(setup.first)
        binding.secondNumber.text = intToBinaryString(setup.second)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}