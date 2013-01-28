package src;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-25
 * Time: 下午4:07
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private int currentIndex;
    private int money=10;
    public int bombNum=0,blockNum=0,robotNum=0;
    List BombList,BlockList,RobotList;
    private static final int SEARCHSTEP = 10;

    public Player(){
        BombList=new ArrayList();
        BlockList= new ArrayList();
        RobotList=new ArrayList();
    }





    public void forward(RichGameMap map, int rollingStep) {
        if(checkBlock(map, rollingStep)!=-1){
            currentIndex=checkBlock(map, rollingStep);
        } else if(checkBomb(map, currentIndex+rollingStep)) {
            currentIndex=14;
     }  else {
           currentIndex+= rollingStep;
        }


    }

    private int checkBlock(RichGameMap map, int destIndex) {
        for(int i=this.currentIndex;i<destIndex;i++) {
            LandForm tempLandForm=(LandForm)map.landList.get(i);
            if(tempLandForm.blockFlag){
                return tempLandForm.index;
            }
        }
        return -1;

    }

    public int getIndex() {

        return currentIndex;
    }
    public int getMoney(){
        return money;
    }

    public boolean checkBomb(RichGameMap map,int destIndex) {
        for(int i=this.currentIndex;i<destIndex;i++) {
            LandForm tempLandForm=(LandForm)map.landList.get(i);
            if(tempLandForm.bombFlag){
                return tempLandForm.bombFlag;
            }
        }
        return false;

    }

    public void setBomb(RichGameMap map, int index) {
        LandForm tempLandForm=(LandForm)map.landList.get(index);
        tempLandForm.setBomb();

    }

    public void setBlock(RichGameMap map, int index) {
        LandForm tempLandForm=(LandForm)map.landList.get(index);
        tempLandForm.setBlock();

    }

    public void useRobot(RichGameMap map) {
        int startIndex=currentIndex-SEARCHSTEP;
        int stopIndex=currentIndex+SEARCHSTEP;
        Robot robot=(Robot)RobotList.get(0);
        robot.clearBombAndBlock(map, currentIndex);
        RobotList.remove(0);
        robotNum--;


    }



    private int findBomb(RichGameMap map, int startIndex, int stopIndex) {
            return map.findBomb(startIndex,stopIndex);
    }

    public void buyRobot() {

        if(money-Robot.price>=0){
            RobotList.add(new Robot());
            robotNum++;
        }

    }
}
