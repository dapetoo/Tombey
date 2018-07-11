package com.dapetoo.tombey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQsActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
	 * Preparing the list data
	 */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Do condoms fail?");
        listDataHeader.add("Why reproductive health education");
        listDataHeader.add("Dont programs for youth push contraceptives on young people?");

        // Adding child data
        List<String> condoms = new ArrayList<String>();
        condoms.add("When used consistently and correctly, latex condoms are extremely effective. Most condom failure results not because of condoms break or leak, but because they are used incorrectly. More information about contraceptives and more education about how to use them increases the chance that contraceptives will be used correctly and consistently. Accurate information will help teenagers make responsible decisions about whether to have sex and about the most appropriate way to avoid STDs and unintended pregnancy.");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The goal of reproductive health education is to promote young people's health. Good sexuality education focuses on both factual information and skills development in setting goals, communicating about whether to have sex, negotiating abstinence or contraceptive use, and resisting peer pressure. In many schools, reproductive health education focuses only on anatomy and physiology or population and neglects the important role of family life or relationships in sexuality education.");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("When used consistently and correctly, latex condoms are extremely effective. Most condom failure results not because of condoms break or leak, but because they are used incorrectly. More information about contraceptives and more education about how to use them increases the chance that contraceptives will be used correctly and consistently. Accurate information will help teenagers make responsible decisions about whether to have sex and about the most appropriate way to avoid STDs and unintended pregnancy.");

        listDataChild.put(listDataHeader.get(0), condoms); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}

