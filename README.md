# opencv-android-ktx
Some cool Kotlin Extensions to bring more productivity while
developing CV-based apps using OpenCV for Android.

# Usage
Add the code below in your root `build.gradle` file:

    allProjects {
        repositories {
            maven { url "https://jitpack.io" }
        }
    }
    
And in your `build.gradle` (app module) add the implementation command:
    
    dependencies {
        implementation 'com.github.ramonrabello:opencv-android-ktx:{latest version}'
    }

Please check the library [latest release](https://www.github.com/ramonrabello/opencv-android-ktx/releases) that can be used. 

# Kotlin Extensions for OpenCV
Thanks to the great power of Kotlin extension functions, instead of doing 
the following boilerplate code to convert a Bitmap using the Canny Edge Algorithm:
    
    val bitmap = ... // get a Bitmap
    val mat = Mat()
    Utils.bitmapToMat(bitmap, mat)
    Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY)
    Imgproc.Canny(mat, mat, 50, 50)
    val newBitmap = Bitmap.createBitmap(mat.cols(), mat.rows(), Config.ARGB_8888)
    Utils.matToBitmap(mat, newBitmap)
    imageView.setImageBitmap(newBitmap)
  
you can reduce considerably all the boilerplate by doing only this:

    // using default values for thresholds
    mat.canny(srcBitmap) {
        imageView.setImageBitmap(it) // 'it' is the result Bitmap
    }
    
    // using custom values for thresholds
    mat.canny(srcBitmap, 50, 100) {
        imageView.setImageBitmap(it) // it is the result Bitmap
    }
                        
All the pre-processing like converting to gray scale channel, Mat instantiation, Bitmap conversion, etc are being handled
by the `Mat.canny()` extension function. The available extension functions are:
- __Mat.toGray():__ Converts to gray scale channel (from RGB)
- __Mat.gaussianBlur():__ Apply Gaussian Blur Algorithm
- __Mat.canny():__ Apply Canny Edge Algorithm
- __Mat.threshold():__ Apply Threshold Algorithm (BINARY or BINARY_INV)
- __Mat.adaptiveThreshold():__ Apply Adaptive Threshold Algorithm
- __Mat.toBitmap():__ Converts `Mat` to `Bitmap` representation
- __Mat.inGray():__ Checks if Bitmap `Mat` is in gray scale
- __Bitmap.toMat():__ Converts to a `Mat` representation of a Bitmap

More extensions functions will be added in the future. Any pull request, suggestions, bug issues
are welcome to better enhance and evolve this project.

# Disclaimer
This project was developed entirely by my own according to previous experience in creating CV-based apps. 
I'm not directly involved in OpenCV development and maintenance.
    
# License
    Copyright 2018 Ramon Rabello
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.