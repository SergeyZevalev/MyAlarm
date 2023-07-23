package com.example.myalarm.presentation

import android.app.AlertDialog
import android.content.ContentProvider
import android.content.DialogInterface
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.CheckBox
import android.widget.CheckedTextView
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.SimpleAdapter
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.example.myalarm.R
import com.google.android.material.textfield.TextInputLayout
import java.io.File

class AddItemFragment(private val itemId: Int = -1) : Fragment() {

    private var hours: Byte = -1
    private var minutes: Byte = -1
    private var europeTimeFormat: Boolean = false
    private var am: Boolean = false
    private var pm: Boolean = false
    private var melodyFile: File = File("")
    private var week: List<Boolean> = listOf()
    private var vibration: Boolean = false
    private var notificationText: String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_item_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hoursInput = view.findViewById<EditText>(R.id.hours_input)
        val minutesInput = view.findViewById<EditText>(R.id.minutes_input)
        val hoursEuropeFormatLayer = view.findViewById<LinearLayout>(R.id.layout_12hours_selector)
        val hoursAM = view.findViewById<CheckedTextView>(R.id.am_input)
        val hoursPM = view.findViewById<CheckedTextView>(R.id.pm_input)
        val hoursModeSelector = view.findViewById<CheckBox>(R.id.hours_mode_selector)

        hoursInput.let {
            it.addTextChangedListener(
                AlarmInputWatcher(
                    europeTimeFormat,
                    true,
                    it,
                    requireContext()
                )
            )
        }
        minutesInput.let {
            it.addTextChangedListener(
                AlarmInputWatcher(
                    europeTimeFormat,
                    false,
                    it,
                    requireContext()
                )
            )
        }

        hoursModeSelector.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) hoursEuropeFormatLayer.visibility = View.VISIBLE
            else hoursEuropeFormatLayer.visibility = View.GONE
        }
        hoursAM.setOnClickListener {
            hoursAM.isChecked = !hoursAM.isChecked
            if (hoursPM.isChecked && hoursAM.isChecked) hoursPM.isChecked = false
        }
        hoursPM.setOnClickListener {
            hoursPM.isChecked = !hoursPM.isChecked
            if (hoursPM.isChecked && hoursAM.isChecked) hoursAM.isChecked = false
        }

        val melodyChooseStringsMenu = view.resources.getStringArray(R.array.sound_resources)
        val melodyChooseMenuAdapter =
            ArrayAdapter(requireContext(), R.layout.simple_list_drop_menu, melodyChooseStringsMenu)
        val melodyAdapterView = view.findViewById<AutoCompleteTextView>(R.id.melody_auto_complete)
        melodyAdapterView.setAdapter(melodyChooseMenuAdapter)
        melodyAdapterView.setOnItemClickListener { parent, viewMelodyMenu, position, id ->
            val openSource: Intent
            val RingtoneManagerIntent = Intent(RingtoneManager.ACTION_RINGTONE_PICKER)
            val DataStoreManagerIntent = Intent()
            when (position) {
                0 -> openSource = RingtoneManagerIntent
                1 -> openSource = DataStoreManagerIntent
            }

        }

        val daysRepeatChooseStringMenu = view.resources.getStringArray(R.array.repeat_mode)
        val daysRepeatMenuAdapter =
            ArrayAdapter(
                requireContext(),
                R.layout.simple_list_drop_menu,
                daysRepeatChooseStringMenu
            )
        val daysRepeatAdapterView =
            view.findViewById<AutoCompleteTextView>(R.id.repeat_auto_complete)
        daysRepeatAdapterView.setAdapter(daysRepeatMenuAdapter)

        val vibrationSwitcher = view.findViewById<SwitchCompat>(R.id.vibration_switch)
        vibrationSwitcher.setOnCheckedChangeListener { buttonView, isChecked -> }

        val textAlarmNotificationAdapterView = view.findViewById<AutoCompleteTextView>(R.id.notification_auto_complete)
        textAlarmNotificationAdapterView.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setView(R.layout.notification_dialog)
                .setTitle(R.string.add_notification_dialog)
                .show()
        }

        val cancelButton = view.findViewById<ImageButton>(R.id.cancel_button)
        val okButton = view.findViewById<ImageButton>(R.id.ok_button)


    }
}