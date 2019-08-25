package com.akitektuo.gtacarcollections

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class CarModel(val id: Int, val image: Int, val name: String, val licensePlate: String, val checkArray: ArrayList<Boolean>, val onClick: () -> Unit = {})

class CarViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val layout = view.findViewById<ConstraintLayout>(R.id.layoutCar)
    private val image = view.findViewById<ImageView>(R.id.imageCar)
    private val imageDivider = view.findViewById<ImageView>(R.id.imageDivider)
    private val textName = view.findViewById<TextView>(R.id.textCarName)
    private val textLicensePlate = view.findViewById<TextView>(R.id.textCarLicensePlate)
    private val checkCollected = view.findViewById<CheckBox>(R.id.checkCollected)

    fun bind(item: CarModel, hideDivider: Boolean = false) {
        with(item) {
            if (hideDivider) {
                imageDivider.visibility = View.GONE
            } else {
                imageDivider.visibility = View.VISIBLE
            }
            Glide.with(view).load(image).into(this@CarViewHolder.image)
            textName.text = name
            textLicensePlate.text = licensePlate
            checkCollected.isChecked = checkArray[id]
            layout.setOnClickListener {
                checkCollected.isChecked = !checkCollected.isChecked
            }
            checkCollected.setOnCheckedChangeListener { _, isChecked ->
                if (view.isAttachedToWindow) {
                    checkArray[id] = isChecked
                    println("AFTER $checkArray")
                    onClick()
                }
            }
        }
    }

}

class CarAdapter : RecyclerView.Adapter<CarViewHolder>() {

    private val cars = ArrayList<CarModel>()

    override fun getItemCount() = cars.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CarViewHolder(parent.inflate(R.layout.item_car))

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) = holder.bind(cars[position], position == itemCount - 1)

    fun add(car: CarModel) {
        val position = cars.size
        cars.add(car)
        notifyItemInserted(position)
    }

    fun clear() {
        cars.clear()
        notifyDataSetChanged()
    }

}

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}