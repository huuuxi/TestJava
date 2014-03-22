package com.huuuxi.funny;
/**   
 * @Title: AnswerEverthing.java 
 * @Description: 
 * @author huuuxi 
 * @Email huuuxi@gmail.com 
 * @date 2014-3-20 下午11:42:33 
 */
public class AnswerEverthing {
	 public static void  mains()  {
	        String s = "Hitchhiker's Guide to the Galaxy";
	        String s2 = "Don'tPanic";
	        String s3 = "The Restaurant at the End of the Universe.";
	 
	        int arthur_dent = s.length();
	        int ford_prefect = s2.length();
	        int zooey_deschanel = s3.length();
	        int vogon_poetry = arthur_dent + ford_prefect;
	 
	        System.out.println("         " + vogon_poetry + "       " + zooey_deschanel + " " + zooey_deschanel); //in case you're confused, I'm using Zooey to print the big '2', and Vogons to print the big '4'.
	        System.out.println("       " + vogon_poetry + vogon_poetry + "     " + zooey_deschanel + "     " + zooey_deschanel);
	        System.out.println("     " + vogon_poetry + "  " + vogon_poetry + "    " + zooey_deschanel + "       " + zooey_deschanel);
	        System.out.println("   " + vogon_poetry + "    " + vogon_poetry + "            " + zooey_deschanel);
	        System.out.println(" " + vogon_poetry + "      " + vogon_poetry + "          " + zooey_deschanel);
	        System.out.println(vogon_poetry + " " + vogon_poetry + " " + vogon_poetry + " DA " + vogon_poetry + "     " + zooey_deschanel);
	        System.out.println("         " + vogon_poetry + "     " + zooey_deschanel);
	        System.out.println("         " + vogon_poetry + "    " + zooey_deschanel + " " + zooey_deschanel + " " + zooey_deschanel + " " + zooey_deschanel);
	    }
	 
	 public static void main(String[] args) {
		mains();
	}
}
