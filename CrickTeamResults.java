package com.cricket.testvagrant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CrickTeamResults {

	String name;
	int points;
	char[] results;

	public CrickTeamResults(String name, int points, char[] results) {
		super();
	    this.name = name;
		this.points = points;
		this.results = results;
	}
//  method for finding 2 consecutive losses
	public static ArrayList<String> results(ArrayList<CrickTeamResults> a)

	{
		ArrayList<String> tname = new ArrayList<>();

		for (CrickTeamResults crickTeamResults : a) {
			int count = 0;
			char[] results = crickTeamResults.results;
            for (int i = 1; i < crickTeamResults.results.length; i++) {
				if (results[i - 1] == 'l' && results[i] == 'l') {
					count++;

                     if (count == 1) {
						tname.add(crickTeamResults.name);
					}
				}
			}
         }
		return tname;
	}
//  method for finding n cosecutive losses or wins
	public static ArrayList<CrickTeamResults> consecutiveResults(ArrayList<CrickTeamResults> a) {
		Scanner sc = new Scanner(System.in);
        	System.out.println("Enter the number of consecutive win or loss");
		int num = sc.nextInt();
		System.out.println("Enter w or l");
		char c = sc.next().toLowerCase().charAt(0);

		ArrayList<CrickTeamResults> tname = new ArrayList<>();

		for (CrickTeamResults crickTeamResults : a) {
			int count = 0;
			char[] results = crickTeamResults.results;

			for (int i = 1; i < crickTeamResults.results.length; i++) {

				if (results[i - 1] == c && results[i] == c) {
					count++;
					if (count == num - 1) {

						tname.add(crickTeamResults);
                                      }
				}
         	         }
		}
		return tname;
	}
	 public String toString() {
		return "CrickTeamResults [name=" + name + ", points=" + points + ", results=" + Arrays.toString(results) + "]";
	}
 }
//     Driver  Code
class DriverCrickTeamResults {

	public static void main(String[] args) {
		 try {
			
	      ArrayList<CrickTeamResults> a=new ArrayList<>();
		
		a.add(new CrickTeamResults("GT", 20, new char[] {'w', 'w', 'l', 'l', 'w'}));
		a.add(new CrickTeamResults("LSG",18, new char[] {'w', 'l', 'l', 'w', 'w'}));
		a.add(new CrickTeamResults("RR", 16, new char[] {'w', 'l', 'w', 'l', 'l'}));
		a.add(new CrickTeamResults("DC", 14, new char[] {'w', 'w', 'l', 'W', 'L'}));
		a.add(new CrickTeamResults("RCB",14, new char[] {'l', 'w', 'w', 'L', 'L'}));
		a.add(new CrickTeamResults("KKR",12, new char[] {'l', 'w', 'w', 'L', 'W'}));
		a.add(new CrickTeamResults("PBKS",12,new char[] {'l', 'w', 'l', 'w', 'l'}));
		a.add(new CrickTeamResults("SRH",12, new char[] {'w', 'l', 'l', 'l', 'l'}));
		a.add(new CrickTeamResults("CSK",8, new char[] {'l', 'l', 'w', 'l', 'w'}));
		a.add(new CrickTeamResults("MI", 6, new char[] {'l', 'w', 'l', 'w', 'w'}));
		 
		  System.out.println("Teams Added Sucessfully");
		  System.out.println("1.Teams with two Consecutive Losses are :");
      //		 calling method 1
		   System.out.println(CrickTeamResults.results(a));
     //	      calling method 2  
		   ArrayList<CrickTeamResults> teams = CrickTeamResults.consecutiveResults(a) ;
		   int sum=0 ; 
		   System.out.println("Teams are : ");
		  for(CrickTeamResults team : teams) {
			  System.out.println(team);
			  sum = sum + team.points ;
		  }
		  //	to give Average Points
         System.out.println("3.The average points of filtered teams is :" + sum/teams.size());
         
		  } 
	
	      catch (ArithmeticException e) {
		               System.out.println("There are no teams with this result ");
		         }
                }
      }

