package cs495.winatwaiting.datum;

import cs495.winatwaiting.fragments.ViewTaskActivityFilterFragment;
import cs495.winatwaiting.fragments.ViewTaskActivityViewListFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomPagerAdapter extends FragmentPagerAdapter {
	 
    Context mContext;

    public CustomPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
    	Fragment fragment = null;
    	switch(position){
    	case 0:
    		fragment = new ViewTaskActivityViewListFragment();
    		break;
    	case 1:
    		fragment = new ViewTaskActivityFilterFragment();
    		break;
    	}

        // Create fragment object

        // Attach some data to the fragment
        // that we'll use to populate our fragment layouts

        // Set the arguments on the fragment
        // that will be fetched in the
        // createView method

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
    	switch(position){
    	case 0:
    		return "View";
    	case 1:
    		return "Filter";
    	default:
    		return "";
    	}
    }
}