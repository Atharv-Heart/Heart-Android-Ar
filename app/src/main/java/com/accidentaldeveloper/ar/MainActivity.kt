package com.accidentaldeveloper.ar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import io.github.sceneview.SceneView
import io.github.sceneview.ar.node.ArModelNode

class MainActivity : AppCompatActivity() {
    lateinit var sceneView: SceneView
    lateinit var palce: ExtendedFloatingActionButton
    lateinit var modelNode:ArModelNode
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
        val receivedIntent = intent
        val receivedData = receivedIntent.data
        var key = receivedIntent.getStringExtra("vinit")
        var filevalue = key.toString()
        if(key=="1"){
            //filevalue = "models/the_great_stupa_at_sanchi.glb"
            filevalue = "models/ganeshji.glb"
        }
        else if(key=="2"){
            filevalue = "models/the_great_stupa_at_sanchi.glb"

        }else if(key=="3"){
            filevalue = "models/god.glb"

        }

        sceneView = findViewById<SceneView>(R.id.sceneView)
       /* palce = findViewById<ExtendedFloatingActionButton>(R.id.place)*/

        /*palce.setOnClickListener {
            place()

        }*/

        modelNode = ArModelNode().apply{
            loadModelGlbAsync(

                glbFileLocation =  filevalue
                /*"models/the_great_stupa_at_sanchi.glb"*/
            )
            {
                sceneView.isVisible = true
            }
            onAnchorChanged = {
               /* palce.isGone*/
            }
        }

        sceneView.addChild(modelNode)

    }

 /*   private fun place(){
        modelNode?.anchor()
        sceneView.isVisible = false
    }*/
}