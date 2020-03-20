
![](https://github.com/image-assets/gif/blob/master/recyclerView.gif)

## Permissions

    <uses-permission android:name="android.permission.INTERNET"/>

## Dependencies

    dependencies {
       
        // Lifecycle components
        def lifecycle_version = "2.2.0"
        implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
        implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version"
    
        // Glide
        def glideVersion = '4.11.0'
        implementation "com.github.bumptech.glide:glide:$glideVersion"
        annotationProcessor "com.github.bumptech.glide:compiler:$glideVersion"
    
        //RecyclerView
        implementation 'com.android.support:recyclerview-v7:28.0.0'
    
        //Support Design for Coordinator layout
        implementation 'com.android.support:design:28.0.0'
    
        //circle imageview
        implementation 'de.hdodenhof:circleimageview:2.2.0'
    
    
    }

