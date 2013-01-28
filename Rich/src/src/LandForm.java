package src;

/**
 * Created with IntelliJ IDEA.
 * User: dell
 * Date: 13-1-25
 * Time: 下午9:47
 * To change this template use File | Settings | File Templates.
 */
public abstract class LandForm {
    String name;
    protected int index;
    protected boolean bombFlag=false;
    public boolean blockFlag=false;

    public LandForm(String name, int index) {
            this.name=name;
            this.index=index;


    }

    public  void setBomb(){
        bombFlag=true;
    }

    public void setBlock(){
        blockFlag=true;
    }
}
