package com.datarita.ultimatecamera.turu.activities;

import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.datarita.ultimatecamera.turu.NavigationDrawerFragment;
import com.datarita.ultimatecamera.turu.R;
import com.datarita.ultimatecamera.turu.fragments.BaseFragment;
import com.datarita.ultimatecamera.turu.fragments.HorizontalPhotoGalleryFragment;
import com.datarita.ultimatecamera.turu.fragments.NativeCameraFragment;
import com.datarita.ultimatecamera.turu.fragments.SimpleAndroidImagePickerFragment;
import com.datarita.ultimatecamera.turu.fragments.SimpleCameraIntentFragment;
import com.datarita.ultimatecamera.turu.fragments.SimplePhotoGalleryListFragment;


public class MainActivity extends CameraActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, BaseFragment.OnFragmentInteractionListener {

    /**
     * Actions
     */
    public static final int SELECT_PHOTO_ACTION = 0;

    /**
     * Fragment Identifiers
     */
    public static final int SIMPLE_CAMERA_INTENT_FRAGMENT = 0;
    public static final int SIMPLE_PHOTO_GALLERY_FRAGMENT = 1;
    public static final int SIMPLE_PHOTO_PICKER_FRAGMENT = 2;
    public static final int NATIVE_CAMERA_FRAGMENT = 3;
    public static final int HORIZONTAL_GALLERY_FRAGMENT = 4;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {

        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        BaseFragment targetFragment = null;

        // Populate the fragment
        switch (position) {
            case SIMPLE_CAMERA_INTENT_FRAGMENT: {
                targetFragment = SimpleCameraIntentFragment.newInstance(position + 1);
                break;
            }
            case SIMPLE_PHOTO_GALLERY_FRAGMENT: {
                targetFragment = SimplePhotoGalleryListFragment.newInstance(position + 1);
                break;
            }
            case SIMPLE_PHOTO_PICKER_FRAGMENT: {
                targetFragment = SimpleAndroidImagePickerFragment.newInstance(position + 1);
                break;
            }
            case NATIVE_CAMERA_FRAGMENT: {
                targetFragment = NativeCameraFragment.newInstance(position + 1);
                break;
            }
            case HORIZONTAL_GALLERY_FRAGMENT:{
                targetFragment = HorizontalPhotoGalleryFragment.newInstance(position + 1);
                break;
            }
            default:
                break;
        }

        // Select the fragment.
        fragmentManager.beginTransaction()
                .replace(R.id.container, targetFragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    /**
     * Handle Incoming messages from contained fragments.
     */

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(String id) {

    }

    @Override
    public void onFragmentInteraction(int actionId) {

    }
}

