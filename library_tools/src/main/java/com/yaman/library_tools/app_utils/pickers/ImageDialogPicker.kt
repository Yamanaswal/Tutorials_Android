package com.yaman.library_tools.app_utils.pickers

import android.Manifest
import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import android.provider.MediaStore
import androidx.core.net.toUri
import com.google.android.material.snackbar.Snackbar
import com.yaman.library_tools.R
import com.yaman.library_tools.databinding.FragmentImageDialogPickerBinding
import java.io.ByteArrayOutputStream
import java.io.File


class ImageDialogPicker(imagePickerInterface: ImagePickerInterface) : DialogFragment() {

    lateinit var binding: FragmentImageDialogPickerBinding

    private val imageDialogPicker: ImagePickerInterface = imagePickerInterface
    private var cameraPermissionGranted: Boolean = false
    private var galleryPermissionGranted: Boolean = false

    companion object {
        private const val TAKE_PICTURE = 1
        private const val GALLERY_PICTURE = 2
        const val TAG = "ImageDialogPicker"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_image_dialog_picker,
            container,
            false
        )

        binding.camera.setOnClickListener {
            if(cameraPermissionGranted){
                openCamera()
            }else{
                Snackbar.make(requireView(), "To Access Camera Need Permission From Settings.", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.gallery.setOnClickListener {
            if(galleryPermissionGranted){
                openGallery()
            }else{
                Snackbar.make(requireView(), "To Access Gallery Need Permission From Settings.", Snackbar.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.ThemeOverlay_AppCompat_Dialog_Alert)
    }

    private fun openGallery() {
        try {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(
                Intent.createChooser(intent, "Select Image"),
                GALLERY_PICTURE
            )
        } catch (e: Exception) {
            Log.e(TAG, "openCamera: $e")
        }
    }

    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, TAKE_PICTURE)
        } catch (e: Exception) {
            Log.e(TAG, "openCamera: $e")
            // display error state to the user
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.e(TAG, "onActivityResult: ${data?.data}")

        if (resultCode == RESULT_OK) {
            if (requestCode == TAKE_PICTURE) {
                Log.e(TAG, "onActivityResult: PHOTO : ${data?.data}")
                Log.e(TAG, "onActivityResult: Extra : " + data?.extras?.get("data"))
                val photo = data!!.extras!!["data"] as Bitmap?
                imageDialogPicker.getUri(getImageUri(requireContext(), photo!!))
            } else if (requestCode == GALLERY_PICTURE) {
                Log.e(TAG, "onActivityResult: GALLERY : ${data?.data}")
                imageDialogPicker.getUri(data?.data)
            }
        }
        dismiss()
    }



}

interface ImagePickerInterface {
    fun getUri(uri: Uri?)
}

//Convert To URI For Camera
fun getImageUri(context: Context, inImage: Bitmap): Uri {
    val file = File(context.cacheDir, "CUSTOM NAME") //Get Access to a local file.
    file.delete() // Delete the File, just in Case, that there was still another File
    file.createNewFile()
    val fileOutputStream = file.outputStream()
    val byteArrayOutputStream = ByteArrayOutputStream()
    inImage.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
    val bytearray = byteArrayOutputStream.toByteArray()
    fileOutputStream.write(bytearray)
    fileOutputStream.flush()
    fileOutputStream.close()
    byteArrayOutputStream.close()
    return file.toUri()
}


