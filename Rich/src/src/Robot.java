package src;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-27
 * Time: 下午8:44
 * To change this template use File | Settings | File Templates.
 */
public class Robot extends OwnedTools {
    private static final int LANDNUM = 70;
    public static int price=0;
    private static final int SEARCHSTEP = 10;

    public Robot(){
        name="Robot";
    }

 /*   public void clearBomb(RichGameMap map, int playerIndex) {
        map.clearBomb(playerIndex);

    }   */

    public boolean isWithinRange(int bombIndex,int currentIndex) {
        if(Math.abs(bombIndex-currentIndex)<11){
            return true;
        }  else if(LANDNUM-Math.abs(bombIndex-currentIndex)<11){
            return true;
        }
        return false;

    }
    public void clearBombAndBlock(RichGameMap map, int playerIndex) {
        int startIndex=(playerIndex-SEARCHSTEP+LANDNUM)%LANDNUM;
        int stopIndex=(playerIndex+SEARCHSTEP+LANDNUM)%LANDNUM;
        if(startIndex>stopIndex){
            for(int i=startIndex;i<LANDNUM;i++){
                LandForm tempLandForm=(LandForm)map.landList.get(i);
                tempLandForm.bombFlag=false;
                tempLandForm.blockFlag=false;

            }
            for(int i=0;i<stopIndex;i++){
                LandForm tempLandForm=(LandForm)map.landList.get(i);
                tempLandForm.bombFlag=false;
                tempLandForm.blockFlag=false;
            }

        }
        else{
            for(int i=startIndex;i<stopIndex;i++){
                LandForm tempLandForm=(LandForm)map.landList.get(i);
                tempLandForm.bombFlag=false;
                tempLandForm.blockFlag=false;
            }
        }

    }

}
