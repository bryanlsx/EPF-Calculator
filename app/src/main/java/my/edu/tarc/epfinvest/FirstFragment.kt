package my.edu.tarc.epfinvest

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.navigation.fragment.findNavController
import my.edu.tarc.epfinvest.databinding.FragmentFirstBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonNavThird.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_thirdFragment)
        }
        binding.buttonDOB.setOnClickListener {
            val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, day ->
                calendar.set(YEAR, year)
                calendar.set(MONTH, month)
                calendar.set(DAY_OF_MONTH, day)

                val dateFormat = "dd/MM/YYYY"
                val standardFormat = SimpleDateFormat(dateFormat, Locale.UK)

                binding.buttonDOB.text = standardFormat.format(calendar.getTime())
            }

            DatePickerDialog(it.context,
                dateSetListener,
                calendar.get(YEAR),
                calendar.get(MONTH),
                calendar.get(DAY_OF_MONTH),
                ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}