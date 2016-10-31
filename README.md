## CircularProgressView ##

A very simple progress view, you can custom the circular ring's **colors** and the **size**.

### Demo ###

<img src="https://github.com/Runly/CircularProgressView/blob/master/demo/demo.gif" width = "300" height = "533.4" align=center />

### Usage ###

- Add it in your **root** `build.gradle` at the end of repositories:
<pre><code>
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
</code></pre>

- Add it in your **app** `build.gradle` at the end of dependencies:
<pre><code>
dependencies {
    compile 'com.github.Runly:CircularProgressView:v2.0.0'
}
</code></pre>

##### XML #####

```xml

	<com.github.runly.circularprogressview.ProgressView
        android:id="@+id/progress_view"
        android:layout_width="100dp"
        android:layout_height="100dp" />

```

##### Java #####

```java

	ProgressView progress1 = (ProgressView) findViewById(R.id.progress1);
	//set the stroke size with dp
	progress1.setStrokeSizeDp(mContext, 5); 
	//set the color
	progress1.setStrokeColors(new int[] {Color.BLUE});

	ProgressView progress2 = (ProgressView) findViewById(R.id.progress2);
	//set the stroke size with px
    progress2.setStrokeSizePx(15);
	//set the colors
    progress2.setStrokeColors(new int[] {Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW});

```

##### You can also use ProgressView without XML #####

```java

	ProgressView progressView = new ProgressView(mContext, null);
	progressView.setStrokeSizeDp(context, 20);
	progressView.setStrokeColors(new int[] {Color.WHITE});

```


### More ###


###### Three methods ######
- start()

means start and Display the progress view
			  
```java

	progress = (ProgressView) findViewById(R.id.progress);
	/*   xxxxxxx   */
	progress3.start()；

```

In default casa, if you initialize a ProgressView, it will auto start, you needn't call `start()`. 

- setAutoStart(boolean isAutoStart)

If you don't want it auto start, you can call this method.

```java

	progress = (ProgressView) findViewById(R.id.progress);
    /*   xxxxxxx   */
	progress.setAutoStart(false);

```

- stop()

means stop and disappear the progress view

```java

		progress = (ProgressView) findViewById(R.id.progress);
    	/*   xxxxxxx   */
		progress3.stop()；

```