package com.akitektuo.gtacarcollections

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val cars = ArrayList<CarModel>()
    private val adapter = CarAdapter()
    private lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = Preferences(this)

        populateCars()
        setupList()
        setupSearch()
    }

    private fun getCheckArray(): ArrayList<Boolean> {
        val values = preferences.get()!!.split(",")
        val checkArray = ArrayList<Boolean>()
        values.forEach {
            checkArray.add(it != "0")
        }
        return checkArray
    }

    private fun saveCheckArray(checkArray: ArrayList<Boolean>) {
        var strBuilder = ""
        println("SIZE ${checkArray.size}")
        checkArray.forEach { strBuilder += "${if (it) 1 else 0}," }
        preferences.set(strBuilder.removeSuffix(","))
    }

    private fun setupSearch() {
        editSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(text: Editable?) {
                searchList(text.toString().trim())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }

    @SuppressLint("SetTextI18n")
    private fun searchList(text: String) {
        adapter.clear()
        if (text.isEmpty()) {
            textError.visibility = View.GONE
            cars.forEach { adapter.add(it) }
            return
        }
        cars.filter { it.name.contains(text, true) || it.licensePlate.contains(text, true) }
            .forEach {
                adapter.add(it)
            }
        if (adapter.itemCount > 0) {
            textError.visibility = View.GONE
        } else {
            textError.text = "No car found for \"$text\""
            textError.visibility = View.VISIBLE
        }
    }

    private fun setupList() {
        listCars.layoutManager = LinearLayoutManager(this)
        listCars.adapter = adapter
        cars.forEach { adapter.add(it) }
    }

    private fun populateCars() {
        val checkArray = getCheckArray()
        cars.add(CarModel(0, R.drawable.c_811, "811", "SL1CK", checkArray) {
            saveCheckArray(checkArray)
        })
        cars.add(
            CarModel(
                1,
                R.drawable.alpha,
                "Alpha",
                "V1S10NRY",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                2,
                R.drawable.banshee_900r,
                "Banshee 900R",
                "DR1FT3R",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                3,
                R.drawable.bestia_gts,
                "Bestia GTS",
                "BE4STY",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                4,
                R.drawable.cheetah,
                "Cheetah",
                "BUZZ3D",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                5,
                R.drawable.coquette_blackfin,
                "Coquette BlackFin",
                "V1NT4G3",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                6,
                R.drawable.coquette_classic,
                "Coquette Classic",
                "T0PL3SS",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                7,
                R.drawable.entity_xf,
                "Entity XF",
                "OV3RFLOD",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(CarModel(8, R.drawable.etr1, "ETR1", "PR3TTY", checkArray) {
            saveCheckArray(checkArray)
        })
        cars.add(
            CarModel(
                9,
                R.drawable.feltzer,
                "Feltzer",
                "POW3RFUL",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(CarModel(10, R.drawable.fmj, "FMJ", "C4TCHM3", checkArray) {
            saveCheckArray(checkArray)
        })
        cars.add(
            CarModel(
                11,
                R.drawable.jester,
                "Jester",
                "NOFOOL",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                12,
                R.drawable.mamba,
                "Mamba",
                "BLKM4MB4",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                13,
                R.drawable.massacro,
                "Massacro",
                "BO55",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                14,
                R.drawable.nightshade,
                "Nightshade",
                "TH37OS",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                15,
                R.drawable.omnis,
                "Omnis",
                "W1D3BOD",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                16,
                R.drawable.osiris,
                "Osiris",
                "SL33K",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                17,
                R.drawable.reaper,
                "Reaper",
                "D34TH4U",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                18,
                R.drawable.roosevelt_valor,
                "Roosevelt Valor",
                "OLDT1M3R",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                19,
                R.drawable.sabre_turbo_custom,
                "Sabre Turbo Custom",
                "BOUNC3",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                20,
                R.drawable.seven_70,
                "Seven-70",
                "4LLOY5",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                21,
                R.drawable.stirling_gt,
                "Stirling GT",
                "R4LLY",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                22,
                R.drawable.sultan_rs,
                "Sultan RS",
                "SNOWFLK3",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(CarModel(23, R.drawable.t20, "T20", "D3V1L", checkArray) {
            saveCheckArray(checkArray)
        })
        cars.add(
            CarModel(
                24,
                R.drawable.tampa,
                "Tampa",
                "CH4RG3D",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                25,
                R.drawable.tropos_rallye,
                "Tropos Rallye",
                "1985",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                26,
                R.drawable.turismo_r,
                "Turismo R",
                "TPD4WG",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(CarModel(27, R.drawable.tyrus, "Tyrus", "C1TRUS", checkArray) {
            saveCheckArray(checkArray)
        })
        cars.add(
            CarModel(
                28,
                R.drawable.verlierer,
                "Verlierer",
                "PR3C10US",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                29,
                R.drawable.x80_proto,
                "X80 Proto",
                "M4K3B4NK",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                30,
                R.drawable.z_type,
                "Z-Type",
                "B1GMON3Y",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
        cars.add(
            CarModel(
                31,
                R.drawable.zentorno,
                "Zentorno",
                "W1NN1NG",
                checkArray
            ) {
                saveCheckArray(checkArray)
            })
    }

}
