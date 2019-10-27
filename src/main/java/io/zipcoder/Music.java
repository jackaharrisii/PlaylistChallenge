package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){
        int output;
        int countForward = 0;
        int countBackward = 0;
        int indexF = startIndex;  //index in the forward loop
        int indexB = startIndex;  //index in the backward loop

        //create a loop to iterate forward through the array
        while(playList[indexF] != selection){
            if (indexF < playList.length){                                   //if we hit haven't reached the end
                if(playList[indexF+1] != playList[indexF]){countForward++;}  //count the number of steps if we have to move again
                indexF++;                                                    //advance to the next index
            }
            else{                                                            //if we hit the end
                if(playList[0] != playList[indexF]){countForward++;}         //count the number of steps if we have to move again
                indexF = 0;                                                  //loop back to the beginning
            }
        }

        //create a loop to iterate backward through the array
        while(playList[indexB] != selection){
            if (indexB > 0){                                                  //if we hit haven't reached the end
                if(playList[indexB-1] != playList[indexB]){countBackward++;}  //count the number of steps if we have to move again
                indexB--;                                                     //retrograde the index
            }
            else{                                                             //if we hit the end
                if(playList[playList.length-1] != playList[indexB]){countBackward++;}  //count the number of steps if we have to move again
                indexB = playList.length-1;                                   //then loop the index back around to the end of the playlist
            }
        }

        //compare the two loops, and set the shorter loop to the output variable
        if (countForward <= countBackward){output = countForward;}
        else {output = countBackward;}
        return output;
    }
}
