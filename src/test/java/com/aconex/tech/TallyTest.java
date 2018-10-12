package com.aconex.tech;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class TallyTest {
    File resourcesDirectory = new File("src/test/java/com/aconex/tech/resources/CandidateList.txt");

    @Test
    public void getWinnerTest1(){
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        ArrayList<Vote> voteList = new ArrayList<Vote> ();
        voteList.add (new Vote  ("ABCD"));
        voteList.add (new Vote  ("BAD"));
        voteList.add (new Vote  ("CABD"));
        voteList.add (new Vote  ("CDAB"));
        voteList.add (new Vote  ("DA"));
        voteList.add (new Vote  ("DB"));
        voteList.add (new Vote  ("BAC"));
        voteList.add (new Vote  ("CBAD"));

        String Win = new Tally(voteList).getWinner();
        ArgumentValidator.checkArgumentNullOrEmpty (Win);
        System.out.println ("Winner is "+Win );
        Assert.assertEquals (Win,"Ten pin bowling");
    }

    @Test
    public void getWinnerTest2(){
        Candidate.readCandidateList (resourcesDirectory.getAbsolutePath ());
        ArrayList<Vote> voteList = new ArrayList<Vote> ();
        voteList.add (new Vote ("ACD"));
        voteList.add (new Vote  ("BD"));
        voteList.add (new Vote  ("ABC"));
        voteList.add (new Vote  ("CD"));
        voteList.add (new Vote  ("B"));
        voteList.add (new Vote ("ACDB"));
        String Win = new Tally(voteList).getWinner();
        ArgumentValidator.checkArgumentNullOrEmpty (Win);
        Assert.assertEquals (Win,"Winery tour");
    }
}
