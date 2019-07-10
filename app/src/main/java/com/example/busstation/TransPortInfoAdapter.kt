package com.example.busstation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busstation.data.Driver
import com.example.busstation.data.TransportInfo
import kotlinx.android.synthetic.main.fragment_driver_buy_ticket.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class TransPortInfoAdapter(): RecyclerView.Adapter<TransPortInfoAdapter.InfoViewHolder>() {
   // class TransPortInfoAdapter(context: Context): RecyclerView.Adapter<TransPortInfoAdapter.InfoViewHolder>() {
    //private val inflater = LayoutInflater.from(context)

    //Local
     var TInfos:List<TransportInfo> = emptyList()
     private var CarInfos:List<Driver> = emptyList()
    public var noOfItem=1
    public var conectionState:Boolean =true

    //remote
    var TInfos2:List<com.example.busstation.data2.TransportInfo> = emptyList()
    var carInfos2:List<com.example.busstation.data2.Driver> = emptyList()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransPortInfoAdapter.InfoViewHolder {
            //val  recyclerViewItem = inflater.
              //      inflate(R.layout.recycler_view_item,parent,false)
        val  recyclerViewItem = LayoutInflater.from(parent.context).
            inflate(R.layout.recycler_view_item,parent,false)
        return InfoViewHolder(recyclerViewItem)

    }
///This is going to Change Depanding on interner connection
    /////<<<<<<<<<<>>>>>>>>>>>>>..
   // override fun getItemCount()=TInfos.size
override fun getItemCount()=noOfItem
   // TInfos2.size


    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        if(!conectionState) {
            //Local
            val tInfo = TInfos[position]
            val carInfo = CarInfos[position]
            holder.dateTv.text = tInfo.transportDate
            holder.timeTv.text = tInfo.transportTime
            holder.seatNo.text = carInfo.seatNo.toString()
            holder.sideNo.text = carInfo.carSideNo.toString()
        }else {
            //Remote
            val tInfo2 = TInfos2[position]
            val carInfo2 = carInfos2[position]
            holder.dateTv.text = tInfo2.transportDate
            holder.timeTv.text = tInfo2.transportTime
            holder.seatNo.text = carInfo2.seatNo.toString()
            holder.sideNo.text = carInfo2.carSideNo.toString()
        }

         }
    internal fun setTransportInfo(TInfos:List<TransportInfo>){
        this.TInfos = TInfos
        notifyDataSetChanged()

    }
    //Remote
    internal fun setTransportInfo2(TInfos:List<com.example.busstation.data2.TransportInfo>){
        this.TInfos2 = TInfos
        notifyDataSetChanged()

    }
    internal fun setCarInfo(CarInfos:List<Driver>){
        this.CarInfos = CarInfos
        notifyDataSetChanged()
    }
    //Remote
    internal fun setCarInfo2(CarInfos:List<com.example.busstation.data2.Driver>){
        this.carInfos2 = CarInfos
        notifyDataSetChanged()
    }

    inner class InfoViewHolder(view:View):RecyclerView.ViewHolder(view){
        val dateTv = view.date_tv
        val timeTv = view.time_tv
        val seatNo = view.seat_no_tv
        val sideNo = view.side_no_tv


    }


}