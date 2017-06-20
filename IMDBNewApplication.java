package enerlytics.android.com.testscripts;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;



/**
 * Created by ankita on 19/6/17.
 */
public class IMDBNewApplication {
    AndroidDriver dr;
    ListView listviewmovies;

    @Before
    public void beforeMethod() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, "Android");
        capabilities.setCapability("deviceName", "0123456789ABCDEF");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.imdb.mobile");
        capabilities.setCapability("appActivity", "com.imdb.mobile.landingpage.LandingPagesActivity");
        dr = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        dr.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

    }

    @Test()
    public void PlayStoreInstallApp() throws Exception {
        dr.findElementById("com.imdb.mobile:id/splash_not_now").click();
        dr.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        dr.findElementByXPath("//android.widget.TextView[@text = 'Movies']").click();
        dr.findElementById("com.imdb.mobile:id/see_all").click();
        System.out.println("Here is the list of popular movies alongwith their ratings and release year");
        System.out.println("Now I am looking for the latest movie :- The Mummy");
        Thread.sleep(1000);
        dr.findElementById("com.imdb.mobile:id/label").findElement(By.name("The Mummy (2017)")).click();
        Thread.sleep(1000);
    }

//    public ListView getListviewmovies() {
//        return listviewmovies;
//
//        listviewmovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
//            {
//                // position parameter gives the index or position of ListView Item which is Clicked
//                //TextView tv=(TextView)v.findViewById(R.id.textViewName);
//                //String name=tv.getText().toString();
//                //Toast.makeText(android.app.ActivityManager,"MoviesSelected: "+name, Toast.LENGTH_LONG).show();
//            }
//
//    }



    @After
    public void afterMethod() {

        if (dr != null) {
            dr.quit();

        }
    }
    }


