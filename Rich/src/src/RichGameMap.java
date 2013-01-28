package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-25
 * Time: 下午8:48
 * To change this template use File | Settings | File Templates.
 */
public class RichGameMap {
    List landList=new ArrayList();
    //LandForm []land;
    LandForm startPoint,toolHouse,magicHouse,giftHouse,hospital,prison;
    LandForm []bareLands;
    LandForm  []mines;
    private static final int LANDNUM = 70;

    public RichGameMap(){
        startPoint=new StartPoint();
        landList.add(startPoint);
        bareLands=new BareLand[58];
        mines=new Mine[6];
        int k=0;
        for(int i=1;i<64;i++) {
            if(i==14) {
                hospital=new Hospital(i);
                landList.add(hospital);
            }else if(i==28){
                toolHouse=new ToolHouse(i);
                landList.add(toolHouse);
            } else if(i==35){
                giftHouse=new GiftHouse(i);
                landList.add(giftHouse);

            }else if(i==49){
                prison=new Prison(i);
                landList.add(prison);
            } else if(i==63){
                magicHouse=new MagicHouse(i);
                landList.add(magicHouse);
            }  else {
                bareLands[k]=new BareLand(i);
                landList.add(bareLands[k]);
                k++;
            }
        }
        for(int i=0;i<6;i++){
            mines[i]=new Mine(64+i);
            landList.add(mines[i]);

        }
    }
    public void diplay(){
        for(int i=0;i<70;i++){
            LandForm tempLandForm=(LandForm)landList.get(i);
            System.out.print(tempLandForm.name);

        }
    }


    public int findBomb(int startIndex, int stopIndex) {
        startIndex=(startIndex+LANDNUM)%LANDNUM;
        stopIndex=(stopIndex+LANDNUM)%LANDNUM;
        if(startIndex>stopIndex){
            for(int i=startIndex;i<LANDNUM;i++){
                LandForm tempLandForm=(LandForm)landList.get(i);
                if(tempLandForm.bombFlag){
                    return tempLandForm.index;
                }
            }
            for(int i=0;i<stopIndex;i++){
                LandForm tempLandForm=(LandForm)landList.get(i);
                if(tempLandForm.bombFlag){
                    return tempLandForm.index;
                }
            }

        }
        else{
        for(int i=startIndex;i<stopIndex;i++){
            LandForm tempLandForm=(LandForm)landList.get(i);
            if(tempLandForm.bombFlag){
                return tempLandForm.index;
            }
        }
        }





        return -1;

    }

    public void clearBomb(int bombIndex) {
        LandForm tempLandForm=(LandForm)landList.get(bombIndex);
        assert(tempLandForm.bombFlag==true);
        tempLandForm.bombFlag=false;

    }
}
