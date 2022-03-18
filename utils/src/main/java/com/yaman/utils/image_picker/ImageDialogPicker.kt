package com.yaman.utils.image_picker

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
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.yaman.permissions.PermissionManager
import com.yaman.permissions.PermissionResult
import com.yaman.utils.R
import com.yaman.utils.databinding.FragmentImageDialogPickerBinding
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.File

const val TAG = "ImageDialogPicker"

class ImageDialogPicker(imagePickerInterface: ImagePickerInterface) : DialogFragment() {

    lateinit var binding: FragmentImageDialogPickerBinding
    private val TAKE_PICTURE = 1
    private val GALLERY_PICTURE = 2
    private val PERMISSIONS_REQUEST_CAMERA = 3
    private val PERMISSIONS_REQUEST_GALLERY = 4
    private val imageDialogPicker: ImagePickerInterface = imagePickerInterface
    private var cameraPermissionGranted: Boolean = false
    private var galleryPermissionGranted: Boolean = false

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

        //Ask Permissions
        askPermissionsCamera()
        askPermissionsGallery()


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


    /**
     *  Camera Permission Handle
     * **/
    private fun askPermissionsCamera() {

        viewLifecycleOwner.lifecycleScope.launch {

            //Resume coroutine once result is ready
            when (PermissionManager.requestPermissions(
                this@ImageDialogPicker,
                PERMISSIONS_REQUEST_CAMERA,
                Manifest.permission.CAMERA,
            )) {
                is PermissionResult.PermissionGranted -> {
                    //Add your logic here after user grants permission(s)
                    Log.e(TAG, "askPermissions: PermissionGranted")
                    cameraPermissionGranted = true
                }
                is PermissionResult.PermissionDenied -> {
                    //Add your logic to handle permission denial
                    //Ask Again Permission
                    Log.e(TAG, "askPermissions: PermissionDenied")
                    askPermissionsCamera()
                    cameraPermissionGranted = false
                }
                is PermissionResult.PermissionDeniedPermanently -> {
                    //Add your logic here if user denied permission(s) permanently.
                    //Ideally you should ask user to manually go to settings and enable permission(s)
                    Log.e(TAG, "askPermissions: PermissionDeniedPermanently")
                    cameraPermissionGranted = false
                    Snackbar.make(
                        requireView(),
                        "Please Provide Camera Permissions From App Settings.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                is PermissionResult.ShowRational -> {
                    //If user denied permission frequently then she/he is not clear about why you are asking this permission.
                    //This is your chance to explain them why you need permission.
                    Log.e(TAG, "askPermissions: ShowRational")
                    cameraPermissionGranted = false
                    Snackbar.make(requireView(), "This App Need Camera Permissions.", Snackbar.LENGTH_SHORT).show()
                }
            }

        }
    }


    /**
     *  Gallery Permission Handle
     * **/
    private fun askPermissionsGallery() {

        viewLifecycleOwner.lifecycleScope.launch {

            //Resume coroutine once result is ready
            when (PermissionManager.requestPermissions(
                this@ImageDialogPicker,
                PERMISSIONS_REQUEST_GALLERY,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
            )) {
                is PermissionResult.PermissionGranted -> {
                    //Add your logic here after user grants permission(s)
                    Log.e(TAG, "askPermissions: PermissionGranted")
                    galleryPermissionGranted = true
                }
                is PermissionResult.PermissionDenied -> {
                    //Add your logic to handle permission denial
                    //Ask Again Permission
                    Log.e(TAG, "askPermissions: PermissionDenied")
                    askPermissionsGallery()
                    galleryPermissionGranted = false
                }
                is PermissionResult.PermissionDeniedPermanently -> {
                    //Add your logic here if user denied permission(s) permanently.
                    //Ideally you should ask user to manually go to settings and enable permission(s)
                    Log.e(TAG, "askPermissions: PermissionDeniedPermanently")
                    galleryPermissionGranted = false
                    Snackbar.make(
                        requireView(),
                        "Please Provide Camera Permissions From App Settings.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                is PermissionResult.ShowRational -> {
                    //If user denied permission frequently then she/he is not clear about why you are asking this permission.
                    //This is your chance to explain them why you need permission.
                    Log.e(TAG, "askPermissions: ShowRational")
                    galleryPermissionGranted = false
                    Snackbar.make(requireView(), "This App Need Storage Permissions.", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
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


