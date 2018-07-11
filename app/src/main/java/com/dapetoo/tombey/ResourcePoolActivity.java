package com.dapetoo.tombey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResourcePoolActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_pool);
        setTitle("Resource Pool");

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

//        // Listview Group click listener
//        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v,
//                                        int groupPosition, long id) {
//                // Toast.makeText(getApplicationContext(),
//                // "Group Clicked " + listDataHeader.get(groupPosition),
//                // Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
//        // Listview Group expanded listener
//        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Expanded",
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        // Listview Group collasped listener
//        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getApplicationContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });

//        // Listview on child click listener
//        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v,
//                                        int groupPosition, int childPosition, long id) {
//                // TODO Auto-generated method stub
//                Toast.makeText(
//                        getApplicationContext(),
//                        listDataHeader.get(groupPosition)
//                                + " : "
//                                + listDataChild.get(
//                                listDataHeader.get(groupPosition)).get(
//                                childPosition), Toast.LENGTH_SHORT)
//                        .show();
//                return false;
//            }
//        });
//    }

    /*
	 * Preparing the list data
	 */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Urban Adolescent SRH SBCC Implementation Kit");
        listDataHeader.add("Teen Health Source");
        listDataHeader.add("WHO Adolescent Sexual and Reproductive Health");
        listDataHeader.add("Teen Health Info");
        listDataHeader.add("Sexual Health Glossary");

        // Adding child data
        List<String> condoms = new ArrayList<String>();
        condoms.add("https://sbccimplementationkits.org/urban-youth/\n" +
                "\n" +
                "This provides a tool to help develop programs for urban adolescents on sexual and reproductive health " +
                "and behaviour change.");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("http://teenhealthsource.com/quiz/\n" +
                "\n" +
                "Take quizzes and assessments to find out more about your sexual health and knowledge");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("http://www.who.int/reproductivehealth/topics/adolescence/en/\n" +
                "\n" +
                "The World Health Organization’s work on adolescent sexual and reproductive health");

        List<String> teenHealth = new ArrayList<String>();
        teenHealth.add("http://kidshealth.org/en/teens/sexual-health/\n" +
                "\n" +
                "Lots and lots of information about teens health");

        List<String> SHG = new ArrayList<String>();
        SHG.add("http://www.ashasexualhealth.org/sexual-health-glossary/\n" +
                "\n" +
                "Definitions of key sexual health terms used around world");

        listDataChild.put(listDataHeader.get(0), condoms); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), teenHealth);
        listDataChild.put(listDataHeader.get(4), SHG);
    }
}

