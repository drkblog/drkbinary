package ar.com.drk.drkbinary

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ar.com.drk.drkbinary.databinding.PlayfieldFragmentBinding
import ar.com.drk.drkbinary.game.GameService

/**
 * Playfield
 */
class PlayfieldFragment : Fragment() {

    private var _binding: PlayfieldFragmentBinding? = null

    private val gameService: GameService = GameService()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PlayfieldFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reset()
        // We want our input field to append numbers to the left
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
                binding.outcome.text = "Correct!"
                return
            }
        } catch (e: Exception) {
            // Ignore it
        } finally {
            binding.result.text.clear()
            reset()
        }
        binding.outcome.text = "Wrong answer"
    }

    private fun reset() {
        val setup = gameService.play()
        binding.level.text = "Level " + gameService.level.displayValue()
        binding.firstNumber.text = intToBinaryString(setup.first)
        binding.secondNumber.text = intToBinaryString(setup.second)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}