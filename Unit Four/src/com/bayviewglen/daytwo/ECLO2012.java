package com.bayviewglen.daytwo;

public class ECLO2012 {

	public static void main(String[] args) {

		String promoter = "TATAAT";
		String dna = "AGATTATATAATGATAGGATTTAGATTGACCCGTCATGCAAGTCCATGCATGACAGC";
		String tu = "GGATTTAGATTGACCC";
		String terminator = "";
		String done = "";
		String terminatorDecrypt = "";
		int endTu = 0;
		String terminatorReverse = "";

		int transStart = dna.indexOf("TATAAT") + 10;

		for (int i = 0; i < dna.length()-11; i++) {
			terminator = dna.substring(i, i + 6);
			terminatorDecrypt = "";
			for (int j = 0; j < terminator.length(); j++) {
				if (terminator.charAt(j) == 'G')
					terminatorDecrypt += "C";
				if (terminator.charAt(j) == 'A')
					terminatorDecrypt += "T";
				if (terminator.charAt(j) == 'T')
					terminatorDecrypt += "A";
				if (terminator.charAt(j) == 'C')
					terminatorDecrypt += "G";
				
			}
			for (int j=terminatorDecrypt.length()-1; j>=0; j--) {
				terminatorReverse += terminatorDecrypt.charAt(j);
		    
			}
			if (dna.indexOf(terminatorReverse) > 0)
				endTu += dna.indexOf(terminator);
			if (1 > 0)
				break;
			
				
		} System.out.println(terminatorReverse);

		for (int i = 0; i < tu.length(); i++) {
			if (tu.charAt(i) == 'G')
				done += "C";
			if (tu.charAt(i) == 'A')
				done += "U";
			if (tu.charAt(i) == 'T')
				done += "A";
			if (tu.charAt(i) == 'C')
				done += "G";
		}

		System.out.print("1: " + done);
		

	}
}



