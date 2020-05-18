package DL.Game.MatchEvents;

import DL.Game.Referee;
import DL.Team.Members.Player;

import javax.persistence.*;

/**
 * Description:     this abstract class represents events of two players
 *
 */


@MappedSuperclass
@NamedQueries(value = {
        @NamedQuery(name = "TwoPlayersEvents", query = "Select tp From TwoPlayersEvent tp")
})

@IdClass(Event.EntryPK.class)
public abstract class TwoPlayersEvent extends Event {

    @Column
    private Player firstPlayer;
    @Column
    private Player secondPlayer;

    public TwoPlayersEvent(Referee createdByUser, EventLog eventLog, int gameTime, Player firstPlayer, Player secondPlayer) {
        super(createdByUser, eventLog, gameTime);
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public TwoPlayersEvent() {
        super(null,null,0);
        firstPlayer = secondPlayer = null;
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }
}
