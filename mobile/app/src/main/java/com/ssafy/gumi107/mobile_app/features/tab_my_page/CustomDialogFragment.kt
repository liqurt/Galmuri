package com.ssafy.gumi107.mobile_app.features.tab_my_page

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.ssafy.gumi107.mobile_app.R


class CustomDialogFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_profile_dialog, container, false)

        //다이얼로그 모서리 둥글게 하기 위함
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        rootView.findViewById<Button>(R.id.Cancelbtn).setOnClickListener {
            dismiss()
        }

        rootView.findViewById<Button>(R.id.submitbtn).setOnClickListener {
            val rg = rootView.findViewById<ChipGroup>(R.id.tripdialog)
            val chipList = ArrayList<String>()
            for(i:Int in 1..rg.childCount){
                val chip: Chip = rg.getChildAt(i-1) as Chip
                if(chip.isChecked == true){
                    chipList.add(chip.text.toString())
                }

            }

            var result = "당신은 "
            for(i in chipList){
                result += "$i, "
            }
            result = result.substring(0, result.length - 2)
            result += "!"
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()

            dismiss()
        }

        return rootView
    }
}