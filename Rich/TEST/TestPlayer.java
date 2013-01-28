import com.sun.deploy.uitoolkit.ToolkitStore;
import org.junit.Test;
import src.Player;
import src.RichGameMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class TestPlayer {
    //Given
    Player player=new Player();
    RichGameMap map=new RichGameMap();
      @Test
    public void should_forward_by_n_when_rolling_for_n(){
          //when
          player.forward(map, 10);
          int index=player.getIndex();
          //then
          assertThat(index,is(10));
    }
    @Test
    public void should_forward_by_k_when_there_is_a_block_after_k_step(){
          //when
        player.setBlock(map,3);
        player.forward(map, 6);
        int index=player.getIndex();
        //then
        assertThat(index,is(3));

    }
    @Test
    public void should_be_in_true_when_there_is_a_bomb(){
        player.setBomb(map,5);
        boolean flag=player.checkBomb(map,10);
        assertThat(flag,is(true));

    }
    @Test
    public void should_be_in_hospital_when_there_is_bomb_in_the_way(){
        player.setBomb(map,5);
        //boolean flag=player.checkBomb(map,10);
        player.forward(map,10);
        assertThat(player.getIndex(),is(14));
    }
    @Test
    public void should_be_in_destIndex_when_player_has_a_robot_when_there_is_a_bomb_within_10_steps(){
        player.setBomb(map,5);
        player.buyRobot();
        player.useRobot(map) ;
        player.forward(map,10);
        assertThat(player.getIndex(),is(10));
    }
    @Test
    public void should_be_in_destIndex_when_player_has_a_block_when_there_is_a_block_within_10_steps(){
        //when
        player.setBlock(map,5);
        player.buyRobot();
        player.useRobot(map);
        player.forward(map,10);
        //then
        assertThat(player.getIndex(),is(10));
    }
    @Test
    public void should_be_in_the_destIndex_when_there_is_bomb_and_block_in_the_way_but_player_has_robot(){
        //when
        player.setBlock(map,6);
        player.setBomb(map,8);
        player.buyRobot();
        player.useRobot(map);
        player.forward(map,10);
        //then
        assertThat(player.getIndex(),is(10));
    }
    @Test
    public void should_be_in_prison_when_there_is_a_prison_in_the_destIndex(){
        player.forward(map,49);
        assertThat(player.getIndex(),is(49));
    }



}
