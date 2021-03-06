package PL.AssociationUI;

import DL.Game.LeagueSeason.League;
import DL.Game.LeagueSeason.LeagueSeason;
import DL.Game.LeagueSeason.Season;
import DL.Game.Policy.GamePolicy;
import DL.Game.Policy.ScorePolicy;
import DL.Game.Referee;
import DL.Team.Team;
import PL.main.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

import java.util.List;

import static PL.AlertUtil.showSimpleAlert;

public abstract class AInitComboBoxObjects {

    public boolean initLeagueChoices(ComboBox<League> leagueNames) {
        try {
            ObservableList<League> leaguesList = FXCollections.observableArrayList();
            leagueNames.setItems(leaguesList);
//            List<League> leagues = new ArrayList<>();
//            leagues.add(new League("check"));
//            leagues.add(new League("chdck2"));
//            leagues.add(new League("chdck3"));

            /**TODO: REMOVE THE COMMENT WHEN COMMUNICATION IS WORKING*/
            List<League> leagues = App.clientSystem.leagueSeasonUnit.getLeagues();
            if (leagues == null)
                showSimpleAlert("Error", "There was a problem with the server. please try again");
            else if (leagues.size() == 0)
                showSimpleAlert("Error", "Please create a new League First and then try again.");
            else {
                leaguesList.addAll(leagues);
                leagueNames.setPromptText("Please select league");
                leagueNames.setTooltip(new Tooltip("Select the league"));
                //FxUtilComboBoxAutoComplete.autoCompleteComboBoxPlus(leagueNames, (typedText, itemToCompare) -> itemToCompare.getName().toLowerCase().contains(typedText.toLowerCase()));
                return true;
            }

        } catch (Exception e) {
            showSimpleAlert("ServerError", e.getMessage());
        }
        return false;
    }

    public boolean initGamePolicyChoices(ComboBox<GamePolicy> gamePolicies) {
        try {
            ObservableList<GamePolicy> gamePolicyList = FXCollections.observableArrayList();
            gamePolicies.setItems(gamePolicyList);
//            List<GamePolicy> gpList = new ArrayList<>();
//            gpList.add(new GamePolicy(3, 4));
//            gpList.add(new GamePolicy(2, 1));

            /**TODO: REMOVE THE COMMENT WHEN COMMUNICATION IS WORKING*/
            List<GamePolicy> gpList = App.clientSystem.policiesUnit.getGamePolicies();
            if (gpList == null)
                showSimpleAlert("Error", "There was a problem with the server. please try again");
            else if (gpList.size() == 0)
                showSimpleAlert("Error", "Please create a new Game Policy First and then try again.");
            else {
                gamePolicyList.addAll(gpList);
                gamePolicies.setPromptText("Please select game policy");
                gamePolicies.setTooltip(new Tooltip("Select the game policy."));
                //FxUtilComboBoxAutoComplete.autoCompleteComboBoxPlus(gamePolicies, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
                return true;
            }

        } catch (Exception e) {
            showSimpleAlert("ServerError", e.getMessage());
        }
        return false;
    }

    public boolean initScorePolicyChoices(ComboBox<ScorePolicy> scorePolicies) {
        try {
            ObservableList<ScorePolicy> scorePolicyList = FXCollections.observableArrayList();
            scorePolicies.setItems(scorePolicyList);
//            List<ScorePolicy> spList = new ArrayList<>();
//            spList.add(new ScorePolicy(3, 1, 0));
//            spList.add(new ScorePolicy(2, 1, 0));

            /**TODO: REMOVE THE COMMENT WHEN COMMUNICATION IS WORKING*/
            List<ScorePolicy> spList = App.clientSystem.policiesUnit.getScorePolicies();
            if (spList == null)
                showSimpleAlert("Error", "There was a problem with the server. please try again");
            else if (spList.size() == 0)
                showSimpleAlert("Error", "Please create a new Score Policy First and then try again.");
            else {
                scorePolicyList.addAll(spList);
                scorePolicies.setPromptText("Please select score policy");
                scorePolicies.setTooltip(new Tooltip("Select the score policy."));
                //FxUtilComboBoxAutoComplete.autoCompleteComboBoxPlus(scorePolicies, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
                return true;
            }

        } catch (Exception e) {
            showSimpleAlert("ServerError", e.getMessage());
        }
        return false;
    }

    public boolean initSeasonChoices(ComboBox<Season> seasons) {
        try {
            ObservableList<Season> seasonsList = FXCollections.observableArrayList();
            seasons.setItems(seasonsList);
            /**TODO:example - should remove*/
//            List<Season> addSeasonsList = new ArrayList<>();
//            addSeasonsList.add(new Season(1950));
//            addSeasonsList.add(new Season(2011));

            /**TODO: REMOVE THE COMMENT WHEN COMMUNICATION IS WORKING*/
            List<Season> addSeasonsList = App.clientSystem.leagueSeasonUnit.getSeasons();
            if (addSeasonsList == null)
                showSimpleAlert("Error", "There was a problem with the server. please try again");
            else if (addSeasonsList.size() == 0)
                showSimpleAlert("Error", "Please create a new League Season First and then try again.");
            else {
                seasonsList.addAll(addSeasonsList);
                seasons.setPromptText("Please select season");
                seasons.setTooltip(new Tooltip("Select the season."));
                return true;
            }
        } catch (Exception e) {
            showSimpleAlert("ServerError", e.getMessage());
        }
        return false;
    }

    public boolean initLeagueSeasonsChoices(ComboBox<LeagueSeason> leagueSeason, Season season) {
        try {
            ObservableList<LeagueSeason> leagueSeasonsList = FXCollections.observableArrayList();
            leagueSeason.setItems(leagueSeasonsList);
            /**TODO:example - should remove*/
//            List<LeagueSeason> addLeagueSeasonsList = new ArrayList<>();
//            addLeagueSeasonsList.add(new LeagueSeason(new League("check"), new Season(2011), null, null, null));
//            addLeagueSeasonsList.add(new LeagueSeason(new League("check1"), new Season(2011), null, null, null));
//            addLeagueSeasonsList.add(new LeagueSeason(new League("check2"), new Season(2012), null, null, null));

            /**TODO: REMOVE THE COMMENT WHEN COMMUNICATION IS WORKING*/
            List<LeagueSeason> addLeagueSeasonsList = App.clientSystem.leagueSeasonUnit.getLeagueSeasons(season);
            if (addLeagueSeasonsList == null)
                showSimpleAlert("Error", "There was a problem with the server. please try again");
            else if (addLeagueSeasonsList.size() == 0)
                showSimpleAlert("Error", "Please create a new League Season First and then try again.");

            else {
                leagueSeasonsList.addAll(addLeagueSeasonsList);
                leagueSeason.setPromptText("Please select league season");
                leagueSeason.setTooltip(new Tooltip("Select the league season."));
                return true;
            }

        } catch (Exception e) {
            showSimpleAlert("ServerError", e.getMessage());
        }
        return false;
    }

    public boolean initRefereesChoices(ComboBox<Referee> referees) {
        try {
            ObservableList<Referee> refereesList = FXCollections.observableArrayList();
            referees.setItems(refereesList);
            /**TODO:example - should remove*/
//            List<Referee> addRefereesList = new ArrayList<>();
//            addRefereesList.add(new Referee("main", "check", null, true));
//            addRefereesList.add(new Referee("main", "check1", null, true));
//            addRefereesList.add(new Referee("main", "check2", null, true));

            /**TODO: REMOVE THE COMMENT WHEN COMMUNICATION IS WORKING*/
            List<Referee> addRefereesList = App.clientSystem.leagueSeasonUnit.getReferees();
            if (addRefereesList == null)
                showSimpleAlert("Error", "There was a problem with the server. please try again");
            else if (addRefereesList.size() == 0)
                showSimpleAlert("Error", "Please add a new Referee to the system First and then try again.");
            else {
                refereesList.addAll(addRefereesList);
                referees.setPromptText("Please select referee");
                referees.setTooltip(new Tooltip("Select the referee."));
                return true;
            }
        } catch (Exception e) {
            showSimpleAlert("ServerError", e.getMessage());
        }
        return false;
    }

    public boolean initTeamChoices(ComboBox<Team> teams) {
        try {
            ObservableList<Team> teamList = FXCollections.observableArrayList();
            teams.setItems(teamList);
            /**TODO:example - should remove*/
//            List<Team> addTeamList = new ArrayList<>();
//            addTeamList.add(new Team("check1", true, false));
//            addTeamList.add(new Team("check2", true, false));
//            addTeamList.add(new Team("check3", true, false));


            /**TODO: REMOVE THE COMMENT WHEN COMMUNICATION IS WORKING*/
            List<Team> addTeamList = App.clientSystem.leagueSeasonUnit.getTeams();
            if (addTeamList == null)
                showSimpleAlert("Error", "There was a problem with the server. please try again");
            else if (addTeamList.size() == 0)
                showSimpleAlert("Error", "Please add a new Team to the system First and then try again.");
            else {
                teamList.addAll(addTeamList);
                teams.setPromptText("Please select team");
                teams.setTooltip(new Tooltip("Select the team."));
                return true;
            }

        } catch (Exception e) {
            showSimpleAlert("ServerError", e.getMessage());
        }
        return false;
    }

}
